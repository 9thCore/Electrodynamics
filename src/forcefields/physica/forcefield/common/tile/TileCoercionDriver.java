package physica.forcefield.common.tile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import physica.api.core.IGuiInterface;
import physica.api.core.ITileBase;
import physica.api.forcefield.IInvFortronTile;
import physica.forcefield.client.gui.GuiCoercionDriver;
import physica.forcefield.common.ForcefieldFluidRegister;
import physica.forcefield.common.ForcefieldItemRegister;
import physica.forcefield.common.inventory.ContainerCoercionDriver;
import physica.library.tile.TileBasePoweredContainer;

public class TileCoercionDriver extends TileBasePoweredContainer implements IInvFortronTile, IGuiInterface {

	public static final int BASE_ENERGY = 700;
	public static final int SLOT_CARD = 0;
	public static final int SLOT_MODULE1 = 1;
	public static final int SLOT_MODULE2 = 2;
	public static final int SLOT_MODULE3 = 3;

	public boolean isActivated = false;
	protected FluidTank fortronTank = new FluidTank(ForcefieldFluidRegister.LIQUID_FORTRON, 0, getMaxEnergyStored());
	protected Set<ITileBase> fortronConnections = new HashSet<>();

	public int getMaxEnergyStored()
	{
		return (int) (BASE_ENERGY + BASE_ENERGY * 10 * Math.pow(1.02, getModuleCount(ForcefieldItemRegister.moduleMap.get("moduleUpgradeSpeed"), SLOT_MODULE1, SLOT_MODULE3)) +
				BASE_ENERGY * 10 * Math.pow(1.02, getModuleCount(ForcefieldItemRegister.moduleMap.get("moduleUpgradeCapacity"), SLOT_MODULE1, SLOT_MODULE3) * 2));
	}

	@Override
	public Set<ITileBase> getFortronConnections()
	{
		return fortronConnections;
	}

	@Override
	public boolean canRecieveFortron(IInvFortronTile from)
	{
		return false;
	}

	public int getFortronTransferRate()
	{
		return (int) (BASE_ENERGY + BASE_ENERGY * 10 * Math.pow(1.021, getModuleCount(ForcefieldItemRegister.moduleMap.get("moduleUpgradeSpeed"), SLOT_MODULE1, SLOT_MODULE3))) / 3;
	}

	@Override
	public void onFirstUpdate()
	{
		invalidateConnections();
		fortronConnections.clear();
		findNearbyConnections(TileFortronCapacitor.class);
	}

	@Override
	public void updateServer(int ticks)
	{
		super.updateServer(ticks);
		if (ticks % 20 == 0) {
			validateConnections();
		}
		if (getEnergyStored() > 1) {
			setEnergyStored(getEnergyStored() - fortronTank.fill(new FluidStack(ForcefieldFluidRegister.LIQUID_FORTRON, Math.min(getEnergyUsage(), getEnergyStored()) - 1), true));
		}
		if (canSendBeam()) {
			fortronTank.getFluid().amount -= sendFortronTo(fortronTank.getFluidAmount(), TileFortronCapacitor.class);
		}
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox()
	{
		return canSendBeam() ? super.getRenderBoundingBox().expand(5, 5, 5) : super.getRenderBoundingBox();
	}

	@Override
	public void updateCommon(int ticks)
	{
		super.updateCommon(ticks);
		fortronTank.setCapacity(getMaxEnergyStored());
		if (fortronTank.getCapacity() < fortronTank.getFluidAmount()) {
			fortronTank.getFluid().amount = fortronTank.getCapacity();
		}
		isActivated = isPoweredByRedstone();
		if (getStackInSlot(SLOT_CARD) != null) {
			if (getStackInSlot(SLOT_CARD).stackTagCompound != null) {
				setFrequency(getStackInSlot(SLOT_CARD).stackTagCompound.getInteger("frequency"));
			}
		}
	}

	@Override
	public void invalidate()
	{
		super.invalidate();
		invalidateConnections();
	}
	private int frequency;

	@Override
	public int getFrequency()
	{
		return frequency;
	}

	@Override
	public void setFrequency(int freq)
	{
		int oldFrequency = frequency;
		frequency = freq;
		if (oldFrequency != freq) {
			onFirstUpdate();
		}
	}

	@Override
	public void writeClientGuiPacket(List<Object> dataList, EntityPlayer player)
	{
		super.writeClientGuiPacket(dataList, player);
		dataList.add(isActivated);
		dataList.add(frequency);
		dataList.add(fortronTank.writeToNBT(new NBTTagCompound()));
	}

	@Override
	public void readClientGuiPacket(ByteBuf buf, EntityPlayer player)
	{
		super.readClientGuiPacket(buf, player);
		isActivated = buf.readBoolean();
		frequency = buf.readInt();
		fortronTank.readFromNBT(ByteBufUtils.readTag(buf));
	}

	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		tag.setInteger("frequency", frequency);
		fortronTank.writeToNBT(tag);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		frequency = tag.getInteger("frequency");
		fortronTank.readFromNBT(tag);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_)
	{
		return ACCESSIBLE_SLOTS_NONE;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack)
	{
		return stack == null ? false
				: stack.getItem() == null ? false : slot >= SLOT_MODULE1 && slot <= SLOT_MODULE3 ? stack.getItem() == ForcefieldItemRegister.itemMetaUpgradeModule
						: slot == SLOT_CARD ? stack.getItem() == ForcefieldItemRegister.itemFrequency : true;
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack stack, int side)
	{
		return isItemValidForSlot(slot, stack);
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack stack, int side)
	{
		return isItemValidForSlot(slot, stack);
	}

	@Override
	public int getSizeInventory()
	{
		return 4;
	}

	@Override
	public boolean isActivated()
	{
		return isActivated;
	}

	@Override
	public int getEnergyUsage()
	{
		return getFortronTransferRate();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from)
	{
		return getMaxEnergyStored();
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from)
	{
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public GuiScreen getClientGuiElement(int id, EntityPlayer player)
	{
		return new GuiCoercionDriver(player, this);
	}

	@Override
	public Container getServerGuiElement(int id, EntityPlayer player)
	{
		return new ContainerCoercionDriver(player, this);
	}

	@Override
	public FluidTank getFortronTank()
	{
		return fortronTank;
	}

}

package electrodynamics.common.item.gear.tools.electric;

import java.util.List;

import electrodynamics.api.electricity.formatting.ChatFormatter;
import electrodynamics.api.electricity.formatting.ElectricUnit;
import electrodynamics.api.item.IItemElectric;
import electrodynamics.common.item.gear.tools.electric.utils.ElectricItemTier;
import electrodynamics.prefab.item.ElectricItemProperties;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemElectricDrill extends PickaxeItem implements IItemElectric {

    private final ElectricItemProperties properties;

    public ItemElectricDrill(ElectricItemProperties properties) {
	super(ElectricItemTier.DRILL, 4, -2.4f, properties.maxDamage(0));
	this.properties = properties;
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
	return true;
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
	if (isInGroup(group)) {
	    ItemStack charged = new ItemStack(this);
	    IItemElectric.setEnergyStored(charged, properties.capacity);
	    items.add(charged);
	    ItemStack empty = new ItemStack(this);
	    IItemElectric.setEnergyStored(empty, 0);
	    items.add(empty);
	}
    }

    @Override
    public boolean isDamageable() {
	return false;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
	return getJoulesStored(stack) > properties.extract.getJoules() ? super.getDestroySpeed(stack, state) : 0;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
	extractPower(stack, properties.extract.getJoules(), false);
	return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
	return 1.0 - getJoulesStored(stack) / properties.capacity;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
	return getJoulesStored(stack) < properties.capacity;
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
	super.addInformation(stack, worldIn, tooltip, flagIn);
	tooltip.add(new TranslationTextComponent("tooltip.item.electric.info").mergeStyle(TextFormatting.GRAY)
		.append(new StringTextComponent(ChatFormatter.getElectricDisplayShort(getJoulesStored(stack), ElectricUnit.JOULES))));
	tooltip.add(new TranslationTextComponent("tooltip.item.electric.voltage",
		ChatFormatter.getElectricDisplayShort(properties.receive.getVoltage(), ElectricUnit.VOLTAGE) + " / "
			+ ChatFormatter.getElectricDisplayShort(properties.extract.getVoltage(), ElectricUnit.VOLTAGE))
				.mergeStyle(TextFormatting.RED));
    }

    @Override
    public ElectricItemProperties getElectricProperties() {
	return properties;
    }

}

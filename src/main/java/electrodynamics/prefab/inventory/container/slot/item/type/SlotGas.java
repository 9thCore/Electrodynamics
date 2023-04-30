package electrodynamics.prefab.inventory.container.slot.item.type;

import electrodynamics.prefab.inventory.container.slot.item.SlotGeneric;
import electrodynamics.prefab.screen.component.ScreenComponentSlot.IconType;
import electrodynamics.prefab.screen.component.ScreenComponentSlot.SlotType;
import electrodynamics.prefab.utilities.CapabilityUtils;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;

public class SlotGas extends SlotGeneric {

	public SlotGas(Container inventory, int index, int x, int y) {
		super(SlotType.NORMAL, IconType.GAS_DARK, inventory, index, x, y);
	}
	
	@Override
	public boolean mayPlace(ItemStack stack) {
		return super.mayPlace(stack) && CapabilityUtils.hasGasItemCap(stack);
	}

}

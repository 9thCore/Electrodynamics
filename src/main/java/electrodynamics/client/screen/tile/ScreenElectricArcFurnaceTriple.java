package electrodynamics.client.screen.tile;

import electrodynamics.common.inventory.container.tile.ContainerElectricArcFurnaceTriple;
import electrodynamics.common.tile.TileElectricArcFurnace;
import electrodynamics.prefab.screen.GenericScreen;
import electrodynamics.prefab.screen.component.ScreenComponentElectricInfo;
import electrodynamics.prefab.screen.component.ScreenComponentProgress;
import electrodynamics.prefab.screen.component.ScreenComponentProgress.ProgressBars;
import electrodynamics.prefab.screen.component.utils.AbstractScreenComponentInfo;
import electrodynamics.prefab.tile.components.type.ComponentProcessor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScreenElectricArcFurnaceTriple extends GenericScreen<ContainerElectricArcFurnaceTriple> {

	public ScreenElectricArcFurnaceTriple(ContainerElectricArcFurnaceTriple container, Inventory playerInventory, Component title) {
		super(container, playerInventory, title);
		components.add(new ScreenComponentProgress(ProgressBars.PROGRESS_ARROW_RIGHT, () -> {
			TileElectricArcFurnace furnace = container.getHostFromIntArray();
			if (furnace != null) {
				ComponentProcessor processor = furnace.getProcessor(0);
				if (processor.operatingTicks.get() > 0) {
					return processor.operatingTicks.get() / processor.requiredTicks.get();
				}
			}
			return 0;
		}, this, 84, 24));
		components.add(new ScreenComponentProgress(ProgressBars.COUNTDOWN_FLAME, () -> {
			TileElectricArcFurnace furnace = container.getHostFromIntArray();
			if (furnace != null) {
				ComponentProcessor processor = furnace.getProcessor(0);
				if (processor.operatingTicks.get() > 0) {
					return 1;
				}
			}
			return 0;
		}, this, 39, 26));
		components.add(new ScreenComponentProgress(ProgressBars.PROGRESS_ARROW_RIGHT, () -> {
			TileElectricArcFurnace furnace = container.getHostFromIntArray();
			if (furnace != null) {
				ComponentProcessor processor = furnace.getProcessor(1);
				if (processor.operatingTicks.get() > 0) {
					return processor.operatingTicks.get() / processor.requiredTicks.get();
				}
			}
			return 0;
		}, this, 84, 44));
		components.add(new ScreenComponentProgress(ProgressBars.COUNTDOWN_FLAME, () -> {
			TileElectricArcFurnace furnace = container.getHostFromIntArray();
			if (furnace != null) {
				ComponentProcessor processor = furnace.getProcessor(1);
				if (processor.operatingTicks.get() > 0) {
					return 1;
				}
			}
			return 0;
		}, this, 39, 46));
		components.add(new ScreenComponentProgress(ProgressBars.PROGRESS_ARROW_RIGHT, () -> {
			TileElectricArcFurnace furnace = container.getHostFromIntArray();
			if (furnace != null) {
				ComponentProcessor processor = furnace.getProcessor(2);
				if (processor.operatingTicks.get() > 0) {
					return processor.operatingTicks.get() / processor.requiredTicks.get();
				}
			}
			return 0;
		}, this, 84, 64));
		components.add(new ScreenComponentProgress(ProgressBars.COUNTDOWN_FLAME, () -> {
			TileElectricArcFurnace furnace = container.getHostFromIntArray();
			if (furnace != null) {
				ComponentProcessor processor = furnace.getProcessor(2);
				if (processor.operatingTicks.get() > 0) {
					return 1;
				}
			}
			return 0;
		}, this, 39, 66));
		imageHeight += 20;
		inventoryLabelY += 20;
		components.add(new ScreenComponentElectricInfo(this, -AbstractScreenComponentInfo.SIZE + 1, 2));
	}
}
package electrodynamics.client.screen.tile;

import electrodynamics.common.inventory.container.tile.ContainerO2OProcessor;
import electrodynamics.prefab.screen.GenericScreen;
import electrodynamics.prefab.screen.component.ScreenComponentElectricInfo;
import electrodynamics.prefab.screen.component.ScreenComponentProgress;
import electrodynamics.prefab.screen.component.ScreenComponentProgress.ProgressBars;
import electrodynamics.prefab.screen.component.utils.AbstractScreenComponentInfo;
import electrodynamics.prefab.tile.GenericTile;
import electrodynamics.prefab.tile.components.type.ComponentProcessor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScreenO2OProcessor extends GenericScreen<ContainerO2OProcessor> {
	public ScreenO2OProcessor(ContainerO2OProcessor container, Inventory playerInventory, Component title) {
		super(container, playerInventory, title);
		components.add(new ScreenComponentProgress(ProgressBars.PROGRESS_ARROW_RIGHT, () -> {
			GenericTile furnace = container.getHostFromIntArray();
			if (furnace != null) {
				ComponentProcessor processor = furnace.getProcessor(0);
				if (processor.operatingTicks.get() > 0) {
					return processor.operatingTicks.get() / processor.requiredTicks.get();
				}
			}
			return 0;
		}, this, 84 - ContainerO2OProcessor.startXOffset, 34));
		components.add(new ScreenComponentElectricInfo(this, -AbstractScreenComponentInfo.SIZE + 1, 2));
	}

}
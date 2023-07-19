package electrodynamics.common.tile.gastransformer.compressor;

import electrodynamics.common.inventory.container.tile.ContainerCompressor;
import electrodynamics.prefab.tile.components.ComponentType;
import electrodynamics.prefab.tile.components.type.ComponentContainerProvider;
import electrodynamics.registers.ElectrodynamicsBlockTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class TileCompressor extends GenericTileCompressor {

	public TileCompressor(BlockPos worldPos, BlockState blockState) {
		super(ElectrodynamicsBlockTypes.TILE_COMPRESSOR.get(), worldPos, blockState, false);
	}

	@Override
	public ComponentContainerProvider getContainerProvider() {
		return new ComponentContainerProvider("container.compressor", this).createMenu((id, inv) -> new ContainerCompressor(id, inv, getComponent(ComponentType.Inventory), getCoordsArray()));
	}

}

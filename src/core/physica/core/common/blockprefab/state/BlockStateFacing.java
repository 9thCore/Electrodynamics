package physica.core.common.blockprefab.state;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.EnumFacing;
import physica.core.common.blockprefab.BlockRotatable;
import physica.core.common.blockprefab.property.PropertySingle;

public class BlockStateFacing extends BlockStateContainer {
	public static final PropertySingle<EnumFacing> FACING = PropertySingle.createProperty("facing",
			EnumFacing.Plane.HORIZONTAL, EnumFacing.class);

	public BlockStateFacing(BlockRotatable<?> block) {
		super(block, FACING);
	}

	public BlockStateFacing(BlockRotatable<?> block, PropertyEnum<?> typeProperty) {
		super(block, FACING, typeProperty);
	}
}
package electrodynamics.common.tile.network.electric;

import org.jetbrains.annotations.NotNull;

import electrodynamics.api.capability.ElectrodynamicsCapabilities;
import electrodynamics.common.settings.Constants;
import electrodynamics.prefab.tile.GenericTile;
import electrodynamics.prefab.tile.components.ComponentType;
import electrodynamics.prefab.tile.components.type.ComponentDirection;
import electrodynamics.prefab.tile.components.type.ComponentElectrodynamic;
import electrodynamics.prefab.utilities.BlockEntityUtils;
import electrodynamics.prefab.utilities.object.TransferPack;
import electrodynamics.registers.ElectrodynamicsBlockTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TileCircuitBreaker extends GenericTile {

	private boolean recievedRedstoneSignal = false;
	
	private boolean isLocked = false;

	public TileCircuitBreaker(BlockPos worldPosition, BlockState blockState) {
		super(ElectrodynamicsBlockTypes.TILE_CIRCUITBREAKER.get(), worldPosition, blockState);
		addComponent(new ComponentDirection(this));
		addComponent(new ComponentElectrodynamic(this).receivePower(this::receivePower).relativeOutput(Direction.SOUTH).relativeInput(Direction.NORTH).voltage(-1));
	}

	// will not transfer power if is recieving redstone signal, voltage exceeds recieving end voltage, or if current exceeds recieving
	// end current if recieving end is wire
	public TransferPack receivePower(TransferPack transfer, boolean debug) {

		if (recievedRedstoneSignal || isLocked) {
			return TransferPack.EMPTY;
		}

		Direction output = BlockEntityUtils.getRelativeSide(this.<ComponentDirection>getComponent(ComponentType.Direction).getDirection(), Direction.SOUTH);

		BlockEntity tile = level.getBlockEntity(worldPosition.relative(output));

		if (tile == null) {
			return TransferPack.EMPTY;
		}

		return tile.getCapability(ElectrodynamicsCapabilities.ELECTRODYNAMIC, output.getOpposite()).map(cap -> {

			if (debug) {
				
				isLocked = true;
				
				TransferPack accepted = cap.receivePower(transfer, debug);

				isLocked = false;
				
				if (accepted.getJoules() > 0) {
					return TransferPack.joulesVoltage(accepted.getJoules() + transfer.getJoules() * (1.0 - Constants.CIRCUITBREAKER_EFFICIENCY), transfer.getVoltage());
				}
				return TransferPack.EMPTY;

			}

			if (cap.getMinimumVoltage() > -1 && cap.getMinimumVoltage() < transfer.getVoltage()) {
				return TransferPack.EMPTY;
			}

			if (tile instanceof GenericTileWire wire && wire.electricNetwork != null && wire.electricNetwork.networkMaxTransfer < transfer.getAmps()) {

				return TransferPack.EMPTY;

			}

			isLocked = true;
			
			TransferPack accepted = cap.receivePower(transfer, debug);

			isLocked = false;
			
			if (accepted.getJoules() > 0) {
				return TransferPack.joulesVoltage(accepted.getJoules() + transfer.getJoules() * (1.0 - Constants.CIRCUITBREAKER_EFFICIENCY), transfer.getVoltage());
			}
			return TransferPack.EMPTY;

		}).orElse(TransferPack.EMPTY);
	}

	@Override
	public void saveAdditional(@NotNull CompoundTag compound) {
		super.saveAdditional(compound);
		compound.putBoolean("hasredstonesignal", recievedRedstoneSignal);
	}

	@Override
	public void onNeightborChanged(BlockPos neighbor) {
		if(level.isClientSide) {
			return;
		}
		recievedRedstoneSignal = level.hasNeighborSignal(getBlockPos());
		if (BlockEntityUtils.isLit(this) ^ recievedRedstoneSignal) {
			BlockEntityUtils.updateLit(this, recievedRedstoneSignal);
			if(recievedRedstoneSignal) {
				level.playSound(null, getBlockPos(), SoundEvents.IRON_TRAPDOOR_OPEN, SoundSource.BLOCKS);
			} else {
				level.playSound(null, getBlockPos(), SoundEvents.IRON_TRAPDOOR_CLOSE, SoundSource.BLOCKS);
			}
		}
	}

	@Override
	public void onPlace(BlockState oldState, boolean isMoving) {
		if(level.isClientSide) {
			return;
		}
		recievedRedstoneSignal = level.hasNeighborSignal(getBlockPos());
		if (BlockEntityUtils.isLit(this) ^ recievedRedstoneSignal) {
			BlockEntityUtils.updateLit(this, recievedRedstoneSignal);
			if(recievedRedstoneSignal) {
				level.playSound(null, getBlockPos(), SoundEvents.IRON_TRAPDOOR_OPEN, SoundSource.BLOCKS);
			}
		}
	}

}
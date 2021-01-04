package electrodynamics.packet;

import java.util.function.Supplier;

import electrodynamics.api.tile.IUpdateableTile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class PacketUpdateTile {

	private final CompoundNBT updateTag;
	private final BlockPos pos;

	public PacketUpdateTile(IUpdateableTile tile) {
		this(tile.getTile().getPos(), tile.createUpdateTag());
	}

	private PacketUpdateTile(BlockPos pos, CompoundNBT updateTag) {
		this.pos = pos;
		this.updateTag = updateTag;
	}

	public static void handle(PacketUpdateTile message, Supplier<Context> context) {
		Context ctx = context.get();
		ctx.enqueueWork(() -> {
			ClientWorld world = Minecraft.getInstance().world;
			if (world != null) {
				IUpdateableTile tile = (IUpdateableTile) world.getTileEntity(message.pos);
				if (tile != null) {
					tile.handleUpdatePacket(message.updateTag);
				}
			}
		});
		ctx.setPacketHandled(true);
	}

	public static void encode(PacketUpdateTile pkt, PacketBuffer buf) {
		buf.writeBlockPos(pkt.pos);
		buf.writeCompoundTag(pkt.updateTag);
	}

	public static PacketUpdateTile decode(PacketBuffer buf) {
		return new PacketUpdateTile(buf.readBlockPos(), buf.readCompoundTag());
	}
}
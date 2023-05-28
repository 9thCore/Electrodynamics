package electrodynamics.prefab.screen.component;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import electrodynamics.common.inventory.container.tile.ContainerFluidPipeFilter;
import electrodynamics.common.packet.NetworkHandler;
import electrodynamics.common.packet.types.server.PacketSendUpdatePropertiesServer;
import electrodynamics.common.tile.network.fluid.TileFluidPipeFilter;
import electrodynamics.prefab.inventory.container.GenericContainerBlockEntity;
import electrodynamics.prefab.properties.Property;
import electrodynamics.prefab.screen.GenericScreen;
import electrodynamics.prefab.screen.component.utils.AbstractScreenComponentGauge.GaugeTextures;
import electrodynamics.prefab.utilities.CapabilityUtils;
import electrodynamics.prefab.utilities.RenderingUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class ScreenComponentFluidFilter extends ScreenComponentGeneric {

	private final int index;

	public ScreenComponentFluidFilter(GenericScreen<ContainerFluidPipeFilter> gui, int x, int y, int index) {
		super(GaugeTextures.BACKGROUND_DEFAULT, gui, x, y);
		this.index = index;
	}

	@Override
	public void renderBackground(PoseStack stack, int xAxis, int yAxis, int guiWidth, int guiHeight) {
		super.renderBackground(stack, xAxis, yAxis, guiWidth, guiHeight);

		TileFluidPipeFilter filter = (TileFluidPipeFilter) ((GenericContainerBlockEntity<?>) ((GenericScreen<?>) gui).getMenu()).getHostFromIntArray();

		if (filter == null) {
			return;
		}

		Property<FluidStack> property = filter.filteredFluids[index];

		FluidStack fluid = property.get();

		if (!fluid.isEmpty()) {

			ResourceLocation fluidText = IClientFluidTypeExtensions.of(fluid.getFluid()).getStillTexture();

			if (fluidText != null) {

				ResourceLocation blocks = InventoryMenu.BLOCK_ATLAS;
				TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(blocks).apply(fluidText);
				RenderSystem.setShaderTexture(0, sprite.atlas().getId());

				int scale = GaugeTextures.BACKGROUND_DEFAULT.textureHeight() - 2;

				RenderingUtils.color(IClientFluidTypeExtensions.of(fluid.getFluid()).getTintColor(fluid));

				for (int i = 0; i < 16; i += 16) {
					for (int j = 0; j < scale; j += 16) {
						int drawWidth = Math.min(super.texture.textureWidth() - 2 - i, 16);
						int drawHeight = Math.min(scale - j, 16);

						int drawX = guiWidth + xLocation + 1;
						int drawY = guiHeight + yLocation - 1 + super.texture.textureHeight() - Math.min(scale - j, super.texture.textureHeight());
						GuiComponent.blit(stack, drawX, drawY, 0, drawWidth, drawHeight, sprite);
					}
				}
				RenderSystem.setShaderColor(1, 1, 1, 1);

			}

		}

		RenderingUtils.bindTexture(GaugeTextures.LEVEL_DEFAULT.getLocation());

		gui.drawTexturedRect(stack, guiWidth + xLocation, guiHeight + yLocation, GaugeTextures.LEVEL_DEFAULT.textureU(), 0, GaugeTextures.LEVEL_DEFAULT.textureWidth(), GaugeTextures.LEVEL_DEFAULT.textureHeight(), GaugeTextures.LEVEL_DEFAULT.imageWidth(), GaugeTextures.LEVEL_DEFAULT.imageHeight());

	}

	@Override
	public void renderForeground(PoseStack stack, int xAxis, int yAxis) {

		if (!isPointInRegion(xLocation, yLocation, xAxis, yAxis, super.texture.textureWidth(), super.texture.textureHeight())) {
			return;
		}

		TileFluidPipeFilter filter = (TileFluidPipeFilter) ((GenericContainerBlockEntity<?>) ((GenericScreen<?>) gui).getMenu()).getHostFromIntArray();

		if (filter == null) {
			return;
		}

		Property<FluidStack> property = filter.filteredFluids[index];

		List<FormattedCharSequence> tooltips = new ArrayList<>();

		tooltips.add(property.get().getDisplayName().getVisualOrderText());

		gui.displayTooltips(stack, tooltips, xAxis, yAxis);
	}

	@Override
	public void mouseClicked(double xAxis, double yAxis, int button) {

		if (!isPointInRegion(xLocation, yLocation, xAxis, yAxis, texture.textureWidth(), texture.textureHeight())) {
			return;
		}

		GenericScreen<?> screen = (GenericScreen<?>) gui;

		TileFluidPipeFilter filter = (TileFluidPipeFilter) ((GenericContainerBlockEntity<?>) screen.getMenu()).getHostFromIntArray();

		if (filter == null) {
			return;
		}

		Property<FluidStack> property = filter.filteredFluids[index];

		ItemStack holding = screen.getMenu().getCarried();

		if (holding.isEmpty()) {

			if (Screen.hasShiftDown()) {
				property.set(FluidStack.EMPTY);
				NetworkHandler.CHANNEL.sendToServer(new PacketSendUpdatePropertiesServer(property.getPropertyManager().getProperties().indexOf(property), property, filter.getBlockPos()));
			} else {
				return;
			}

		}

		FluidStack taken = CapabilityUtils.drainFluidItem(holding, Integer.MAX_VALUE, FluidAction.SIMULATE);

		if (taken.isEmpty()) {
			return;
		}

		property.set(taken);
		NetworkHandler.CHANNEL.sendToServer(new PacketSendUpdatePropertiesServer(property.getPropertyManager().getProperties().indexOf(property), property, filter.getBlockPos()));

	}

}

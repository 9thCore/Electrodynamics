package electrodynamics.prefab.screen.component;

import java.util.function.DoubleSupplier;

import com.mojang.blaze3d.vertex.PoseStack;

import electrodynamics.api.References;
import electrodynamics.api.screen.IScreenWrapper;
import electrodynamics.api.screen.ITexture;
import electrodynamics.prefab.utilities.RenderingUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScreenComponentProgress extends ScreenComponentGeneric {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(References.ID + ":textures/screen/component/progress.png");

	private final DoubleSupplier progressInfoHandler;
	private final ProgressBars bar;

	public ScreenComponentProgress(ProgressBars progressBar, final DoubleSupplier progressInfoHandler, final IScreenWrapper gui, final int x, final int y) {
		super(progressBar.off, gui, x, y);
		this.progressInfoHandler = progressInfoHandler;
		bar = progressBar;
	}

	@Override
	public void renderBackground(PoseStack stack, final int xAxis, final int yAxis, final int guiWidth, final int guiHeight) {
		super.renderBackground(stack, xAxis, yAxis, guiWidth, guiHeight);
		ProgressTextures on = bar.on;
		RenderingUtils.bindTexture(on.getLocation());
		int progress;
		switch(bar) {
		case PROGRESS_ARROW_RIGHT:
			progress = (int) (progressInfoHandler.getAsDouble() * on.textureWidth());
			gui.drawTexturedRect(stack, guiWidth + xLocation, guiHeight + yLocation, on.textureU(), on.textureV(), (int) (progressInfoHandler.getAsDouble() * on.textureWidth()), on.textureHeight(), on.imageWidth(), on.imageHeight());
			break;
		case PROGRESS_ARROW_LEFT:
			progress = (int) (progressInfoHandler.getAsDouble() * on.textureWidth());
			int xStart = on.textureU() + on.textureWidth() - progress;
			gui.drawTexturedRect(stack, guiWidth + xLocation + on.textureWidth() - progress, guiHeight + yLocation, xStart, on.textureV(), progress, on.textureHeight(), on.imageWidth(), on.imageHeight());
			break;
		case COUNTDOWN_FLAME:
			progress = (int) (progressInfoHandler.getAsDouble() * on.textureHeight());
			gui.drawTexturedRect(stack, guiWidth + xLocation, guiHeight + yLocation + on.textureHeight() - progress, on.textureU(), on.textureV() + on.textureHeight() - progress, on.textureWidth(), progress, on.imageWidth(), on.imageHeight());
			break;
		case BATTERY_CHARGE_RIGHT: 
			progress = (int) (progressInfoHandler.getAsDouble() * on.textureWidth());
			gui.drawTexturedRect(stack, guiWidth + xLocation, guiHeight + yLocation, on.textureU(), on.textureV(), (int) (progressInfoHandler.getAsDouble() * on.textureWidth()), on.textureHeight(), on.imageWidth(), on.imageHeight());
			break;
		}
		
	}
	
	public static enum ProgressBars {
		
		PROGRESS_ARROW_RIGHT(ProgressTextures.ARROW_RIGHT_OFF, ProgressTextures.ARROW_RIGHT_ON), 
		PROGRESS_ARROW_LEFT(ProgressTextures.ARROW_LEFT_OFF, ProgressTextures.ARROW_LEFT_ON), 
		COUNTDOWN_FLAME(ProgressTextures.FLAME_OFF, ProgressTextures.FLAME_ON), 
		BATTERY_CHARGE_RIGHT(ProgressTextures.BATTER_CHARGE_RIGHT_OFF, ProgressTextures.BATTER_CHARGE_RIGHT_ON);
		
		public final ProgressTextures off;
		public final ProgressTextures on;
		
		private ProgressBars(ProgressTextures off, ProgressTextures on) {
			this.off = off;
			this.on = on;
		}
		
	}
	
	public static enum ProgressTextures implements ITexture {
		ARROW_RIGHT_OFF(22, 16, 0, 0, 256, 256, TEXTURE),
		ARROW_RIGHT_ON(22, 16, 22, 0, 256, 256, TEXTURE),
		ARROW_LEFT_ON(22, 16, 44, 0, 256, 256, TEXTURE),
		ARROW_LEFT_OFF(22, 16, 96, 0, 256, 256, TEXTURE),
		FLAME_ON(14, 14, 0, 19, 256, 256, TEXTURE),
		FLAME_OFF(14, 14, 0, 33, 256, 256, TEXTURE),
		BATTER_CHARGE_RIGHT_OFF(19, 10, 0, 47, 256, 256, TEXTURE),
		BATTER_CHARGE_RIGHT_ON(19, 10, 19, 47, 256, 256, TEXTURE);
		
		private final int textureWidth;
		private final int textureHeight;
		private final int textureU;
		private final int textureV;
		private final int imageWidth;
		private final int imageHeight;
		private final ResourceLocation loc;
		
		private ProgressTextures(int textureWidth, int textureHeight, int textureU, int textureV, int imageWidth, int imageHeight, ResourceLocation loc) {
			this.textureWidth = textureWidth;
			this.textureHeight = textureHeight;
			this.textureU = textureU;
			this.textureV = textureV;
			this.imageWidth = imageWidth;
			this.imageHeight = imageHeight;
			this.loc = loc;
		}

		@Override
		public ResourceLocation getLocation() {
			return loc;
		}

		@Override
		public int imageHeight() {
			return imageHeight;
		}

		@Override
		public int imageWidth() {
			return imageWidth;
		}

		@Override
		public int textureHeight() {
			return textureHeight;
		}

		@Override
		public int textureU() {
			return textureU;
		}

		@Override
		public int textureV() {
			return textureV;
		}

		@Override
		public int textureWidth() {
			return textureWidth;
		}
		
	}

}
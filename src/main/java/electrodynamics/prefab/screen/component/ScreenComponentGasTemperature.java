package electrodynamics.prefab.screen.component;

import java.util.ArrayList;
import java.util.List;

import electrodynamics.api.electricity.formatting.ChatFormatter;
import electrodynamics.api.electricity.formatting.DisplayUnit;
import electrodynamics.api.gas.PropertyGasTank;
import electrodynamics.api.screen.IScreenWrapper;
import electrodynamics.api.screen.component.TextPropertySupplier;
import electrodynamics.prefab.inventory.container.GenericContainerBlockEntity;
import electrodynamics.prefab.screen.GenericScreen;
import electrodynamics.prefab.screen.component.ScreenComponentSlot.IconType;
import electrodynamics.prefab.screen.component.utils.AbstractScreenComponentInfo;
import electrodynamics.prefab.tile.GenericTile;
import electrodynamics.prefab.tile.components.ComponentType;
import electrodynamics.prefab.tile.components.utils.IComponentGasHandler;
import electrodynamics.prefab.utilities.TextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.util.FormattedCharSequence;

public class ScreenComponentGasTemperature  extends ScreenComponentGuiTab {

	public ScreenComponentGasTemperature(TextPropertySupplier infoHandler, IScreenWrapper gui, int x, int y) {
		super(GuiInfoTabTextures.REGULAR, IconType.THERMOMETER, infoHandler, gui, x, y);
	}

	public ScreenComponentGasTemperature(IScreenWrapper gui, int x, int y) {
		super(GuiInfoTabTextures.REGULAR, IconType.THERMOMETER, AbstractScreenComponentInfo.EMPTY, gui, x, y);
	}

	@Override
	protected List<? extends FormattedCharSequence> getInfo(List<? extends FormattedCharSequence> list) {
		if (infoHandler == EMPTY) {
			return getMaxPressureInfo();
		}
		return super.getInfo(list);
	}

	private List<? extends FormattedCharSequence> getMaxPressureInfo() {

		List<FormattedCharSequence> tooltips = new ArrayList<>();

		GenericTile generic = (GenericTile) ((GenericContainerBlockEntity<?>) ((GenericScreen<?>) gui).getMenu()).getHostFromIntArray();

		if (generic == null) {
			return tooltips;
		}

		IComponentGasHandler handler = generic.getComponent(ComponentType.GasHandler);

		int index = 1;

		for (PropertyGasTank tank : handler.getInputTanks()) {

			tooltips.add(TextUtils.tooltip("tankmaxin", index, ChatFormatter.getChatDisplayShort(tank.getMaxTemperature(), DisplayUnit.TEMPERATURE_KELVIN)).withStyle(ChatFormatting.GRAY).getVisualOrderText());

			index++;
		}

		index = 1;

		for (PropertyGasTank tank : handler.getOutputTanks()) {
			
			tooltips.add(TextUtils.tooltip("tankmaxout", index, ChatFormatter.getChatDisplayShort(tank.getMaxTemperature(), DisplayUnit.TEMPERATURE_KELVIN)).withStyle(ChatFormatting.DARK_GRAY).getVisualOrderText());
			
			index++;
			
		}

		return tooltips;

	}

}

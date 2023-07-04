package electrodynamics.datagen.client;

import electrodynamics.api.References;
import electrodynamics.api.gas.Gas;
import electrodynamics.common.block.subtype.SubtypeGlass;
import electrodynamics.common.block.subtype.SubtypeMachine;
import electrodynamics.common.block.subtype.SubtypeOre;
import electrodynamics.common.block.subtype.SubtypeOreDeepslate;
import electrodynamics.common.block.subtype.SubtypeFluidPipe;
import electrodynamics.common.block.subtype.SubtypeGasPipe;
import electrodynamics.common.block.subtype.SubtypeRawOreBlock;
import electrodynamics.common.block.subtype.SubtypeResourceBlock;
import electrodynamics.common.block.subtype.SubtypeWire;
import electrodynamics.common.fluid.types.liquid.subtype.SubtypeSulfateFluid;
import electrodynamics.common.item.subtype.SubtypeCeramic;
import electrodynamics.common.item.subtype.SubtypeCircuit;
import electrodynamics.common.item.subtype.SubtypeCrystal;
import electrodynamics.common.item.subtype.SubtypeDrillHead;
import electrodynamics.common.item.subtype.SubtypeDust;
import electrodynamics.common.item.subtype.SubtypeGear;
import electrodynamics.common.item.subtype.SubtypeImpureDust;
import electrodynamics.common.item.subtype.SubtypeIngot;
import electrodynamics.common.item.subtype.SubtypeItemUpgrade;
import electrodynamics.common.item.subtype.SubtypeNugget;
import electrodynamics.common.item.subtype.SubtypeOxide;
import electrodynamics.common.item.subtype.SubtypePlate;
import electrodynamics.common.item.subtype.SubtypeRawOre;
import electrodynamics.common.item.subtype.SubtypeRod;
import electrodynamics.common.recipe.categories.fluid2gas.specificmachines.ElectrolyticSeparatorRecipe;
import electrodynamics.common.recipe.categories.fluid2item.specificmachines.ChemicalCrystalizerRecipe;
import electrodynamics.common.recipe.categories.fluiditem2fluid.specificmachines.ChemicalMixerRecipe;
import electrodynamics.common.recipe.categories.fluiditem2fluid.specificmachines.FermentationPlantRecipe;
import electrodynamics.common.recipe.categories.fluiditem2fluid.specificmachines.MineralWasherRecipe;
import electrodynamics.common.recipe.categories.item2item.specificmachines.EnergizedAlloyerRecipe;
import electrodynamics.common.recipe.categories.item2item.specificmachines.LatheRecipe;
import electrodynamics.common.recipe.categories.item2item.specificmachines.MineralCrusherRecipe;
import electrodynamics.common.recipe.categories.item2item.specificmachines.MineralGrinderRecipe;
import electrodynamics.common.recipe.categories.item2item.specificmachines.OxidationFurnaceRecipe;
import electrodynamics.common.recipe.categories.item2item.specificmachines.ReinforcedAlloyerRecipe;
import electrodynamics.common.recipe.categories.item2item.specificmachines.WireMillRecipe;
import electrodynamics.registers.ElectrodynamicsBlocks;
import electrodynamics.registers.ElectrodynamicsFluids;
import electrodynamics.registers.ElectrodynamicsGases;
import electrodynamics.registers.ElectrodynamicsItems;
import electrodynamics.registers.ElectrodynamicsRegistries;
import electrodynamics.registers.ElectrodynamicsSounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ElectrodynamicsLangKeyProvider extends LanguageProvider {

	public final Locale locale;
	public final String modID;

	public ElectrodynamicsLangKeyProvider(DataGenerator gen, Locale locale, String modID) {
		super(gen, modID, locale.toString());
		this.locale = locale;
		this.modID = modID;
	}

	public ElectrodynamicsLangKeyProvider(DataGenerator gen, Locale local) {
		this(gen, local, References.ID);
	}

	@Override
	protected void addTranslations() {

		switch (locale) {
		case EN_US:
		default:

			add("itemGroup.itemgroup" + References.ID, "Electrodynamics");
			add("itemGroup.itemgroupelectrogrid", "Electrodynamics Grid");

			addItem(ElectrodynamicsItems.ITEM_BATTERY, "Battery");
			addItem(ElectrodynamicsItems.ITEM_LITHIUMBATTERY, "Lithium Battery");
			addItem(ElectrodynamicsItems.ITEM_CARBYNEBATTERY, "Carbyne Battery");

			addItem(ElectrodynamicsItems.ITEM_COMBATHELMET, "Combat Helmet");
			addItem(ElectrodynamicsItems.ITEM_COMBATCHESTPLATE, "Combat Chestplate");
			addItem(ElectrodynamicsItems.ITEM_COMBATLEGGINGS, "Combat Leggings");
			addItem(ElectrodynamicsItems.ITEM_COMBATBOOTS, "Combat Boots");

			addItem(ElectrodynamicsItems.ITEM_COMPOSITEHELMET, "Composite Helmet");
			addItem(ElectrodynamicsItems.ITEM_COMPOSITECHESTPLATE, "Composite Chestplate");
			addItem(ElectrodynamicsItems.ITEM_COMPOSITELEGGINGS, "Composite Leggings");
			addItem(ElectrodynamicsItems.ITEM_COMPOSITEBOOTS, "Composite Boots");

			addItem(ElectrodynamicsItems.ITEM_ELECTRICBATON, "Electric Baton");
			addItem(ElectrodynamicsItems.ITEM_ELECTRICCHAINSAW, "Electric Chainsaw");
			addItem(ElectrodynamicsItems.ITEM_ELECTRICDRILL, "Electric Drill");
			addItem(ElectrodynamicsItems.ITEM_HYDRAULICBOOTS, "Hydraulic Boots");
			addItem(ElectrodynamicsItems.ITEM_INSULATION, "Insulation");
			addItem(ElectrodynamicsItems.ITEM_JETPACK, "Jetpack");
			addItem(ElectrodynamicsItems.ITEM_KINETICRAILGUN, "Kinetic Rail Gun");
			addItem(ElectrodynamicsItems.GUIDEBOOK, "EEC 1st Edition");
			addItem(ElectrodynamicsItems.ITEM_CANISTERREINFORCED, "Reinforced Canister");
			addItem(ElectrodynamicsItems.ITEM_PORTABLECYLINDER, "Portable Gas Cylinder");
			addItem(ElectrodynamicsItems.ITEM_WRENCH, "Wrench");
			addItem(ElectrodynamicsItems.ITEM_MECHANIZEDCROSSBOW, "Mechanized Crossbow");
			addItem(ElectrodynamicsItems.ITEM_MULTIMETER, "Handheld Multimeter");
			addItem(ElectrodynamicsItems.ITEM_NIGHTVISIONGOGGLES, "Night Vision Goggles");
			addItem(ElectrodynamicsItems.ITEM_PLASMARAILGUN, "Plasma Rail Gun");
			addItem(ElectrodynamicsItems.ITEM_RUBBERBOOTS, "Rubber Boots");
			addItem(ElectrodynamicsItems.ITEM_SEISMICSCANNER, "Seismic Scanner");
			addItem(ElectrodynamicsItems.ITEM_SERVOLEGGINGS, "Servo Leggings");

			addItem(ElectrodynamicsItems.ITEM_SHEETPLASTIC, "Polyethylene Sheet");
			addItem(ElectrodynamicsItems.ITEM_SOLARPANELPLATE, "Solar Panel Plate");
			addItem(ElectrodynamicsItems.ITEM_TITANIUM_COIL, "Titanium Coil");
			addItem(ElectrodynamicsItems.ITEM_SLAG, "Metallic Slag");
			addItem(ElectrodynamicsItems.ITEM_CERAMICINSULATION, "Ceramic Insulation");
			addItem(ElectrodynamicsItems.ITEM_COIL, "Copper Coil");
			addItem(ElectrodynamicsItems.ITEM_MOLYBDENUMFERTILIZER, "Fertilizer");
			addItem(ElectrodynamicsItems.ITEM_MOTOR, "Motor");
			addItem(ElectrodynamicsItems.ITEM_COAL_COKE, "Coal Coke");
			addItem(ElectrodynamicsItems.ITEM_RAWCOMPOSITEPLATING, "Raw Composite Plating");
			addItem(ElectrodynamicsItems.ITEM_COMPOSITEPLATING, "Composite Plating");
			addItem(ElectrodynamicsItems.ITEM_PLASTIC_FIBERS, "Polyethlyene Fibers");
			addItem(ElectrodynamicsItems.ITEM_MECHANICALVALVE, "Mechanical Valve");
			addItem(ElectrodynamicsItems.ITEM_PRESSUREGAGE, "Pressure Gauge");
			addItem(ElectrodynamicsItems.ITEM_FIBERGLASSSHEET, "Fiberglass Sheet");
			
			addItem(ElectrodynamicsItems.getItem(SubtypeCeramic.cooked), "Ceramic");
			addItem(ElectrodynamicsItems.getItem(SubtypeCeramic.fuse), "Ceramic Fuse");
			addItem(ElectrodynamicsItems.getItem(SubtypeCeramic.plate), "Ceramic Plate");
			addItem(ElectrodynamicsItems.getItem(SubtypeCeramic.wet), "Wet Ceramic");

			addItem(ElectrodynamicsItems.getItem(SubtypeCircuit.basic), "Basic Circuit");
			addItem(ElectrodynamicsItems.getItem(SubtypeCircuit.advanced), "Advanced Circuit");
			addItem(ElectrodynamicsItems.getItem(SubtypeCircuit.elite), "Elite Circuit");
			addItem(ElectrodynamicsItems.getItem(SubtypeCircuit.ultimate), "Ultimate Circuit");

			addItem(ElectrodynamicsItems.getItem(SubtypeCrystal.copper), "Copper Sulfate Crystal");
			addItem(ElectrodynamicsItems.getItem(SubtypeCrystal.gold), "Gold Sulfate Crystal");
			addItem(ElectrodynamicsItems.getItem(SubtypeCrystal.halite), "Halite Crystal");
			addItem(ElectrodynamicsItems.getItem(SubtypeCrystal.iron), "Iron Sulfate Crystal");
			addItem(ElectrodynamicsItems.getItem(SubtypeCrystal.lead), "Lead Sulfate Crystal");
			addItem(ElectrodynamicsItems.getItem(SubtypeCrystal.lithium), "Lithium Sulfate Crystal");
			addItem(ElectrodynamicsItems.getItem(SubtypeCrystal.molybdenum), "Molybdenum Sulfate Crystal");
			addItem(ElectrodynamicsItems.getItem(SubtypeCrystal.netherite), "Carbyne Sulfate Crystal");
			addItem(ElectrodynamicsItems.getItem(SubtypeCrystal.potassiumchloride), "Sylvite Crystal");
			addItem(ElectrodynamicsItems.getItem(SubtypeCrystal.silver), "Silver Sulfate Crystal");
			addItem(ElectrodynamicsItems.getItem(SubtypeCrystal.tin), "Tin Sulfate Crystal");
			addItem(ElectrodynamicsItems.getItem(SubtypeCrystal.vanadium), "Vanadium Sulfate Crystal");

			addItem(ElectrodynamicsItems.getItem(SubtypeDrillHead.hslasteel), "HSLA Drill Head");
			addItem(ElectrodynamicsItems.getItem(SubtypeDrillHead.stainlesssteel), "Stainless Drill Head");
			addItem(ElectrodynamicsItems.getItem(SubtypeDrillHead.steel), "Steel Drill Head");
			addItem(ElectrodynamicsItems.getItem(SubtypeDrillHead.titanium), "Titanium Drill Head");
			addItem(ElectrodynamicsItems.getItem(SubtypeDrillHead.titaniumcarbide), "Carbide Drill Head");

			addItem(ElectrodynamicsItems.getItem(SubtypeDust.bronze), "Bronze Blend");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.copper), "Copper Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.endereye), "Ender Eye Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.gold), "Gold Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.iron), "Iron Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.lead), "Lead Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.lithium), "Lithium Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.molybdenum), "Molybdenum Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.netherite), "Carbyne Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.niter), "Niter");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.obsidian), "Obsidian Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.salt), "Salt");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.silica), "Silica Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.steel), "Steel Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.silver), "Silver Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.sulfur), "Sulfur");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.superconductive), "Superconductive Blend");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.tin), "Tin Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeDust.vanadium), "Vanadium Dust");

			addItem(ElectrodynamicsItems.getItem(SubtypeGear.bronze), "Bronze Gear");
			addItem(ElectrodynamicsItems.getItem(SubtypeGear.copper), "Copper Gear");
			addItem(ElectrodynamicsItems.getItem(SubtypeGear.iron), "Iron Gear");
			addItem(ElectrodynamicsItems.getItem(SubtypeGear.steel), "Steel Gear");
			addItem(ElectrodynamicsItems.getItem(SubtypeGear.tin), "Tin Gear");

			addItem(ElectrodynamicsItems.getItem(SubtypeImpureDust.copper), "Impure Copper Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeImpureDust.gold), "Impure Gold Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeImpureDust.iron), "Impure Iron Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeImpureDust.lead), "Impure Lead Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeImpureDust.lithium), "Impure Lithium Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeImpureDust.molybdenum), "Impure Molybdenum Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeImpureDust.netherite), "Impure Carbyne Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeImpureDust.silver), "Impure Silver Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeImpureDust.tin), "Impure Tin Dust");
			addItem(ElectrodynamicsItems.getItem(SubtypeImpureDust.vanadium), "Impure Vanadium Dust");

			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.aluminum), "Aluminum Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.bronze), "Bronze Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.chromium), "Chromium Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.hslasteel), "HSLA Steel Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.lead), "Lead Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.lithium), "Lithium Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.molybdenum), "Molybdenum Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.silver), "Silver Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.stainlesssteel), "Stainless Steel Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.steel), "Steel Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.superconductive), "Superconductive Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.tin), "Tin Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.titanium), "Titanium Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.titaniumcarbide), "Titanium Carbide Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.vanadium), "Vanadium Ingot");
			addItem(ElectrodynamicsItems.getItem(SubtypeIngot.vanadiumsteel), "Vanadium Steel Ingot");

			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.advancedcapacity), "Advanced Capacity Upgrade");
			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.advancedspeed), "Advanced Speed Upgrade");
			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.basiccapacity), "Basic Capacity Upgrade");
			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.basicspeed), "Basic Speed Upgrade");
			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.experience), "Experience Upgrade");
			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.fortune), "Fortune Upgrade");
			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.improvedsolarcell), "Solar Cell Upgrade");
			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.iteminput), "Auto-Injector Upgrade");
			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.itemoutput), "Auto-Ejector Upgrade");
			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.itemvoid), "Void Upgrade");
			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.range), "Range Upgrade");
			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.silktouch), "Silk Touch Upgrade");
			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.stator), "Stator Upgrade");
			addItem(ElectrodynamicsItems.getItem(SubtypeItemUpgrade.unbreaking), "Unbreaking Upgrade");

			addItem(ElectrodynamicsItems.getItem(SubtypeNugget.copper), "Copper Nugget");
			addItem(ElectrodynamicsItems.getItem(SubtypeNugget.hslasteel), "HSLA Steel Nugget");
			addItem(ElectrodynamicsItems.getItem(SubtypeNugget.silver), "Silver Nugget");
			addItem(ElectrodynamicsItems.getItem(SubtypeNugget.steel), "Steel Nugget");
			addItem(ElectrodynamicsItems.getItem(SubtypeNugget.stainlesssteel), "Stainless Steel Nugget");
			addItem(ElectrodynamicsItems.getItem(SubtypeNugget.superconductive), "Superconductive Nugget");
			addItem(ElectrodynamicsItems.getItem(SubtypeNugget.tin), "Tin Nugget");
			addItem(ElectrodynamicsItems.getItem(SubtypeNugget.titaniumcarbide), "Titanium Carbide Nugget");

			addItem(ElectrodynamicsItems.getItem(SubtypeOxide.calciumcarbonate), "Calcium Carbonate");
			addItem(ElectrodynamicsItems.getItem(SubtypeOxide.chromite), "Chromium Oxide");
			addItem(ElectrodynamicsItems.getItem(SubtypeOxide.chromiumdisilicide), "Chromium Disilicide");
			addItem(ElectrodynamicsItems.getItem(SubtypeOxide.disulfur), "Sulfur Dioxide");
			addItem(ElectrodynamicsItems.getItem(SubtypeOxide.dititanium), "Titanium Dioxide");
			addItem(ElectrodynamicsItems.getItem(SubtypeOxide.sodiumcarbonate), "Sodium Carbonate");
			addItem(ElectrodynamicsItems.getItem(SubtypeOxide.sulfurdichloride), "Sulfur Dichloride");
			addItem(ElectrodynamicsItems.getItem(SubtypeOxide.thionylchloride), "Thionyl Chloride");
			addItem(ElectrodynamicsItems.getItem(SubtypeOxide.trisulfur), "Sulfur Trioxide");
			addItem(ElectrodynamicsItems.getItem(SubtypeOxide.vanadium), "Vanadium Oxide");

			addItem(ElectrodynamicsItems.getItem(SubtypePlate.aluminum), "Aluminum Plate");
			addItem(ElectrodynamicsItems.getItem(SubtypePlate.bronze), "Bronze Plate");
			addItem(ElectrodynamicsItems.getItem(SubtypePlate.hslasteel), "HSLA Steel Plate");
			addItem(ElectrodynamicsItems.getItem(SubtypePlate.iron), "Iron Plate");
			addItem(ElectrodynamicsItems.getItem(SubtypePlate.lead), "Lead Plate");
			addItem(ElectrodynamicsItems.getItem(SubtypePlate.lithium), "Lithium Plate");
			addItem(ElectrodynamicsItems.getItem(SubtypePlate.copper), "Copper Plate");
			addItem(ElectrodynamicsItems.getItem(SubtypePlate.stainlesssteel), "Stainless Steel Plate");
			addItem(ElectrodynamicsItems.getItem(SubtypePlate.steel), "Steel Plate");
			addItem(ElectrodynamicsItems.getItem(SubtypePlate.titanium), "Titanium Plate");
			addItem(ElectrodynamicsItems.getItem(SubtypePlate.titaniumcarbide), "Titanium Carbide Plate");
			addItem(ElectrodynamicsItems.getItem(SubtypePlate.vanadiumsteel), "Vanadium Steel Plate");

			addItem(ElectrodynamicsItems.getItem(SubtypeRawOre.chromium), "Raw Chromite");
			addItem(ElectrodynamicsItems.getItem(SubtypeRawOre.fluorite), "Raw Fluorite Crystal");
			addItem(ElectrodynamicsItems.getItem(SubtypeRawOre.lead), "Raw Galena");
			addItem(ElectrodynamicsItems.getItem(SubtypeRawOre.lepidolite), "Raw Lepidolite");
			addItem(ElectrodynamicsItems.getItem(SubtypeRawOre.silver), "Raw Argentite");
			addItem(ElectrodynamicsItems.getItem(SubtypeRawOre.thorium), "Raw Thorianite");
			addItem(ElectrodynamicsItems.getItem(SubtypeRawOre.tin), "Raw Cassiterite");
			addItem(ElectrodynamicsItems.getItem(SubtypeRawOre.titanium), "Raw Rutile");
			addItem(ElectrodynamicsItems.getItem(SubtypeRawOre.uranium), "Raw Uraninite");
			addItem(ElectrodynamicsItems.getItem(SubtypeRawOre.vanadinite), "Raw Vanadinite");

			addItem(ElectrodynamicsItems.getItem(SubtypeRod.hslasteel), "HSLA Steel Rod");
			addItem(ElectrodynamicsItems.getItem(SubtypeRod.stainlesssteel), "Stainless Steel Rod");
			addItem(ElectrodynamicsItems.getItem(SubtypeRod.steel), "Steel Rod");
			addItem(ElectrodynamicsItems.getItem(SubtypeRod.titaniumcarbide), "Titanium Carbide Rod");

			addBlock(ElectrodynamicsBlocks.BLOCK_FRAME, "Quarry Frame");
			addBlock(ElectrodynamicsBlocks.BLOCK_FRAME_CORNER, "Quarry Frame Corner");
			addBlock(ElectrodynamicsBlocks.BLOCK_LOGISTICALMANAGER, "Logistical Manager");
			addBlock(ElectrodynamicsBlocks.BLOCK_SEISMICMARKER, "Seismic Marker");
			addBlock(ElectrodynamicsBlocks.BLOCK_MULTISUBNODE, "Multiblock Subnode");

			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeGlass.aluminum), "ALON");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeGlass.clear), "Clear Glass");

			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.advancedsolarpanel), "Advanced Solar Panel");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.batterybox), "Battery Box");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.carbynebatterybox), "Carbyne Battery Box");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.chargerlv), "120V Charger");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.chargermv), "240V Charger");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.chargerhv), "480V Charger");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.chemicalcrystallizer), "Chemical Crystallizer");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.chemicalmixer), "Chemical Mixer");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.circuitbreaker), "Circuit Breaker");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.coalgenerator), "Coal Generator");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.combustionchamber), "Combustion Chamber");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.coolantresavoir), "Coolant Resavoir");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.creativefluidsource), "Creative Fluid Source");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.creativepowersource), "Creative Power Source");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.downgradetransformer), "Downgrade Transformer");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.electricarcfurnace), "Electric Arc Furnace");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.electricarcfurnacedouble), "Double Electric Arc Furnace");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.electricarcfurnacetriple), "Triple Electric Arc Furnace");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.electricfurnace), "Electric Furnace");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.electricfurnacedouble), "Double Electric Furnace");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.electricfurnacetriple), "Triple Electric Furnace");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.electricpump), "Electric Pump");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.electrolyticseparator), "Electrolyic Separator");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.energizedalloyer), "Energized Alloyer");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.fermentationplant), "Fermentation Plant");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.fluidvoid), "Fluid Void");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.hydroelectricgenerator), "Hydroelectric Generator");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.lathe), "Lathe");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.lithiumbatterybox), "Lithium Battery Box");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.mineralcrusher), "Mineral Crusher");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.mineralcrusherdouble), "Double Mineral Crusher");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.mineralcrushertriple), "Triple Mineral Crusher");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.mineralgrinder), "Mineral Grinder");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.mineralgrinderdouble), "Double Mineral Grinder");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.mineralgrindertriple), "Triple Mineral Grinder");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.mineralwasher), "Mineral Washer");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.motorcomplex), "Motor Complex");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.multimeterblock), "Multimeter Block");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.oxidationfurnace), "Chemical Furnace");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.quarry), "Quarry");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.reinforcedalloyer), "Reinforced Alloyer");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.seismicrelay), "Seismic Relay");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.solarpanel), "Solar Panel");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.tanksteel), "Steel Tank");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.tankreinforced), "Reinforced Tank");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.tankhsla), "HSLA Tank");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.thermoelectricgenerator), "Thermoelectric Generator");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.upgradetransformer), "Upgrade Transformer");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.windmill), "Windmill");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.wiremill), "Wire Mill");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.wiremilldouble), "Double Wire Mill");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.wiremilltriple), "Triple Wire Mill");

			addBlock(ElectrodynamicsBlocks.blockCompressor, "Compressor");
			addBlock(ElectrodynamicsBlocks.blockDecompressor, "Decompressor");
			addBlock(ElectrodynamicsBlocks.blockGasTransformerAddonTank, "Pressurized Tank");
			addBlock(ElectrodynamicsBlocks.blockGasTransformerSide, "Compressor Side");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.gasvent), "Gas Vent");
			addBlock(ElectrodynamicsBlocks.blockThermoelectricManipulator, "Thermoelectric Manipulator");

			addBlock(ElectrodynamicsBlocks.blockGasValve, "Gas Valve");
			addBlock(ElectrodynamicsBlocks.blockFluidValve, "Fluid Valve");
			addBlock(ElectrodynamicsBlocks.blockGasPipePump, "Gas Pipe Pump");
			addBlock(ElectrodynamicsBlocks.blockFluidPipePump, "Fluid Pipe Pump");
			addBlock(ElectrodynamicsBlocks.blockGasPipeFilter, "Gas Pipe Filter");
			addBlock(ElectrodynamicsBlocks.blockFluidPipeFilter, "Fluid Pipe Filter");

			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.relay), "Relay");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.potentiometer), "Potentiometer");

			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.aluminum), "Bauxite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.chromium), "Chromite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.fluorite), "Fluorite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.lead), "Galena Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.lithium), "Lepidolite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.molybdenum), "Molybdenite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.monazite), "Monazite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.niter), "Saltpeter Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.salt), "Halite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.silver), "Argentite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.sulfur), "Sulfur Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.sylvite), "Sylvite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.titanium), "Rutile Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.tin), "Cassiterite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.thorium), "Thorianite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.uranium), "Uraninite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOre.vanadium), "Vanadinite Ore");

			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.aluminum), "Deep Bauxite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.chromium), "Deep Chromite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.fluorite), "Deep Fluorite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.lead), "Deep Galena Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.lithium), "Deep Lepidolite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.molybdenum), "Deep Molybdenite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.monazite), "Deep Monazite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.niter), "Deep Saltpeter Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.salt), "Deep Halite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.silver), "Deep Argentite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.sulfur), "Deep Sulfur Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.sylvite), "Deep Sylvite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.tin), "Deep Cassiterite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.titanium), "Deep Rutile Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.thorium), "Deep Thorianite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.uranium), "Deep Uraninite Ore");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeOreDeepslate.vanadium), "Deep Vanadinite Ore");

			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeFluidPipe.copper), "Copper Fluid Pipe");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeFluidPipe.steel), "Steel Fluid Pipe");

			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeRawOreBlock.chromium), "Block of Raw Chromite");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeRawOreBlock.lead), "Block of Raw Galena");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeRawOreBlock.silver), "Block of Raw Argentite");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeRawOreBlock.thorium), "Block of Raw Thorianite");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeRawOreBlock.tin), "Block of Raw Cassiterite");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeRawOreBlock.titanium), "Block of Raw Rutile");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeRawOreBlock.uranium), "Block of Raw Uraninite");

			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeResourceBlock.aluminum), "Block of Aluminum");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeResourceBlock.bronze), "Block of Bronze");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeResourceBlock.chromium), "Block of Chromium");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeResourceBlock.hslasteel), "Block of HSLA Steel");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeResourceBlock.lead), "Block of Lead");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeResourceBlock.silver), "Block of Silver");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeResourceBlock.stainlesssteel), "Block of Stainless Steel");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeResourceBlock.steel), "Block of Steel");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeResourceBlock.tin), "Block of Tin");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeResourceBlock.titanium), "Block of Titanium");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeResourceBlock.titaniumcarbide), "Block of Titanium Carbide");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeResourceBlock.vanadiumsteel), "Block of Vanadium Steel");

			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.copper), "Copper Wire");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.gold), "Gold Wire");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.iron), "Iron Wire");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.silver), "Silver Wire");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.superconductive), "Superconductive Wire");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.tin), "Tin Wire");
			
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedcopperblack), "Insulated Copper Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedgoldblack), "Insulated Gold Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedironblack), "Insulated Iron Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsilverblack), "Insulated Silver Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsuperconductiveblack), "Insulated Superconductive Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedtinblack), "Insulated Tin Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedcopperred), "Insulated Copper Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedgoldred), "Insulated Gold Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedironred), "Insulated Iron Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsilverred), "Insulated Silver Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsuperconductivered), "Insulated Superconductive Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedtinred), "Insulated Tin Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedcoppergreen), "Insulated Copper Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedgoldgreen), "Insulated Gold Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedirongreen), "Insulated Iron Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsilvergreen), "Insulated Silver Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsuperconductivegreen), "Insulated Superconductive Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedtingreen), "Insulated Tin Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedcopperblue), "Insulated Copper Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedgoldblue), "Insulated Gold Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedironblue), "Insulated Iron Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsilverblue), "Insulated Silver Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsuperconductiveblue), "Insulated Superconductive Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedtinblue), "Insulated Tin Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedcopperwhite), "Insulated Copper Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedgoldwhite), "Insulated Gold Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedironwhite), "Insulated Iron Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsilverwhite), "Insulated Silver Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsuperconductivewhite), "Insulated Superconductive Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedtinwhite), "Insulated Tin Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedcopperyellow), "Insulated Copper Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedgoldyellow), "Insulated Gold Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedironyellow), "Insulated Iron Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsilveryellow), "Insulated Silver Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsuperconductiveyellow), "Insulated Superconductive Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedtinyellow), "Insulated Tin Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedcopperbrown), "Insulated Copper Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedgoldbrown), "Insulated Gold Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedironbrown), "Insulated Iron Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsilverbrown), "Insulated Silver Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedsuperconductivebrown), "Insulated Superconductive Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.insulatedtinbrown), "Insulated Tin Wire (Brown)");
			
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedcopperblack), "Ceramic Copper Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedgoldblack), "Ceramic Gold Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedironblack), "Ceramic Iron Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsilverblack), "Ceramic Silver Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsuperconductiveblack), "Ceramic Superconductive Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedtinblack), "Ceramic Tin Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedcopperred), "Ceramic Copper Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedgoldred), "Ceramic Gold Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedironred), "Ceramic Iron Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsilverred), "Ceramic Silver Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsuperconductivered), "Ceramic Superconductive Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedtinred), "Ceramic Tin Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedcopperwhite), "Ceramic Copper Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedgoldwhite), "Ceramic Gold Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedironwhite), "Ceramic Iron Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsilverwhite), "Ceramic Silver Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsuperconductivewhite), "Ceramic Superconductive Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedtinwhite), "Ceramic Tin Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedcoppergreen), "Ceramic Copper Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedgoldgreen), "Ceramic Gold Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedirongreen), "Ceramic Iron Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsilvergreen), "Ceramic Silver Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsuperconductivegreen), "Ceramic Superconductive Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedtingreen), "Ceramic Tin Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedcopperblue), "Ceramic Copper Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedgoldblue), "Ceramic Gold Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedironblue), "Ceramic Iron Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsilverblue), "Ceramic Silver Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsuperconductiveblue), "Ceramic Superconductive Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedtinblue), "Ceramic Tin Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedcopperyellow), "Ceramic Copper Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedgoldyellow), "Ceramic Gold Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedironyellow), "Ceramic Iron Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsilveryellow), "Ceramic Silver Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsuperconductiveyellow), "Ceramic Superconductive Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedtinyellow), "Ceramic Tin Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedcopperbrown), "Ceramic Copper Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedgoldbrown), "Ceramic Gold Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedironbrown), "Ceramic Iron Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsilverbrown), "Ceramic Silver Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedsuperconductivebrown), "Ceramic Superconductive Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.ceramicinsulatedtinbrown), "Ceramic Tin Wire (Brown)");
			
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticscopperblack), "Logistical Copper Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsgoldblack), "Logistical Gold Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsironblack), "Logistical Iron Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssilverblack), "Logistical Silver Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssuperconductiveblack), "Logistical Superconductive Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticstinblack), "Logistical Tin Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticscopperred), "Logistical Copper Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsgoldred), "Logistical Gold Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsironred), "Logistical Iron Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssilverred), "Logistical Silver Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssuperconductivered), "Logistical Superconductive Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticstinred), "Logistical Tin Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticscopperwhite), "Logistical Copper Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsgoldwhite), "Logistical Gold Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsironwhite), "Logistical Iron Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssilverwhite), "Logistical Silver Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssuperconductivewhite), "Logistical Superconductive Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticstinwhite), "Logistical Tin Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticscoppergreen), "Logistical Copper Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsgoldgreen), "Logistical Gold Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsirongreen), "Logistical Iron Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssilvergreen), "Logistical Silver Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssuperconductivegreen), "Logistical Superconductive Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticstingreen), "Logistical Tin Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticscopperblue), "Logistical Copper Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsgoldblue), "Logistical Gold Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsironblue), "Logistical Iron Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssilverblue), "Logistical Silver Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssuperconductiveblue), "Logistical Superconductive Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticstinblue), "Logistical Tin Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticscopperyellow), "Logistical Copper Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsgoldyellow), "Logistical Gold Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsironyellow), "Logistical Iron Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssilveryellow), "Logistical Silver Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssuperconductiveyellow), "Logistical Superconductive Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticstinyellow), "Logistical Tin Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticscopperbrown), "Logistical Copper Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsgoldbrown), "Logistical Gold Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticsironbrown), "Logistical Iron Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssilverbrown), "Logistical Silver Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticssuperconductivebrown), "Logistical Superconductive Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.logisticstinbrown), "Logistical Tin Wire (Brown)");
			
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedcopperblack), "Thick Copper Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedgoldblack), "Thick Gold Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedironblack), "Thick Iron Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsilverblack), "Thick Silver Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsuperconductiveblack), "Thick Superconductive Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedtinblack), "Thick Tin Wire (Black)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedcopperred), "Thick Copper Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedgoldred), "Thick Gold Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedironred), "Thick Iron Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsilverred), "Thick Silver Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsuperconductivered), "Thick Superconductive Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedtinred), "Thick Tin Wire (Red)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedcoppergreen), "Thick Copper Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedgoldgreen), "Thick Gold Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedirongreen), "Thick Iron Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsilvergreen), "Thick Silver Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsuperconductivegreen), "Thick Superconductive Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedtingreen), "Thick Tin Wire (Green)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedcopperblue), "Thick Copper Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedgoldblue), "Thick Gold Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedironblue), "Thick Iron Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsilverblue), "Thick Silver Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsuperconductiveblue), "Thick Superconductive Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedtinblue), "Thick Tin Wire (Blue)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedcopperwhite), "Thick Copper Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedgoldwhite), "Thick Gold Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedironwhite), "Thick Iron Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsilverwhite), "Thick Silver Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsuperconductivewhite), "Thick Superconductive Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedtinwhite), "Thick Tin Wire (White)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedcopperyellow), "Thick Copper Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedgoldyellow), "Thick Gold Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedironyellow), "Thick Iron Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsilveryellow), "Thick Silver Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsuperconductiveyellow), "Thick Superconductive Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedtinyellow), "Thick Tin Wire (Yellow)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedcopperbrown), "Thick Copper Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedgoldbrown), "Thick Gold Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedironbrown), "Thick Iron Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsilverbrown), "Thick Silver Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedsuperconductivebrown), "Thick Superconductive Wire (Brown)");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeWire.highlyinsulatedtinbrown), "Thick Tin Wire (Brown)");

			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeGasPipe.UNINSULATEDCOPPER), "Copper Gas Pipe");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeGasPipe.UNINSULATEDSTEEL), "Steel Gas Pipe");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeGasPipe.UNINSULATEDPLASTIC), "Plastic Gas Pipe");
			// addBlock(ElectrodynamicsBlocks.getBlock(SubtypeGasPipe.WOOLINSULATEDCOPPER), "Woolen Copper Gas Pipe");
			// addBlock(ElectrodynamicsBlocks.getBlock(SubtypeGasPipe.WOOLINSULATEDSTEEL), "Woolen Steel Gas Pipe");
			// addBlock(ElectrodynamicsBlocks.getBlock(SubtypeGasPipe.WOOLINSULATEDPLASTIC), "Woolen Plastic Gas Pipe");
			// addBlock(ElectrodynamicsBlocks.getBlock(SubtypeGasPipe.CERAMICINSULATEDCOPPER), "Ceramic Copper Gas Pipe");
			// addBlock(ElectrodynamicsBlocks.getBlock(SubtypeGasPipe.CERAMICINSULATEDSTEEL), "Ceramic Steel Gas Pipe");
			// addBlock(ElectrodynamicsBlocks.getBlock(SubtypeGasPipe.CERAMICINSULATEDPLASTIC), "Ceramic Plastic Gas Pipe");

			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.gastanksteel), "Steel Gas Cylinder");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.gastankreinforced), "Reinforced Gas Cylinder");
			addBlock(ElectrodynamicsBlocks.getBlock(SubtypeMachine.gastankhsla), "HSLA Gas Cylinder");
			
			addBlock(ElectrodynamicsBlocks.blockSteelScaffold, "Steel Scaffold");

			addFluid(ElectrodynamicsFluids.fluidClay, "Clay Slurry");
			addFluid(ElectrodynamicsFluids.fluidEthanol, "Ethanol");
			addFluid(ElectrodynamicsFluids.fluidHydraulic, "Hydraulic Fluid");
			addFluid(ElectrodynamicsFluids.fluidHydrogen, "Liquid Hydrogen");
			addFluid(ElectrodynamicsFluids.fluidHydrogenFluoride, "Hydrofluoric Acid");
			addFluid(ElectrodynamicsFluids.fluidOxygen, "Liquid Oxygen");
			addFluid(ElectrodynamicsFluids.fluidPolyethylene, "Molten Polyethylene");
			addFluid(ElectrodynamicsFluids.fluidSulfuricAcid, "Sulfuric Acid");
			addFluid(ElectrodynamicsFluids.getFluid(SubtypeSulfateFluid.copper), "Copper Sulfate");
			addFluid(ElectrodynamicsFluids.getFluid(SubtypeSulfateFluid.gold), "Gold Sulfate");
			addFluid(ElectrodynamicsFluids.getFluid(SubtypeSulfateFluid.iron), "Iron Sulfate");
			addFluid(ElectrodynamicsFluids.getFluid(SubtypeSulfateFluid.lead), "Lead Sulfate");
			addFluid(ElectrodynamicsFluids.getFluid(SubtypeSulfateFluid.lithium), "Lithium Sulfate");
			addFluid(ElectrodynamicsFluids.getFluid(SubtypeSulfateFluid.molybdenum), "Molybdenum Sulfate");
			addFluid(ElectrodynamicsFluids.getFluid(SubtypeSulfateFluid.netherite), "Carbyne Sulfate");
			addFluid(ElectrodynamicsFluids.getFluid(SubtypeSulfateFluid.silver), "Silver Sulfate");
			addFluid(ElectrodynamicsFluids.getFluid(SubtypeSulfateFluid.tin), "Tin Sulfate");
			addFluid(ElectrodynamicsFluids.getFluid(SubtypeSulfateFluid.vanadium), "Vanadium Sulfate");

			addGas(ElectrodynamicsGases.EMPTY, "Empty");
			addGas(ElectrodynamicsGases.HYDROGEN, "Hydrogen");
			addGas(ElectrodynamicsGases.OXYGEN, "Oxygen");
			addGas(ElectrodynamicsGases.STEAM, "Steam");

			addContainer(SubtypeMachine.advancedsolarpanel, "Advanced Solar Panel");
			addContainer(SubtypeMachine.batterybox, "Battery Box");
			addContainer(SubtypeMachine.carbynebatterybox, "Carbyne Battery Box");
			addContainer(SubtypeMachine.chargerlv, "120V Charger");
			addContainer(SubtypeMachine.chargermv, "240V Charger");
			addContainer(SubtypeMachine.chargerhv, "480V Charger");
			addContainer(SubtypeMachine.chemicalcrystallizer, "Chemical Crystallizer");
			addContainer(SubtypeMachine.chemicalmixer, "Chemical Mixer");
			addContainer(SubtypeMachine.coalgenerator, "Coal Generator");
			addContainer(SubtypeMachine.coolantresavoir, "Coolant Resavoir");
			addContainer(SubtypeMachine.combustionchamber, "Combustion Chamber");
			addContainer(SubtypeMachine.creativefluidsource, "Creative Fluid Source");
			addContainer(SubtypeMachine.creativepowersource, "Creative Power Source");
			addContainer(SubtypeMachine.electricarcfurnace, "Arc Furnace");
			addContainer(SubtypeMachine.electricarcfurnacedouble, "Double Arc Furnace");
			addContainer(SubtypeMachine.electricarcfurnacetriple, "Triple Arc Furnace");
			addContainer(SubtypeMachine.electricfurnace, "Electric Furnace");
			addContainer(SubtypeMachine.electricfurnacedouble, "Double Electric Furnace");
			addContainer(SubtypeMachine.electricfurnacetriple, "Triple Electric Furnace");
			addContainer(SubtypeMachine.electrolyticseparator, "Electrolytic Separator");
			addContainer(SubtypeMachine.energizedalloyer, "Energized Alloyer");
			addContainer(SubtypeMachine.fermentationplant, "Fermentation Plant");
			addContainer(SubtypeMachine.fluidvoid, "Fluid Void");
			addContainer(SubtypeMachine.hydroelectricgenerator, "Hydroelectric Generator");
			addContainer(SubtypeMachine.lathe, "Lathe");
			addContainer(SubtypeMachine.lithiumbatterybox, "Lithium Battery Box");
			addContainer(SubtypeMachine.mineralcrusher, "Mineral Crusher");
			addContainer(SubtypeMachine.mineralcrusherdouble, "Double Mineral Crusher");
			addContainer(SubtypeMachine.mineralcrushertriple, "Triple Mineral Crusher");
			addContainer(SubtypeMachine.mineralgrinder, "Mineral Grinder");
			addContainer(SubtypeMachine.mineralgrinderdouble, "Double Mineral Grinder");
			addContainer(SubtypeMachine.mineralgrindertriple, "Triple Mineral Grinder");
			addContainer(SubtypeMachine.mineralwasher, "Mineral Washer");
			addContainer(SubtypeMachine.motorcomplex, "Motor Complex");
			addContainer(SubtypeMachine.oxidationfurnace, "Chemical Furnace");
			addContainer(SubtypeMachine.quarry, "Quarry");
			addContainer(SubtypeMachine.reinforcedalloyer, "Reinforced Alloyer");
			addContainer(SubtypeMachine.seismicrelay, "Seismic Relay");
			addContainer(SubtypeMachine.solarpanel, "Solar Panel");
			addContainer(SubtypeMachine.tanksteel, "Steel Tank");
			addContainer(SubtypeMachine.tankreinforced, "Reinforced Tank");
			addContainer(SubtypeMachine.tankhsla, "HSLA Tank");
			addContainer(SubtypeMachine.windmill, "Windmill");
			addContainer(SubtypeMachine.wiremill, "Wire Mill");
			addContainer(SubtypeMachine.wiremilldouble, "Double Wire Mill");
			addContainer(SubtypeMachine.wiremilltriple, "Triple Wire Mill");
			
			addContainer("guidebook", "Guidebook");
			addContainer("seismicscanner", "Seismic Scanner");
			addContainer("electricdrill", "Electric Drill");
			
			addContainer(SubtypeMachine.gastanksteel, "Steel Gas Cylinder");
			addContainer(SubtypeMachine.gastankreinforced, "Reinforced Gas Cylinder");
			addContainer(SubtypeMachine.gastankhsla, "HSLA Gas Cylinder");
			addContainer("compressor", "Compressor");
			addContainer("decompressor", "Decompressor");
			addContainer(SubtypeMachine.gasvent, "Gas Vent");
			addContainer("thermoelectricmanipulator", "Thermoelectric Manipulator");

			addContainer("gaspipepump", "Gas Pipe Pump");
			addContainer("fluidpipepump", "Fluid Pipe Pump");
			addContainer("gaspipefilter", "Gas Pipe Filter");
			addContainer("fluidpipefilter", "Fluid Pipe Filter");
			
			addContainer(SubtypeMachine.potentiometer, "Potentiometer");

			addTooltip("itemwire.resistance", "Resistance: %s");
			addTooltip("itemwire.maxamps", "Ampacity: %s");
			addTooltip("itemwire.info.insulationrating", "Insulation Rating: %s");
			addTooltip("itemwire.info.uninsulated", "Uninsulated!");
			addTooltip("itemwire.info.fireproof", "Fire-proof");
			addTooltip("itemwire.info.redstone", "Conducts Redstone");
			addTooltip("info.capacityupgrade", "Multiplies Energy Capacity and Transfer by %sx");
			addTooltip("info.capacityupgradevoltage", "Will upgrade machine voltage up to %s");
			addTooltip("info.speedupgrade", "Multiplies Speed by %sx");
			addTooltip("info.itemoutputupgrade", "Ejects items into adjacent inventories");
			addTooltip("info.iteminputupgrade", "Injects items from adjacent inventories");
			addTooltip("info.dirlist", "Current Directions:");
			addTooltip("info.nodirs", "Shift+Right-Click to add a direction");
			addTooltip("info.cleardirs", "Shift+Left-Click to clear directions");
			addTooltip("info.insmartmode", "Smart Mode");
			addTooltip("info.togglesmart", "Right-Click to toggle smart mode.");
			addTooltip("info.guidebookuse", "Shift+Right-Click to open wiki");
			addTooltip("info.guidebooktemp", "Book Coming Soon");
			addTooltip("info.xpstored", "Stored XP: %s");
			addTooltip("info.xpusage", "Shift+Right-Click to dispense");
			addTooltip("info.range", "Increases raduis by 1");
			addTooltip("info.broken", "NOT WORKING");
			addTooltip("transformer.energyloss", "Efficiency: 99.25%");
			addTooltip("machine.voltage", "Voltage: %s");
			addTooltip("item.electric.info", "Energy Stored: %s");
			addTooltip("item.electric.voltage", "I/O Voltage: %s");
			addTooltip("itemcanister", "1000 mB");
			addTooltip("railguntemp", "Temperature %s");
			addTooltip("railgunmaxtemp", "Max Temp: %s");
			addTooltip("railgunoverheat", "WARNING : OVERHEATING");
			addTooltip("ceramicplatecount", "Plates: %s");
			addTooltip("fluidtank.capacity", "Capacity: %s");
			addTooltip("creativepowersource.joke", "\"Unlimited Power\" - Buck Rogers from Star Trek");
			addTooltip("creativefluidsource.joke", "\"More\" - Crylo Ren");
			addTooltip("fluidvoid", "Voids fluids");
			addTooltip("seismicscanner.use", "Scans for ores in a 16 block radius");
			addTooltip("seismicscanner.opengui", "Right-Click to view status");
			addTooltip("seismicscanner.oncooldown", "COOLDOWN");
			addTooltip("seismicscanner.showuse", "Shift + Right-Click to scan");
			addTooltip("seismicscanner.currentore", "Current Ore: %s");
			addTooltip("seismicscanner.empty", "[None]");
			addTooltip("nightvisiongoggles.status", "Status: ");
			addTooltip("nightvisiongoggles.on", "ON");
			addTooltip("nightvisiongoggles.off", "OFF");
			addTooltip("jetpack.mode", "Mode: ");
			addTooltip("jetpack.moderegular", "Regular");
			addTooltip("jetpack.modehover", "Hover");
			addTooltip("jetpack.modeelytra", "Elytra");
			addTooltip("jetpack.modeoff", "Off");
			addTooltip("countdown.tickstillcheck", "Ticks left: %s");
			addTooltip("seismicmarker.redstone", "Apply redstone for guide lines");
			addTooltip("seismicrelay.use", "Detects and stores Marker rings");
			addTooltip("coolantresavoir.place", "Place above Quarry");
			addTooltip("motorcomplex.use", "Controls Speed of Quarry");
			addTooltip("blockframe.joke", "How did you get this!?!");
			addTooltip("quarry.power", "Upgrades require power to work");
			addTooltip("logisticalmanager.use", "Optional: manages quarry inventory");
			addTooltip("servolegs.step", "STEP");
			addTooltip("servolegs.both", "BOTH");
			addTooltip("servolegs.speed", "SPEED");
			addTooltip("servolegs.none", "NONE");
			addTooltip("currbattery", "Battery: %s");
			addTooltip("gasvent", "Voids gases");
			addTooltip("validupgrades", "Valid Upgrades:");
			addTooltip("electricdrill.miningspeed", "Mining Speed: %s");

			addTooltip("pipematerial", "Material: %s");
			addTooltip("pipeinsulationmaterial", "Insulation: %s");
			addTooltip("pipemaximumpressure", "Max Pressure: %s");
			addTooltip("pipeheatloss", "Heat Loss: -%s / block");

			addTooltip("pipematerialcopper", "Copper");
			addTooltip("pipematerialsteel", "Steel");
			addTooltip("pipematerialplastic", "Plastic");

			addTooltip("pipeinsulationnone", "None");
			addTooltip("pipeinsulationwool", "Wool");
			addTooltip("pipeinsulationceramic", "Ceramic");

			addTooltip("currentgas", "Gas: %s");
			addTooltip("gasamount", "Amount: %1$s / %2$s");
			addTooltip("gastemperature", "Temp: %s");
			addTooltip("gaspressure", "Pressure: %s");
			addTooltip("maxpressure", "Max Pressure: %s");
			addTooltip("maxtemperature", "Max Temp: %s");

			addTooltip("tankmaxin", "In %1$s : %2$s");
			addTooltip("tankmaxout", "Out %1$s : %2$s");

			addTooltip("addontankcap", "Increases capacity by %s");
			addTooltip("gastank.capacity", "Capacity : %s");

			addTooltip("gasvalve", "Blocks gases when powered with redstone");
			addTooltip("fluidvalve", "Blocks fluids when powered with redstone");
			
			addTooltip("guidebookjeiuse", "Press 'U' for uses");
			addTooltip("guidebookjeirecipe", "Press 'R' for recipes");
			
			addTooltip("guidebookname", "AKA Guidebook");
			
			addTooltip("electricdrill.overclock", "Overclock: %s");
			addTooltip("electricdrill.fortunelevel", "Fortune %s");
			addTooltip("electricdrill.silktouch", "Silk Touch");
			addTooltip("electricdrill.usage", "Use / Block: %s");
			
			addTooltip("potentiometer.use", "A programmable energy void");

			addGuiLabel("creativepowersource.voltage", "Voltage: ");
			addGuiLabel("creativepowersource.power", "Power: ");
			addGuiLabel("creativefluidsource.setfluid", "Set Fluid");
			addGuiLabel("machine.usage", "Usage: %s");
			addGuiLabel("machine.voltage", "Voltage: %s");
			addGuiLabel("machine.current", "Current: %s");
			addGuiLabel("machine.output", "Output: %s");
			addGuiLabel("machine.transfer", "Transfer: %s");
			addGuiLabel("machine.stored", "Stored: %s");
			addGuiLabel("machine.temperature", "Temperature: %s");
			addGuiLabel("machine.heat", "Heat: %s");
			addGuiLabel("coalgenerator.timeleft", "Time Left: %s");
			addGuiLabel("seismicscanner.dataheader", "Scan Results:");
			addGuiLabel("seismicscanner.notfound", "Block not found!");
			addGuiLabel("seismicscanner.xcoord", "X , %s");
			addGuiLabel("seismicscanner.ycoord", "Y , %s");
			addGuiLabel("seismicscanner.zcoord", "Z , %s");
			addGuiLabel("seismicscanner.xcoordna", "X , Not Found");
			addGuiLabel("seismicscanner.ycoordna", "Y , Not Found");
			addGuiLabel("seismicscanner.zcoordna", "Z , Not Found");
			addGuiLabel("seismicscanner.material", "Material:");
			addGuiLabel("genericcharger.chargeperc", "Charge: %s");
			addGuiLabel("genericcharger.chargecapable", "Possible: %s");
			addGuiLabel("seismicrelay.dataheader", "Markers");
			addGuiLabel("seismicrelay.posnotfound", "%s , Not Found");
			addGuiLabel("seismicrelay.posfound", "%1$s , %2$s");
			addGuiLabel("seismicrelay.posoptional", "%s , Optional");
			addGuiLabel("motorcomplex.speed", "Ticks per Block: %s");

			addGuiLabel("quarry.ringusage", "Ring Usage: %s");
			addGuiLabel("quarry.miningusage", "Drill Usage: %s");

			addGuiLabel("quarry.fortune", "Fortune: %s");
			addGuiLabel("quarry.silktouch", "Silk Touch: %s");
			addGuiLabel("quarry.unbreaking", "Unbreaking: %s");

			addGuiLabel("quarry.wateruse", "Coolant/Block: %s");

			addGuiLabel("quarry.motorcomplex", "Motor Complex");
			addGuiLabel("quarry.seismicrelay", "Seismic Relay");
			addGuiLabel("quarry.coolantresavoir", "Coolant Resavoir");

			addGuiLabel("quarry.voiditems", "Void List");
			addGuiLabel("quarry.needvoidcard", "No Card");

			addGuiLabel("quarry.status", "Status:");
			addGuiLabel("quarry.clearingarea", "Clearing...");
			addGuiLabel("quarry.setup", "Setting Up...");
			addGuiLabel("quarry.mining", "Mining...");
			addGuiLabel("quarry.notmining", "Error!");
			addGuiLabel("quarry.finished", "Finished!");

			addGuiLabel("quarry.miningposition", "Mining At: %s");
			addGuiLabel("quarry.notavailable", "N/A");

			addGuiLabel("quarry.drillhead", "Drill Head: %s");
			addGuiLabel("quarry.hashead", "Present");
			addGuiLabel("quarry.nohead", "Missing");

			addGuiLabel("quarry.errors", "Errors:");
			addGuiLabel("quarry.norelay", "No Relay");
			addGuiLabel("quarry.nomotorcomplex", "No Motor");
			addGuiLabel("quarry.nocoolantresavoir", "No Resavoir");
			addGuiLabel("quarry.nocorners", "Invalid Corners");
			addGuiLabel("quarry.motorcomplexnotpowered", "Motor Power");
			addGuiLabel("quarry.nopower", "Quarry Power");
			addGuiLabel("quarry.areanotclear", "Area Blocked");
			addGuiLabel("quarry.noring", "No Ring");
			addGuiLabel("quarry.missinghead", "No Drill Head");
			addGuiLabel("quarry.noerrors", "None");
			addGuiLabel("quarry.miningframe", "Active Frame");
			addGuiLabel("quarry.nocoolant", "Coolant Levels");
			addGuiLabel("quarry.inventoryroom", "Inventory Full");

			addGuiLabel("thermoelectricmanipulator.temp", "Temperature:");

			addGuiLabel("prioritypump.priority", "Priority");
			
			addGuiLabel("filter.blacklist",  "Blacklist");
			addGuiLabel("filter.whitelist", "Whitelist");
			
			addGuiLabel("multimeterblock.transfer", "Transfer: %s");
			addGuiLabel("multimeterblock.voltage", "Voltage: %s");
			addGuiLabel("multimeterblock.resistance", "Resistance: %s");
			addGuiLabel("multimeterblock.loss", "Loss: %s");
			addGuiLabel("multimeterblock.minvoltage", "Min Voltage: %s");
			
			addGuiLabel("potentiometer.watts", "W");
			addGuiLabel("potentiometer.usage", "Usage");
			
			
			
			addGuiLabel("displayunit.infinity.name", "Infinite");
			
			addGuiLabel("displayunit.ampere.name", "Ampere");
			addGuiLabel("displayunit.ampere.nameplural", "Amperes");
			addGuiLabel("displayunit.ampere.symbol", "A");
			addGuiLabel("displayunit.amphour.name", "Amp Hour");
			addGuiLabel("displayunit.amphour.nameplural", "Amp Hours");
			addGuiLabel("displayunit.amphour.symbol", "Ah");
			addGuiLabel("displayunit.voltage.name", "Volt");
			addGuiLabel("displayunit.voltage.nameplural", "Volts");
			addGuiLabel("displayunit.voltage.symbol", "V");
			addGuiLabel("displayunit.watt.name", "Watt");
			addGuiLabel("displayunit.watt.nameplural", "Watts");
			addGuiLabel("displayunit.watt.symbol", "W");
			addGuiLabel("displayunit.watthour.name", "Watt Hour");
			addGuiLabel("displayunit.watthour.nameplural", "Watt Hours");
			addGuiLabel("displayunit.watthour.symbol", "Wh");
			addGuiLabel("displayunit.resistance.name", "Ohm");
			addGuiLabel("displayunit.resistance.nameplural", "Ohms");
			addGuiLabel("displayunit.resistance.symbol", "" + '\u03A9');
			addGuiLabel("displayunit.conductance.name", "Siemen");
			addGuiLabel("displayunit.conductance.nameplural", "Siemens");
			addGuiLabel("displayunit.conductance.symbol", "S");
			addGuiLabel("displayunit.joules.name", "Joule");
			addGuiLabel("displayunit.joules.nameplural", "Joules");
			addGuiLabel("displayunit.joules.symbol", "J");
			addGuiLabel("displayunit.buckets.name", "Bucket");
			addGuiLabel("displayunit.buckets.nameplural", "Buckets");
			addGuiLabel("displayunit.buckets.symbol", "B");
			addGuiLabel("displayunit.tempkelvin.name", "Kelvin");
			addGuiLabel("displayunit.tempkelvin.nameplural", "Kelvin");
			addGuiLabel("displayunit.tempkelvin.symbol", "K");
			addGuiLabel("displayunit.tempcelcius.name", "Celcius");
			addGuiLabel("displayunit.tempcelcius.nameplural", "Celcius");
			addGuiLabel("displayunit.tempcelcius.symbol", "C");
			addGuiLabel("displayunit.tempfahrenheit.name", "Fahrenheit");
			addGuiLabel("displayunit.tempfahrenheit.nameplural", "Fahrenheit");
			addGuiLabel("displayunit.tempfahrenheit.symbol", "F");
			addGuiLabel("displayunit.timeseconds.name", "Second");
			addGuiLabel("displayunit.timeseconds.nameplural", "Seconds");
			addGuiLabel("displayunit.timeseconds.symbol", "s");
			addGuiLabel("displayunit.pressureatm.name", "Atmosphere");
			addGuiLabel("displayunit.pressureatm.nameplural", "Atmospheres");
			addGuiLabel("displayunit.pressureatm.symbol", "ATM");
			addGuiLabel("displayunit.percentage.name", "Percent");
			addGuiLabel("displayunit.percentage.nameplural", "Percent");
			addGuiLabel("displayunit.percentage.symbol", "%");
			
			
			addGuiLabel("measurementunit.pico.name", "Pico");
			addGuiLabel("measurementunit.pico.symbol", "p");
			addGuiLabel("measurementunit.nano.name", "Nano");
			addGuiLabel("measurementunit.nano.symbol", "n");
			addGuiLabel("measurementunit.micro.name", "Micro");
			addGuiLabel("measurementunit.micro.symbol", "" + '\u00B5');
			addGuiLabel("measurementunit.milli.name", "Milli");
			addGuiLabel("measurementunit.milli.symbol", "m");
			addGuiLabel("measurementunit.none.name", "");
			addGuiLabel("measurementunit.none.symbol", "");
			addGuiLabel("measurementunit.kilo.name", "Kilo");
			addGuiLabel("measurementunit.kilo.symbol", "k");
			addGuiLabel("measurementunit.mega.name", "Mega");
			addGuiLabel("measurementunit.mega.symbol", "M");
			addGuiLabel("measurementunit.giga.name", "Giga");
			addGuiLabel("measurementunit.giga.symbol", "G");
			
			
			

			add("keycategory.electrodynamics", "Electrodynamics");
			addKeyLabel("jetpackascend", "Ascend with Jetpack");
			addKeyLabel("togglenvgs", "Toggle Night Vision Goggles");
			addKeyLabel("jetpackmode", "Switch Jetpack Mode");
			addKeyLabel("servoleggingsmode", "Switch Servo Leggings Mode");
			addKeyLabel("toggleservoleggings", "Toggle Servo Leggings");
			addKeyLabel("swapbattery", "Swap Battery");

			addJei("guilabel.power", "%1$sV %2$skW");
			addJei("info.item.coalgeneratorfuelsource", "Coal Generator Fuel:\n    Burn Time: %s");
			addJei("info.fluid.combustionchamberfuel", "Combustion Chamber Fuel:\n    Produces: %1$s \n    Cost: %2$s.");
			
			addJei(ElectrolyticSeparatorRecipe.RECIPE_GROUP, "Electrolytic Separator");
			addJei(ChemicalCrystalizerRecipe.RECIPE_GROUP, "Chemical Crystalizer");
			addJei(MineralWasherRecipe.RECIPE_GROUP, "Mineral Washer");
			addJei(FermentationPlantRecipe.RECIPE_GROUP, "Fermentation Plant");
			addJei(ChemicalMixerRecipe.RECIPE_GROUP, "Chemical Mixer");
			addJei(WireMillRecipe.RECIPE_GROUP, "Wire Mill");
			addJei(ReinforcedAlloyerRecipe.RECIPE_GROUP, "Reinforced Alloyer");
			addJei(OxidationFurnaceRecipe.RECIPE_GROUP, "Chemical Furnace");
			addJei(MineralGrinderRecipe.RECIPE_GROUP, "Mineral Grinder");
			addJei(MineralCrusherRecipe.RECIPE_GROUP, "Mineral Crusher");
			addJei(LatheRecipe.RECIPE_GROUP, "Lathe");
			addJei(EnergizedAlloyerRecipe.RECIPE_GROUP, "Energized Alloyer");
			addJei("blasting", "Electric Arc Furnace");
			addJei("smelting", "Electric Furnace");
			addJei("gas_condensing", "Gas Condensation");
			addJei("gas_evaporating", "Fluid Evaporation");
			

			addDamageSource("electricity", "%s was electrocuted");
			addDamageSource("accelerated_bolt", "%1$s was perforated by %2$s");
			addDamageSource("accelerated_bolt_ia", "%1$s was perforated by %2$s");
			addDamageSource("plasma_bolt", "%1$s was vaporized by %2$s");

			addChatMessage("guidebookclick", "Click Here");

			addSubtitle(ElectrodynamicsSounds.SOUND_HUM, "Machine Hums");
			addSubtitle(ElectrodynamicsSounds.SOUND_MINERALCRUSHER, "Hammer crushes");
			addSubtitle(ElectrodynamicsSounds.SOUND_MINERALGRINDER, "Grinding Wheel grinds");
			addSubtitle(ElectrodynamicsSounds.SOUND_ELECTRICPUMP, "Electric Pump pumps");
			addSubtitle(ElectrodynamicsSounds.SOUND_WINDMILL, "Air spins Wind Mill blades");
			addSubtitle(ElectrodynamicsSounds.SOUND_COMBUSTIONCHAMBER, "Combustion Chamber pistons fire");
			addSubtitle(ElectrodynamicsSounds.SOUND_CERAMICPLATEBREAKING, "Ceramic Plate shatters");
			addSubtitle(ElectrodynamicsSounds.SOUND_CERAMICPLATEADDED, "Ceramic Plate added");
			addSubtitle(ElectrodynamicsSounds.SOUND_RAILGUNKINETIC, "Kinetic Railgun fires");
			addSubtitle(ElectrodynamicsSounds.SOUND_RAILGUNKINETIC_NOAMMO, "Out of rods");
			addSubtitle(ElectrodynamicsSounds.SOUND_RAILGUNPLASMA, "Plasma Railgun fires");
			addSubtitle(ElectrodynamicsSounds.SOUND_RAILGUNPLASMA_NOPOWER, "Plasma Railgun has no power");
			addSubtitle(ElectrodynamicsSounds.SOUND_RODIMPACTINGGROUND, "Rod impacts ground");
			addSubtitle(ElectrodynamicsSounds.SOUND_LATHEPLAYING, "Lathe spins");
			addSubtitle(ElectrodynamicsSounds.SOUND_EQUIPHEAVYARMOR, "Equipped heavy armor");
			addSubtitle(ElectrodynamicsSounds.SOUND_HYDROELECTRICGENERATOR, "Hydroelectric generator spins");
			addSubtitle(ElectrodynamicsSounds.SOUND_SEISMICSCANNER, "Seismic Ping");
			addSubtitle(ElectrodynamicsSounds.SOUND_ELECTROLYTICSEPARATOR, "Electrical Sparks");
			addSubtitle(ElectrodynamicsSounds.SOUND_NIGHTVISIONGOGGLESON, "Night Vision Goggles activated");
			addSubtitle(ElectrodynamicsSounds.SOUND_NIGHTVISIONGOGGLESOFF, "Night Vision Goggles de-activated");
			addSubtitle(ElectrodynamicsSounds.SOUND_HYDRAULICBOOTS, "Hydraulic piston fires");
			addSubtitle(ElectrodynamicsSounds.SOUND_JETPACKSWITCHMODE, "Equipment cycles mode");
			addSubtitle(ElectrodynamicsSounds.SOUND_JETPACK, "Jetpack engine runs");
			addSubtitle(ElectrodynamicsSounds.SOUND_BATTERY_SWAP, "Battery is swapped");
			addSubtitle(ElectrodynamicsSounds.SOUND_PRESSURERELEASE, "Gas hisses");
			addSubtitle(ElectrodynamicsSounds.SOUND_COMPRESSORRUNNING, "Compressor pressurizes gas");
			addSubtitle(ElectrodynamicsSounds.SOUND_DECOMPRESSORRUNNING, "Decompressor depressurizes gas");

			addAdvancement("root.title", "Electrodynamics");
			addAdvancement("root.desc", "You have entered a world of electricity.");

			addAdvancement("ores.title", "Mining");
			addAdvancement("ores.desc", "Make a Wooden Pickaxe!");
			addAdvancement("rawvanadium.title", "Raw Vanadinite Crystals");
			addAdvancement("rawvanadium.desc", "Find some Raw Vanadinite Crystals!");
			addAdvancement("rawuranium.title", "Raw Uraninite Ore");
			addAdvancement("rawuranium.desc", "Find some Raw Uraninite Ore!");
			addAdvancement("rawtitanium.title", "Raw Rutile Ore");
			addAdvancement("rawtitanium.desc", "Find some Raw Rutile Ore!");
			addAdvancement("rawtin.title", "Raw Cassiterite Ore");
			addAdvancement("rawtin.desc", "Find some Raw Cassiterite Ore!");
			addAdvancement("rawthorium.title", "Raw Thorianite Ore");
			addAdvancement("rawthorium.desc", "Find some Raw Thorianite Ore!");
			addAdvancement("rawsilver.title", "Raw Argentite Ore");
			addAdvancement("rawsilver.desc", "Find some Raw Argentite Ore!");
			addAdvancement("rawlithium.title", "Raw Lepidolite Ore");
			addAdvancement("rawlithium.desc", "Find some Raw Lepidolite Ore!");
			addAdvancement("rawvanadinite.title", "Raw Vanadinite Crystals");
			addAdvancement("rawvanadinite.desc", "Find some Raw Vanadinite Crystals!");
			addAdvancement("rawlead.title", "Raw Galena Ore");
			addAdvancement("rawlead.desc", "Find some Raw Galena Ore!");
			addAdvancement("rawfluorite.title", "Raw Fluorite Crystals");
			addAdvancement("rawfluorite.desc", "Find some Raw Fluorite Crystals!");
			addAdvancement("rawchromium.title", "Raw Chromite Ore");
			addAdvancement("rawchromium.desc", "Find some Raw Chromite Ore!");

			addAdvancement("basicwiring.title", "Wiring");
			addAdvancement("basicwiring.desc", "Make your first wires!");
			addAdvancement("betterwiring.title", "Better Wiring");
			addAdvancement("betterwiring.desc", "Make some Silver wires!");
			addAdvancement("superiorwiring.title", "Superior Wiring");
			addAdvancement("superiorwiring.desc", "Make some Gold wires!");
			addAdvancement("superconductivewiring.title", "Superconductive Wiring");
			addAdvancement("superconductivewiring.desc", "Make some Superconductive wires!");

			addAdvancement("insulation.title", "Insulation");
			addAdvancement("insulation.desc", "Make some insulation!");
			addAdvancement("insulatedwiring.title", "Insulated Wiring");
			addAdvancement("insulatedwiring.desc", "Make some insulated Copper wire!");
			addAdvancement("highlyinsulatedwiring.title", "Thick Wiring");
			addAdvancement("highlyinsulatedwiring.desc", "Make some thick Copper wire!");
			addAdvancement("ceramicinsulation.title", "Ceramic Insulation");
			addAdvancement("ceramicinsulation.desc", "Make some ceramic insulation!");
			addAdvancement("ceramicinsulatedwiring.title", "Ceramic Wiring");
			addAdvancement("ceramicinsulatedwiring.desc", "Make some ceramic Copper wire!");

			addAdvancement("downgradetransformer.title", "Downgrade Transformer");
			addAdvancement("downgradetransformer.desc", "Make a Downgrade Transformer!");
			addAdvancement("upgradetransformer.title", "Upgrade Transformer");
			addAdvancement("upgradetransformer.desc", "Make an Upgrade Transformer!");
			addAdvancement("circuitbreaker.title", "Circuit Breaker");
			addAdvancement("circuitbreaker.desc", "Make a Circuit Breaker!");

			addAdvancement("coalgenerator.title", "Coal Generator");
			addAdvancement("coalgenerator.desc", "Make a Coal Generator!");
			addAdvancement("thermoelectricgenerator.title", "Thermoelectric Generator");
			addAdvancement("thermoelectricgenerator.desc", "Make a Thermoelectric Generator!");
			addAdvancement("solarpanel.title", "Solar Panel");
			addAdvancement("solarpanel.desc", "Make a Solar Panel!");
			addAdvancement("advancedsolarpanel.title", "Advanced Solar Panel");
			addAdvancement("advancedsolarpanel.desc", "Make an Advanced Solar Panel!");

			addAdvancement("batterybox.title", "Battery Box");
			addAdvancement("batterybox.desc", "Make a Battery Box!");
			addAdvancement("lithiumbatterybox.title", "Lithium Battery Box");
			addAdvancement("lithiumbatterybox.desc", "Make a Lithium Battery Box!");
			addAdvancement("carbynebatterybox.title", "Carbyne Battery Box");
			addAdvancement("carbynebatterybox.desc", "Make a Carbyne Battery Box!");

			addAdvancement("wiremill.title", "Wire Milling");
			addAdvancement("wiremill.desc", "Make a Wire Mill!");
			addAdvancement("doublewiremill.title", "Double Milling");
			addAdvancement("doublewiremill.desc", "Make a Double Wire Mill!");
			addAdvancement("triplewiremill.title", "Triple Milling");
			addAdvancement("triplewiremill.desc", "Make a Triple Wire Mill!");

			addAdvancement("electricfurnace.title", "Electric Smelting");
			addAdvancement("electricfurnace.desc", "Make an Electric Furnace!");
			addAdvancement("doubleelectricfurnace.title", "Double Smelting");
			addAdvancement("doubleelectricfurnace.desc", "Make a Double Electric Furnace!");
			addAdvancement("tripleelectricfurnace.title", "Triple Smelting");
			addAdvancement("tripleelectricfurnace.desc", "Make a Triple Electric Furnace!");

			addAdvancement("electricarcfurnace.title", "Electric Blasting");
			addAdvancement("electricarcfurnace.desc", "Make an Electric Arc Furnace!");
			addAdvancement("doubleelectricarcfurnace.title", "Double Blasting");
			addAdvancement("doubleelectricarcfurnace.desc", "Make a Double Electric Arc Furnace!");
			addAdvancement("tripleelectricarcfurnace.title", "Triple Blasting");
			addAdvancement("tripleelectricarcfurnace.desc", "Make a Triple Electric Arc Furnace!");

			addAdvancement("mineralgrinder.title", "Mineral Grinding");
			addAdvancement("mineralgrinder.desc", "Make a Mineral Grinder!");
			addAdvancement("doublemineralgrinder.title", "Double Grinding");
			addAdvancement("doublemineralgrinder.desc", "Make a Double Mineral Grinder!");
			addAdvancement("triplemineralgrinder.title", "Triple Grinding");
			addAdvancement("triplemineralgrinder.desc", "Make a Triple Mineral Grinder!");

			addAdvancement("mineralcrusher.title", "Mineral Crushing");
			addAdvancement("mineralcrusher.desc", "Make a Mineral Crusher!");
			addAdvancement("doublemineralcrusher.title", "Double Crushing");
			addAdvancement("doublemineralcrusher.desc", "Make a Double Mineral Crushing!");
			addAdvancement("triplemineralcrusher.title", "Triple Crushing");
			addAdvancement("triplemineralcrusher.desc", "Make a Triple Mineral Crusher!");
			
			addAdvancement("multimeter.title", "Multimetering");
			addAdvancement("multimeter.desc", "Make a Multimeter!");

			addGuidebook("title", "Electrodynamics Electric Code 1st Edition");
			addGuidebook("titlequote", "\"There is nothing more permanent than a temporary solution.\"");

			addGuidebook("availablemodules", "Available Modules");
			addGuidebook("chapters", "Chapters");

			addGuidebook(References.ID, "Electrodynamics");

			addGuidebook("chapter.gettingstarted", "Getting Started");

			addGuidebook("chapter.gettingstarted.l1",
					"Electrodynamics is a mod based around realistic electricity and more realistic concepts in general. As a result, you will find it plays very differently than other tech mods you're used to. The main difference will be that Electro "
							+ "is much more involved, as that is the price that comes with realism. Keep this in mind as you progress in the mod! If you are brand new to this mod, I highly recommend you read the section on Electricity, as it will help you "
							+ "immensely. Another important concept to note is that Electrodynamics is not designed to stand on its own. It is based on the concept of the old Universal Electricity mod, in which you have a mod with basic concepts and technology, " + "and then have several addon mods that hook into those concepts.");
			addGuidebook("chapter.gettingstarted.l2", "In terms of actually getting started with Electrodynamics, you will need Steel and a source of power. Steel is created by smelting Iron Ingots in a Blast Furnace. The first power source you will use is the Thermoelectric Generator. I highly encourage installing a mod like JEI, " + "as it will make finding recipes much easier!");

			addGuidebook("chapter.ores", "Ores");
			addGuidebook("chapter.ores.spawnrange", "Y = %1$s to Y = %2$s");
			addGuidebook("chapter.ores.material", "Material: %s");
			addGuidebook("chapter.ores.veinsperchunk", "Veins per Chunk: %s");
			addGuidebook("chapter.ores.veinsize", "Vein Size: %s");
			addGuidebook("chapter.ores.miningteir", "Mining Teir: %s");
			addGuidebook("chapter.ores.material_aluminum", "Aluminum");
			addGuidebook("chapter.ores.material_chromium", "Chromium");
			addGuidebook("chapter.ores.material_fluorite", "Fluorite");
			addGuidebook("chapter.ores.material_salt", "NaCl");
			addGuidebook("chapter.ores.material_lead", "Lead");
			addGuidebook("chapter.ores.material_lithium", "Lithium");
			addGuidebook("chapter.ores.material_molybdenum", "Molybdenum");
			addGuidebook("chapter.ores.material_monazite", "Monazite");
			addGuidebook("chapter.ores.material_niter", "Niter");
			addGuidebook("chapter.ores.material_titanium", "Titanium");
			addGuidebook("chapter.ores.material_silver", "Silver");
			addGuidebook("chapter.ores.material_sulfur", "Sulfur");
			addGuidebook("chapter.ores.material_sylvite", "KCl");
			addGuidebook("chapter.ores.material_thorium", "Thorium");
			addGuidebook("chapter.ores.material_tin", "Tin");
			addGuidebook("chapter.ores.material_uranium", "Uranium");
			addGuidebook("chapter.ores.material_vanadium", "Vanadium");

			addGuidebook("chapter.metricprefixes", "Metric Prefixes");

			addGuidebook("chapter.metricprefixes.l1", "Electrodynamics makes use of several Metric System unit prefixes when displaying units. Prefixes are used to help condense values into a more concise and readable format. While you are possibly familiar with some or all of them, below is a list of prefixes and their numerical " + "meanings:");

			addGuidebook("chapter.metricprefixes.pico", "Pico (p) : 1 / 1000000000000");
			addGuidebook("chapter.metricprefixes.nano", "Nano (n) : 1 / 1000000000");
			addGuidebook("chapter.metricprefixes.micro", "Micro (" + '\u00B5' + ") : 1 / 1000000");
			addGuidebook("chapter.metricprefixes.mili", "Mili (m) : 1 / 1000");

			addGuidebook("chapter.metricprefixes.kilo", "Kilo (k) : 1000");
			addGuidebook("chapter.metricprefixes.mega", "Mega (M) : 1000000");
			addGuidebook("chapter.metricprefixes.giga", "Giga (G) : 1000000000");
			addGuidebook("chapter.metricprefixes.tera", "Tera (T) : 1000000000000");

			addGuidebook("chapter.metricprefixes.l2", "This prefixes will be used extensively throughout the mod, so it is important to at least familiarize yourself with the existance of this list in case you need to reference it again.");

			addGuidebook("chapter.electricity", "Electricity");

			addGuidebook("chapter.electricity.l1.1", "Understanding how energy and electricity work is key if you want to do well in Electrodynamics. Energy is what machines use to do work, and it is measured in units of Joules (J). However, the energy needs to be \"flowing\" in order to do work. The rate "
					+ "of flow is measured in units of Volts (V). The pressure or force of the flow in measured in units of Amperes or Amps for short (A or I). The amount of energy transfered in one second is known as the Power and is measured in units of " + "Watts (W). Power can easily be found through following the formula:");
			addGuidebook("chapter.electricity.powerformula", "P = I * V");
			addGuidebook("chapter.electricity.l1.2", "where I is the current and V is the voltage.");

			addGuidebook("chapter.electricity.l2", "Now, how does this impact you and what do you need to pay attention to? All machines require energy at a specific voltage to function. The voltage will be displayed in the tooltip usually. However, " + "if you do not have access to this, there are a couple of methods of checking.");

			addGuidebook("chapter.electricity.l3", "The first method is to look at the base of the machine in question. Most machines have a set of colored diagonal lines, with the color being directly related to the voltage. The " + "following voltages are represented by the following colors:");

			addGuidebook("chapter.electricity.voltageval", "%1$s V : %2$s");
			addGuidebook("chapter.electricity.yellow", "Yellow");
			addGuidebook("chapter.electricity.blue", "Blue");
			addGuidebook("chapter.electricity.red", "Red");
			addGuidebook("chapter.electricity.purple", "Purple");

			addGuidebook("chapter.electricity.l4", "The following pages contain examples of machines with these markings:");

			addGuidebook("chapter.electricity.voltageexample", "Examples of %sV machines:");
			addGuidebook("chapter.electricity.left", "Left: %s");
			addGuidebook("chapter.electricity.middle", "Middle: %s");
			addGuidebook("chapter.electricity.right", "Right: %s");
			addGuidebook("chapter.electricity.voltageexamplenote", "Note the markings do not have to be at the base.");

			addGuidebook("chapter.electricity.l5", "The second method for checking a machine's voltage is to look at the voltage displayed by the energy tooltip in it's GUI. This tooltip will also tell you useful information such as the " + "wattage of the machine. The next page contains examples of this tooltip:");

			addGuidebook("chapter.electricity.guivoltagenote", "Note, the tooltip can also contain other useful info.");

			addGuidebook("chapter.electricity.l6", "However, not every machine has markings such as the Quarry or has a GUI like the Pump, so it's important to pay attention when placing cables and machines. Too low of a " + "voltage, and a machine won't run. Too high of a voltage, and the machine will explode!");

			addGuidebook("chapter.electricity.l7",
					"Now that we have a basic understanding of voltage and how it works, it's time to understand how to get energy into the machine. All machines that use energy will have an I/O port to connect to. However, unlike the voltage indicators discussed previously, these " + "ports are universal to all machines that use energy. There are two ports for energy:");

			addGuidebook("chapter.electricity.energyinput", "Red : Input");
			addGuidebook("chapter.electricity.energyoutput", "Grey : Output");

			addGuidebook("chapter.electricity.l8", "Here is an example of each:");

			addGuidebook("chapter.electricity.l9",
					"However, what is connected to these ports? Now it's time to discuss how electricity is transfered: Wires. Wires in this mod function a little differently than what you're used to. If you hover over a " + "wire in your inventory, you will notice it has a Resistance measures in units of Ohms (" + '\u03A9' + ") and a maximum rated current, known as its Ampacity:");

			addGuidebook("chapter.electricity.l10",
					"Resistance is a measure of how opposed a material is to the flow of electricity. The Resistance of a wire will determine how much energy is lost when a current is developed over it. You can use P = I * I * R to to calculate the exact amount of power lost. "
							+ "This means the more wires you connect together, the higher the overall resistance will be. However, it is important to note from this formula that the power lost is based on the square of the current. It is crucial to keep this in mind when designing complex wire layouts, as you might loose a great deal "
							+ "of usable energy to the wires alone. It should also be noted here that wires do not store energy as you may be accustomed to in other mods.");

			addGuidebook("chapter.electricity.l11.1", "If you were paying attention, you may have also noticed that the wire tooltip will display an insulation rating. The insulation rating of a wire determines what voltage the wire can handle before it shocks you if touched. You can mitigate the danger of being shocked by " + "wearing ");

			addGuidebook("chapter.electricity.l11.2", ". You will still take damage wearing them if you are being shocked, however you will be able to survive the encounter at the price of boot durability.");

			addGuidebook("chapter.electricity.l12.1", "Different insulation types also come with pros and cons. Wool-based insulation is flammable, but is cheap has the ability to be colored:");

			addGuidebook("chapter.electricity.l12.2",
					"Black is the default wire color for wool insulation, with a black wire being able to connect to any wire color or type. A yellow wire on the other hand "
							+ "is only able to connect to black and other yellow wires. This is especially useful if you need to run multiple lines in parallel, as it means you can have two different-colored wires next to each other and not have them connect. This can be very helpful if you are dealing with machine setups where "
							+ "multiple voltages are involved in tight quarters. A specialzed variant of a wool-insulated wire is the Logistical Wire:");

			addGuidebook("chapter.electricity.l12.3", "It will emit a redstone signal when power is flowing through it.");

			addGuidebook("chapter.electricity.l13.1", "Ceramic insulation on the other hand is more expensive than wool, but gains the advantage of being fire-proof:");

			addGuidebook("chapter.electricity.l13.2", "This makes ceramicly insulated wires especially useful when working around fluids like lava. It should be noted though that ceramic insulation is not as effective as " + "woolen insulation, meaning that if you want to insulate high voltages, you will need to take the risk of fire!");

			addGuidebook("chapter.electricity.l14", "One final note while on the topic of wires is the ability to field-modify them. If you right-click any insulated wire with Shears (excluding thick wires), it will remove the insulation from the wire. You can also apply woolen and ceramic insulation to an existing wire "
					+ "by right-clicking the insulation on the wire. A woolen wire can be converted to a logistical wire by right-clicking a piece of redstone on it. You can also dye wires by right-clicking the respective dye onto the wire. Note that this is a less-efficiant way to color wires than crafting them to " + "the respective color!");

			addGuidebook("chapter.electricity.l15",
					"Now that we know how to get energy to a machine and understand it must be at a specific voltage, you're probably wondering how that voltage is achieved. Most power sources in Electrodynamics are 120V or 240V, which works well for some basic machines, but that simply won't cut it for higher voltage "
							+ "machines. This is where the Upgrade and Downgrade Transformers come in. The Upgrade Transformer will take any input voltage at any current and output double voltage at half the current. The Downgrade Transformer takes any input voltage at any current and outputs half the voltage at "
							+ "double the current. Note, Transformers are not 100% efficient, so be wise with your use of them. Also, Transformers will instantly kill you if you walk over them while energized!");

			addGuidebook("chapter.electricity.l16.1", "By now, you are feeling overwhelmed most likely. How are you supposed to keep track of what voltage your wire network is operating at? How are you supposed to keep track of the overall resistance? Fear not, for Electrodynamics offers several tools and blocks " + "to help you out along the way. The first and most important is the ");

			addGuidebook("chapter.electricity.l16.2", ". Right-clicking a wire network with one will display several imporant data points about that network:");

			addGuidebook("chapter.electricity.l16.3", "The first data point is the current power being transmitted in Amps in proportion to the Ampacity of the wire network. The second data point shows the current operating voltage of the wire network. The third data point shows the current power transfer "
					+ "in watts. The fourth data point shows the total resistance of the network, with the fifth data point showing the power loss due to resistance. The final data point shows the lowest voltage machine connected to the network. If you wish to view the data points for a longer period of time, " + "you can craft a ");

			addGuidebook("chapter.electricity.l16.4", ", which offers the same functionality, but will display the relevant data constantly.");

			addGuidebook("chapter.electricity.l17.1", "The next useful block Electrodynamics adds is the %1$s, which will stop the flow of electricity when powered with a redstone signal:");

			addGuidebook("chapter.electricity.l17.2", "This is particularly useful, as it means that you can turn machines off and on without having to break a wire or waiting for them to fill up. The %1$s also does not impose a power loss when power flows across it. This comes at a price however, as it is also a dumb switch, "
					+ "meaning the only way it will open is when manually activated. This means the %1$s is a useful logistical tool, but will not really be effective at protecting your downstream equipment.");

			addGuidebook("chapter.electricity.l18.1", "For a true protective device, you will need to upgrade the %1$s into a %2$s. The %3$s not only is able to be manually opened with redstone like its predecessor, but will also open automatically if it senses that the transmitting voltage will damage a machine of if the " + "transmitting current will damage a wire:");

			addGuidebook("chapter.electricity.l18.2", "However, this protective nature comes at a price, as the %1$s has a small power loss. This means you will need to be somewhat more thoughtful with your use of them!");

			addGuidebook("chapter.electricity.l19", "In summary, machines need energy at a specific voltage to work. There are multiple methods of finding this voltage. Machines have specific colored ports for energy input and output. Energy is transfered into machines using wires, with the type of wire "
					+ "used determining how the cable network performs. Voltages can be stepped up and stepped down using transformers. There are multiple methods for monitoring and controling a wire network. The next page contains a list of symbols and formulas for you to reference..");

			addGuidebook("chapter.electricity.symbols", "Symbols:");
			addGuidebook("chapter.electricity.symbvoltage", "Voltage : V");
			addGuidebook("chapter.electricity.symbcurrent", "Current : A or I");
			addGuidebook("chapter.electricity.symbresistance", "Resistance : " + '\u03A9');
			addGuidebook("chapter.electricity.symbpower", "Power : W or P");
			addGuidebook("chapter.electricity.symbenergy", "Energy : J or E");

			addGuidebook("chapter.electricity.equations", "Equations:");
			addGuidebook("chapter.electricity.powerfromenergy", "P = E / time");
			addGuidebook("chapter.electricity.powerfromvoltage", "P = V * I");
			addGuidebook("chapter.electricity.energytickstoseconds", "E/s = (E/tick) * 20");
			addGuidebook("chapter.electricity.ohmslaw", "V = I * R");
			addGuidebook("chapter.electricity.powerfromcurrent", "P = I * I * R");

			addGuidebook("chapter.fluids", "Fluids");

			addGuidebook("chapter.fluids.l1.1", "Fluids play an important role just like energy in Electrodynamics. They're used for crafting various materials and for cooling machinery. Fortunately, if you have been able to grasp energy, then fluid mechanics should be a breeze, as they are very similar to how other mods work.");

			addGuidebook("chapter.fluids.l1.2", "Electrodynamics adds the following fluids:");
			
			addGuidebook("chapter.fluids.l2", "As with energy, fluids have their own I/O ports. These ports are universal to any machine that uses or produces fluid. They are:");
			addGuidebook("chapter.fluids.fluidinput", "Input: Blue");
			addGuidebook("chapter.fluids.fluidoutput", "Output: Yellow");
			addGuidebook("chapter.fluids.l3", "Here are some examples:");

			addGuidebook("chapter.fluids.l4",
					"However, what do we hook up to these ports? The answer is simple: Pipes! Unlike other mods, pipes in Electrodynamics have no internal storage buffer, which means they will not transfer a fluid unless it has somewhere to go. This means you don't have to worry about a machine "
							+ "outputting a fluid if you hook up a pipe accidentally. Also, Electrodynamics machines will only accept fluids they can process with! Pipes have a limited transfer rate similar to the Ampacity of wires. However, unlike wires, they "
							+ "will not explode if this limit is reached. The downside though is that your choice of pipe is limited to the following throughput capacities:");

			addGuidebook("chapter.fluids.pipecapacity", "%1$s : %2$s mB ");
			addGuidebook("chapter.fluids.pipecopper", "Copper");
			addGuidebook("chapter.fluids.pipesteel", "Steel");

			addGuidebook("chapter.fluids.l5.1", "Electrodynamics also offers a few modified fluid pipes which give you greater control over transmitting and receiving fluids. The first of these is the %1$s. The %2$s is a simple bi-directional switch. In the off-position, it will allow fluids to flow both ways through it like a " + "standard pipe:");
			addGuidebook("chapter.fluids.l5.2", "In the on position however, it prevents all fluids from flowing. This ability is passive and does not require power. The %1$s is also compatible with other mods' fluid pipes.");

			addGuidebook("chapter.fluids.l6.1", "The next control block offered is the %1$s. The %2$s has a passive ability and an active ability. Passively, the block acts like a diode, allowing fluids to only flow in one direction: ");
			addGuidebook("chapter.fluids.l6.2", "This ability is compatible with all other mods. The active ability requires the pump to be powered, and has the downside of only working with Electrodynamics fluid pipes due to the limitations of the game. When powered and connected to an Electrodynamics pipe network, the "
					+ "pump has the ability to take priority on the transmitted fluids. The priority can be programmed in its GUI:");
			addGuidebook("chapter.fluids.l6.3", "The minimum priority is 0 and the maximum is 9. If multiple pumps have the same priority, then the fluid will be split evenly among them.");

			addGuidebook("chapter.fluids.l7.1", "Another block offered is the %1$s. As the name suggests, the %2$s is a monodirectional pipe and is able to filter what fluids are allowed through it:");
			addGuidebook("chapter.fluids.l7.2", "This ability is passive and is compatible with other mods' pipes. To program a fluid, open the GUI:");
			addGuidebook("chapter.fluids.l7.3", "The %1$s is capable of filtering up to 4 fluids at a time. You will also note there is a \"Whitelist\" and \"Blacklist\" toggle button. In Blacklilst, the fluids in the filter list will be blocked from flowing through the pipe. Having no fluids selected means it will allow any "
					+ "fluid through like a normal pipe. In Whitelist, the fluids in the filter will be the only fluids allowed to flow through. Having no fluids selected means it will allow no fluids through. To add a filtered fluid, take a bucket or otherwise item containing the desiered fluid, and click one of the filter slots:");
			addGuidebook("chapter.fluids.l7.4", "The %1$s will only allow that specific fluid through. It should be noted that the %1$s is not tag-compatible, meaning Ethanol from Immersive Engineering will not be allowed through even though Ethanol from Electrodynamics is selected as a filtered fluid.");

			addGuidebook("chapter.fluids.l8", "While pipes may not be able to store fluid, Electrodynamics offers bulk fluid storage in the form of Tanks. Electrodynamics tanks accept fluid from the top and output fluid through the bottom. Furthermore, stack two tanks on top of eachother, and the top one will automatically " + "output into the bottom one.");

			addGuidebook("chapter.fluids.l9", "One final thing to note is that Electrodynamics fluids cannot be carried by a bucket. For example, it simply doesn't make sense to transfer Sulfuric Acid in a bucket made out of Iron. If you need to manually move fluids such as Sulfuric Acid, you will need to "
					+ "use a Reinforced Canister! All fluid machines have input and output bucket slots that can be used for manually filling and draining the machine. If you need to manually empty an input tank, click a Reinforced Canister on it and the fluid will drain into the canister. To void any fluid, " + "either pipe or manually transfer it into ");

			addGuidebook("chapter.gases", "Gases");

			addGuidebook("chapter.gases.l1.1", "While fluids in Electrodynamics may be similar to what you have seen before, gases are very much more complex and in depth. However, if you pay attention to a few key items, you will find that working with gases can be fairly painless and easy to do.");
			addGuidebook("chapter.gases.l1.2", "Electrodynamics adds the following gases:");

			addGuidebook("chapter.gases.l2", "Right off the bat, gases in Electrodynamics cannot be seen. While certain gases may be colored or refractive in real life, a vast majority are clear. As a result, you will never actually see a gas (with the above visuals being manufactured for simplicity). Instead, you will see its "
					+ "presence through montioring devices like a pressure gauge in " + "a GUI.");

			addGuidebook("chapter.gases.l3", "Gases in Electrodyanmics also have a pressure and temperature. We will first cover the mechanics of pressure. %1$s is measured in units of Atmospheres (ATM). The minimum pressure a gas can have is 1 ATM. A gas's pressure however will only be a whole number. In other words, you will "
					+ "never see a gas with a 1.23601 ATM pressure. As a gas's pressure increases, its volume will decrease linearly. For example, if you double the pressure of a gas, its volume will halve.");
			addGuidebook("chapter.gases.pressure", "Pressure");
			addGuidebook("chapter.gases.l4.1", "All items and machines that work with gases have a maximum rated pressure. If this pressure is exceded, then the machine or item may be damaged or even explode! By convention, items with a pressure cap will display the cap when shift is held:");
			addGuidebook("chapter.gases.l4.2", "Machines on the other hand will have a dedicated GUI data tab displaying the maximum pressure for input and output tanks:");
			addGuidebook("chapter.gases.l4.3", "It should be noted that gas pipes will display their maximum pressure rating in their noraml tooltip.");
			addGuidebook("chapter.gases.l5", "Another crucial aspect to keep in mind is that gases will seek equilibrium and equalize pressures when two amounts of the same gas at different pressures are mixed. As pressure is always a whole value, the gas with the lowest pressure will become the ruling pressure, and the higher " + "pressure amount will have its pressure lowered in kind.");

			addGuidebook("chapter.gases.l6", "Now we will cover the mechanics of %1$s. Temperature is measured in units of Kelvin (K), and the minimum temperature a gas can achieve is 1 degree Kelvin. Unlike pressure, temperature can take a non-whole value, meaning a gas can have a temperature of 273.163K. As a gas's temperatrure "
					+ "increases, its volume increases linearly. For example, if you double the temperature of a gas, you will also double its volume.");
			addGuidebook("chapter.gases.temperature", "Temperature");
			addGuidebook("chapter.gases.l7.1", "As with pressure, all items and machines that work with gases have a maximum rated temperature. If this temperature is exceded, then the machine or item may be damaged or even melt! By convention, items with a temperature cap will display the cap when shift is held:");
			addGuidebook("chapter.gases.l7.2", "Similarly to pressure, machines will have a dedicated GUI data tab displaying the maximum temperature for input and output tanks:");
			addGuidebook("chapter.gases.l7.3", "It should be noted that gas pipes do not have a maximum rated temperature as of yet.");
			addGuidebook("chapter.gases.l8", "Another crucial aspect to keep in mind is that gases will seek equilibrium and equalize temperature when two amounts of the same gas at different temperatures are mixed. As temperature is a non-whole value, the combined gases will take on the average temperature of the two combined " + "gases.");

			addGuidebook("chapter.gases.l9", "One final thing to note on the topic of temperature is that certain gases in Electrodynamics, like their real-life counterparts, will condense into a liquid below a certain temperature. The following gases have the ability to be condensed:");

			addGuidebook("chapter.gases.gas", "Gas: %s");
			addGuidebook("chapter.gases.condensedfluid", "Fluid: %s");
			addGuidebook("chapter.gases.condtemp", "Temp: %s");

			addGuidebook("chapter.gases.l10.1", "The immediate concern now is of course what happens to a gas if it condenses while contained within a machine? On machines that handle gases that also do not have a dedicated output fluid tank, you will notice a greyed out fluid droplet:");
			addGuidebook("chapter.gases.l10.2", "This represents the machine's runoff catch. When a gas condenses in one of these machines, the dropplet will light up indicating a gas has condensed into a fluid and has been caught. To extract this caught gas, simply click on the droplet with a bucket or similar item. It is "
					+ "important to note that the runoff catch can only handle one fluid at a time. If a gas condenses while a fluid is held, the existing fluid held by the catch will be lost! The runoff catch is only so large, so be mindful you don't let it get too full either.");

			addGuidebook("chapter.gases.l11", "Now that we are familiar with the basic mechanics of pressure and temperature, we can discuss how to manipulate gases. As with other machines, gases have a dedicated input and output port. The respective ports are represented as so:");
			addGuidebook("chapter.gases.input", "Input: Green");
			addGuidebook("chapter.gases.output", "Output: Orange");
			addGuidebook("chapter.gases.l12", "As with other ports, these colors are universal to all gas ports. An example of each can be seen on the next page:");

			addGuidebook("chapter.gases.l13.1", "Like with fluids, gases are transfered between places through the use of pipes. Gas pipes do not store gases, and Electrodynamics machines will only accept gases that they can process with. Pipes have a maximum rated pressure and throughput capacity. If this pressure is exceded, "
					+ "the pipe will explode, and the gas being transmitted will be lost. You have the following pipes to chose from:");
			addGuidebook("chapter.gases.pipecapacity", "Max Throughput : %s");
			addGuidebook("chapter.gases.pipepressure", "Max Pressure: %s");
			addGuidebook("chapter.gases.pipecopper", "Copper");
			addGuidebook("chapter.gases.pipesteel", "Steel");
			addGuidebook("chapter.gases.pipeplastic", "Plastic");
			addGuidebook("chapter.gases.l13.2", "The inclusion of plastic may seem strange, but it serves a very pratical and important role. Metal pipes can be corroded by certain gases, where as plastic cannot be. The following gases are considered corrosive, and will destroy metal pipes:");
			addGuidebook("chapter.gases.l13.3", "Pay attention to this list, as it will save you valuable time and resources!");

			addGuidebook("chapter.gases.l14.1", "As with fluids, Electrodynamics also offers a few modified gas pipes which give you greater control over transmitting and receiving gases. The first of these is the %1$s. The %2$s is a simple bi-directional switch. In the off-position, it will allow gases to flow both ways " + "through it like a standard pipe:");
			addGuidebook("chapter.gases.l14.2", "In the on position however, it prevents all gases from flowing. This ability is passive and does not require power. The %1$s is also compatible with other mods' gas pipes.");

			addGuidebook("chapter.gases.l15.1", "The next control block offered is the %1$s. The %2$s has a passive ability and an active ability. Passively, the block acts like a diode, allowing gases to only flow in one direction: ");
			addGuidebook("chapter.gases.l15.2", "This ability is compatible with all other mods. The active ability requires the pump to be powered, and has the downside of only working with Electrodynamics gas pipes due to the limitations of the game. When powered and connected to an Electrodynamics pipe network, the "
					+ "pump has the ability to take priority on the transmitted gases. The priority can be programmed in its GUI:");
			addGuidebook("chapter.gases.l15.3", "The minimum priority is 0 and the maximum is 9. If multiple pumps have the same priority, then the gas will be split evenly among them.");

			addGuidebook("chapter.gases.l16.1", "Another block offered is the %1$s. As the name suggests, the %2$s is a monodirectional pipe and is able to filter what gases are allowed through it:");
			addGuidebook("chapter.gases.l16.2", "This ability is passive and is compatible with other mods' pipes. To program a gas, open the GUI:");
			addGuidebook("chapter.gases.l16.3", "The %1$s is capable of filtering up to 4 gases at a time. You will also note there is a \"Whitelist\" and \"Blacklist\" toggle button. In Blacklilst, the gases in the filter list will be blocked from flowing through the pipe. Having no gases selected means it will allow any "
					+ "gas through like a normal pipe. In Whitelist, the gases in the filter will be the only gases allowed to flow through. Having no gases selected means it will allow no gases through. To add a filtered gas, take a gas cylinder or otherwise item containing the desiered gas, and click one of the filter slots:");
			addGuidebook("chapter.gases.l16.4", "The %1$s will only allow that specific fluid through. It should be noted that the %1$s is not tag-compatible, meaning Hydrogen from Mekanism will not be allowed through even though Hydrogen from Electrodynamics is selected as a filtered gas.");

			addGuidebook("chapter.gases.l17", "While pipes may not be able to store gas, Electrodynamics offers bulk gas storage in the form of Cylinders. Gas Cylinders accept gas from the top and output gas through the bottom like a fluid tank. Furthermore, stack two cylinders on top of eachother, and the top one " + "will automatically output into the bottom one. "
					+ "An important thing to note about cylinders however is that they are not thermally adiabatic, and will slowly heat or cool the gas contained within to room temperature. Gas cylinders heat and cool at a rate of %1$s per second. You can help mitigate this by installing a %2$s in the cylinder. Each peice will reduce the rate by "
					+ "%3$s for a maximum of 6 possible reduction of %4$s.");

			addGuidebook("chapter.gases.l18", "Up until this point, there has been mention of gases at different temperatures and pressures, but no talk of how those values are actually achieved. Sure, some machines might produce a gas at a certain temperature and pressure, but what if another process calls for it to be "
					+ "at twice the temperature and twice the pressure? We now come to what this chapter has been building towards: gas manipulation. Electrodynamics offers dedicated machines for manipulating a gas's pressure and temperature.");

			addGuidebook("chapter.gases.l19", "The first of these are the %1$s and %2$s. The %3$s will take any gas input to it and double the pressure. The %4$s conversely will take any gas input to it and halve the pressure. By convention, gases produced by machines will be a power of two. This means the %3$s and %4$s " + "effectively function as Upgrade and Downgrade Transformers.");

			addGuidebook("chapter.gases.l20.1",
					"You may notice however that the input and output tanks on these two blocks have a rather limited storage capacity. This can especially be a problem if you are decompressing a gas. Fortunately, the %1$s and %2$s can have thier storage tank capacities increased by the addition of " + "a %3$s. The %4$s is placed atop of the input and output tank like so:");

			addGuidebook("chapter.gases.l20.2", "A total of 5 can be stacked to increase the tank capacity.");

			addGuidebook("chapter.gases.l21.1", "The third block for manipulating gases is the %1$s. The %2$s is able to heat or cool a gas to any specified temperature. To program the temperature, open the GUI, and input it:");

			addGuidebook("chapter.gases.l21.2", "If you paid attention to the condensed gases list from earlier, you may also notice that the %1$s has a fluid input and output tank. If you program the temperature to the gas's condensation point, the Manipulator will in turn condense the gas into a fluid. The manipulator is also "
					+ "capable of converting fluids into gases if the temperature is above the gas's condensation point. Also, like the %2$s and %3$s, the %1$s can have its tank capacity increased with a %4$s.");

			addGuidebook("chapter.gases.l22", "One final thing to note is that Electrodynamics gas can be caried by hand with a %s. Note that it does have a maximum rated temperature and pressure, so make sure the gas you are inputing to it won't destroy it!");

			addGuidebook("chapter.generators", "Generators");
			addGuidebook("chapter.generators.l1", "Electrodynamics offers several power sources for you to consider. Each has its pros and cons, so pick and choose the ones that suit you. It should be notes that all fuel-burning generators can be turned off with a redstone signal.");
			addGuidebook("chapter.generators.generationbase", "Default: %1$s at %2$sV");
			addGuidebook("chapter.generators.generationupgrade", "Upgraded: %1$s at %2$sV");
			addGuidebook("chapter.generators.tips", "Tips:");
			addGuidebook("chapter.generators.tipsolarweather", "*Rain reduces production");
			addGuidebook("chapter.generators.tipsolartemperature", "*Hotter biomes produce more power");
			addGuidebook("chapter.generators.tipminy", "Min Y: %s");
			addGuidebook("chapter.generators.tipidealy", "Ideal Y: %s");
			addGuidebook("chapter.generators.tiptemprange", "Temp: %1$s C < T < %2$s C");
			addGuidebook("chapter.generators.tipidealtemp", "Ideal Temp: %s C");
			addGuidebook("chapter.generators.fuels", "Fuels:");
			addGuidebook("chapter.generators.burntime", "Burn Time: %s");
			addGuidebook("chapter.generators.use", "Use:");
			addGuidebook("chapter.generators.heatsource", "Heat Sources:");
			addGuidebook("chapter.generators.multiplier", "Multiplier: x%s");
			addGuidebook("chapter.generators.upgrades", "Upgrades:");

			addGuidebook("chapter.generators.thermoelectricgeneratoruse", "The heat source is placed at the back of the machine");
			addGuidebook("chapter.generators.combustionchamberburn", "Usage/burn: %s mB");

			addGuidebook("chapter.machines.basespecs", "Base: %1$s kW at %2$s V");
			addGuidebook("chapter.machines.maxspecs", "Max: %1$s kW at %2$s V");
			addGuidebook("chapter.machines.wind", "Y=319: 1.16 kW, 120 V");
			addGuidebook("chapter.machines.windu", "Y=319, U: 2.61 kW, 120 V");
			addGuidebook("chapter.machines.coalgentemp", "Temp: 2500 C");
			addGuidebook("chapter.machines.thermoheatsource", "Heat Source: Lava");
			addGuidebook("chapter.machines.combfuel", "Fuel: Ethanol, Hydrogen");
			addGuidebook("chapter.machines.thermoname", "Thermoelectric Gen.");
			addGuidebook("chapter.machines.hydroname", "Hydroelectric Gen.");

			addGuidebook("chapter.machines", "Machines");

			addGuidebook("chapter.machines.chargerheader", "Understanding the Charger:");
			addGuidebook("chapter.machines.l1", "The Charger does what the name suggests and charges items. When charging an item, it's crucial to select a Charger with the correct voltage. If the charger's voltage is less than the item's, the item will only be charged to a percentage of it's full charge. This can be " + "calculated by the formula:");
			addGuidebook("chapter.machines.chargeformula", "V(charger) / V(item)");

			addGuidebook("chapter.machines.l2", "If the charger's voltage is greater than the item's, it will explode!");
			addGuidebook("chapter.machines.l3", "It is possible to operate a charger with battery power using the 3 battery slots:");

			addGuidebook("chapter.machines.l4", "The charge of the item placed in one of these slots will be transfered to the item in the charging slot. Along with actual batteries, any item with a charge can be used! However, be mindful of the item's voltage. If it is less than the voltage of the charger, it "
					+ "will be reduced to a pile of Slag! If the item's voltage is greater than the charger's, the charger will explode!");

			addGuidebook("chapter.quarry", "The Quarry");

			addGuidebook("chapter.quarry.l1", "The Quarry is Electrodynamics' way of providing auto-mining. It takes inspiration from Buildcraft's Quarry and expands upon what it can do. This short walkthrough will provide you the steps on how to set up and operate one yourself.");

			addGuidebook("chapter.quarry.step", "Step %s:");

			addGuidebook("chapter.quarry.step1l1", "Set up a ring of 4 Seismic Markers with one Marker at each corner. The ring must be a minimum of 3x3 and has a default maximum size of 66x66. Placing a redstone signal next to a marker will display guide lines.");

			addGuidebook("chapter.quarry.step2l1", "Place a Seismic Relay down at the outside of one of the corners next to a Seismic Marker. If done correctly, you will hear the sound of an Anvil. The Seismic Markers will also then be collected by the Relay and placed in its inventory.");

			addGuidebook("chapter.quarry.step3l1", "Place a Quarry on either the left or the right side of the Relay. The Quarry must be facing the same direction as the Relay.");

			addGuidebook("chapter.quarry.step4l1", "Place a Coolant Resavoir on top of the Quarry. The Quarry needs a constant supply of Water to remain cool. The faster it runs, the more water it will use!");

			addGuidebook("chapter.quarry.step5l1", "Place a Motor Complex on the side of the Quarry opposite the Seismic Relay. The green port of the Relay must be facing the green port of the Quarry. The Motor Complex controls the speed of the Quarry. It accepts either Basic or Advanced Speed Upgrades, "
					+ "and has a maximum speed of 1 Block/tick. This can be achieved with 6 Advanced upgrades, but comes with a heafty power consumtion!");

			addGuidebook("chapter.quarry.step6l1", "Power the Quarry and the Motor Complex; both use 240V. The Quarry itself uses power to perform tasks such as clearing amd maintaining the mining ring. The upgrades placed in the Quarry also have a direct impact on its power usage. Note that if blocks are in the way when "
					+ "the Quarry starts clearing the ring, they will be removed without drops! When the ring is finished, the mining arm will deploy.");

			addGuidebook("chapter.quarry.step7l1", "Open the Quarry GUI. In order to begin mining blocks, the Quarry will need a Drill Head. There are multiple types with varying durabilities:");

			addGuidebook("chapter.quarry.drillhead", "%1$s : %2$s");
			addGuidebook("chapter.quarry.steelhead", "Steel");
			addGuidebook("chapter.quarry.stainlesshead", "Stainless");
			addGuidebook("chapter.quarry.hslahead", "HSLA Steel");
			addGuidebook("chapter.quarry.titaniumhead", "Titanium");
			addGuidebook("chapter.quarry.carbidehead", "Carbide");
			addGuidebook("chapter.quarry.infinitedurability", "Infinite");

			addGuidebook("chapter.quarry.step7l2",
					"Take the Drill Head of your choice and place it in the bottom left slot of the Quarry GUI. Now direct your attention to the 3 upgrade slots in the GUI. The Quarry itself will not passively use power after setup. However, if you add upgrades, it will begin to, and depending on the " + "upgrade, this can be a substantial amount! Your 4 upgrade options are:");

			addGuidebook("chapter.quarry.step7unbreaking", "The %s reduces the durability used from the Drill Head when a block is mined. A maximum of 3 can be used for an effect of Unbreaking III, and it will cause the Quarry to draw a large amount of power when installed.");
			addGuidebook("chapter.quarry.step7fortune", "The %s applies the Fortune enchantment to the blocks mined by the Quarry. A maximum of 3 can be used for an effect of Fortune III and it cannot be used in tandem with the Silk Touch Upgrade. The upgrade draws a large amount of power.");
			addGuidebook("chapter.quarry.step7silktouch", "The %s will apply the Silk Touch enchantment to the blocks mined by the Quarry. A maximum of 1 can be used and it cannot be used in tandem with the Fortune Upgrade. The upgrade will cause the Quarry to draw a huge amount of power.");
			addGuidebook("chapter.quarry.step7void", "The %s will activate 6 otherwise hidden slots in the GUI. Any items placed in these slots will be voided by the Quarry when mined. The upgrade will cause the Quarry to start drawing its base usage.");
			
			addGuidebook("chapter.quarry.step8l1", "This step is optional, but highly recommended. Place a Logistical Manager in front of the Quarry, then place a chest on any remaining side of the Manager. The Logistical Manager will automatically transfer items from the Quarry's inventory into an attached chest. "
					+ "Furthermore, if you place a Drill Head in one of the attached chests, it will automatically be transfered to the Quarry when the existing one breaks.");

			addGuidebook("chapter.upgrades", "Upgrades");

			addGuidebook("chapter.upgrades.injectorheader", "Using the Injector Upgrade:");

			addGuidebook("chapter.upgrades.l1", "The Auto-Injector Upgrade gives machines the ability to intake items from surrounding inventories. The upgrade has two modes: Default and Smart. ");
			addGuidebook("chapter.upgrades.default", "Default");
			addGuidebook("chapter.upgrades.l2", " mode will attempt to fill every input slot in order of the directions on the card. ");
			addGuidebook("chapter.upgrades.smart", "Smart");
			addGuidebook("chapter.upgrades.l3", " mode will map each input slot to each direction on the card. If there are more slots than directions, the remaining slots will be mapped to the final direction. To add a direction, Shift + Right-Click the card while facing the desired direction. To clear all " + "directions, Shift + Left-Click. To toggle Smart mode, Right-Click the card.");

			addGuidebook("chapter.upgrades.ejectorheader", "Using the Ejector Upgrade:");

			addGuidebook("chapter.upgrades.l4", "The Auto-Ejector Upgrade gives machines the ability to output items to surrounding inventories. The upgrade has two modes: Default and Smart. ");
			addGuidebook("chapter.upgrades.l5", " mode will attempt to output every slot in order of the directions on the card. ");
			addGuidebook("chapter.upgrades.l6", " mode will map each output slot to each direction on the card. If there are more slots than directions, the remaining slots will be mapped to the final direction. To add a direction, Shift + Right-Click the card while facing the desired direction. To clear all " + "directions, Shift + Left-Click. To toggle Smart mode, Right-Click the card.");
			addGuidebook("chapter.upgrades.l7", "It is important to note that indexes for Electrodynamics output slots come before biproduct slots in the inventory. For example, if there are 3 output slots and 2 biproduct slots, the card would empty all 3 output slots before it empties the 2 biproduct slots.");

			addGuidebook("chapter.tools", "Tools");

			addGuidebook("chapter.tools.ammo", "Ammo:");
			addGuidebook("chapter.tools.damage", "Damage:");

			addGuidebook("chapter.tools.roddamage", "%1$s: %2$s");
			addGuidebook("chapter.tools.steel", "Steel");
			addGuidebook("chapter.tools.stainless", "Stainless Steel");
			addGuidebook("chapter.tools.hsla", "HSLA Steel");
			addGuidebook("chapter.tools.ap", " AP*");
			addGuidebook("chapter.tools.apnote", "*ignores armor");

			addGuidebook("chapter.tools.kineticl1", "To use the Kinetic Railgun, hold the gun in one hand and the ammo type of your choice in the other.");

			addGuidebook("chapter.tools.energy", "Energy");
			addGuidebook("chapter.tools.initial", "Initial");
			addGuidebook("chapter.tools.after", "After %s");

			addGuidebook("chapter.tools.seismicl1", "The Seismic Scanner is a very useful item. It is able to scan for a selected block within a 16 block radius from the player. To use the Scanner, Right-Click to access it's GUI and insert the desired block into the scanning slot. Next, Shift + Right-Click to start a "
					+ "scan. If the Scanner is able to find the block, it will list the coordinates in its GUI and temporarily highlight the block in the world. Note, you will not see the highlight if you can't see the block itself. The Scanner has a 10s cooldown between scans.");

			addGuidebook("chapter.tools.electricdrilll1", "The Electric Drill is a useful mining tool indeed. Not only does it remove the need to constantly craft pickaxes, but it can also be upgraded to suit your needs. Firstly, the drill can have it's current head swapped out with another drill head. Steel is the default head. "
					+ "The following heads provide the following speed boosts:");
			addGuidebook("chapter.tools.electricdrilll2", "It should be noted this speed boost is passive and does not impact power consumption. To swap out a drill head, hover over the drill in your inventory with the drill head of choice, and Left-Click the drill. The new head will be installed, and you will be left holding "
					+ "the previous drill head.");
			addGuidebook("chapter.tools.electricdrilll3", "The drill also accepts various upgrades like a machine. Right-Click to open the drill's upgrade GUI to install upgrades. It should be noted that upgrades will increase power usage, so be wise with your usage of them!");

			
			addGuidebook("chapter.armor", "Armor");

			addGuidebook("chapter.armor.jetpack", "The Jetpack uses Hydrogen Gas at 1ATM as fuel. It can be filled in either a Gas Cylinder or directly in the Electrolyzer. The Jetpack has 4 modes: Regular, Hover, Elytra, and Off. Elytra mode allows you to glide as if you had an Elytra on, and gives you the ability to slowly "
					+ "ascend. It is worth mentioning that the Jetpack has a maximum pressure tolerance of 4 ATM. I wonder what happens with higher pressure gas?");
			addGuidebook("chapter.armor.hydraulicboots", "Hydraulic Boots use Hydraulic Fluid as their \"fuel\". They can be filled either in a tank or directly in a Chemical Mixer. Hydraulic Boots will heavily reduce fall damage, but not completely eliminate it.");
			addGuidebook("chapter.armor.combatchestplate", "The Jetpack uses Hydrogen Gas at 1ATM as fuel. It can be filled in either a Gas Cylinder or directly in the Electrolyzer. The Jetpack has 4 modes: Regular, Hover, Elytra, and Off. Elytra mode allows you to glide as if you had an Elytra on, and gives you the ability to "
					+ "slowly ascend. It is worth mentioning that the Combat Chestplate has a maximum pressure tolerance of 4 ATM. I wonder what happens with higher pressure gas?");
			addGuidebook("chapter.armor.combatboots", "Combat Boots use Hydraulic Fluid as their \"fuel\". They can be filled either in a tank or directly in a Chemical Mixer. Combat Boots will heavily reduce fall damage, but not completely eliminate it.");

			addGuidebook("chapter.armor.ceramicheader", "Ceramic Plate Protection:");
			addGuidebook("chapter.armor.ceramicl1",
					"Composite and Combat armor have a unique ability: Ceramic Protection. To use this ability, you must first add Ceramic Plates to the chestplate. This is accomplished by Right-Clicking a Ceramic Plate while wearing one of the two chestplates. If sucessfull, you will hear " + "the sound of a velcro strap. A maximum of two plates can be be held by both chestplates.");

			addGuidebook("chapter.armor.ceramicl2", "For the ability to trigger, you must be wearing a full set of the armor type, and it must be a complete set. You must then take more than 16 damage. If these conditions are met, you will hear the plate break and a Ceramic Plate will be removed " + "from the chestplate. The damage dealt will then be reduced to its square root.");

			addGuidebook("chapter.misc", "Misc");
			addGuidebook("chapter.misc.l1", "Electrodynamics pipes and wires can be camouflaged to look like other blocks. This can be especially usefully if you have to run a wire through a wall but don't want to have an awkward hole in it. To hide the cable in question, you will first need to enhance it's structure. This can be accomplished "
					+ "by right-clicking the cable with Scaffolding (not the vanilla kind):");
			
			addGuidebook("chapter.misc.l2", "Once the Scaffolding has been applied, you can then place the block of your choice. Note that placing the Scaffolding and camouflage block will consume it, but you will also get it back when you break the cable:");
			
			addGuidebook("chapter.misc.l3", "You can also easily swap the disguising block by simply right-clicking again with a different block:");
			
			addGuidebook("chapter.misc.l4", "Note that while the cable might glow like the light source it is disguised as, it very much is still a cable. This is particularly important in the case of Wires, which not only can still shock you while hidden, but can also be upgraded still:");
			
			addGuidebook("chapter.misc.l5", "As mentioned earlier, the cable will drop the scaffolding and disguising block when broken with a pickaxe. However, there are a couple other methods to do this. You can remove the disguising block by right-clicking the cable with a wrench:");
			
			addGuidebook("chapter.misc.l6", "This will leave the scaffolding in place. To remove the Scaffolding with the wrench as well, right-click again:");

			addGuidebook("chapter.tips", "Tips");
			addGuidebook("chapter.tips.tip", "Tip %s:");
			addGuidebook("chapter.tips.tip1", "Use Energy Storage frequently. Electrodynamics has several tiers of energy storage. You should invest in using them in all stages of progression. Note, the Capacity Upgrade not only increases the capacity of a Battery Box, but also the output voltage!");

			addGuidebook("chapter.tips.tip2", "Transmit at High Voltage. This is mentioned in the Electricity chapter, but you should transmit large amounts of power at high voltage and then step it down for distribution. This will help reduce the need for heavy-duty cables as well as the " + "amount of power lost due to the cable's own resistance!");

			addGuidebook("chapter.tips.tip3",
					"If you are using an electric tool from Electrodynamics or one of its surrounding mods, there is a good chance that the tool can have its battery replaced. This can be especially useful when you need to recharge a tool and don't have ready access to a charger. A battery can be replaced in one of two ways. "
							+ "The first way is to hold the tool in question in your main hand and press the \"R\" key. A battery with a matching voltage will then be selected from your inventory and placed inside of the tool. The current battery inside the tool will be then placed in your inventory. Note, this method will use the first battery it finds in your "
							+ "inventory, which might mean the battery you want may not be the one that gets used. The second and more precise way to replace a tool's battery is to hover over the tool in question with the battery in your inventory. Then, Right-Click the tool with the battery. If the voltage of the tool matches the voltage of the battery, the "
							+ "new battery will replace the old battery, and you will be left holding the old battery.");
			
			addGuidebook("chapter.tips.tip4", "Holding the Control key while hoving over an upgrade slot in a GUI will display what upgrades are valid for said slot.");

			addGuidebook("searchparameters", "Parameters");
			addGuidebook("selectall", "All");
			addGuidebook("selectnone", "None");
			addGuidebook("casesensitive", "Case-Sensitive");

		}

	}

	public void addItem(RegistryObject<Item> item, String translation) {
		add(item.get(), translation);
	}

	public void addItem(Item item, String translation) {
		add(item, translation);
	}

	public void addBlock(RegistryObject<Block> block, String translation) {
		add(block.get(), translation);
	}

	public void addBlock(Block block, String translation) {
		add(block, translation);
	}

	public void addTooltip(String key, String translation) {
		add("tooltip." + modID + "." + key, translation);
	}

	public void addFluid(Fluid fluid, String translation) {
		add("fluid." + modID + "." + ForgeRegistries.FLUIDS.getKey(fluid).getPath(), translation);
	}

	public void addGas(RegistryObject<Gas> gas, String translation) {
		addGas(gas.get(), translation);
	}

	public void addGas(Gas gas, String translation) {
		add("gas." + modID + "." + ElectrodynamicsRegistries.gasRegistry().getKey(gas).getPath(), translation);
	}

	public void addContainer(SubtypeMachine key, String translation) {
		addContainer(key.name(), translation);
	}

	public void addContainer(String key, String translation) {
		add("container." + key, translation);
	}

	public void addCommand(String key, String translation) {
		add("command." + modID + "." + key, translation);
	}

	public void addSubtitle(String key, String translation) {
		add("subtitles." + modID + "." + key, translation);
	}

	public void addSubtitle(RegistryObject<SoundEvent> sound, String translation) {
		addSubtitle(sound.getId().getPath(), translation);
	}

	public void addGuiLabel(String key, String translation) {
		add("gui." + modID + "." + key, translation);
	}

	public void addDimension(String key, String translation) {
		add("dimension." + modID + "." + key, translation);
	}

	public void addKeyLabel(String key, String translation) {
		add("key." + modID + "." + key, translation);
	}

	public void addJei(String key, String translation) {
		add("jei." + key, translation);
	}

	public void addDamageSource(String key, String translation) {
		add("death.attack." + key, translation);
	}

	public void addChatMessage(String key, String translation) {
		add("chat." + modID + "." + key, translation);
	}

	public void addGuidebook(String key, String translation) {
		add("guidebook." + modID + "." + key, translation);
	}

	public void addAdvancement(String key, String translation) {
		add("advancement." + modID + "." + key, translation);
	}

	public static enum Locale {
		EN_US;

		@Override
		public String toString() {
			return super.toString().toLowerCase(java.util.Locale.ROOT);
		}
	}

}

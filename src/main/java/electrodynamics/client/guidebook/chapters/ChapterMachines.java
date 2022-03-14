package electrodynamics.client.guidebook.chapters;

import java.util.ArrayList;
import java.util.List;

import electrodynamics.DeferredRegisters;
import electrodynamics.api.References;
import electrodynamics.api.item.ItemUtils;
import electrodynamics.client.guidebook.utils.ImageWrapperObject;
import electrodynamics.client.guidebook.utils.ItemWrapperObject;
import electrodynamics.client.guidebook.utils.TextWrapperObject;
import electrodynamics.client.guidebook.utils.components.Chapter;
import electrodynamics.client.guidebook.utils.components.Page;
import electrodynamics.common.block.subtype.SubtypeMachine;
import net.minecraft.ChatFormatting;

public class ChapterMachines extends Chapter {
	
	private static final ImageWrapperObject LOGO = new ImageWrapperObject(10, 50, 0, 0, 32, 32, 32, 32, References.ID + ":textures/item/motor.png");
	
	@Override
	protected List<Page> genPages() {
		//DO NOT COMPRESS
		List<Page> pages = new ArrayList<>();
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p0l1").setTextStyles(ChatFormatting.UNDERLINE),
			new TextWrapperObject(45, 57, 4210752, "block.electrodynamics.solarpanel"),
			new TextWrapperObject(45, 67, 4210752, "guidebook.electrodynamics.chapter.machines.basespecs", 0.67, 120),
			new TextWrapperObject(45, 77, 4210752, "guidebook.electrodynamics.chapter.machines.maxspecs", 1.51, 120),
			new TextWrapperObject(45, 93, 4210752, "block.electrodynamics.advancedsolarpanel"),
			new TextWrapperObject(45, 103, 4210752, "guidebook.electrodynamics.chapter.machines.basespecs", 4.8, 240),
			new TextWrapperObject(45, 113, 4210752, "guidebook.electrodynamics.chapter.machines.maxspecs", 10.8, 240),
			new TextWrapperObject(45, 127, 4210752, "block.electrodynamics.windmill"),
			new TextWrapperObject(45, 137, 4210752, "guidebook.electrodynamics.chapter.machines.wind"),
			new TextWrapperObject(45, 147, 4210752, "guidebook.electrodynamics.chapter.machines.windu"),
			new TextWrapperObject(45, 163, 4210752, "block.electrodynamics.coalgenerator"),
			new TextWrapperObject(45, 173, 4210752, "guidebook.electrodynamics.chapter.machines.maxspecs", 4.08, 120),
			new TextWrapperObject(45, 183, 4210752, "guidebook.electrodynamics.chapter.machines.coalgentemp"),
		}, new ItemWrapperObject[] {
			new ItemWrapperObject(15, 60, 2.0F, ItemUtils.fromBlock(DeferredRegisters.SUBTYPEBLOCK_MAPPINGS.get(SubtypeMachine.solarpanel))),
			new ItemWrapperObject(15, 95, 2.0F, ItemUtils.fromBlock(DeferredRegisters.SUBTYPEBLOCK_MAPPINGS.get(SubtypeMachine.advancedsolarpanel))),
			new ItemWrapperObject(15, 130, 2.0F, ItemUtils.fromBlock(DeferredRegisters.SUBTYPEBLOCK_MAPPINGS.get(SubtypeMachine.windmill))),
			new ItemWrapperObject(15, 165, 2.0F, ItemUtils.fromBlock(DeferredRegisters.SUBTYPEBLOCK_MAPPINGS.get(SubtypeMachine.coalgenerator))),
		}));
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(45, 47, 4210752, "guidebook.electrodynamics.chapter.machines.thermoname"),
			new TextWrapperObject(45, 57, 4210752, "guidebook.electrodynamics.chapter.machines.maxspecs", 0.54, 120),
			new TextWrapperObject(45, 67, 4210752, "guidebook.electrodynamics.chapter.machines.thermoheatsource"),
			new TextWrapperObject(45, 83, 4210752, "guidebook.electrodynamics.chapter.machines.hydroname"),
			new TextWrapperObject(45, 93, 4210752, "guidebook.electrodynamics.chapter.machines.basespecs", 0.72, 120),
			new TextWrapperObject(45, 103, 4210752, "guidebook.electrodynamics.chapter.machines.maxspecs", 1.62, 120),
			new TextWrapperObject(45, 117, 4210752, "block.electrodynamics.combustionchamber"),
			new TextWrapperObject(45, 127, 4210752, "guidebook.electrodynamics.chapter.machines.maxspecs", 7.0, 120),
			new TextWrapperObject(45, 137, 4210752, "guidebook.electrodynamics.chapter.machines.combfuel")
		}, new ItemWrapperObject[] {
			new ItemWrapperObject(15, 50, 2.0F, ItemUtils.fromBlock(DeferredRegisters.SUBTYPEBLOCK_MAPPINGS.get(SubtypeMachine.thermoelectricgenerator))),
			new ItemWrapperObject(15, 85, 2.0F, ItemUtils.fromBlock(DeferredRegisters.SUBTYPEBLOCK_MAPPINGS.get(SubtypeMachine.hydroelectricgenerator))),
			new ItemWrapperObject(15, 120, 2.0F, ItemUtils.fromBlock(DeferredRegisters.SUBTYPEBLOCK_MAPPINGS.get(SubtypeMachine.combustionchamber)))
		}));
		
		pages.add(new Page(new ImageWrapperObject[] {
			new ImageWrapperObject(12, 110, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/markerring.png"),		
		}, new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p1l1").setTextStyles(ChatFormatting.UNDERLINE),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p1l2-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(55, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p1l2-2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p1l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p1l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p1l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p1l6"),
			new TextWrapperObject(10, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p1l7"),
		}));
		
		pages.add(new Page(new ImageWrapperObject[] {
			new ImageWrapperObject(12, 110, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/seismicrelay1.png")
		}, new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p2l1-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(55, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p2l1-2"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p2l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p2l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p2l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p2l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p2l6"),
			new TextWrapperObject(10, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p2l7"),
		}));
		
		pages.add(new Page(new ImageWrapperObject[] {
			new ImageWrapperObject(12, 38, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/seismicrelay2.png"),
			new ImageWrapperObject(12, 117, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/seismicrelay3.png")
		}));
		
		pages.add(new Page(new ImageWrapperObject[] {
			new ImageWrapperObject(12, 110, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/quarryplacement.png")
		}, new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p4l1-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(55, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p4l1-2"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p4l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p4l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p4l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p4l5")
		}));
		
		pages.add(new Page(new ImageWrapperObject[] {
			new ImageWrapperObject(12, 110, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/coolantresplacement.png")
		}, new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p5l1-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(55, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p5l1-2"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p5l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p5l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p5l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p5l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p5l6")
		}));
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p6l1-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(55, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p6l1-2"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p6l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p6l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p6l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p6l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p6l6"),
			new TextWrapperObject(10, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p6l7"),
			new TextWrapperObject(10, 110, 4210752, "guidebook.electrodynamics.chapter.machines.p6l8"),
			new TextWrapperObject(10, 120, 4210752, "guidebook.electrodynamics.chapter.machines.p6l9"),
			new TextWrapperObject(10, 130, 4210752, "guidebook.electrodynamics.chapter.machines.p6l10"),
			new TextWrapperObject(10, 140, 4210752, "guidebook.electrodynamics.chapter.machines.p6l11"),
			new TextWrapperObject(10, 150, 4210752, "guidebook.electrodynamics.chapter.machines.p6l12"),
			new TextWrapperObject(10, 160, 4210752, "guidebook.electrodynamics.chapter.machines.p6l13"),
			new TextWrapperObject(10, 170, 4210752, "guidebook.electrodynamics.chapter.machines.p6l14")
		}));
		
		pages.add(new Page(new ImageWrapperObject[] {
			new ImageWrapperObject(12, 38, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/motorcomplex1.png"),
			new ImageWrapperObject(12, 117, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/motorcomplex2.png")
		}));
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p8l1-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(55, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p8l1-2"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p8l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p8l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p8l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p8l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p8l6"),
			new TextWrapperObject(10, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p8l7"),
			new TextWrapperObject(10, 110, 4210752, "guidebook.electrodynamics.chapter.machines.p8l8"),
			new TextWrapperObject(10, 120, 4210752, "guidebook.electrodynamics.chapter.machines.p8l9")
		}));
		
		pages.add(new Page(new ImageWrapperObject[] {
			new ImageWrapperObject(12, 38, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/quarrypower1.png"),
			new ImageWrapperObject(12, 117, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/quarrypower2.png")
		}));
		
		pages.add(new Page(new ImageWrapperObject[] {
			new ImageWrapperObject(12, 38, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/quarrypower3.png")
		}));
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p11l1-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(55, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p11l1-2"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p11l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p11l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p11l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p11l5"),
			new TextWrapperObject(30, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p11l6"),
			new TextWrapperObject(85, 90, 4210752, "guidebook.electrodynamics.chapter.machines.durability", 200),
			new TextWrapperObject(30, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p11l7"),
			new TextWrapperObject(85, 100, 4210752, "guidebook.electrodynamics.chapter.machines.durability", 400),
			new TextWrapperObject(30, 110, 4210752, "guidebook.electrodynamics.chapter.machines.p11l8"),
			new TextWrapperObject(85, 110, 4210752, "guidebook.electrodynamics.chapter.machines.durability", 600),
			new TextWrapperObject(30, 120, 4210752, "guidebook.electrodynamics.chapter.machines.p11l9"),
			new TextWrapperObject(85, 120, 4210752, "guidebook.electrodynamics.chapter.machines.durability", 1000),
			new TextWrapperObject(30, 130, 4210752, "guidebook.electrodynamics.chapter.machines.p11l10"),
			new TextWrapperObject(85, 130, 4210752, "guidebook.electrodynamics.chapter.machines.durability", "Infinite"),
			new TextWrapperObject(10, 140, 4210752, "guidebook.electrodynamics.chapter.machines.p11l11"),
			new TextWrapperObject(10, 150, 4210752, "guidebook.electrodynamics.chapter.machines.p11l12"),
			new TextWrapperObject(10, 160, 4210752, "guidebook.electrodynamics.chapter.machines.p11l13"),
			new TextWrapperObject(10, 170, 4210752, "guidebook.electrodynamics.chapter.machines.p11l14"),
			new TextWrapperObject(10, 180, 4210752, "guidebook.electrodynamics.chapter.machines.p11l15"),
		}));
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p12l1"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p12l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p12l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p12l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p12l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p12l6"),
			new TextWrapperObject(10, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p12l7"),
			new TextWrapperObject(10, 110, 4210752, "guidebook.electrodynamics.chapter.machines.p12l8"),
			new TextWrapperObject(10, 120, 4210752, "guidebook.electrodynamics.chapter.machines.p12l9-1"),
			new TextWrapperObject(31, 120, 4210752, "guidebook.electrodynamics.chapter.machines.p12l9-2").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(58, 120, 4210752, "guidebook.electrodynamics.chapter.machines.p12l9-3"),
			new TextWrapperObject(10, 130, 4210752, "guidebook.electrodynamics.chapter.machines.p12l10"),
			new TextWrapperObject(10, 140, 4210752, "guidebook.electrodynamics.chapter.machines.p12l11"),
			new TextWrapperObject(10, 150, 4210752, "guidebook.electrodynamics.chapter.machines.p12l12"),
			new TextWrapperObject(10, 160, 4210752, "guidebook.electrodynamics.chapter.machines.p12l13"),
			new TextWrapperObject(10, 170, 4210752, "guidebook.electrodynamics.chapter.machines.p12l14"),
			new TextWrapperObject(10, 180, 4210752, "guidebook.electrodynamics.chapter.machines.p12l15"),
		}));
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p13l1-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(60, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p13l1-2"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p13l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p13l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p13l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p13l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p13l6"),
			new TextWrapperObject(10, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p13l7-1"),
			new TextWrapperObject(80, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p13l7-2").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(10, 110, 4210752, "guidebook.electrodynamics.chapter.machines.p13l8"),
			new TextWrapperObject(10, 120, 4210752, "guidebook.electrodynamics.chapter.machines.p13l9"),
			new TextWrapperObject(10, 130, 4210752, "guidebook.electrodynamics.chapter.machines.p13l10"),
			new TextWrapperObject(10, 140, 4210752, "guidebook.electrodynamics.chapter.machines.p13l11"),
			new TextWrapperObject(10, 150, 4210752, "guidebook.electrodynamics.chapter.machines.p13l12"),
			new TextWrapperObject(10, 160, 4210752, "guidebook.electrodynamics.chapter.machines.p13l13"),
			new TextWrapperObject(10, 170, 4210752, "guidebook.electrodynamics.chapter.machines.p13l14"),
			new TextWrapperObject(10, 180, 4210752, "guidebook.electrodynamics.chapter.machines.p13l15"),
		}));
		
		pages.add(new Page(new ImageWrapperObject[] {
			new ImageWrapperObject(12, 110, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/quarrygui1.png")
		}, new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p14l1-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(79, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p14l1-2"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p14l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p14l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p14l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p14l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p14l6"),
		}));
		
		pages.add(new Page(new ImageWrapperObject[] {
			new ImageWrapperObject(12, 38, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/quarrygui2.png"),
			new ImageWrapperObject(12, 117, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/quarrygui3.png")
		}));
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p16l1-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(55, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p16l1-2"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p16l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p16l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p16l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p16l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p16l6"),
			new TextWrapperObject(10, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p16l7"),
			new TextWrapperObject(10, 110, 4210752, "guidebook.electrodynamics.chapter.machines.p16l8"),
			new TextWrapperObject(10, 120, 4210752, "guidebook.electrodynamics.chapter.machines.p16l9"),
			new TextWrapperObject(10, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p16l7"),
			new TextWrapperObject(10, 110, 4210752, "guidebook.electrodynamics.chapter.machines.p16l8"),
			new TextWrapperObject(10, 120, 4210752, "guidebook.electrodynamics.chapter.machines.p16l9"),
			new TextWrapperObject(10, 130, 4210752, "guidebook.electrodynamics.chapter.machines.p16l10"),
			new TextWrapperObject(10, 140, 4210752, "guidebook.electrodynamics.chapter.machines.p16l11"),
			new TextWrapperObject(10, 150, 4210752, "guidebook.electrodynamics.chapter.machines.p16l12"),
			new TextWrapperObject(10, 160, 4210752, "guidebook.electrodynamics.chapter.machines.p16l13")
		}));
		
		pages.add(new Page(new ImageWrapperObject[] {
			new ImageWrapperObject(12, 38, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/logisticalmanager1.png"),
			new ImageWrapperObject(12, 117, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/logisticalmanager2.png")
		}));
		
		pages.add(new Page(new ImageWrapperObject[] {
			new ImageWrapperObject(12, 38, 0, 0, 150, 79, 150, 79, References.ID + ":textures/screen/guidebook/logisticalmanager3.png")
		}));
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p19l1").setTextStyles(ChatFormatting.UNDERLINE),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p19l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p19l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p19l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p19l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p19l6"),
			new TextWrapperObject(10, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p19l7-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(58, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p19l7-2"),
			new TextWrapperObject(10, 110, 4210752, "guidebook.electrodynamics.chapter.machines.p19l8"),
			new TextWrapperObject(10, 120, 4210752, "guidebook.electrodynamics.chapter.machines.p19l9"),
			new TextWrapperObject(10, 130, 4210752, "guidebook.electrodynamics.chapter.machines.p19l10-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(47, 130, 4210752, "guidebook.electrodynamics.chapter.machines.p19l10-2"),
			new TextWrapperObject(10, 140, 4210752, "guidebook.electrodynamics.chapter.machines.p19l11"),
			new TextWrapperObject(10, 150, 4210752, "guidebook.electrodynamics.chapter.machines.p19l12"),
			new TextWrapperObject(10, 160, 4210752, "guidebook.electrodynamics.chapter.machines.p19l13"),
			new TextWrapperObject(10, 170, 4210752, "guidebook.electrodynamics.chapter.machines.p19l14"),
			new TextWrapperObject(10, 180, 4210752, "guidebook.electrodynamics.chapter.machines.p19l15")
		}));
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p20l1"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p20l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p20l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p20l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p20l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p20l6")
		}));
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p21l1").setTextStyles(ChatFormatting.UNDERLINE),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p21l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p21l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p21l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p21l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p21l6"),
			new TextWrapperObject(10, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p21l7-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(58, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p21l7-2"),
			new TextWrapperObject(10, 110, 4210752, "guidebook.electrodynamics.chapter.machines.p21l8"),
			new TextWrapperObject(10, 120, 4210752, "guidebook.electrodynamics.chapter.machines.p21l9"),
			new TextWrapperObject(10, 130, 4210752, "guidebook.electrodynamics.chapter.machines.p21l10-1").setTextStyles(ChatFormatting.BOLD),
			new TextWrapperObject(47, 130, 4210752, "guidebook.electrodynamics.chapter.machines.p21l10-2"),
			new TextWrapperObject(10, 140, 4210752, "guidebook.electrodynamics.chapter.machines.p21l11"),
			new TextWrapperObject(10, 150, 4210752, "guidebook.electrodynamics.chapter.machines.p21l12"),
			new TextWrapperObject(10, 160, 4210752, "guidebook.electrodynamics.chapter.machines.p21l13"),
			new TextWrapperObject(10, 170, 4210752, "guidebook.electrodynamics.chapter.machines.p21l14"),
			new TextWrapperObject(10, 180, 4210752, "guidebook.electrodynamics.chapter.machines.p21l15")
		}));
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p22l1"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p22l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p22l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p22l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p22l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p22l6"),
			new TextWrapperObject(10, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p22l7"),
			new TextWrapperObject(10, 110, 4210752, "guidebook.electrodynamics.chapter.machines.p22l8"),
			new TextWrapperObject(10, 120, 4210752, "guidebook.electrodynamics.chapter.machines.p22l9"),
			new TextWrapperObject(10, 130, 4210752, "guidebook.electrodynamics.chapter.machines.p22l10"),
			new TextWrapperObject(10, 140, 4210752, "guidebook.electrodynamics.chapter.machines.p22l11"),
			new TextWrapperObject(10, 150, 4210752, "guidebook.electrodynamics.chapter.machines.p22l12"),
			new TextWrapperObject(10, 160, 4210752, "guidebook.electrodynamics.chapter.machines.p22l13")
		}));
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p23l1").setTextStyles(ChatFormatting.UNDERLINE),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p23l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p23l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p23l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p23l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p23l6"),
			new TextWrapperObject(10, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p23l7"),
			new TextWrapperObject(10, 110, 4210752, "guidebook.electrodynamics.chapter.machines.p23l8"),
			new TextWrapperObject(10, 120, 4210752, "guidebook.electrodynamics.chapter.machines.p23l9"),
			new TextWrapperObject(10, 130, 4210752, "guidebook.electrodynamics.chapter.machines.p23l10"),
			new TextWrapperObject(10, 140, 4210752, "guidebook.electrodynamics.chapter.machines.p23l11"),
			new TextWrapperObject(10, 150, 4210752, "guidebook.electrodynamics.chapter.machines.p23l12"),
			new TextWrapperObject(10, 160, 4210752, "guidebook.electrodynamics.chapter.machines.p23l13"),
			new TextWrapperObject(10, 170, 4210752, "guidebook.electrodynamics.chapter.machines.p23l14"),
			new TextWrapperObject(10, 180, 4210752, "guidebook.electrodynamics.chapter.machines.p23l15")
		}));
		
		pages.add(new Page(new ImageWrapperObject[] {
			new ImageWrapperObject(12, 59, 0, 0, 150, 70, 150, 70, References.ID + ":textures/screen/guidebook/chargerbatteryslots.png"),
		},new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p24l1"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p24l2"),
			new TextWrapperObject(10, 130, 4210752, "guidebook.electrodynamics.chapter.machines.p24l3"),
			new TextWrapperObject(10, 140, 4210752, "guidebook.electrodynamics.chapter.machines.p24l4"),
			new TextWrapperObject(10, 150, 4210752, "guidebook.electrodynamics.chapter.machines.p24l5"),
			new TextWrapperObject(10, 160, 4210752, "guidebook.electrodynamics.chapter.machines.p24l6"),
			new TextWrapperObject(10, 170, 4210752, "guidebook.electrodynamics.chapter.machines.p24l7"),
			new TextWrapperObject(10, 180, 4210752, "guidebook.electrodynamics.chapter.machines.p24l8")
			
		}));
		
		pages.add(new Page(new TextWrapperObject[] {
			new TextWrapperObject(10, 40, 4210752, "guidebook.electrodynamics.chapter.machines.p25l1"),
			new TextWrapperObject(10, 50, 4210752, "guidebook.electrodynamics.chapter.machines.p25l2"),
			new TextWrapperObject(10, 60, 4210752, "guidebook.electrodynamics.chapter.machines.p25l3"),
			new TextWrapperObject(10, 70, 4210752, "guidebook.electrodynamics.chapter.machines.p25l4"),
			new TextWrapperObject(10, 80, 4210752, "guidebook.electrodynamics.chapter.machines.p25l5"),
			new TextWrapperObject(10, 90, 4210752, "guidebook.electrodynamics.chapter.machines.p25l6"),
			new TextWrapperObject(10, 100, 4210752, "guidebook.electrodynamics.chapter.machines.p25l7")
		}));
		
		return pages;
	}

	@Override
	public ImageWrapperObject getLogo() {
		return LOGO;
	}

	@Override
	public String getTitleKey() {
		return "guidebook.electrodynamics.chapter.machines";
	}

}

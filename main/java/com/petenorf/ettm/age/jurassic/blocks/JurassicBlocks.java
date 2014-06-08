package com.petenorf.ettm.age.jurassic.blocks;

import com.petenorf.ettm.age.jurassic.itemblocks.ItemBlockJurassicLeaves;
import com.petenorf.ettm.age.jurassic.itemblocks.ItemBlockJurassicLog;
import com.petenorf.ettm.util.reference.Names;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class JurassicBlocks {
	public static final Block smokingDirt = new BlockSmokingDirt();
	public static final Block mud = new BlockMud();
	public static final Block dinoEggDecorative = new BlockDinoEggDecorative();
	public static final Block jurassicLog = new BlockJurassicLog();
	public static final Block jurassicLeaves = new BlockJurassicLeaves();
	
	public static void load() {
		GameRegistry.registerBlock(smokingDirt, Names.Blocks.SMOKING_DIRT);
		GameRegistry.registerBlock(mud, Names.Blocks.MUD);
		GameRegistry.registerBlock(dinoEggDecorative, Names.Blocks.DINOEGG_DECORATIVE);
		GameRegistry.registerBlock(jurassicLog, ItemBlockJurassicLog.class, "Log");
		GameRegistry.registerBlock(jurassicLeaves, ItemBlockJurassicLeaves.class, Names.Blocks.JURASSIC_LEAVES);
	}
}

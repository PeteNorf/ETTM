package com.petenorf.ettm.age.jurassic.Blocks;

import com.petenorf.ettm.util.reference.Names;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class JurassicBlocks {
	public static final Block smokingDirt = new BlockSmokingDirt();
	
	public static void load() {
		GameRegistry.registerBlock(smokingDirt, Names.Blocks.smokingDirt);
	}
}

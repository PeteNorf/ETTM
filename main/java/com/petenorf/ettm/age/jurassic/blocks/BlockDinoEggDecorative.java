package com.petenorf.ettm.age.jurassic.blocks;

import com.petenorf.ettm.age.jurassic.JurassicPeriod;
import com.petenorf.ettm.util.reference.Names;
import com.petenorf.ettm.util.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDinoEggDecorative extends Block {
	public BlockDinoEggDecorative(){
		super(Material.dragonEgg);
		setCreativeTab(JurassicPeriod.jurassicTab);
		setBlockName(Names.Blocks.DINOEGG_DECORATIVE);
		setBlockTextureName(Reference.MOD_ID + ":" + Names.Blocks.DINOEGG_DECORATIVE);
	}
}

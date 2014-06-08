package com.petenorf.ettm.age.jurassic.blocks;

import com.petenorf.ettm.age.jurassic.JurassicPeriod;
import com.petenorf.ettm.util.reference.Names;
import com.petenorf.ettm.util.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSmokingDirt extends Block {
	public BlockSmokingDirt(){
		super(Material.ground);
		setCreativeTab(JurassicPeriod.jurassicTab);
		setBlockName(Names.Blocks.SMOKING_DIRT);
		setBlockTextureName(Reference.MOD_ID + ":" + Names.Blocks.SMOKING_DIRT);
	}
}

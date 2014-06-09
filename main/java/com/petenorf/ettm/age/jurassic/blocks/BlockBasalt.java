package com.petenorf.ettm.age.jurassic.blocks;

import com.petenorf.ettm.age.jurassic.JurassicPeriod;
import com.petenorf.ettm.util.reference.Names;
import com.petenorf.ettm.util.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBasalt extends Block {
	public BlockBasalt() {
		super(Material.rock);
		setCreativeTab(JurassicPeriod.jurassicTab);
		setBlockName(Names.Blocks.BASALT);
		setBlockTextureName(Reference.MOD_ID + ":" + Names.Blocks.BASALT);
	}
}

package com.petenorf.ettm.age.jurassic.blocks;

import com.petenorf.ettm.age.jurassic.JurassicPeriod;
import com.petenorf.ettm.util.reference.Names;
import com.petenorf.ettm.util.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMud extends Block {
	public BlockMud(){
		super(Material.ground);
		setCreativeTab(JurassicPeriod.jurassicTab);
		setBlockName(Names.Blocks.MUD);
		setBlockTextureName(Reference.MOD_ID + ":" + Names.Blocks.MUD);
	}
}

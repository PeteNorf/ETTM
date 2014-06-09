package com.petenorf.ettm.age.jurassic.blocks;

import com.petenorf.ettm.age.jurassic.JurassicPeriod;
import com.petenorf.ettm.util.reference.Names;
import com.petenorf.ettm.util.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockDinoEggDecorative extends BlockDragonEgg {
	public BlockDinoEggDecorative(){
		super();
		setCreativeTab(JurassicPeriod.jurassicTab);
		setBlockName(Names.Blocks.DINOEGG_DECORATIVE);
		setBlockTextureName(Reference.MOD_ID + ":" + Names.Blocks.DINOEGG_DECORATIVE);
	}
	
	@Override
	public int getRenderType(){
		return 27;
		
	}
	@Override
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){
		return false;
		
	}
	@Override
	 public void onBlockClicked(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_){
		
	}
}

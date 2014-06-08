package com.petenorf.ettm.event;


import com.petenorf.ettm.age.jurassic.blocks.BlockJurassicSapling;
import com.petenorf.ettm.age.jurassic.blocks.JurassicBlocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ETTMBoneMealEvent {
	@SubscribeEvent
	public void onUseBonemeal(BonemealEvent event){
		World world = event.world;
		int x = event.x;
		int y = event.y;
		int z = event.z;
		
		Block block = event.block;
		int meta = event.world.getBlockMetadata(x, y, z);
		
		if(block == JurassicBlocks.jurassicSapling){
		event.setResult(Event.Result.ALLOW);
		((BlockJurassicSapling) block).func_149878_d(event.world, x, y, z,event.world.rand);
		}
	}
}

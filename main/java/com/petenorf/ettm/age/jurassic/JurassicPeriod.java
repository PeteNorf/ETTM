package com.petenorf.ettm.age.jurassic;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.petenorf.ettm.age.jurassic.blocks.JurassicBlocks;
import com.petenorf.ettm.age.jurassic.fluid.JurassicFluids;
import com.petenorf.ettm.event.ETTMEventHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class JurassicPeriod {
	public static CreativeTabs jurassicTab = new CreativeTabs("jurassicTab"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return Items.apple;
		}
	};
	

	
	public static void preInit() {
		JurassicFluids.preInit();
		JurassicBlocks.load();
		ETTMEventHandler.registerEvents();
	}
	
	public void init() {
		JurassicFluids.init();
	}
	
	public void postInit() {
		
	}
}

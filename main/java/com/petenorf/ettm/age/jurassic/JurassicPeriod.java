package com.petenorf.ettm.age.jurassic;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.petenorf.ettm.age.jurassic.Blocks.JurassicBlocks;

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
		JurassicBlocks.load();
	}
	
	public void init() {
		
	}
	
	public void postInit() {
		
	}
}

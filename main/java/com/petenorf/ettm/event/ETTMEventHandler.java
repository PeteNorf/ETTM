package com.petenorf.ettm.event;

import net.minecraftforge.common.MinecraftForge;

public class ETTMEventHandler {
	public static void registerEvents(){
		MinecraftForge.EVENT_BUS.register(new ETTMBoneMealEvent());
	}
}

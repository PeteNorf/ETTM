package com.petenorf.ettm;

import com.petenorf.ettm.proxy.IProxy;
import com.petenorf.ettm.util.reference.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, version = Reference.MOD_VERSION)
public class ETTM {
	@Instance(Reference.MOD_ID)
	public static ETTM instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide= Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	
    }
}

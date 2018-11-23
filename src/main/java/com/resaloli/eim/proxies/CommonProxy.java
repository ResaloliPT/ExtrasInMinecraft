package com.resaloli.eim.proxies;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.handlers.EventHandler;
import com.resaloli.eim.handlers.GUIHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("PreIniting EIM");
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
    public void init(FMLInitializationEvent event) {
        System.out.println("Initing EIM");
        NetworkRegistry.INSTANCE.registerGuiHandler(ExtrasInMinecraft.instance, new GUIHandler());
    }
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("PostIniting EIM");
    }
}


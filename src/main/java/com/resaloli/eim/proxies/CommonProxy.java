package com.resaloli.eim.proxies;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.gui.GUIHandler;
import com.resaloli.eim.content.te.TileEntityDCT;
import com.resaloli.eim.handlers.EventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("PreIniting EIM");
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        GameRegistry.registerTileEntity(TileEntityDCT.class, ExtrasInMinecraft.modid+":TileEntitydualCraftingTable");
    }
    public void init(FMLInitializationEvent event) {
        System.out.println("Initing EIM");
        NetworkRegistry.INSTANCE.registerGuiHandler(ExtrasInMinecraft.instance, new GUIHandler());

    }
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("PostIniting EIM");
    }
}


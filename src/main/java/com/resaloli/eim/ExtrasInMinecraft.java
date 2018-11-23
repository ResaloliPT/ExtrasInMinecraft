package com.resaloli.eim;

import com.resaloli.eim.command.Commands;
import com.resaloli.eim.proxies.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(
        modid = ExtrasInMinecraft.MOD_ID,
        name = ExtrasInMinecraft.MOD_NAME,
        version = ExtrasInMinecraft.VERSION,
        dependencies = "required-after:forge@[14.23.5.2772,);",
        acceptedMinecraftVersions = "[1.12.2,1.13.0)")

public class ExtrasInMinecraft {

    //Mod Properties
    public static final String MOD_ID = "extrasinminecraft";
    public static final String MOD_NAME = "Extras In Minecraft";
    public static final String VERSION = "0.1";

    //Instance
    @Mod.Instance(com.resaloli.eim.ExtrasInMinecraft.MOD_ID)
    public static com.resaloli.eim.ExtrasInMinecraft instance;

    //Proxy Things
    @SidedProxy(
            clientSide = "com.resaloli.eim.proxies.ClientProxy",
            serverSide="com.resaloli.eim.proxies.CommonProxy")
    public static CommonProxy proxy;

    /* Events */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        Commands.initCommands(event);
    }
}
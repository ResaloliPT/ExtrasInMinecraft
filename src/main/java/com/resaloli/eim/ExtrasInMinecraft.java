package com.resaloli.eim;

import com.resaloli.eim.proxies.CommonProxy;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import javax.annotation.Nullable;
import java.io.File;

@Mod(
        modid=ExtrasInMinecraft.modid,
        name=ExtrasInMinecraft.modName,
        version=ExtrasInMinecraft.version,
        acceptedMinecraftVersions = "[1.12.2,1.13.0)",
        dependencies = "required-after:forge@[14.23.3.2684,);")

public class ExtrasInMinecraft{

    //Strings
    public final static String modid = CONSTANTS.MOD_ID;
    public static final String modName = "Extras In Minecraft";
    public final static String version = "0.1";

	//Instance
	@Mod.Instance(ExtrasInMinecraft.modid)
	public static ExtrasInMinecraft instance;

	@Nullable
    private File configFile;
	
	//Proxy Things
	@SidedProxy(
	        clientSide="com.resaloli.eim.proxies.ClientProxy",
            serverSide="com.resaloli.eim.proxies.CommonProxy")

	public static CommonProxy proxy;


    //CreativeTabs
    public static final EIMCreativeTab tabExtrasInMinecraft = new EIMCreativeTab();

	//GUIID'S
	public static final int GUIDdualCraftingTable = 0;
		
	//Inits
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        configFile = new File(event.getModConfigurationDirectory(), CONSTANTS.MOD_ID);
        //TODO: Implement Configs! Config.load(event.getSide());

        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        MinecraftServer server = event.getServer();
        ICommandManager command = server.getCommandManager();
        ServerCommandManager manager = (ServerCommandManager) command;
        manager.registerCommand(new CheatCommand());
    }

    public String getModId()
  {
    return this.modid;
  }
  
    public String getModName()
  {
    return this.modName;
  }
  
    public String getModVersion()
  {
    return this.version;
  }
}

package com.resaloli.eim;

import com.resaloli.eim.handlers.EventHandler;
import com.resaloli.eim.proxies.*;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid=ExtrasInMinecraft.modid, name=ExtrasInMinecraft.modName, version=ExtrasInMinecraft.version)

public class ExtrasInMinecraft{

    //Strings
    public final static String modid = "extrasinminecraft";
    public static final String modName = "Extras In Minecraft";
    public final static String version = "0.1";

	//Instance
	@Mod.Instance(ExtrasInMinecraft.modid)
	public static ExtrasInMinecraft instance;
	
	
	//Proxy Things
	@SidedProxy(clientSide="com.resaloli.eim.proxies.ClientProxy", serverSide="com.resaloli.eim.proxies.CommonProxy")
	public static CommonProxy proxy;


    //CreativeTabs
    public static final EIMCreativeTab tabExtrasInMinecraft = new EIMCreativeTab();

	//GUIID'S
	public static final int GUIDdualCraftingTable = 0;
		
	//Inits
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
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

    @Mod.EventHandler //TODO: Fix command
    public void serverStarting(FMLServerStartingEvent event) {
        MinecraftServer server = event.getServer();
        ICommandManager command = server.getCommandManager();
        ServerCommandManager manager = (ServerCommandManager) command;
        manager.registerCommand(new CheatCommand());
    }

  /**
  public void preInit(FMLPreInitializationEvent paramFMLPreInitializationEvent)
  {
	  System.out.println("PreIniting EIM");
	  GameRegistry.registerTileEntity(TileEntityDCT.class, "TileEntitydualCraftingTable");
	  
  }
  
  @Mod.EventHandler
  public void initialize(FMLInitializationEvent paramFMLInitializationEvent)
  {
	  System.out.println("Initing EIM");
	  MinecraftForge.EVENT_BUS.register(proxy);
	  NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
	  Recipes.initRecipes();
  }

  
  @Mod.EventHandler //TODO: Fix command
  public void serverStarting(FMLServerStartingEvent event) {
	  MinecraftServer server = event.getServer();
	  ICommandManager command = server.getCommandManager();
	  ServerCommandManager manager = (ServerCommandManager) command;
	  manager.registerCommand(new CheatCommand());
  }**/
  

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

package com.resaloli.eim;

import com.resaloli.eim.content.items.EIMItems;
import com.resaloli.eim.proxies.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=ExtrasInMinecraft.modid, name=ExtrasInMinecraft.modName, version=ExtrasInMinecraft.version, dependencies="")

public class ExtrasInMinecraft{

	//Instance
	@Mod.Instance("extrasinminecraft")
	public static ExtrasInMinecraft instance;

	//Strings
	public final static String modid = "extrasinminecraft";
	public static final String modName = "Extras In Minecraft";
	public final static String version = "0.1";
	
	
	//Proxy Things
	@SidedProxy(clientSide="com.resaloli.eim.proxies.ProxyClient", serverSide="com.resaloli.eim.proxies.ProxyServer")
	public static ProxyClient proxy;

    //CreativeTabs
    public static final EIMCreativeTab tabExtrasInMinecraft = new EIMCreativeTab();

	//GUIID'S
	public static final int GUIDdualCraftingTable = 0;
		
	//Inits
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("PreIniting EIM");
        EIMItems.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("Initing EIM");

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("PostIniting EIM");
    }

  /**
  public void preInit(FMLPreInitializationEvent paramFMLPreInitializationEvent)
  {
	  System.out.println("PreIniting EIM");
	  ProxyClient.registerProxies();
	  EIMBlocks.init();
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

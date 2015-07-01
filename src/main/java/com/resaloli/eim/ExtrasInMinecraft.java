package com.resaloli.eim;

import com.resaloli.eim.content.gui.*;
import com.resaloli.eim.content.recipes.Recipes;
import com.resaloli.eim.content.te.*;
import com.resaloli.eim.content.blocks.*;
import com.resaloli.eim.proxies.*;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid="extrasinminecraft", name="Extras In Minecraft", version="0.1", dependencies="")

public class ExtrasInMinecraft{
	
	//Instance
	@Mod.Instance("extrasinminecraft")
	public static ExtrasInMinecraft instance;
	
	//Strings
	public final static String modid = "extrasinminecraft";
	public static final String modName = "Extras In Minecraft";
	public final String version = "0.1";
	
	
	//Proxy Things
	@SidedProxy(clientSide="com.resaloli.eim.proxies.ProxyClient", serverSide="com.resaloli.eim.proxies.ProxyServer")
	public static ProxyClient proxy;  
	
	//CreativeTabs
	
	public static CreativeTabs tabExtrasInMinecraft = new CreativeTabs("tabExtrasInMinecraft"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return GameRegistry.findItem(ExtrasInMinecraft.modid, "dualCraftingTable");
		}
	};
	//GUIID'S
	public static final int GUIDdualCraftingTable = 0;
		
	//Inits
	public TileEntityDCT TileEntitydualCraftingTable = new TileEntityDCT();
  
  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent paramFMLPreInitializationEvent)
  {
	  System.out.println("PreIniting EIM");
	  ProxyClient.registerProxies();
	  EIMBlocks.preinit();
	  GameRegistry.registerTileEntity(TileEntityDCT.class, "TileEntitydualCraftingTable");
	  
  }
  
  @Mod.EventHandler
  public void initialize(FMLInitializationEvent paramFMLInitializationEvent)
  {
	  System.out.println("Initing EIM");
	  MinecraftForge.EVENT_BUS.register(proxy);
	  NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
	  ProxyClient.registerRender();
	  Recipes.initRecipes();
  }
  
  @Mod.EventHandler
  public void postInit(FMLPostInitializationEvent paramFMLPostInitializationEvent)
  {
	  System.out.println("PostIniting EIM");
	  
	  System.out.println("Extras In Minecraft Ready to launch!!");
	  
  }
  
  @Mod.EventHandler
	public void load(FMLInitializationEvent event)  {
  }
  
  @Mod.EventHandler
  public void serverStarting(FMLServerStartingEvent event) {
	  MinecraftServer server = MinecraftServer.getServer();
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

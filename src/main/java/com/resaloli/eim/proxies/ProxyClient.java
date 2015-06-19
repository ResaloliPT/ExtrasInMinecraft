package com.resaloli.eim.proxies;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.container.ContainerDCT;
import com.resaloli.eim.content.gui.GUIdualCraftingTable;
import com.resaloli.eim.content.te.TileEntityDCT;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ProxyClient extends ProxyServer{
	
	public static void registerProxies(){
		
	}
	
	
	public static void registerRender(){
		//dualCraftingTable;
		Item dualCraftingTableItem = GameRegistry.findItem(ExtrasInMinecraft.modid, "dualCraftingTable");
		ModelResourceLocation dualCraftingTableRes = new ModelResourceLocation("extrasinminecraft:dualCraftingTable", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(dualCraftingTableItem, 0, dualCraftingTableRes);
	}
	
	public static Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
		
		TileEntityDCT tileEntity = new TileEntityDCT();
			if(tileEntity instanceof TileEntity){
				
				return new ContainerDCT(player.inventory, tileEntity);
			}
			return null;
	}
	
	public static Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
		
		TileEntityDCT tileEntity = new TileEntityDCT();
			if(tileEntity instanceof TileEntity){
				
				return new GUIdualCraftingTable(player.inventory, (TileEntityDCT)tileEntity, world, new BlockPos(x,y,z));
			}
			return null;
	}
}

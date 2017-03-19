package com.resaloli.eim.proxies;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.container.ContainerDCT;
import com.resaloli.eim.content.gui.GUIdualCraftingTable;
import com.resaloli.eim.content.te.TileEntityDCT;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;


public class ProxyClient extends ProxyServer{

	public static void registerRender(Item item, int meta, String nameID){
		//dualCraftingTable;
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(ExtrasInMinecraft.modid+":"+nameID, "inventory"));
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

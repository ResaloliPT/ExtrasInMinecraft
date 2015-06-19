package com.resaloli.eim.content.gui;

import com.resaloli.eim.content.container.ContainerDCT;
import com.resaloli.eim.content.te.TileEntityDCT;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler
{

        @Override
        public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
        { 
                TileEntityDCT tileEntity = (TileEntityDCT) world.getTileEntity(new BlockPos(x, y, z));

                if(tileEntity != null)
                {
                        switch(ID)
                        {
                        case 0: return new ContainerDCT(player.inventory, tileEntity);
                        }
                }

                return null;
        }

        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
        {
                TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

                if (tileEntity != null)
                {
                        switch(ID)
                        {
                        case 0: return new GUIdualCraftingTable(player.inventory, (TileEntityDCT)tileEntity, world, new BlockPos(x,y,z));
                        }
                }

                return null;
        }
}
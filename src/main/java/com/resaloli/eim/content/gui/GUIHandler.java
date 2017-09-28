package com.resaloli.eim.content.gui;

import com.resaloli.eim.CONSTANTS;
import com.resaloli.eim.content.container.ContainerDCT;
import com.resaloli.eim.content.te.TileEntityDCT;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler
{

        @Override
        public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
                switch(ID)
                {
                        case CONSTANTS.GUI_DUAL_CRAFTING_TABLE_ID: return new ContainerDCT(player.inventory, world, new BlockPos(x,y,z));
                }
                return null;
        }

        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
                switch(ID)
                {
                       case CONSTANTS.GUI_DUAL_CRAFTING_TABLE_ID: return new GUIdualCraftingTable(player.inventory, world, new BlockPos(x,y,z));
                }
                return null;
        }
}
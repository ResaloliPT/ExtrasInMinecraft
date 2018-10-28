package com.resaloli.eim.handlers;

import com.resaloli.eim.CONSTANTS;
import com.resaloli.eim.ModularContent.Energy.Container.ContainerGenerator;
import com.resaloli.eim.ModularContent.Energy.GUI.GUIGenerator;
import com.resaloli.eim.content.container.ContainerDCT;
import com.resaloli.eim.content.gui.GUIdualCraftingTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler
{

        @Override
        public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
                switch(ID)
                {
                    case CONSTANTS.GUI_DUAL_CRAFTING_TABLE_ID:
                        return new ContainerDCT(player.inventory, world, new BlockPos(x,y,z));
                    case CONSTANTS.GUI_ENERGY_GENERATOR_ID:
                        return  new ContainerGenerator(player.inventory, world, new BlockPos(x,y,z));
                }
                return null;
        }

        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
                switch(ID)
                {
                       case CONSTANTS.GUI_DUAL_CRAFTING_TABLE_ID:
                           return new GUIdualCraftingTable(player.inventory, world, new BlockPos(x,y,z));
                       case CONSTANTS.GUI_ENERGY_GENERATOR_ID:
                           return new GUIGenerator(player.inventory, world, new BlockPos(x,y,z));
                }
                return null;
        }
}
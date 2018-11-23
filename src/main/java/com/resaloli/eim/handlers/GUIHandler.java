package com.resaloli.eim.handlers;

import com.resaloli.eim.ModularContent.Energy.Container.ContainerGenerator;
import com.resaloli.eim.ModularContent.Energy.GUI.GUIGenerator;
import com.resaloli.eim.content.container.ContainerDCT;
import com.resaloli.eim.content.gui.GUIID;
import com.resaloli.eim.content.gui.GUIdualCraftingTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        GUIID gui = GUIID.getGUI(ID);

        if (gui == null) {
            return null;
        }

        switch (gui) {
            case DUAL_CRAFTING_TABLE:
                return new ContainerDCT(player.inventory, world, new BlockPos(x, y, z));
            case GUI_ENERGY_GENERATOR_ID:
                return new ContainerGenerator(player.inventory, world, new BlockPos(x, y, z));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        GUIID gui = GUIID.getGUI(ID);

        if (gui == null) {
            return null;
        }

        switch (gui) {

            case DUAL_CRAFTING_TABLE:
                return new GUIdualCraftingTable(player.inventory, world, new BlockPos(x, y, z));
            case GUI_ENERGY_GENERATOR_ID:
                return new GUIGenerator(player.inventory, world, new BlockPos(x, y, z));
            default:
                return null;
        }
    }
}
package com.resaloli.eim.content.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;

public class EIMBlocks {

    //TODO: FIX STEALING ITEMS
    public static BlockDCT dualCraftingTable = new BlockDCT();

    public static final Block[] BLOCKS = {
            dualCraftingTable
    };


    public static Block[] getList() {
        return BLOCKS;
    }
}
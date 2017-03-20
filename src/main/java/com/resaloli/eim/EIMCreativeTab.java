package com.resaloli.eim;

import com.resaloli.eim.content.blocks.EIMBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EIMCreativeTab extends CreativeTabs{

    public EIMCreativeTab() {
        super(ExtrasInMinecraft.modid);
    }


    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.APPLE/*getItemFromBlock(EIMBlocks.dualCraftingTable)*/);
    }

    @Override
    public boolean hasSearchBar() {
        return false;
    }
}

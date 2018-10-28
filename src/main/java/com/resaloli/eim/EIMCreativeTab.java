package com.resaloli.eim;

import com.resaloli.eim.content.items.EIMItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class EIMCreativeTab extends CreativeTabs{

    public EIMCreativeTab() {
        super(ExtrasInMinecraft.modid);
    }


    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(EIMItems.ITEMS[1]);
    }

    @Override
    public boolean hasSearchBar() {
        return false;
    }
}

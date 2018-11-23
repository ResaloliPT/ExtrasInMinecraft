package com.resaloli.eim;

import com.resaloli.eim.content.items.EIMItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class EIMCreativeTab extends CreativeTabs {

    //CreativeTabs
    public static final EIMCreativeTab EIM_CREATIVE_TAB = new EIMCreativeTab();

    private EIMCreativeTab() {
        super(ExtrasInMinecraft.MOD_ID);
    }

    public ItemStack getTabIconItem() {
        return new ItemStack(EIMItems.superSword);
    }

    @Override
    public ItemStack createIcon() {
        ItemStack itemStack = new ItemStack(EIMItems.superSword);
        return itemStack;
    }

    @Override
    public boolean hasSearchBar() {
        return false;
    }
}

package com.resaloli.eim.content.items;

import com.resaloli.eim.EIMCreativeTab;
import com.resaloli.eim.ExtrasInMinecraft;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item  {
    private String name;

    ItemBase(String name){
        this.name = name;
        this.setRegistryName(new ResourceLocation(ExtrasInMinecraft.MOD_ID, name));
        this.setCreativeTab(EIMCreativeTab.EIM_CREATIVE_TAB);
        this.setTranslationKey(ExtrasInMinecraft.MOD_ID + ":" + name);
    }

    public String getUnlocalizedName()
    {
        return "item." + ExtrasInMinecraft.MOD_ID + ":" + this.name;
    }
}

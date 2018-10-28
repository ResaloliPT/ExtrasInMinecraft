package com.resaloli.eim.content.items;

import com.resaloli.eim.ExtrasInMinecraft;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item  {
    private String name;

    ItemBase(String name){
        this.name = name;
        this.setRegistryName(new ResourceLocation(ExtrasInMinecraft.modid, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(ExtrasInMinecraft.tabExtrasInMinecraft);
    }

    public String getUnlocalizedName()
    {
        return "item." + ExtrasInMinecraft.modid + ":" + this.name;
    }
}

package com.resaloli.eim.content.items;

import com.resaloli.eim.EIMCreativeTab;
import com.resaloli.eim.ExtrasInMinecraft;
import net.minecraft.item.Item;

public class ItemBase extends Item  {
    public ItemBase(String name){
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ExtrasInMinecraft.tabExtrasInMinecraft);
    }
}

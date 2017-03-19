package com.resaloli.eim.content.blocks;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.Interfaces.IItemModelProvider;
import com.resaloli.eim.content.items.ItemBase;
import com.resaloli.eim.proxies.ProxyClient;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockBase extends Block implements IItemModelProvider{
    protected String name;

    @Override
    public void registerItemBlockModel(Item itemBlock) {
        ProxyClient.registerRender(itemBlock, 0, name);
    }

    public BlockBase(Material material, String name){
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setCreativeTab(ExtrasInMinecraft.tabExtrasInMinecraft);
    }

    @Override
    public void registerItemModel(ItemBase itemBlock) {
    }
}

package com.resaloli.eim.content.blocks;

import com.resaloli.eim.ExtrasInMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block{
    protected String name;

    //@Override
    //public void registerItemBlockModel(Item itemBlock) {        ProxyClient.registerRender(itemBlock, 0, name);}

    public BlockBase(Material material, String name){
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setCreativeTab(ExtrasInMinecraft.tabExtrasInMinecraft);
    }
}

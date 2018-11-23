package com.resaloli.eim.content.blocks;

import com.resaloli.eim.EIMCreativeTab;
import com.resaloli.eim.ExtrasInMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public abstract class BlockBase extends Block {

    private String name;

    public BlockBase(Material materialIn, String name) {
        super(materialIn);
        this.name = name;
        this.setRegistryName(new ResourceLocation(ExtrasInMinecraft.MOD_ID, name));
        this.setCreativeTab(EIMCreativeTab.EIM_CREATIVE_TAB);
        this.setTranslationKey(ExtrasInMinecraft.MOD_ID + ":" + name);
    }
}
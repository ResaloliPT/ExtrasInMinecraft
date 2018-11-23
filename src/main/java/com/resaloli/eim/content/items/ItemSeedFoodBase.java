package com.resaloli.eim.content.items;

import com.resaloli.eim.EIMCreativeTab;
import com.resaloli.eim.ExtrasInMinecraft;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.util.ResourceLocation;

public class ItemSeedFoodBase extends ItemSeedFood {

    public ItemSeedFoodBase(String name, int heal, float saturation, Block crops, Block soil) {
        super(heal, saturation, crops, soil);
        this.setRegistryName(new ResourceLocation(ExtrasInMinecraft.MOD_ID, name));
        this.setCreativeTab(EIMCreativeTab.EIM_CREATIVE_TAB);
        this.setTranslationKey(ExtrasInMinecraft.MOD_ID + ":" + name);
    }
}

package com.resaloli.eim.content.crops;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.items.EIMItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class CropLettuce extends BlockCrops {
    protected CropLettuce(String name)
    {
        super.setRegistryName(new ResourceLocation(ExtrasInMinecraft.MOD_ID, name));
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)));
        this.setTickRandomly(true);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
        this.disableStats();
    }

    protected Item getSeed()
    {
        return EIMItems.lettuce;
    }

    protected Item getCrop()
    {
        return EIMItems.lettuce;
    }
}

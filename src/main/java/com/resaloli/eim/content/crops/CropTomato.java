package com.resaloli.eim.content.crops;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.items.EIMItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class CropTomato extends BlockCrops{
    protected CropTomato(String name)
    {
        super.setRegistryName(new ResourceLocation(ExtrasInMinecraft.modid, name));
        super.setUnlocalizedName(ExtrasInMinecraft.modid+":"+name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)));
        this.setTickRandomly(true);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
        this.disableStats();
    }

    protected Item getSeed()
    {
        return (Item)EIMItems.tomato;
    }

    protected Item getCrop()
    {
        return EIMItems.tomato;
    }
}

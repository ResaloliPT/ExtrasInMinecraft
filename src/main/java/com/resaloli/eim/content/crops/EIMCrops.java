package com.resaloli.eim.content.crops;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;

public class EIMCrops {
    public static CropTomato tomato = new CropTomato("crop_tomato");
    public static CropLettuce lettuce = new CropLettuce("crop_lettuce");

    public static final Block[] CROPS = {
            tomato,
            lettuce
    };


    public static Block[] getList() {
        return CROPS;
    }
}

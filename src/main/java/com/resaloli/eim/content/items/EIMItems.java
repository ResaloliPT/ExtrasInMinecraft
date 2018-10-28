package com.resaloli.eim.content.items;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.crops.EIMCrops;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

public class EIMItems {

    public static ItemBase debugItem = new ItemBase("item_debug");
    public static ItemSwordBase superSword = new ItemSwordBase("item_super_sword", Item.ToolMaterial.DIAMOND, 1000, 1000000.0F, 30);
    public static ItemFoodBase hamburger = new ItemFoodBase("item_food_hamburger", 20, 20.0F);
    public static ItemSeedFood tomato = (ItemSeedFood) (new ItemSeedFood(1, 1.0F, EIMCrops.tomato, Blocks.FARMLAND)).setUnlocalizedName(ExtrasInMinecraft.modid+":item_food_tomato").setRegistryName(new ResourceLocation(ExtrasInMinecraft.modid, "item_food_tomato")).setCreativeTab(ExtrasInMinecraft.tabExtrasInMinecraft);
    public static  ItemSeedFood lettuce = (ItemSeedFood)(new ItemSeedFood(1, 1.0F, EIMCrops.lettuce, Blocks.FARMLAND)).setUnlocalizedName(ExtrasInMinecraft.modid+":item_food_lettuce").setRegistryName(new ResourceLocation(ExtrasInMinecraft.modid, "item_food_lettuce")).setCreativeTab(ExtrasInMinecraft.tabExtrasInMinecraft);

    public static final Item[] ITEMS = {
            debugItem,
            superSword,
            hamburger,
            tomato,
            lettuce
    };

    public static Item[] getList() {
        return ITEMS;
    }
}
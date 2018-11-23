package com.resaloli.eim.content.items;

import com.resaloli.eim.content.crops.EIMCrops;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class EIMItems {

    public static ItemBase debugItem = new ItemBase("item_debug");

    public static ItemSwordBase superSword = new ItemSwordBase("item_super_sword", Item.ToolMaterial.DIAMOND, 1000, 1000000.0F, 30);

    public static ItemFoodBase hamburger = new ItemFoodBase("item_food_hamburger", 20, 20.0F);
    public static ItemSeedFoodBase tomato = new ItemSeedFoodBase("item_food_tomato", 1, 1.0F, EIMCrops.tomato, Blocks.FARMLAND);
    public static ItemSeedFoodBase lettuce = new ItemSeedFoodBase("item_food_lettuce", 1, 1.0F, EIMCrops.lettuce, Blocks.FARMLAND);

    private static final Item[] ITEMS = {
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
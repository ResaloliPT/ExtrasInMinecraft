package com.resaloli.eim.content.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.resaloli.eim.ExtrasInMinecraft.modid;

public class EIMItems {

    public static Item debugItem;
    public static Item superSwordItem;

    public static void init() {
        debugItem = new ItemBase("debugItem");
        superSwordItem = new ItemBase("superSwordItem");
    }

    public static void register() {
        registerItem(debugItem);
        registerItem(superSwordItem);
    }

    public static void registerRenders() {
        registerRenderItem(debugItem, 0);
        registerRenderItem(superSwordItem, 0);
    }

    public static void registerItem(Item item) {
        GameRegistry.register(item);
        System.out.println("Register Item: " + item.getRegistryName());
    }

    public static void registerRenderItem(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(modid, item.getUnlocalizedName().substring(5)), "inventory"));
        System.out.println("Register Render: " + item.getRegistryName());
    }
}

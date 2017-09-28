package com.resaloli.eim.content.items;

import com.resaloli.eim.ExtrasInMinecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EIMItems {

    public static ItemBase debugItem = new ItemBase("item_debug");
    public static ItemSwordBase superSword = new ItemSwordBase("item_super_sword", Item.ToolMaterial.DIAMOND, 1000, 10.0F, 30);


    public static final Item[] ITEMS = {
            debugItem,
            superSword
    };

    public static void init(){

    }

    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(ITEMS);
    }

    @SideOnly(Side.CLIENT)
    public static void initClient(ItemModelMesher mesher){
        for (Item item: ITEMS) {
            ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.registerItemVariants(item, model);
            mesher.register(item, 0, model);
        }
    }
}
package com.resaloli.eim;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class Utils {
    public static void initClient(ItemModelMesher mesher, Block[] BlockList){
        for (Block block: BlockList) {
            Item item = Item.getItemFromBlock(block);
            ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
            ModelLoader.registerItemVariants(item, model);
            mesher.register(item, 0, model);
        }
    }

    public static void initClient(ItemModelMesher mesher, Item[] ItemList){
        for (Item item: ItemList) {
            ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.registerItemVariants(item, model);
            mesher.register(item, 0, model);
        }
    }


    public static void registerItemBlocks(RegistryEvent.Register<Item> event, Block[] blockList){
        for (Block block : blockList) {
            Item itemBlock = new ItemBlock(block).setRegistryName(block.getRegistryName());
            event.getRegistry().register(itemBlock);
        }
    }

    public static void registerItems(RegistryEvent.Register<Item> event, Item[] itemList){
        event.getRegistry().registerAll((Item[]) itemList);
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event, Block[] blockList){
        event.getRegistry().registerAll(blockList);
    }

    public static void registerPotions(RegistryEvent.Register<Potion> event, Potion[] blockList){
        event.getRegistry().registerAll(blockList);
    }
}

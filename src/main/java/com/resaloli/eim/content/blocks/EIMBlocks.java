package com.resaloli.eim.content.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EIMBlocks {

    public static BlockDCT dualCraftingTable = new BlockDCT(Material.WOOD, "block_dual_crafting_table");

    public static final Block[] BLOCKS = {
            dualCraftingTable
    };

    public static void registerItemBlocks(RegistryEvent.Register<Item> event){
        System.out.print("Register Item");
        for (Block block: BLOCKS) {
            Item itemBlock = new ItemBlock(block).setRegistryName(block.getRegistryName());
            event.getRegistry().register(itemBlock);
        }
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(BLOCKS);
    }


    @SideOnly(Side.CLIENT)
    public static void initClient(ItemModelMesher mesher){
        for (Block block: BLOCKS) {
            Item item = Item.getItemFromBlock(block);
            ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
            ModelLoader.registerItemVariants(item, model);
            mesher.register(item, 0, model);
        }
    }
}
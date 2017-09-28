package com.resaloli.eim.handlers;

import com.resaloli.eim.content.blocks.EIMBlocks;
import com.resaloli.eim.content.items.EIMItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        System.out.println("Register Items.");
        EIMItems.registerItems(event);
        EIMBlocks.registerItemBlocks(event);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        System.out.println("Register Blocks.");
        EIMBlocks.registerBlocks(event);
    }
}

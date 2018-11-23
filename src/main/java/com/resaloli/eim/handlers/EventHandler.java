package com.resaloli.eim.handlers;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.ModularContent.Energy.Blocks.EIMEnerBlocks;
import com.resaloli.eim.ModularContent.Energy.TileEntities.TileEntityGenerator;
import com.resaloli.eim.Utils;
import com.resaloli.eim.content.blocks.EIMBlocks;
import com.resaloli.eim.content.crops.EIMCrops;
import com.resaloli.eim.content.items.EIMItems;
import com.resaloli.eim.content.potions.EIMPotions;
import com.resaloli.eim.content.tileentity.TileEntityDCT;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class EventHandler {

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        System.out.println("Register Items.");

        ///Core
        Utils.registerItems(event, EIMItems.getList());
        Utils.registerItemBlocks(event, EIMBlocks.getList());


        ///Modules
        //Energy
        Utils.registerItemBlocks(event, EIMEnerBlocks.getList());
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        System.out.println("Register Blocks.");

        ///Core
        Utils.registerBlocks(event, EIMBlocks.getList());
        Utils.registerBlocks(event, EIMCrops.getList());

        ///Modules
        //Energy
        Utils.registerBlocks(event, EIMEnerBlocks.getList());


        /// Register TileEntities ///
        //Core
        GameRegistry.registerTileEntity(TileEntityDCT.class, new ResourceLocation(ExtrasInMinecraft.MOD_ID, "TileEntityDCT"));


        ///Modules
        //Energy
        GameRegistry.registerTileEntity(TileEntityGenerator.class, new ResourceLocation(ExtrasInMinecraft.MOD_ID, "TileEntityGenerator"));
    }

    @SubscribeEvent
    public void registerPotions(RegistryEvent.Register<Potion> event) {
        System.out.println("Register Potions.");

        Utils.registerPotions(event, EIMPotions.getList());
    }

    @SubscribeEvent
    public void  onEntityUpdate(LivingEvent.LivingUpdateEvent event){
        if (event.getEntityLiving().isPotionActive(EIMPotions.wellFed)){
            if(event.getEntityLiving().getActivePotionEffect(EIMPotions.wellFed).getDuration() == 0){
                event.getEntityLiving().removePotionEffect(EIMPotions.wellFed);
                return;
            }else if(event.getEntityLiving().world.rand.nextInt(30) == 0){
                event.getEntityLiving().heal(2.0F);
            }
        }
    }
}

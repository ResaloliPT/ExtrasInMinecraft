package com.resaloli.eim.proxies;

import com.resaloli.eim.ModularContent.Energy.Blocks.EIMEnerBlocks;
import com.resaloli.eim.content.blocks.EIMBlocks;
import com.resaloli.eim.content.crops.EIMCrops;
import com.resaloli.eim.content.items.EIMItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.resaloli.eim.Utils.initClient;


public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

        ///Core
        initClient(mesher, EIMItems.getList());
        initClient(mesher, EIMBlocks.getList());
        initClient(mesher, EIMCrops.getList());

        ///Modules
        //Energy
        initClient(mesher, EIMEnerBlocks.getList());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}

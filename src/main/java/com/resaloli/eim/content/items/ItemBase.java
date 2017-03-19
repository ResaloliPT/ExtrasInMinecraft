package com.resaloli.eim.content.items;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.Interfaces.IItemModelProvider;
import com.resaloli.eim.proxies.ProxyClient;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemBase extends Item implements IItemModelProvider {

    protected String name;

    @Override
    public void registerItemBlockModel(Item item) {}

    public ItemBase(String name){
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(ExtrasInMinecraft.tabExtrasInMinecraft);
        registerItemModel(this);
        registerITem(this);
    }

    public static void registerITem(ItemBase item){
        GameRegistry.register(item);
    }

    @Override
    public void registerItemModel(ItemBase item) {
        ProxyClient.registerRender(item, 0, name);
    }

}

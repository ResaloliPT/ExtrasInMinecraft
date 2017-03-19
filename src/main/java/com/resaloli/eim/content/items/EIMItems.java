package com.resaloli.eim.content.items;

import net.minecraftforge.fml.common.registry.GameRegistry;
import com.resaloli.eim.proxies.ProxyClient;

public class EIMItems {

    public static ItemBase debugItem;

    public static void init(){
        debugItem = new ItemBase("debugItem");
    }
}
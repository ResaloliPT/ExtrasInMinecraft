package com.resaloli.eim.Interfaces;

import com.resaloli.eim.content.items.ItemBase;
import net.minecraft.item.Item;

public interface IItemModelProvider {
    void registerItemModel(ItemBase item);
    void registerItemBlockModel(Item item);
}

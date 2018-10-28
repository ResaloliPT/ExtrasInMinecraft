package com.resaloli.eim.content.inventory;

import com.resaloli.eim.content.te.TileEntityDCT;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraftforge.items.IItemHandler;


public class DCTSlot extends Slot {
    public DCTSlot (InventoryCrafting inv, int index , int x, int y, TileEntityDCT te) {
        super(inv, index , x, y);
        IItemHandler handler;
    }
}

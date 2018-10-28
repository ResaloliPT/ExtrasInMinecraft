package com.resaloli.eim.ModularContent.Energy.Inventory;

import cofh.redstoneflux.api.IEnergyContainerItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotElectric extends SlotItemHandler {
    private IItemHandler itemHandler;
    private int index;

    public SlotElectric(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
        this.itemHandler = itemHandler;
        this.index = index;
    }

    public boolean isItemValid(ItemStack stack) {
        //TODO: Check what is canonical to place here
        if ((stack.getItem() instanceof IEnergyStorage) || (stack.getItem() instanceof IEnergyContainerItem) && index == 0)
            return true;
        return false;
    }

    public int getItemStackLimit(ItemStack stack) {
        //Allow only one item at a time
        return 1;
    }
}

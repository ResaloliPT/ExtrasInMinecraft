package com.resaloli.eim.ModularContent.Energy.Inventory;

import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;


public class SlotGeneratorFuel extends SlotItemHandler {

    public SlotGeneratorFuel(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    public boolean isItemValid(ItemStack stack) {
        return TileEntityFurnace.isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack);
    }

    public int getItemStackLimit(ItemStack stack) {
        return SlotFurnaceFuel.isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }
}

package com.resaloli.eim.content.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class DCTCrafting extends Slot
{

	public DCTCrafting(IInventory inventory, int index, int x,int y)
	{
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemStack)
	{
		return true;
	}

}
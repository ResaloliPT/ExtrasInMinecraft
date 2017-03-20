package com.resaloli.eim.content.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class DCTSlot extends Slot
{
	private final IInventory tileEntity;
	private EntityPlayer thePlayer;
	private  int amountCrafted;

	public DCTSlot (EntityPlayer player, IInventory iInventory, IInventory inventory, int index, int x, int y)
	{
		super(inventory, index, x, y);
		this.tileEntity = iInventory;
		this.thePlayer = player;
	}
	
	@Override
	public boolean isItemValid(ItemStack itemStack)
	{
		return false;
	}
	
	@Override
	public boolean canTakeStack(EntityPlayer player)
	{
		return true;
	}
	
	@Override
	public ItemStack decrStackSize(int amount)
    {
        if (this.getHasStack())
        {
            this.amountCrafted += Math.min(amount, this.getStack().getCount());
        }

        return super.decrStackSize(amount);
    }

    protected void onCrafting(ItemStack itemStack, int amount)
    {
        this.amountCrafted += amount;
        this.onCrafting(itemStack);
    }

}
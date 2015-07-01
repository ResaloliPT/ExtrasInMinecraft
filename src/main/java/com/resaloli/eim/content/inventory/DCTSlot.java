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
            this.amountCrafted += Math.min(amount, this.getStack().stackSize);
        }

        return super.decrStackSize(amount);
    }

    protected void onCrafting(ItemStack itemStack, int amount)
    {
        this.amountCrafted += amount;
        this.onCrafting(itemStack);
    }

    protected void onCrafting(ItemStack itemStack)
    {
        itemStack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.amountCrafted);
        this.amountCrafted = 0;

        if (itemStack.getItem() == Item.getItemFromBlock(Blocks.crafting_table))
        {
            this.thePlayer.addStat(AchievementList.buildWorkBench, 1);
        }

        if (itemStack.getItem() instanceof ItemPickaxe)
        {
            this.thePlayer.addStat(AchievementList.buildPickaxe, 1);
        }

        if (itemStack.getItem() == Item.getItemFromBlock(Blocks.furnace))
        {
            this.thePlayer.addStat(AchievementList.buildFurnace, 1);
        }

        if (itemStack.getItem() instanceof ItemHoe)
        {
            this.thePlayer.addStat(AchievementList.buildHoe, 1);
        }

        if (itemStack.getItem() == Items.bread)
        {
            this.thePlayer.addStat(AchievementList.makeBread, 1);
        }

        if (itemStack.getItem() == Items.cake)
        {
            this.thePlayer.addStat(AchievementList.bakeCake, 1);
        }

        if (itemStack.getItem() instanceof ItemSword)
        {
            this.thePlayer.addStat(AchievementList.buildSword, 1);
        }

        if (itemStack.getItem() == Item.getItemFromBlock(Blocks.enchanting_table))
        {
            this.thePlayer.addStat(AchievementList.enchantments, 1);
        }

        if (itemStack.getItem() == Item.getItemFromBlock(Blocks.bookshelf))
        {
            this.thePlayer.addStat(AchievementList.bookcase, 1);
        }
    }

    @Override
    public void onPickupFromSlot(EntityPlayer player, ItemStack itemStack)
    {
        FMLCommonHandler.instance().firePlayerCraftingEvent(player, itemStack, tileEntity);
        this.onCrafting(itemStack);

        for (int i = 0; i < this.tileEntity.getSizeInventory(); ++i)
        {
            ItemStack itemstack1 = this.tileEntity.getStackInSlot(i);

            if (itemstack1 != null)
            {
                this.tileEntity.decrStackSize(i, 1);

                if (itemstack1.getItem().hasContainerItem(itemstack1))
                {
                    ItemStack itemstack2 = itemstack1.getItem().getContainerItem(itemstack1);

                    if (itemstack2 != null && itemstack2.isItemStackDamageable() && itemstack2.getItemDamage() > itemstack2.getMaxDamage())
                    {
                        MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(thePlayer, itemstack2));
                        continue;
                    }

                    if (!itemstack1.getItem().hasContainerItem(itemstack1) || !this.thePlayer.inventory.addItemStackToInventory(itemstack2))
                    {
                        if (this.tileEntity.getStackInSlot(i) == null)
                        {
                            this.tileEntity.setInventorySlotContents(i, itemstack2);
                        }
                        else
                        {
                            this.thePlayer.dropPlayerItemWithRandomChoice(itemstack2, false);
                        }
                    }
                }
            }
        }
    }
}
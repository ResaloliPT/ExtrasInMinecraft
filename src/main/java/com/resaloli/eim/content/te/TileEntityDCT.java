package com.resaloli.eim.content.te;

import com.resaloli.eim.content.container.ContainerDCT;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityLockable;


public class TileEntityDCT extends TileEntityLockable implements IInventory
{
	public ItemStack[] inventory = new ItemStack[25];
	public TileEntityDCT() {}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
		readFromNBT(packet.getNbtCompound());
	}

	@Override
    public int getSizeInventory()
    {
        return this.inventory.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

	@Override
    public ItemStack getStackInSlot(int slotIn)
    {
        return inventory[slotIn];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        ItemStack stackInSlot = inventory[index];
        ItemStack stackRemoved;

        if (stackInSlot == null)
            return null;
        /* .func_190916_E() = getCount()*/
        if (stackInSlot.getCount() <= count) {
            stackRemoved = stackInSlot;
            setInventorySlotContents(index, null);
        } else {
            stackRemoved = stackInSlot.splitStack(count);
            if (stackInSlot.getCount() == 0)
                setInventorySlotContents(index, ItemStack.EMPTY);
        }
        markDirty();
        return stackRemoved;
    }

    /**
     * Removes a stack from the given slot and returns it.
     *
     * @param index
     */
    @Override
    public ItemStack removeStackFromSlot(int index) {
        return null;
    }

	@Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory[i] = itemstack;
		if (itemstack != null && itemstack.getCount() > getInventoryStackLimit()) {
		    itemstack.setCount(getInventoryStackLimit());
		}
	}

	@Override
    public String getName()
    {
    	return "Dual.Crafting.Table";
    }

	@Override
    public boolean hasCustomName()
    {
    	return false;
    }
    
    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer playerIn)
    {
        return this.world.getTileEntity(this.pos) != this ? false : playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer playerIn) {
    	//not bein called
    	System.out.println("Open");
    }

    @Override
    public void closeInventory(EntityPlayer playerIn) {
    	//not bein called
    	System.out.println("Close");
    }

    
    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        return true;
    }


    @Override
    public String getGuiID()
    {
        return "0";
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
    	return new ContainerDCT(playerInventory, this);
    }

    public int getField(int id)
    {
		return 0;
    }

    public void setField(int id, int value)
    {
    }

    public int getFieldCount()
    {
        return 0;
    }

    @Override
    public void clear()
    {
        for (int var1 = 0; var1 < this.inventory.length; ++var1)
        {
            this.inventory[var1] = null;
        }
    }

	
}
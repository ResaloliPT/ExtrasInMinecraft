package com.resaloli.eim.content.te;

import com.resaloli.eim.content.container.ContainerDCT;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;


public class TileEntityDCT extends TileEntityLockable implements IInventory
{

	public ItemStack[] inventory = new ItemStack[26];
	

	@Override
    public int getSizeInventory()
    {
        return this.inventory.length;
    }

	@Override
    public ItemStack getStackInSlot(int slotIn)
    {
        return this.inventory[slotIn];
    }

	@Override
    public ItemStack decrStackSize(int index, int count)
    {
        if (this.inventory[index] != null)
        {
            ItemStack var3;

            if (this.inventory[index].stackSize <= count)
            {
                var3 = this.inventory[index];
                this.inventory[index] = null;
                return var3;
            }
            else
            {
                var3 = this.inventory[index].splitStack(count);

                if (this.inventory[index].stackSize == 0)
                {
                    this.inventory[index] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }

	@Override
    public ItemStack getStackInSlotOnClosing(int index)
    {
        if (this.inventory[index] != null)
        {
            ItemStack var2 = inventory[index];
            this.inventory[index] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

	@Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
		markDirty();
	}

	@Override
    public String getName()
    {
    	return "Dual Crafting Table";
    }

	@Override
    public boolean hasCustomName()
    {
    	return true;
    }

    @Override
	public Packet getDescriptionPacket() {
	    NBTTagCompound tag = new NBTTagCompound();
	    writeToNBT(tag);
	    return new S35PacketUpdateTileEntity(pos, 0, tag);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
	    readFromNBT(pkt.getNbtCompound());
	}
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        NBTTagList list = compound.getTagList("ItemsDCTSlots", 10);
        this.inventory = new ItemStack[this.getSizeInventory()];
        for (int var3 = 0; var3 < list.tagCount(); ++var3){
            NBTTagCompound var4 = list.getCompoundTagAt(var3);
            byte var5 = var4.getByte("SlotDCT");
            if (var5 >= 0 && var5 < this.inventory.length)
            {
                this.inventory[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        NBTTagList var2 = new NBTTagList();
        for (int var3 = 0; var3 < this.inventory.length; ++var3)
        {
            if (this.inventory[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("SlotDCT", (byte)var3);
                this.inventory[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        compound.setTag("ItemsDCTSlots", var2);
    }
    
    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }
    

    public static boolean func_174903_a(IInventory p_174903_0_)
    {
        return p_174903_0_.getField(0) > 0;
    }

    public void updateEntity(){
    	this.markDirty();
    }

    public int func_174904_a(ItemStack p_174904_1_)
    {
        return 200;
    }

    
    @Override
    public boolean isUseableByPlayer(EntityPlayer playerIn)
    {
        return this.worldObj.getTileEntity(this.pos) != this ? false : playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer playerIn) {}

    @Override
    public void closeInventory(EntityPlayer playerIn) {}

    
    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        return true;
    }

    public boolean canInsertItem(int slotIn, ItemStack itemStackIn, EnumFacing direction)
    {
        return this.isItemValidForSlot(slotIn, itemStackIn);
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

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
import net.minecraftforge.common.util.Constants;


public class TileEntityDCT extends TileEntityLockable implements IInventory
{

	
	
	public ItemStack[] inventory = new ItemStack[25];
	public TileEntityDCT() {}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(pos, 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.getNbtCompound());
	}
	
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
        NBTTagList tagList = par1NBTTagCompound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
        for (int i = 0; i < tagList.tagCount(); i++) 
          {
                NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
                byte slot = tag.getByte("Slot");                                                 
                if (slot >= 0 && slot < inventory.length)   
                  {
                	inventory[slot] = ItemStack.loadItemStackFromNBT(tag); 
                  }                                                                                                
          }
	}

	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
		NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < inventory.length; i++)                             
          {
                ItemStack stack = inventory[i]; 
                if (stack != null)                                                                      
                  {
                        NBTTagCompound tag = new NBTTagCompound();  
                        tag.setByte("Slot", (byte) i);                   
                        stack.writeToNBT(tag);  
                        itemList.appendTag(tag);
                  }
          }
        par1NBTTagCompound.setTag("Inventory", itemList);   
        markDirty();
	}

	@Override
    public int getSizeInventory()
    {
        return this.inventory.length;
    }
	
	public void updateTE(){
		getDescriptionPacket();
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
    

    public static boolean func_174903_a(IInventory p_174903_0_)
    {
        return p_174903_0_.getField(0) > 0;
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
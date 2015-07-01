package com.resaloli.eim.content.container;

import com.resaloli.eim.content.blocks.EIMBlocks;
import com.resaloli.eim.content.crafting.CraftingManagerDCT;
import com.resaloli.eim.content.slot.DCTCrafting;
import com.resaloli.eim.content.slot.DCTSlot;
import com.resaloli.eim.content.te.TileEntityDCT;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ContainerDCT extends Container{

	//Vars
    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    public World worldObj;
    public BlockPos pos;
    public InventoryPlayer invPlayer;
    
    //Contructer
    public ContainerDCT(InventoryPlayer playerInventory, TileEntityDCT tileEntity) {
    	 craftMatrix = new InventoryCrafting(this, 5, 5);
         craftResult = new InventoryCraftResult();
         worldObj = tileEntity.getWorld();
         pos = tileEntity.getPos();
         invPlayer = playerInventory;
         //output
         this.addSlotToContainer(new DCTSlot(playerInventory.player, craftMatrix, craftResult, 0, 123, 68));
         //craftingGrid
         for(int j = 0; j < 5; j++)
         {
             for(int i = 0; i < 5; i++)
             {
             	this.addSlotToContainer(new DCTCrafting(craftMatrix, i + j * 5, 8+i*18, 7+j*18));
             }

         }
         
         //playerInventory
         for(int j = 0; j < 3; j++)
         {
             for(int i = 0; i < 9; i++)
             {
             	this.addSlotToContainer(new Slot(playerInventory, 9+i+j*9, 8+i*18, 101+j*18));
             }

         }

         //playerHotbar
         for(int i = 0; i < 9; i++)
         {
         	this.addSlotToContainer(new Slot(playerInventory, i, 8+i*18, 159));
         }

         onCraftMatrixChanged(craftMatrix);
	}

    @Override
	public void onCraftMatrixChanged(IInventory iinventory)
    {
        craftResult.setInventorySlotContents(0, CraftingManagerDCT.getInstance().findMatchingRecipe(craftMatrix, worldObj));
        markBlockForUpdate();
    }
	
    public void markBlockForUpdate() {
    	worldObj.markBlockForUpdate(pos);
	}

	@Override
    public void onContainerClosed(EntityPlayer entityplayer)
    {
        super.onContainerClosed(entityplayer);
    }

	@Override
    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return this.worldObj.getBlockState(this.pos).getBlock() != EIMBlocks.dualCraftingTable ? false : invPlayer.player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
	 public ItemStack transferStackInSlot(EntityPlayer player, int index)
  {
      ItemStack itemstack = null;
      Slot slot = (Slot)this.inventorySlots.get(index);

      if (slot != null && slot.getHasStack())
      {
          ItemStack itemstack1 = slot.getStack();
          itemstack = itemstack1.copy();

          if (index == 0)
          {
              if (!this.mergeItemStack(itemstack1, 26, 62, true))
              {
                  return null;
              }

              slot.onSlotChange(itemstack1, itemstack);
          }
          else if (index >= 1 && index < 26)
          {
              if (!this.mergeItemStack(itemstack1, 26, 62, false))
              {
                  return null;
              }
          }
          else if (index >= 26 && index < 53)
          {
              if (!this.mergeItemStack(itemstack1, 53, 62, false))
              {
                  return null;
              }
          }
          else if (!this.mergeItemStack(itemstack1, 26, 53, false))
          {
              return null;
          }

          if (itemstack1.stackSize == 0)
          {
              slot.putStack((ItemStack)null);
          }
          else
          {
              slot.onSlotChanged();
          }

          if (itemstack1.stackSize == itemstack.stackSize)
          {
              return null;
          }

          slot.onPickupFromSlot(player, itemstack1);
      }

      return itemstack;
  }
}
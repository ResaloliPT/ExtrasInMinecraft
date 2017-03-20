package com.resaloli.eim.content.container;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.resaloli.eim.content.blocks.EIMBlocks;
import com.resaloli.eim.content.crafting.CraftingManagerDCT;
import com.resaloli.eim.content.inventory.DCTCrafting;
import com.resaloli.eim.content.inventory.DCTSlot;
import com.resaloli.eim.content.te.TileEntityDCT;

public class ContainerDCT extends Container{

	//Vars
	public ItemStack[] inventory = new ItemStack[25];
    public InventoryCrafting craftMatrix;
    public IInventory craftResult;
    public World worldObj;
    public BlockPos pos;
    public InventoryPlayer invPlayer;
    public TileEntityDCT tileEntity = new TileEntityDCT();
    
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

    public ContainerDCT() {}

	@Override
	public void onCraftMatrixChanged(IInventory iinventory)
    {
        craftResult.setInventorySlotContents(0, CraftingManagerDCT.getInstance().findMatchingRecipe(craftMatrix, worldObj));
    }

	public void getInventoryItemStacks() {
		for(int i = 0; i < 25; i++){
			if(craftMatrix.getStackInSlot(i) != null){
				inventory[i] = craftMatrix.getStackInSlot(i);
			}
		}
		tileEntity.inventory.equals(inventory);
		
	}
	
	@Override
    public void onContainerClosed(EntityPlayer entityplayer)
    {
    }

	@Override
    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return false; //this.worldObj.getBlockState(this.pos).getBlock() != EIMBlocks.dualCraftingTable ? false : invPlayer.player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
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

          if (itemstack1.getCount() == 0)
          {
              slot.putStack(ItemStack.EMPTY);
          }
          else
          {
              slot.onSlotChanged();
          }

          if (itemstack1.getCount() == itemstack.getCount())
          {
              return null;
          }

          slot.onTake(player, itemstack1);
      }

      return itemstack;
  }
}
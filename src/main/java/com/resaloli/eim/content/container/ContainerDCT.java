package com.resaloli.eim.content.container;

import com.resaloli.eim.content.blocks.EIMBlocks;
import com.resaloli.eim.content.crafting.CraftingManagerDCT;
import com.resaloli.eim.content.crafting.DCTCrafting;
import com.resaloli.eim.content.crafting.InventoryCraftingResult;
import com.resaloli.eim.content.inventory.DCTSlotCrafting;
import com.resaloli.eim.content.tileentity.TileEntityDCT;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.network.play.server.SPacketSetSlot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerDCT extends Container
{
    /** The crafting matrix inventory (5x5). */
    private DCTCrafting craftMatrix;
    private InventoryCraftingResult craftResult;
    private final World world;
    /** Position of the workbench */
    private final BlockPos pos;
    private final EntityPlayer player;
    private TileEntityDCT te;
    private IItemHandler handler;

    public ContainerDCT(InventoryPlayer playerInventory, World worldIn, BlockPos posIn)
    {
        this.world = worldIn;
        this.pos = posIn;
        this.player = playerInventory.player;
        this.te = (TileEntityDCT)worldIn.getTileEntity(posIn);
        this.handler = te.getHandler();
        this.craftMatrix = new DCTCrafting(this, 5, 5);
        this.craftMatrix.openInventory(playerInventory.player);
        this.craftResult = new InventoryCraftingResult();


        this.addSlotToContainer(new DCTSlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 25, 123, 68));

        for (int i = 0; i < craftMatrix.getHeight(); ++i)
        {
            for (int j = 0; j < craftMatrix.getWidth(); ++j)
            {
                this.addSlotToContainer(new SlotItemHandler(this.handler, j + i * 5, 8 + j * 18, 7 + i * 18));
            }
        }

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 101 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 159));
        }
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        if (!this.world.isRemote)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)this.player;
            ItemStack itemstack = ItemStack.EMPTY;
            IRecipe irecipe = CraftingManagerDCT.findMatchingRecipes(this.craftMatrix, this.world);

            if (irecipe != null && (irecipe.isDynamic() || !this.world.getGameRules().getBoolean("doLimitedCrafting") || entityplayermp.getRecipeBook().isUnlocked(irecipe)))
            {
                this.craftResult.setRecipeUsed(irecipe);
                itemstack = irecipe.getCraftingResult(this.craftMatrix);
            }

            this.craftResult.setInventorySlotContents(0, itemstack);
            entityplayermp.connection.sendPacket(new SPacketSetSlot(this.windowId, 0, itemstack));
        }
        detectAndSendChanges();
    }

    /**
     * Called when the container is closed.
     */
    @Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        this.craftMatrix.closeInventory(playerIn);
        for (int i = 0; i < this.handler.getSlots(); i++){
            this.handler.insertItem(i, this.craftMatrix.getStackInSlot(i), false);
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        if (this.world.getBlockState(this.pos).getBlock() != EIMBlocks.dualCraftingTable)
        {
            return false;
        }
        else
        {
            return playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 0)
            {
                itemstack1.getItem().onCreated(itemstack1, this.world, playerIn);

                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index >= 10 && index < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (index >= 37 && index < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            ItemStack itemstack2 = slot.onTake(playerIn, itemstack1);

            if (index == 0)
            {
                playerIn.dropItem(itemstack2, false);
            }
        }

        return itemstack;
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     */
    @Override
    public boolean canMergeSlot(ItemStack stack, Slot slotIn)
    {
        return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
    }

}
package com.resaloli.eim.ModularContent.Energy.Container;

import com.resaloli.eim.ModularContent.Energy.Inventory.SlotElectric;
import com.resaloli.eim.ModularContent.Energy.Inventory.SlotGeneratorFuel;
import com.resaloli.eim.ModularContent.Energy.TileEntities.TileEntityGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerGenerator extends Container {

    private static TileEntityGenerator te;
    private final World world;
    private final BlockPos pos;
    private final EntityPlayer player;
    private static int burnTime;
    private static int currentItemBurnTime;


    public ContainerGenerator(InventoryPlayer playerInventory, World worldIn, BlockPos posIn){
        this.world = worldIn;
        this.player = playerInventory.player;
        this.pos = posIn;
        te = (TileEntityGenerator) worldIn.getTileEntity(posIn);

        //Rechargeable slot
        this.addSlotToContainer(new SlotElectric(te.getItemHandler(), 0, 56, 17));

        //Fuel Slot
        this.addSlotToContainer(new SlotGeneratorFuel(te.getItemHandler(),1, 56, 53));

        //Player Inventory
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }

    public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, te);
    }

    public boolean canInteractWith(EntityPlayer playerIn)
    {
            return playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();


        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icontainerlistener = this.listeners.get(i);

            if (burnTime != te.getField(1))
            {
                icontainerlistener.sendWindowProperty(this, 1, te.getField(1));
            }

            if (currentItemBurnTime != te.getField(2))
            {
                icontainerlistener.sendWindowProperty(this, 2, te.getField(2));
            }
        }

        burnTime = te.getField(1);
        currentItemBurnTime = te.getField(2);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        te.setField(id, data);
    }

    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 1 && index != 0)
            {
                if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 3 && index < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
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

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }
}

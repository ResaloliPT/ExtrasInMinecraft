package com.resaloli.eim.ModularContent.Energy.TileEntities;

import com.resaloli.eim.ModConfigs;
import com.resaloli.eim.ModularContent.Energy.Blocks.BlockGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;

public class TileEntityGenerator extends TileEntityEnergyBase implements ISidedInventory, ITickable {

    public static IItemHandler handler;
    private static String CustomName = "EIM_Generator";
    private static boolean isBurning = false;
    private static int currBurnTime;
    private static int burnTime;
    private static int energyPerTick;
    private static int maxBurnTime;

    public TileEntityGenerator(int energyPerTick)
    {
        super(10000, 0, 1024, 0);
        handler = getItemHandler();
        TileEntityGenerator.energyPerTick = energyPerTick;
    }

    public TileEntityGenerator(){
        //Hardcoded for now
        this(ModConfigs.GeneratorEnergyPerTick);
    }


    // General Tile Entity Related //

    public void update()
    {
        if (this.world != null){
            /*System.out.println("Generator isBurning: "+this.isBurning);
            System.out.println("Generator burnTime: "+this.burnTime);
            System.out.println("Generator currBurnTime: "+this.currBurnTime);*/
            if (this.world.isRemote){
                if (isBurning)
                {

                    //BurnFuel
                    --burnTime;
                    currBurnTime = maxBurnTime - burnTime;
                    if (burnTime == 0) {
                        isBurning = false;
                        burnTime = 0;
                        maxBurnTime = 0;
                        currBurnTime = 0;

                        this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).withProperty(BlockGenerator.ACTIVATED, false), 2);
                    }

                    //Gen Power
                    int extract = getEnergyStored();
                    extractEnergy(extract, false);
                    if (getMaxEnergyStored() - getEnergyStored() > energyPerTick) {
                        produceEnergy(energyPerTick);
                        this.markDirty();
                        this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).withProperty(BlockGenerator.ACTIVATED, true), 2);
                        isBurning = true;
                    } else {
                        produceEnergy(getMaxEnergyStored() - getEnergyStored());
                        this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).withProperty(BlockGenerator.ACTIVATED, false), 2);
                        isBurning = false;
                    }
                }
            }

            if (!isBurning && !(this.getMaxEnergyStored() == this.getEnergyStored())) {
                ItemStack iStack = handler.getStackInSlot(1);
                if (iStack.getCount() > 0 && !(iStack.equals(ItemStack.EMPTY))){
                    int itemBurnTime = TileEntityFurnace.getItemBurnTime(iStack);
                    //TODO: Add Augment to also change the energyPerTick relating to burnTime( the more burn time the lower the TickRate, and the less burn time the more tickrate)

                    this.decrStackSize(1, 1);

                    //Default Generator Doubles burntime
                    burnTime = itemBurnTime * 2;
                    maxBurnTime = burnTime * 2;
                    isBurning = true;
                }
            }
        }
    }



    public int getField(int id) {
       switch (id){
           case 0:
               return isBurning ? 1 : 0;
           case 1:
               return burnTime;
           case 2:
               return currBurnTime;
           default:
               return 404;
       }
    }

    public void setField(int id, int value) {
        switch (id){
            case 0:
                isBurning = value == 0;
            case 1:
                burnTime = value;
            case 2:
                currBurnTime = value;
        }
    }

    public int getBurnTimeRemainingScaled(int pixels){
        if (maxBurnTime == 0 || currBurnTime == 0 || isBurning == false)
            return 0;
        return (int) Math.ceil(((double) currBurnTime * pixels) / (double) maxBurnTime);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        isBurning = nbt.getBoolean("isBurning");
        burnTime = nbt.getInteger("burnTime");
        maxBurnTime = nbt.getInteger("maxBurnTime");
        currBurnTime = nbt.getInteger("currBurnTime");
        super.readFromNBT(nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        nbt.setBoolean("isBurning", isBurning);
        nbt.setInteger("burnTime", burnTime);
        nbt.setInteger("maxBurnTime", maxBurnTime);
        nbt.setInteger("currBurnTime", currBurnTime);
        return super.writeToNBT(nbt);
    }



    // ISidedInventory Related //

    public int[] getSlotsForFace(EnumFacing side) {
        return new int[0];
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side.
     *
     * @param index
     * @param itemStackIn
     * @param direction
     */
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        if ((TileEntityFurnace.isItemFuel(itemStackIn) || SlotFurnaceFuel.isBucket(itemStackIn)) && index == 1)
            return true;
        return (itemStackIn.getItem() instanceof IEnergyStorage) /*|| (itemStackIn.getItem() instanceof IEnergyContainerItem)*/ && index == 0;

    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side.
     *
     * @param index
     * @param stack
     * @param direction
     */
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return false;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory() {
        return handler.getSlots();
    }

    public boolean isEmpty() {
        return false;
    }

    /**
     * Returns the stack in the given slot.
     *
     * @param index
     */
    public ItemStack getStackInSlot(int index) {
        return handler.getStackInSlot(index);
    }

    public ItemStack decrStackSize(int index, int count) {
        ItemStack itemStack = this.getStackInSlot(index);
        if (itemStack.getCount() == 1){
            handler.insertItem(index, ItemStack.EMPTY, false);
            return ItemStack.EMPTY;
        }
        itemStack.setCount(itemStack.getCount()-count);
        return itemStack;
    }

    /**
     * Removes a stack from the given slot and returns it.
     *
     * @param index
     */
    public ItemStack removeStackFromSlot(int index) {
        return null;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     *
     * @param index
     * @param stack
     */
    public void setInventorySlotContents(int index, ItemStack stack) {

    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
     */
    public int getInventoryStackLimit() {
        return 1;
    }

    /**
     * Don't rename this method to canInteractWith due to conflicts with Container
     *
     * @param player
     */
    public boolean isUsableByPlayer(EntityPlayer player) {
        return player.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64;
    }

    public void openInventory(EntityPlayer player) {

    }

    public void closeInventory(EntityPlayer player) {

    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot. For
     * guis use Slot.isItemValid
     *
     * @param index
     * @param stack
     */
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return false;
    }

    public int getFieldCount() {
        return 0;
    }

    public void clear() {

    }

    public String getName() {
        return CustomName;
    }

    public boolean hasCustomName() {
        return true;
    }
}

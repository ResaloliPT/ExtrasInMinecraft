package com.resaloli.eim.ModularContent.Energy.TileEntities;

import com.resaloli.eim.content.te.TileEntityBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import scala.Int;

public class TileEntityEnergyBase extends TileEntityBase implements IEnergyStorage, ICapabilityProvider {

    private static int capacity;
    private static int maxReceive;
    private static int maxExtract;
    private static int energy;
    private static boolean canExtractBol;
    private static boolean canReceiveBol;
    private static IEnergyStorage Enerhandler;


    public TileEntityEnergyBase(int capacity, int maxReceive, int maxExtract, int energy){
        super(2);
        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
        this.canReceiveBol = maxReceive > 0 ? true : false;
        this.canExtractBol = maxExtract > 0 ? true : false;
        this.energy = Math.max(0 , Math.min(capacity, energy));
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        if (!canReceive())
            return 0;
        if (simulate == false) this.energy = maxReceive+this.energy;
        return maxReceive;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        if (!canExtract())
            return 0;

        if (simulate == false) this.energy = maxExtract+this.energy;
        return maxExtract;
    }

    @Override
    public int getEnergyStored() {
        return energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return capacity;
    }

    @Override
    public boolean canExtract() {
        return this.canExtractBol;
    }

    @Override
    public boolean canReceive() {
        return this.canReceiveBol;
    }

    public IItemHandler getItemHandler(){
        return super.handler;
    }

    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityEnergy.ENERGY)
            return true;
        return super.hasCapability(capability, facing);
    }

    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityEnergy.ENERGY)
            return (T) this.Enerhandler;
        return super.getCapability(capability, facing);
    }

    public int produceEnergy(int energyPerTick){
        if ((this.getMaxEnergyStored() -  this.getEnergyStored()) > energyPerTick){
            //Save default maxReceive
            this.canReceiveBol = true;

            //Temporary add max int to remove producing limitations
            this.maxReceive = Int.MaxValue();

            //Add new Energy
            int producedEnergy = this.receiveEnergy(energyPerTick, false);

            //Restore default maxReceive
            this.canReceiveBol = false;

            //return produced energy
            return  producedEnergy;
        }
        return 0;
    }

    public int getEnergyScaled(int pixels){
        if (this.energy == 0){
            return 0;
        }else{
            return (this.energy * pixels)/this.capacity;
        }
    }
}

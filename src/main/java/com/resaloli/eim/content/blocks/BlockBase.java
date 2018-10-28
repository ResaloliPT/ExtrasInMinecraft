package com.resaloli.eim.content.blocks;

import com.resaloli.eim.CONSTANTS;
import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.te.TileEntityBase;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

import static net.minecraft.inventory.InventoryHelper.spawnItemStack;

public class BlockBase extends Block  {
    private String name;
    private boolean isTileProvider;

    public BlockBase(Material material, String name, boolean hasTE){
        super(material);
        this.name = name;
        this.setRegistryName(new ResourceLocation(ExtrasInMinecraft.modid, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(ExtrasInMinecraft.tabExtrasInMinecraft);
        this.isTileProvider = hasTE;
    }

    @Nullable
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        if (isTileProvider)
        {
            return ((ITileEntityProvider)this).createNewTileEntity(world, getMetaFromState(state));
        }
        return null;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return this.isTileProvider;
    }

    @Override
    public String getUnlocalizedName()
    {
        return "tile." + CONSTANTS.MOD_ID + ":" +  this.name;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        if (this.hasTileEntity(state)){
            TileEntityBase te = (TileEntityBase) worldIn.getTileEntity(pos);
            IItemHandler iStackHandler = te.handler;

            for (int i = 0; i < iStackHandler.getSlots(); i++){
                ItemStack iStack = iStackHandler.getStackInSlot(i);
                spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), iStack);
            }
        }
        super.breakBlock(worldIn, pos, state);
        worldIn.updateComparatorOutputLevel(pos, this);
    }
}
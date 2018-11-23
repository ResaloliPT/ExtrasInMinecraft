package com.resaloli.eim.content.blocks;

import com.resaloli.eim.content.tileentity.TileEntityBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

import static net.minecraft.inventory.InventoryHelper.spawnItemStack;

public abstract class BlockTileEntity extends BlockBase implements ITileEntityProvider {
    protected TileEntityBase tileEntity;

    public BlockTileEntity(Material materialIn, String name, TileEntityBase tileEntity) {
        super(materialIn, name);
        this.tileEntity = tileEntity;
    }

    public TileEntity createTileEntity(World world, IBlockState state) {
        return createNewTileEntity(world, getMetaFromState(state));
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return tileEntity;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        if (!(worldIn.getTileEntity(pos) instanceof TileEntityBase)) {
            return;
        }

        TileEntityBase te = (TileEntityBase) worldIn.getTileEntity(pos);
        if (te == null || te.getHandler() == null) {
            return;
        }

        IItemHandler iStackHandler = te.getHandler();

        for (int i = 0; i < iStackHandler.getSlots(); i++) {
            ItemStack iStack = iStackHandler.getStackInSlot(i);
            spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), iStack);
        }
        worldIn.removeTileEntity(pos);
        super.breakBlock(worldIn, pos, state);
    }
}

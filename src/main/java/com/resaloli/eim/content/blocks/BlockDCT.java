package com.resaloli.eim.content.blocks;

import com.resaloli.eim.CONSTANTS;
import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.te.TileEntityDCT;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockDCT extends BlockBase implements ITileEntityProvider {
    protected BlockDCT()
    {
        super(Material.WOOD, "block_dual_crafting_table", true);
        this.setHardness(2.0F);
        this.setHarvestLevel("axe", 0);
    }

    /**
     * Called when the block is right clicked by a player.
     */
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityDCT)
            {
                playerIn.openGui(ExtrasInMinecraft.instance, CONSTANTS.GUI_DUAL_CRAFTING_TABLE_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
                //TODO: ADD STAT: playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
                return true;
            }

            return false;
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     *
     * @param worldIn
     * @param meta
     */
    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityDCT();
    }
}

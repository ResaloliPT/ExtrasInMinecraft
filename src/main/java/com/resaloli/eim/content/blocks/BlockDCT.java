package com.resaloli.eim.content.blocks;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.gui.GUIID;
import com.resaloli.eim.content.tileentity.TileEntityDCT;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockDCT extends BlockTileEntity {

    BlockDCT() {
        super(Material.WOOD, "block_dual_crafting_table", new TileEntityDCT());
        this.setHardness(2.0F);
        this.setHarvestLevel("axe", 0);
    }

    /**
     * Called when the block is right clicked by a player.
     */
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {
            return true;
        } else {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (!(tileentity instanceof TileEntityDCT)) {
                return false;
            }

            playerIn.openGui(ExtrasInMinecraft.instance, GUIID.DUAL_CRAFTING_TABLE.getId(), worldIn, pos.getX(), pos.getY(), pos.getZ());
            //TODO: ADD STAT: playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
            return true;
        }
    }
}

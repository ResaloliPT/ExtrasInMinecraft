package com.resaloli.eim.content.blocks;

import com.resaloli.eim.CONSTANTS;
import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.container.ContainerDCT;
import com.resaloli.eim.content.te.TileEntityDCT;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockDCT extends BlockBase implements ITileEntityProvider {
    protected BlockDCT(Material material, String name)
    {
        super(material, name);
    }

    /**
     * Called when the block is right clicked by a player.
     */
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
                playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
            }

            return true;
        }
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
        TileEntityDCT te = (TileEntityDCT) world.getTileEntity(pos);
        //InventoryHelper.dropInventoryItems(world, pos, te);
        super.breakBlock(world, pos, blockstate);
    }


    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (stack.hasDisplayName()) {
            ((TileEntityDCT) worldIn.getTileEntity(pos)).setName(stack.getDisplayName());
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


    public static class InterfaceCraftingTable implements IInteractionObject
    {
        private final World world;
        private final BlockPos position;

        public InterfaceCraftingTable(World worldIn, BlockPos pos)
        {
            this.world = worldIn;
            this.position = pos;
        }

        /**
         * Get the name of this object. For players this returns their username
         */
        public String getName()
        {
            return EIMBlocks.dualCraftingTable.getRegistryName().toString();
        }

        /**
         * Returns true if this thing is named
         */
        public boolean hasCustomName()
        {
            return false;
        }

        /**
         * Get the formatted ChatComponent that will be used for the sender's username in chat
         */
        public ITextComponent getDisplayName()
        {
            return new TextComponentTranslation(EIMBlocks.dualCraftingTable.getUnlocalizedName(), new Object[0]);
        }

        public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
        {
            return new ContainerDCT(playerInventory, this.world, this.position);
        }

        public String getGuiID()
        {
            return EIMBlocks.dualCraftingTable.getRegistryName().toString();
        }
    }
}

package com.resaloli.eim.content.blocks;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.te.TileEntityDCT;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class dualCraftingTable extends BlockContainer{
	
	public dualCraftingTable() {
		super(Material.wood);
		setHardness(2.5F);
		setCreativeTab(ExtrasInMinecraft.tabExtrasInMinecraft);
		setStepSound(Block.soundTypeWood);
		setUnlocalizedName("dualCraftingTable");
		setHarvestLevel("axe", 0);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int arg1) {
		return new TileEntityDCT();
	}
	
    @Override
	public int getRenderType(){
		return 3;		
	}
    
    @Override
	public boolean isOpaqueCube(){
		return true;		
	}
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	TileEntityDCT tileentity = (TileEntityDCT)worldIn.getTileEntity(pos);

        if (tileentity != null)
        {
        	playerIn.openGui(ExtrasInMinecraft.instance, ExtrasInMinecraft.GUIDdualCraftingTable, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
		return true;
    }
    
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof IInventory)
        {
            InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
            worldIn.updateComparatorOutputLevel(pos, this);
        }

        super.breakBlock(worldIn, pos, state);
    }
}
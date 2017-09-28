package com.resaloli.eim.content.blocks;

import com.resaloli.eim.ExtrasInMinecraft;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class BlockBase extends Block  {
    private String name;
    private boolean isTileProvider = this instanceof ITileEntityProvider;

    public BlockBase(Material material, String name){
        super(material);
        this.name = name;
        this.setRegistryName(new ResourceLocation(ExtrasInMinecraft.modid, name));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(ExtrasInMinecraft.tabExtrasInMinecraft);
    }

    @Override
    public String getUnlocalizedName()
    {
        return "tile." + ExtrasInMinecraft.modid + ":" +  this.name;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        if (isTileProvider)
        {
            return ((ITileEntityProvider)this).createNewTileEntity(world, getMetaFromState(state));
        }
        return null;
    }
}
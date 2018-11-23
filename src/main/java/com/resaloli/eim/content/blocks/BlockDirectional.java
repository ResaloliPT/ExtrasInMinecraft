package com.resaloli.eim.content.blocks;

import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockProperties;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BlockDirectional extends BlockBase implements IBlockProperties {

    private Material material;

    public BlockDirectional(Material material, String name) {
        super(material, name);
        this.material = material;
    }

    @Override
    public Material getMaterial() {
        return this.material;
    }

    @Override
    public boolean isFullBlock() {
        return true;
    }

    @Override
    public boolean canEntitySpawn(Entity entityIn) {
        return true;
    }

    @Override
    public int getLightOpacity() {
        return 0;
    }

    @Override
    public int getLightOpacity(IBlockAccess world, BlockPos pos) {
        return 0;
    }

    @Override
    public int getLightValue() {
        return 0;
    }

    @Override
    public int getLightValue(IBlockAccess world, BlockPos pos) {
        return 0;
    }

    @Override
    public boolean isTranslucent() {
        return false;
    }

    @Override
    public boolean useNeighborBrightness() {
        return false;
    }

    @Override
    public MapColor getMapColor(IBlockAccess blockAccess, BlockPos blockPos) {
        return null;
    }

    /**
     * Returns the blockstate with the given rotation. If inapplicable, returns itself.
     *
     * @param rot
     */
    @Override
    public IBlockState withRotation(Rotation rot) {
        return null;
    }

    /**
     * Returns the blockstate mirrored in the given way. If inapplicable, returns itself.
     *
     * @param mirrorIn
     */
    @Override
    public IBlockState withMirror(Mirror mirrorIn) {
        return null;
    }

    @Override
    public boolean isFullCube() {
        return true;
    }

    @Override
    public boolean hasCustomBreakingProgress() {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType() {
        return null;
    }

    @Override
    public int getPackedLightmapCoords(IBlockAccess source, BlockPos pos) {
        return 0;
    }

    @Override
    public float getAmbientOcclusionLightValue() {
        return 0;
    }

    @Override
    public boolean isBlockNormalCube() {
        return true;
    }

    @Override
    public boolean isNormalCube() {
        return true;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public int getWeakPower(IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return 0;
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return false;
    }

    @Override
    public int getComparatorInputOverride(World worldIn, BlockPos pos) {
        return 0;
    }

    @Override
    public float getBlockHardness(World worldIn, BlockPos pos) {
        return 0;
    }

    @Override
    public float getPlayerRelativeBlockHardness(EntityPlayer player, World worldIn, BlockPos pos) {
        return 0;
    }

    @Override
    public int getStrongPower(IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return 0;
    }

    @Override
    public EnumPushReaction getPushReaction() {
        return null;
    }

    @Override
    public IBlockState getActualState(IBlockAccess blockAccess, BlockPos pos) {
        return null;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos) {
        return null;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, BlockPos pos, EnumFacing facing) {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockAccess worldIn, BlockPos pos) {
        return null;
    }

    @Override
    public void addCollisionBoxToList(World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185908_6_) {

    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockAccess blockAccess, BlockPos pos) {
        return null;
    }

    @Override
    public RayTraceResult collisionRayTrace(World worldIn, BlockPos pos, Vec3d start, Vec3d end) {
        return null;
    }


    /**
     * Determines if the block is solid enough on the top side to support other blocks, like redstone components.
     */
    @Override
    public boolean isTopSolid() {
        return false;
    }


    /**
     * Checks if side is solid
     *
     * @param world the world
     * @param pos   the block position
     * @param side  the side of the block
     * @return true if solid
     */
    @Override
    public boolean isSideSolid(IBlockAccess world, BlockPos pos, EnumFacing side) {
        return true;
    }


    @Override
    public boolean doesSideBlockRendering(IBlockAccess world, BlockPos pos, EnumFacing side) {
        return false;
    }



    @Override
    public boolean doesSideBlockChestOpening(IBlockAccess world, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public Vec3d getOffset(IBlockAccess access, BlockPos pos) {
        return new Vec3d(0,0,0);
    }

    @Override
    public boolean causesSuffocation() {
        return true;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, BlockPos pos, EnumFacing facing) {
        return BlockFaceShape.UNDEFINED;
    }
}

package com.resaloli.eim.content.items;

import com.resaloli.eim.ExtrasInMinecraft;
import com.resaloli.eim.content.potions.EIMPotions;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemFoodBase extends ItemFood {

    private String name;
    private PotionEffect potionId;
    private float potionEffectProbability;
    private boolean alwaysEdible = false;

    ItemFoodBase(String itemName, int healAmount, float saturation) {
        super(healAmount, saturation, false);
        this.name = itemName;
        this.setRegistryName(new ResourceLocation(ExtrasInMinecraft.modid, itemName));
        this.setUnlocalizedName(this.getRegistryName().toString());
        this.setCreativeTab(ExtrasInMinecraft.tabExtrasInMinecraft);
    }

    public String getUnlocalizedName()
    {
        return "item." + ExtrasInMinecraft.modid + ":" + this.name;
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote && this.potionId != null && worldIn.rand.nextFloat() < this.potionEffectProbability)
        {
            player.addPotionEffect(new PotionEffect(this.potionId));
        }
    }

    public ItemFood setPotionEffect(PotionEffect effect, float probability)
    {
        this.potionId = effect;
        this.potionEffectProbability = probability;
        return this;
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));

            if (entityplayer instanceof EntityPlayerMP)
            {
                CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
            }
        }

        stack.shrink(1);
        entityLiving.addPotionEffect(new PotionEffect(EIMPotions.wellFed, 200, 4));
        entityLiving.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 200, 3));
        return stack;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (playerIn.canEat(this.alwaysEdible))
        {
            playerIn.setActiveHand(handIn);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
        else
        {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
        }
    }
}
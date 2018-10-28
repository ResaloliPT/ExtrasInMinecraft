package com.resaloli.eim.content.potions;

import com.resaloli.eim.ExtrasInMinecraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class WellFedEffect extends Potion{

    public static final ResourceLocation icon = new ResourceLocation("minecraft", "textures/gui/container/inventory.png");

    public WellFedEffect(boolean isBadEffectIn, int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
        super.setPotionName("effect.wellFed");
        super.setRegistryName(ExtrasInMinecraft.modid, "wellFed");
    }


    public Potion setIconIndex(int x, int y){
        super.setIconIndex(x, y);
        return (Potion)this;
    }

    public int getStatusIconIndex()
    {
        ITextureObject textureObject = Minecraft.getMinecraft().renderEngine.getTexture(icon);
        Minecraft.getMinecraft().renderEngine.bindTexture(icon);
        return super.getStatusIconIndex();
    }

    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier)
    {
        ((EntityPlayer)entityLivingBaseIn).getFoodStats().addStats(amplifier + 1, 4.0F);
        entityLivingBaseIn.heal((float)Math.max(4 << amplifier, 0));
        entityLivingBaseIn.setAbsorptionAmount(4.0F);
        entityLivingBaseIn.addPotionEffect(new PotionEffect(EIMPotions.wellFed, 5, 1));
    }
}

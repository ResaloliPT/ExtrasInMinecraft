package com.resaloli.eim.content.potions;

import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;

public class EIMPotions {
    public static Potion wellFed = new WellFedEffect(false, 13458603).setIconIndex(7, 0);

    private static Potion[] POTIONS = {
            wellFed
    };

    public static void registerPotions(RegistryEvent.Register<Potion> event) {
        //TODO: ADD POTION ITEM PotionUtils.addPotionToItemStack(new ItemStack(Items.potionitem), <PotionType>)
        event.getRegistry().registerAll(POTIONS);
    }

    public static Potion[] getList() {
        return POTIONS;
    }
}

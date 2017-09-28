package com.resaloli.eim.interfaces;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public interface IRecipe extends net.minecraft.item.crafting.IRecipe
{
    /**
     * Used to check if a recipe matches current crafting inventory
     */
    boolean matches(InventoryCrafting inv, World worldIn);

    /**
     * Returns an Item that is the result of this recipe
     */
    ItemStack getCraftingResult(InventoryCrafting inv);

    /**
     * Used to determine if this recipe can fit in a grid of the given width/height
     */
    boolean canFit(int width, int height);

    ItemStack getRecipeOutput();

    default NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv)
    {
        return net.minecraftforge.common.ForgeHooks.defaultRecipeGetRemainingItems(inv);
    }

    default NonNullList<Ingredient> getIngredients()
    {
        return NonNullList.<Ingredient>create();
    }

    default boolean isHidden()
    {
        return false;
    }

    default String getGroup()
    {
        return "";
    }
}
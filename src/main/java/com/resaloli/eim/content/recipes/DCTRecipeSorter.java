package com.resaloli.eim.content.recipes;

import java.util.Comparator;

import com.resaloli.eim.content.crafting.CraftingManagerDCT;

import net.minecraft.item.crafting.IRecipe;

public class DCTRecipeSorter implements Comparator
{
    final CraftingManagerDCT CraftingManagerDCT;

    public DCTRecipeSorter(CraftingManagerDCT CraftingManagerDCT)
    {
        this.CraftingManagerDCT = CraftingManagerDCT;
    }

    public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
    {
        return par1IRecipe instanceof DCTShapelessRecipes && par2IRecipe instanceof DCTShapedRecipes ? 1 : (par2IRecipe instanceof DCTShapelessRecipes && par1IRecipe instanceof DCTShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object par1Obj, Object par2Obj)
    {
        return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
    }
}
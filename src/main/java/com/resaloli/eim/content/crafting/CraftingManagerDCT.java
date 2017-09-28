package com.resaloli.eim.content.crafting;

import com.google.common.collect.Lists;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class CraftingManagerDCT extends CraftingManager
{

    private static final CraftingManagerDCT instance = new CraftingManagerDCT();
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();


    public CraftingManagerDCT () {
        super();
    }

    @Nullable
    public static IRecipe findMatchingRecipe(InventoryCrafting craftMatrix, World worldIn)
    {

        for (IRecipe irecipe : REGISTRY)
        {
            if (irecipe.matches(craftMatrix, worldIn))
            {
                return irecipe;
            }
        }

        return null;
    }

    public static CraftingManagerDCT getInstance()
    {
        /** The static instance of this class */
        return instance;
    }

    @Nullable
    public static IRecipe getRecipe(ResourceLocation name)
    {
        return (IRecipe) REGISTRY.getObject(name);
    }

}
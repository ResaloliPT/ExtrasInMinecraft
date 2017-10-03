package com.resaloli.eim.content.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class CraftingManagerDCT extends CraftingManager {

    private static int nextAvailableId;
    public static final RegistryNamespaced<ResourceLocation, IRecipe> REGISTRY = net.minecraftforge.registries.GameData.getWrapper(IRecipe.class);

    /**
     * Retrieves an ItemStack that has multiple recipes for it.
     */
    public static ItemStack findMatchingResult(InventoryCrafting p_82787_0_, World craftMatrix) {
        for (IRecipe irecipe : REGISTRY) {
            if (irecipe.matches(p_82787_0_, craftMatrix)) {
                return irecipe.getCraftingResult(p_82787_0_);
            }
        }

        return ItemStack.EMPTY;
    }

    @Nullable
    public static IRecipe findMatchingRecipes(InventoryCrafting craftMatrix, World worldIn) {
        for (IRecipe irecipe : REGISTRY) {
            if (irecipe.matches(craftMatrix, worldIn)) {
                return irecipe;
            }
        }

        return null;
    }

    public static NonNullList<ItemStack> getRemainingItems(InventoryCrafting p_180303_0_, World craftMatrix) {
        for (IRecipe irecipe : REGISTRY) {
            if (irecipe.matches(p_180303_0_, craftMatrix)) {
                return irecipe.getRemainingItems(p_180303_0_);
            }
        }

        NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(p_180303_0_.getSizeInventory(), ItemStack.EMPTY);

        for (int i = 0; i < nonnulllist.size(); ++i) {
            nonnulllist.set(i, p_180303_0_.getStackInSlot(i));
        }

        return nonnulllist;
    }

    @Nullable
    public static IRecipe getRecipes(ResourceLocation name) {
        return REGISTRY.getObject(name);
    }
}
package com.resaloli.eim.content.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.resaloli.eim.content.crafting.CraftingManagerDCT;

public class Recipes {
	public static CraftingManagerDCT CraftMana = new CraftingManagerDCT();
	
	public static void addRecipes(CraftingManagerDCT craftMan){
		craftMan.addShapelessRecipe(new ItemStack(net.minecraft.init.Blocks.diamond_block), new ItemStack(net.minecraft.init.Blocks.dirt));
		craftMan.addRecipe(new ItemStack(Blocks.diamond_block, 3), new Object[] {"WWWW", "WWWW", "WWWW", "WWWW" , 'W', new ItemStack(Blocks.dirt)});
	}
	
	public static void addVanillas(){
		
	}
}

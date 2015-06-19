package com.resaloli.eim.content.blocks;

import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Blocks {
	
	public static Block dualCraftingTable = new dualCraftingTable();
	
	
	public static void preinit(){
		//Registers
		GameRegistry.registerBlock(dualCraftingTable, "dualCraftingTable");
		
		//Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(dualCraftingTable, 1), new ItemStack(Block.getBlockFromName("crafting_table")), new ItemStack(Block.getBlockFromName("crafting_table")));
	}
};

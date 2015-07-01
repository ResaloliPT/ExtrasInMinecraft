package com.resaloli.eim.content.blocks;

import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class EIMBlocks {
	
	public static Block dualCraftingTable = new dualCraftingTable();
	
	
	public static void preinit(){
		//Registers
		GameRegistry.registerBlock(dualCraftingTable, "dualCraftingTable");
	}
};

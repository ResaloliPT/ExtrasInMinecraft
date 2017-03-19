package com.resaloli.eim.content.blocks;

import com.resaloli.eim.Interfaces.IItemModelProvider;
import com.resaloli.eim.content.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class EIMBlocks {

	public static dualCraftingTable dualCraftingTable;

	public static void init() {
		dualCraftingTable = register(new dualCraftingTable("dualCraftingTable"));
	}

	private static <T extends Block> T register (T block, ItemBlock itemblock) {
		GameRegistry.register(block);
		if(itemblock != null) {
			GameRegistry.register(itemblock);
		}

		if(block instanceof IItemModelProvider) {
			((IItemModelProvider)block).registerItemBlockModel(itemblock);
		}
		 return block;
	}

	private static <T extends Block> T register(T block) {
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		return register(block, itemBlock);
	}
}

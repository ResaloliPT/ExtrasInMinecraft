package com.resaloli.eim.content.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class dualCraftingTable extends BlockBase {

	public dualCraftingTable(String name) {
		super(Material.WOOD, name);
		setHardness(2.5F);
		setSoundType(SoundType.WOOD);
		setHarvestLevel("axe", 0);
	}

	@Override
	public dualCraftingTable setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}
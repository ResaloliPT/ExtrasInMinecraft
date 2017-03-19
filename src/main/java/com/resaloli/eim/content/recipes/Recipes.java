package com.resaloli.eim.content.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.resaloli.eim.content.blocks.EIMBlocks;
import com.resaloli.eim.content.crafting.CraftingManagerDCT;

public class Recipes {

	//Patterns
	//private static String[][] weaponsPatterns = new String[][] {{"X", "X", "#"}};
	//private static String[][] toolsPatterns = new String[][] {{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
	//private static String[][] armourPatterns = new String[][] {{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
	
	//Materials
	//private static  Object[][] materials = new Object[][] {{Blocks.planks, Blocks.cobblestone, Items.iron_ingot, Items.diamond, Items.gold_ingot}, {Items.wooden_sword, Items.stone_sword, Items.iron_sword, Items.diamond_sword, Items.golden_sword}};
	//private static  Item[][] materials1 = new Item[][] {{Items.leather, Items.iron_ingot, Items.diamond, Items.gold_ingot}, {Items.leather_helmet, Items.iron_helmet, Items.diamond_helmet, Items.golden_helmet}, {Items.leather_chestplate, Items.iron_chestplate, Items.diamond_chestplate, Items.golden_chestplate}, {Items.leather_leggings, Items.iron_leggings, Items.diamond_leggings, Items.golden_leggings}, {Items.leather_boots, Items.iron_boots, Items.diamond_boots, Items.golden_boots}};
	
	public static void initRecipes(){
		//Recipes That need to be inited
		GameRegistry.addRecipe(new ItemStack(EIMBlocks.dualCraftingTable), new Object[] {"XPX", "III", "XPX", 'X', "minecraft:crafting_table", 'I', Items.IRON_INGOT, 'P', Blocks.PLANKS});
	}
	
	public static void addRecipes(CraftingManagerDCT craftMan){
		//Custom Recipes Here!
	}
	
	public static void addVanillas(CraftingManagerDCT craftMan){
		/*//Recipe Ingots
		//Adds all the blocks into ingots recipes
		for (int var2 = 0; var2 < blockIngots.length; ++var2)
        {
            Block var3 = (Block)blockIngots[var2][0];
            ItemStack var4 = (ItemStack)blockIngots[var2][1];
            craftMan.addRecipe(new ItemStack(var3), new Object[] {"###", "###", "###", '#', var4});
            craftMan.addRecipe(var4, new Object[] {"#", '#', var3});
        }

		//gold nugget into gold ingot
		craftMan.addRecipe(new ItemStack(Items.gold_ingot), new Object[] {"###", "###", "###", '#', Items.gold_nugget});
        //gold ingot into gold nugget
		craftMan.addRecipe(new ItemStack(Items.gold_nugget, 9), new Object[] {"#", '#', Items.gold_ingot});
		
		
		//Recipe Weapons
		//Adds all Swords Recipes
		for (int var2 = 0; var2 < materials[0].length; ++var2)
        {
            Object var3 = materials[0][var2];

            for (int var4 = 0; var4 < materials.length - 1; ++var4)
            {
                Item var5 = (Item)materials[var4 + 1][var2];
                craftMan.addRecipe(new ItemStack(var5), new Object[] {weaponsPatterns[var4], '#', Items.stick, 'X', var3});
            }
        }
		
		//Bow
		craftMan.addRecipe(new ItemStack(Items.bow, 1), new Object[] {" #X", "# X", " #X", 'X', Items.string, '#', Items.stick});
        //Arrow
		craftMan.addRecipe(new ItemStack(Items.arrow, 4), new Object[] {"X", "#", "Y", 'Y', Items.feather, 'X', Items.flint, '#', Items.stick});
	
		
		//Recipe Tools
		//Adds all tools
		for (int var2 = 0; var2 < materials[0].length; ++var2)
        {
            Object var3 = materials[0][var2];

            for (int var4 = 0; var4 < materials.length - 1; ++var4)
            {
                Item var5 = (Item)materials[var4 + 1][var2];
                craftMan.addRecipe(new ItemStack(var5), new Object[] {toolsPatterns[var4], '#', Items.stick, 'X', var3});
            }
        }
		
		//Shears
		craftMan.addRecipe(new ItemStack(Items.shears), new Object[] {" #", "# ", '#', Items.iron_ingot});
		
		//Recipe Foods
		//Mushroom Soup
		craftMan.addShapelessRecipe(new ItemStack(Items.mushroom_stew), new Object[] {Blocks.brown_mushroom, Blocks.red_mushroom, Items.bowl});
		//Cookie
		craftMan.addRecipe(new ItemStack(Items.cookie, 8), new Object[] {"#X#", 'X', new ItemStack(Items.dye, 1, EnumDyeColor.BROWN.getDyeDamage()), '#', Items.wheat});
		//Rabbit Soup
		craftMan.addRecipe(new ItemStack(Items.rabbit_stew), new Object[] {" R ", "CPM", " B ", 'R', new ItemStack(Items.cooked_rabbit), 'C', Items.carrot, 'P', Items.baked_potato, 'M', Blocks.brown_mushroom, 'B', Items.bowl});
		//Rabbit Soup
		craftMan.addRecipe(new ItemStack(Items.rabbit_stew), new Object[] {" R ", "CPD", " B ", 'R', new ItemStack(Items.cooked_rabbit), 'C', Items.carrot, 'P', Items.baked_potato, 'D', Blocks.red_mushroom, 'B', Items.bowl});
        //Melon
		craftMan.addRecipe(new ItemStack(Blocks.melon_block), new Object[] {"MMM", "MMM", "MMM", 'M', Items.melon});
        //Melon Seeds
		craftMan.addRecipe(new ItemStack(Items.melon_seeds), new Object[] {"M", 'M', Items.melon});
        //Pumpkin Seeds
		craftMan.addRecipe(new ItemStack(Items.pumpkin_seeds, 4), new Object[] {"M", 'M', Blocks.pumpkin});
        //Pumpkin pie
		craftMan.addShapelessRecipe(new ItemStack(Items.pumpkin_pie), new Object[] {Blocks.pumpkin, Items.sugar, Items.egg});
        //Fermented Spider eye?a food?
		craftMan.addShapelessRecipe(new ItemStack(Items.fermented_spider_eye), new Object[] {Items.spider_eye, Blocks.brown_mushroom, Items.sugar});
        //blaze power?a food?
		craftMan.addShapelessRecipe(new ItemStack(Items.blaze_powder, 2), new Object[] {Items.blaze_rod});
		//Magma Cream?a food?
		craftMan.addShapelessRecipe(new ItemStack(Items.magma_cream), new Object[] {Items.blaze_powder, Items.slime_ball});
		
		//Recipe Dyes
		//Carpets
		for (int var2 = 0; var2 < 16; ++var2)
        {
			craftMan.addRecipe(new ItemStack(Blocks.carpet, 3, var2), new Object[] {"##", '#', new ItemStack(Blocks.wool, 1, var2)});
        }
		
		//Wools,Hardened Clay,Stained Glass, Glass Pane
		for (int var2 = 0; var2 < 16; ++var2)
        {
			craftMan.addShapelessRecipe(new ItemStack(Blocks.wool, 1, var2), new Object[] {new ItemStack(Items.dye, 1, 15 - var2), new ItemStack(Item.getItemFromBlock(Blocks.wool), 1, 0)});
			craftMan.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 8, 15 - var2), new Object[] {"###", "#X#", "###", '#', new ItemStack(Blocks.hardened_clay), 'X', new ItemStack(Items.dye, 1, var2)});
			craftMan.addRecipe(new ItemStack(Blocks.stained_glass, 8, 15 - var2), new Object[] {"###", "#X#", "###", '#', new ItemStack(Blocks.glass), 'X', new ItemStack(Items.dye, 1, var2)});
			craftMan.addRecipe(new ItemStack(Blocks.stained_glass_pane, 16, var2), new Object[] {"###", "###", '#', new ItemStack(Blocks.stained_glass, 1, var2)});
        }
		
		//Color Sources
		craftMan.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.YELLOW.getDyeDamage()), new Object[] {new ItemStack(Blocks.yellow_flower, 1, BlockFlower.EnumFlowerType.DANDELION.ordinal())});
		craftMan.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.RED.getDyeDamage()), new Object[] {new ItemStack(Blocks.red_flower, 1, BlockFlower.EnumFlowerType.POPPY.ordinal())});
		craftMan.addShapelessRecipe(new ItemStack(Items.dye, 3, EnumDyeColor.WHITE.getDyeDamage()), new Object[] {Items.bone});
		craftMan.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.SILVER.getDyeDamage()), new Object[] {new ItemStack(Blocks.red_flower, 1, BlockFlower.EnumFlowerType.HOUSTONIA.ordinal())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.RED.getDyeDamage()), new Object[] {new ItemStack(Blocks.red_flower, 1, BlockFlower.EnumFlowerType.RED_TULIP.ordinal())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.ORANGE.getDyeDamage()), new Object[] {new ItemStack(Blocks.red_flower, 1, BlockFlower.EnumFlowerType.ORANGE_TULIP.ordinal())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.SILVER.getDyeDamage()), new Object[] {new ItemStack(Blocks.red_flower, 1, BlockFlower.EnumFlowerType.WHITE_TULIP.ordinal())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.PINK.getDyeDamage()), new Object[] {new ItemStack(Blocks.red_flower, 1, BlockFlower.EnumFlowerType.PINK_TULIP.ordinal())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.SILVER.getDyeDamage()), new Object[] {new ItemStack(Blocks.red_flower, 1, BlockFlower.EnumFlowerType.OXEYE_DAISY.ordinal())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.YELLOW.getDyeDamage()), new Object[] {new ItemStack(Blocks.double_plant, 1, BlockDoublePlant.EnumPlantType.SUNFLOWER.ordinal())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.MAGENTA.getDyeDamage()), new Object[] {new ItemStack(Blocks.double_plant, 1, BlockDoublePlant.EnumPlantType.SYRINGA.ordinal())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.RED.getDyeDamage()), new Object[] {new ItemStack(Blocks.double_plant, 1, BlockDoublePlant.EnumPlantType.ROSE.ordinal())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.PINK.getDyeDamage()), new Object[] {new ItemStack(Blocks.double_plant, 1, BlockDoublePlant.EnumPlantType.PAEONIA.ordinal())});
		
        //Color Mixes
		craftMan.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.PINK.getDyeDamage()), new Object[] {new ItemStack(Items.dye, 1, EnumDyeColor.RED.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.WHITE.getDyeDamage())});
		craftMan.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.ORANGE.getDyeDamage()), new Object[] {new ItemStack(Items.dye, 1, EnumDyeColor.RED.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.YELLOW.getDyeDamage())});
		craftMan.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.LIME.getDyeDamage()), new Object[] {new ItemStack(Items.dye, 1, EnumDyeColor.GREEN.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.WHITE.getDyeDamage())});
		craftMan.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.GRAY.getDyeDamage()), new Object[] {new ItemStack(Items.dye, 1, EnumDyeColor.BLACK.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.WHITE.getDyeDamage())});
		craftMan.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.SILVER.getDyeDamage()), new Object[] {new ItemStack(Items.dye, 1, EnumDyeColor.GRAY.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.WHITE.getDyeDamage())});
		craftMan.addShapelessRecipe(new ItemStack(Items.dye, 3, EnumDyeColor.SILVER.getDyeDamage()), new Object[] {new ItemStack(Items.dye, 1, EnumDyeColor.BLACK.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.WHITE.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.WHITE.getDyeDamage())});
		craftMan.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.LIGHT_BLUE.getDyeDamage()), new Object[] {new ItemStack(Items.dye, 1, EnumDyeColor.BLUE.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.WHITE.getDyeDamage())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.CYAN.getDyeDamage()), new Object[] {new ItemStack(Items.dye, 1, EnumDyeColor.BLUE.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.GREEN.getDyeDamage())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.PURPLE.getDyeDamage()), new Object[] {new ItemStack(Items.dye, 1, EnumDyeColor.BLUE.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.RED.getDyeDamage())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 2, EnumDyeColor.MAGENTA.getDyeDamage()), new Object[] {new ItemStack(Items.dye, 1, EnumDyeColor.PURPLE.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.PINK.getDyeDamage())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 3, EnumDyeColor.MAGENTA.getDyeDamage()), new Object[] {new ItemStack(Items.dye, 1, EnumDyeColor.BLUE.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.RED.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.PINK.getDyeDamage())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 4, EnumDyeColor.MAGENTA.getDyeDamage()), new Object[] {new ItemStack(Items.dye, 1, EnumDyeColor.BLUE.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.RED.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.RED.getDyeDamage()), new ItemStack(Items.dye, 1, EnumDyeColor.WHITE.getDyeDamage())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.LIGHT_BLUE.getDyeDamage()), new Object[] {new ItemStack(Blocks.red_flower, 1, BlockFlower.EnumFlowerType.BLUE_ORCHID.ordinal())});
        craftMan.addShapelessRecipe(new ItemStack(Items.dye, 1, EnumDyeColor.MAGENTA.getDyeDamage()), new Object[] {new ItemStack(Blocks.red_flower, 1, BlockFlower.EnumFlowerType.ALLIUM.ordinal())});
        
		//Recipes Crafting
        craftMan.addRecipe(new ItemStack(Blocks.chest), new Object[] {"###", "# #", "###", '#', Blocks.planks});
        craftMan.addRecipe(new ItemStack(Blocks.trapped_chest), new Object[] {"#-", '#', Blocks.chest, '-', Blocks.tripwire_hook});
        craftMan.addRecipe(new ItemStack(Blocks.ender_chest), new Object[] {"###", "#E#", "###", '#', Blocks.obsidian, 'E', Items.ender_eye});
        craftMan.addRecipe(new ItemStack(Blocks.furnace), new Object[] {"###", "# #", "###", '#', Blocks.cobblestone});
        craftMan.addRecipe(new ItemStack(Blocks.crafting_table), new Object[] {"##", "##", '#', Blocks.planks});
        craftMan.addRecipe(new ItemStack(Blocks.sandstone), new Object[] {"##", "##", '#', new ItemStack(Blocks.sand, 1, BlockSand.EnumType.SAND.ordinal())});
        craftMan.addRecipe(new ItemStack(Blocks.red_sandstone), new Object[] {"##", "##", '#', new ItemStack(Blocks.sand, 1, BlockSand.EnumType.RED_SAND.ordinal())});
        craftMan.addRecipe(new ItemStack(Blocks.sandstone, 4, BlockSandStone.EnumType.SMOOTH.ordinal()), new Object[] {"##", "##", '#', new ItemStack(Blocks.sandstone, 1, BlockSandStone.EnumType.DEFAULT.ordinal())});
        craftMan.addRecipe(new ItemStack(Blocks.red_sandstone, 4, BlockRedSandstone.EnumType.SMOOTH.getMetadata()), new Object[] {"##", "##", '#', new ItemStack(Blocks.red_sandstone, 1, BlockRedSandstone.EnumType.DEFAULT.getMetadata())});
        craftMan.addRecipe(new ItemStack(Blocks.sandstone, 1, BlockSandStone.EnumType.CHISELED.ordinal()), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, BlockStoneSlab.EnumType.SAND.ordinal())});
        craftMan.addRecipe(new ItemStack(Blocks.red_sandstone, 1, BlockRedSandstone.EnumType.CHISELED.getMetadata()), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab2, 1, BlockStoneSlabNew.EnumType.RED_SANDSTONE.ordinal())});
        craftMan.addRecipe(new ItemStack(Blocks.quartz_block, 1, BlockQuartz.EnumType.CHISELED.getMetadata()), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, BlockStoneSlab.EnumType.QUARTZ.ordinal())});
        craftMan.addRecipe(new ItemStack(Blocks.quartz_block, 2, BlockQuartz.EnumType.LINES_Y.getMetadata()), new Object[] {"#", "#", '#', new ItemStack(Blocks.quartz_block, 1, BlockQuartz.EnumType.DEFAULT.getMetadata())});
        craftMan.addRecipe(new ItemStack(Blocks.stonebrick, 4), new Object[] {"##", "##", '#', new ItemStack(Blocks.stone, 1, BlockStone.EnumType.STONE.getMetadata())});
        craftMan.addRecipe(new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.CHISELED_META), new Object[] {"#", "#", '#', new ItemStack(Blocks.stone_slab, 1, BlockStoneSlab.EnumType.SMOOTHBRICK.ordinal())});
        craftMan.addShapelessRecipe(new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.MOSSY_META), new Object[] {Blocks.stonebrick, Blocks.vine});
        craftMan.addShapelessRecipe(new ItemStack(Blocks.mossy_cobblestone, 1), new Object[] {Blocks.cobblestone, Blocks.vine});
        craftMan.addRecipe(new ItemStack(Blocks.iron_bars, 16), new Object[] {"###", "###", '#', Items.iron_ingot});
        craftMan.addRecipe(new ItemStack(Blocks.glass_pane, 16), new Object[] {"###", "###", '#', Blocks.glass});
        craftMan.addRecipe(new ItemStack(Blocks.redstone_lamp, 1), new Object[] {" R ", "RGR", " R ", 'R', Items.redstone, 'G', Blocks.glowstone});
        craftMan.addRecipe(new ItemStack(Blocks.beacon, 1), new Object[] {"GGG", "GSG", "OOO", 'G', Blocks.glass, 'S', Items.nether_star, 'O', Blocks.obsidian});
        craftMan.addRecipe(new ItemStack(Blocks.nether_brick, 1), new Object[] {"NN", "NN", 'N', Items.netherbrick});
        craftMan.addRecipe(new ItemStack(Blocks.stone, 2, BlockStone.EnumType.DIORITE.getMetadata()), new Object[] {"CQ", "QC", 'C', Blocks.cobblestone, 'Q', Items.quartz});
        craftMan.addShapelessRecipe(new ItemStack(Blocks.stone, 1, BlockStone.EnumType.GRANITE.getMetadata()), new Object[] {new ItemStack(Blocks.stone, 1, BlockStone.EnumType.DIORITE.getMetadata()), Items.quartz});
        craftMan.addShapelessRecipe(new ItemStack(Blocks.stone, 2, BlockStone.EnumType.ANDESITE.getMetadata()), new Object[] {new ItemStack(Blocks.stone, 1, BlockStone.EnumType.DIORITE.getMetadata()), Blocks.cobblestone});
        craftMan.addRecipe(new ItemStack(Blocks.dirt, 4, BlockDirt.DirtType.COARSE_DIRT.getMetadata()), new Object[] {"DG", "GD", 'D', new ItemStack(Blocks.dirt, 1, BlockDirt.DirtType.DIRT.getMetadata()), 'G', Blocks.gravel});
        craftMan.addRecipe(new ItemStack(Blocks.stone, 4, BlockStone.EnumType.DIORITE_SMOOTH.getMetadata()), new Object[] {"SS", "SS", 'S', new ItemStack(Blocks.stone, 1, BlockStone.EnumType.DIORITE.getMetadata())});
        craftMan.addRecipe(new ItemStack(Blocks.stone, 4, BlockStone.EnumType.GRANITE_SMOOTH.getMetadata()), new Object[] {"SS", "SS", 'S', new ItemStack(Blocks.stone, 1, BlockStone.EnumType.GRANITE.getMetadata())});
        craftMan.addRecipe(new ItemStack(Blocks.stone, 4, BlockStone.EnumType.ANDESITE_SMOOTH.getMetadata()), new Object[] {"SS", "SS", 'S', new ItemStack(Blocks.stone, 1, BlockStone.EnumType.ANDESITE.getMetadata())});
        craftMan.addRecipe(new ItemStack(Blocks.prismarine, 1, BlockPrismarine.ROUGH_META), new Object[] {"SS", "SS", 'S', Items.prismarine_shard});
        craftMan.addRecipe(new ItemStack(Blocks.prismarine, 1, BlockPrismarine.BRICKS_META), new Object[] {"SSS", "SSS", "SSS", 'S', Items.prismarine_shard});
        craftMan.addRecipe(new ItemStack(Blocks.prismarine, 1, BlockPrismarine.DARK_META), new Object[] {"SSS", "SIS", "SSS", 'S', Items.prismarine_shard, 'I', new ItemStack(Items.dye, 1, EnumDyeColor.BLACK.getDyeDamage())});
        craftMan.addRecipe(new ItemStack(Blocks.sea_lantern, 1, 0), new Object[] {"SCS", "CCC", "SCS", 'S', Items.prismarine_shard, 'C', Items.prismarine_crystals});
	
        //Recipe Armour
        for (int var2 = 0; var2 < materials1[0].length; ++var2)
        {
            Item var3 = materials1[0][var2];

            for (int var4 = 0; var4 < materials1.length - 1; ++var4)
            {
                Item var5 = materials1[var4 + 1][var2];
                craftMan.addRecipe(new ItemStack(var5), new Object[] {armourPatterns[var4], 'X', var3});
            }
        }*/
	}
}

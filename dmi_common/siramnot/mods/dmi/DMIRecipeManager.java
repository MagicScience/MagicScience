package siramnot.mods.dmi;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author SirAmNot
 * 
 */
//PLEASE DO NOT EDIT THIS CLASS!
public class DMIRecipeManager {


	public static void load() {

		//shapedRecipes();
		//shapelessRecipes();
		//smeltRecipes();
	}

	private static void shapedRecipes() {
		GameRegistry.addRecipe(new ItemStack(DMIBlockManager.aqueousBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(DMIItemManager.aqueousCrystal)); // Recipe for aqueous storage block
		GameRegistry.addRecipe(new ItemStack(DMIItemManager.scrollExample), "XYX", "YFY", "XYX", 'X', new ItemStack(DMIItemManager.aqueousCrystal), 'F', new ItemStack(Item.enchantedBook), 'Y', new ItemStack(DMIItemManager.igneousCrystal)); 
		GameRegistry.addRecipe(new ItemStack(DMIBlockManager.igneousBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(DMIItemManager.igneousCrystal));
		GameRegistry.addRecipe(new ItemStack(DMIBlockManager.consistoriumBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(DMIItemManager.consistoriumCrystal));
		GameRegistry.addRecipe(new ItemStack(DMIBlockManager.caelBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(DMIItemManager.caelCrystal));
		GameRegistry.addRecipe(new ItemStack(DMIBlockManager.magicGlass, 8), "XXX", "XFX", "XXX", 'X', new ItemStack(Block.glass), 'F', new ItemStack(DMIItemManager.igneousCrystal));
		GameRegistry.addRecipe(new ItemStack(DMIBlockManager.magicGlass, 8), "XXX", "XFX", "XXX", 'X', new ItemStack(Block.glass), 'F', new ItemStack(DMIItemManager.aqueousCrystal));
		GameRegistry.addRecipe(new ItemStack(DMIBlockManager.magicGlass, 8), "XXX", "XFX", "XXX", 'X', new ItemStack(Block.glass), 'F', new ItemStack(DMIItemManager.consistoriumCrystal));
		GameRegistry.addRecipe(new ItemStack(DMIBlockManager.magicGlass, 8), "XXX", "XFX", "XXX", 'X', new ItemStack(Block.glass), 'F', new ItemStack(DMIItemManager.caelCrystal));
	}

	private static void shapelessRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(DMIItemManager.aqueousCrystal, 9), new ItemStack(DMIBlockManager.aqueousBlock)); // Recipe for aqueous crystals from storage block
		GameRegistry.addShapelessRecipe(new ItemStack(DMIItemManager.igneousCrystal, 9), new ItemStack(DMIBlockManager.igneousBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(DMIItemManager.consistoriumCrystal, 9), new ItemStack(DMIBlockManager.consistoriumBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(DMIItemManager.caelCrystal, 9), new ItemStack(DMIBlockManager.caelBlock));
	}

	private static void smeltRecipes() {
		// Little compensation for Silk-touch users. Super complicated, but worth it :)
		//	GameRegistry.addSmelting(DMIBlockManager.aqueousOre.blockID, new ItemStack(DMIItemManager.aqueousCrystal,DMIBlockManager.aqueousOre.getQuantityDropped() * DMIBlockManager.aqueousOre.getEnchantModifier()), DMIBlockManager.aqueousOre.getXpDropped() * 2);
		//	GameRegistry.addSmelting(DMIBlockManager.igneousOre.blockID, new ItemStack(DMIItemManager.igneousCrystal,DMIBlockManager.igneousOre.getQuantityDropped() * DMIBlockManager.igneousOre.getEnchantModifier()), DMIBlockManager.igneousOre.getXpDropped() * 2);
		//    GameRegistry.addSmelting(DMIBlockManager.consistoriumOre.blockID, new ItemStack(DMIItemManager.consistoriumCrystal,DMIBlockManager.consistoriumOre.getQuantityDropped() * DMIBlockManager.consistoriumOre.getEnchantModifier()), DMIBlockManager.consistoriumOre.getXpDropped() * 2);
	}


}

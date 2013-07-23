package siramnot.mods.dmi;

import net.minecraft.item.Item;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class DMIRecipeManager {
	

	public static void load() {
		
		shapedRecipes();
		shapelessRecipes();
		smeltRecipes();
	}
	
	private static void shapedRecipes() {
		GameRegistry.addRecipe(new ItemStack(DMIBlockManager.aqueousBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(DMIItemManager.aqueousCrystal)); // Recipe for aqueous storage block
		GameRegistry.addRecipe(new ItemStack(DMIItemManager.scrollExample), "XYX", "YFY", "XYX", 'X', new ItemStack(DMIItemManager.aqueousCrystal), 'F', new ItemStack(Item.enchantedBook), 'Y', new ItemStack(DMIItemManager.igneousCrystal)); 
		GameRegistry.addRecipe(new ItemStack(DMIBlockManager.igneousBlock), "XXX", "XXX", "XXX", 'X', new ItemStack(DMIItemManager.igneousCrystal));
	}
	
	private static void shapelessRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(DMIItemManager.aqueousCrystal, 9), new ItemStack(DMIBlockManager.aqueousBlock)); // Recipe for aqueous crystals from storage block
	}
	
	private static void smeltRecipes() {
		// Little compensation for Silk-touch users. Super complicated, but worth it :)
//		GameRegistry.addSmelting(DMIBlockManager.aqueousOre.blockID, new ItemStack(DMIItemManager.aqueousCrystal,DMIBlockManager.aqueousOre.getQuantityDropped() * DMIBlockManager.aqueousOre.getEnchantModifier()), DMIBlockManager.aqueousOre.getXpDropped() * 2);
		

	}


}

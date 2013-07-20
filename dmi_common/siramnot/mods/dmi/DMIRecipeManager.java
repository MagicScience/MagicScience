package siramnot.mods.dmi;

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
	}
	
	private static void shapelessRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(DMIItemManager.aqueousCrystal, 9), new ItemStack(DMIBlockManager.aqueousBlock)); // Recipe for aqueous crystals from storage block
	}
	
	private static void smeltRecipes() {
		// Little compensation for Silk-touch users. Super complicated, but worth it :)
		GameRegistry.addSmelting(DMIBlockManager.aqueousOre.blockID, new ItemStack(DMIItemManager.aqueousCrystal,DMIBlockManager.aqueousOre.getQuantityDropped() * DMIBlockManager.aqueousOre.getEnchantModifier()), DMIBlockManager.aqueousOre.getXpDropped() * 2);
	}

}

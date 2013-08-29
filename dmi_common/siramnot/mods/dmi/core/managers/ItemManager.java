package siramnot.mods.dmi.core.managers;

import cpw.mods.fml.common.registry.LanguageRegistry;
import siramnot.mods.dmi.items.BasicScroll;
import siramnot.mods.dmi.items.EnumStaff;
import siramnot.mods.dmi.items.ItemAqueousCrystal;
import siramnot.mods.dmi.items.ItemCaelCrystal;
import siramnot.mods.dmi.items.ItemConsistoriumCrystal;
import siramnot.mods.dmi.items.ItemFoodMagicBread;
import siramnot.mods.dmi.items.ItemGem;
import siramnot.mods.dmi.items.ItemIgneousCrystal;
import siramnot.mods.dmi.items.ItemLightningStaff;
import siramnot.mods.dmi.items.ItemStaff;
import siramnot.mods.dmi.items.ScrollExample;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author JiffyJay, SirAmNot, MTH
 * 
 */
public class ItemManager {

	public static Item crystals;
	public static Item basicScroll; // By convention, objects are camelCase.
	public static Item scrollExample;
	public static Item magicBread;
	

	public static void load() {
		crystals = new ItemGem(IDManager.gems);
		
		basicScroll = new BasicScroll(IDManager.BASIC_SCROLL);
		scrollExample = new ScrollExample(IDManager.SCROLL_EXAMPLE);
		magicBread = new ItemFoodMagicBread(IDManager.MAGIC_BREAD);

		languageRegistry(LanguageRegistry.instance());
		miscRegisters();
	}

	private static void languageRegistry(LanguageRegistry lr) {
		lr.addName(scrollExample, ScrollExample.getName());
	}
	
	private static void miscRegisters() {
		((ItemFoodMagicBread) magicBread).doRegisters();
		((ItemGem) crystals).doRegisters();
	}

}

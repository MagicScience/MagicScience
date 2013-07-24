package siramnot.mods.dmi;

import cpw.mods.fml.common.registry.LanguageRegistry;
import siramnot.mods.dmi.items.BasicScroll;
import siramnot.mods.dmi.items.ItemAqueousCrystal;
import siramnot.mods.dmi.items.ItemIgneousCrystal;
import siramnot.mods.dmi.items.ItemStaff;
import siramnot.mods.dmi.items.ScrollExample;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author JiffyJay, SirAmNot, MTH
 * 
 */
public class DMIItemManager {

	public static Item aqueousCrystal;
	public static Item igneousCrystal;
	public static Item basicScroll; // By convention, objects are camelCase.
	public static Item scrollExample;
	public static ItemStaff uselessStaff;

	public static void load() {
		aqueousCrystal = new ItemAqueousCrystal(IDManager.AQUEOUS_CRYSTAL);
		igneousCrystal = new ItemIgneousCrystal(IDManager.IGNEOUS_CRYSTAL);
		basicScroll = new BasicScroll(IDManager.BASIC_SCROLL);
		scrollExample = new ScrollExample(IDManager.SCROLL_EXAMPLE);
//		uselessStaff = new ItemStaff(IDManager.BASIC_STAFF);

		languageRegistry(LanguageRegistry.instance());
	}

	private static void languageRegistry(LanguageRegistry lr) { // Added a parameter to this method to make it simpler by typing lr.(...) instead of LanguageRegistry.(...);
		lr.addName(aqueousCrystal, ItemAqueousCrystal.getName());
		lr.addName(igneousCrystal, ItemIgneousCrystal.getName());
		lr.addName(scrollExample, ScrollExample.getName());
	}

}

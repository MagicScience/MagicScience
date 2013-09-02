package siramnot.mods.dmi.core.managers;

import cpw.mods.fml.common.registry.LanguageRegistry;
import siramnot.mods.dmi.items.BasicScroll;
import siramnot.mods.dmi.items.EnumStaff;
import siramnot.mods.dmi.items.ItemFoodMagicBread;
import siramnot.mods.dmi.items.ItemGem;
import siramnot.mods.dmi.items.ItemLightningStaff;
import siramnot.mods.dmi.items.ItemStaff;
import siramnot.mods.dmi.items.ScrollExample;
import siramnot.mods.dmi.items.debug.ItemFlight;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author JiffyJay, SirAmNot, MTH, Tombenpotter
 * 
 */
public class ItemManager {

	public static Item crystals;
	public static Item basicScroll; // By convention, objects are camelCase.
	public static Item scrollExample;
	public static Item magicBread;
	public static Item debug_flight;
	

	public static void load() {
		crystals = new ItemGem(IDManager.gems);
		
		basicScroll = new BasicScroll(IDManager.BASIC_SCROLL);
		scrollExample = new ScrollExample(IDManager.SCROLL_EXAMPLE);
		magicBread = new ItemFoodMagicBread(IDManager.MAGIC_BREAD);
		debug_flight = new ItemFlight(IDManager.DEBUG_FLIGHT);

		languageRegistry(LanguageRegistry.instance());
		miscRegisters();
	}

	private static void languageRegistry(LanguageRegistry lr) {
		lr.addName(scrollExample, ScrollExample.getName());
		lr.addName(debug_flight, "CHEATZOR!");
	}
	
	private static void miscRegisters() {
		((ItemFoodMagicBread) magicBread).doRegisters();
		((ItemGem) crystals).doRegisters();
	}

}

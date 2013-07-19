package siramnot.mods.dmi;

import cpw.mods.fml.common.registry.LanguageRegistry;
import siramnot.mods.dmi.items.ItemAqueousCrystal;
import siramnot.mods.dmi.lib.IDs;
import net.minecraft.item.Item;
/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author JiffyJay, SirAmNot, MTH
 *
 */
public class DMIItemManager {
	

	public static Item aqueousCrystal;
	public static Item basicScroll; // By convention, objects are camelCase.
	
	public static void load() {
		aqueousCrystal = new ItemAqueousCrystal(IDs.AQUEOUS_CRYSTAL);
		basicScroll = new BasicScroll(IDs.BASIC_SCROLL);
		
		languageRegistry(LanguageRegistry.instance());
	}


	private static void languageRegistry(LanguageRegistry lr) {	// Added a parameter to this method to make it simpler by typing lr.(...) instead of LanguageRegistry.(...);
		lr.addNameForObject(aqueousCrystal, "", ItemAqueousCrystal.getName());
	}

}

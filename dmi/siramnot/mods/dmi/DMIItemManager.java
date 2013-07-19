package siramnot.mods.dmi;

import siramnot.mods.dmi.items.ItemAqueousCrystal;
import siramnot.mods.dmi.lib.IDS;
import net.minecraft.item.Item;

public class DMIItemManager {
	
	
	public static Item aqueousCrystal;
	
	public static void load() {
		aqueousCrystal = new ItemAqueousCrystal(IDS.AqueousCrystalID);
		
		languageRegistry();
	}

	private static void languageRegistry() {
		
	}

}

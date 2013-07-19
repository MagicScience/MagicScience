package siramnot.mods.dmi;

import siramnot.mods.dmi.items.ItemAqueousCrystal;
import siramnot.mods.dmi.lib.IDS;
import net.minecraft.item.Item;

public class DMIItemManager {
	

	public static Item aqueousCrystal;
	public static Item BasicScroll
	
	public static void load() {
		aqueousCrystal = new ItemAqueousCrystal(IDS.AqueousCrystalID);
		
		languageRegistry();
	}


        public static void load() {
        	BasicScroll = new BasicScroll(IDS.BasicScrollID);
        	
        	LanguageRegistry();
        }
	
	private static void languageRegistry() {
		
		
		
		
	}

}

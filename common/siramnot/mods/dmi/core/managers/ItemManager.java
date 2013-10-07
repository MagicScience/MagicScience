package siramnot.mods.dmi.core.managers;


import cpw.mods.fml.common.registry.LanguageRegistry;
import siramnot.mods.dmi.items.BasicScroll;
import siramnot.mods.dmi.items.ItemFoodMagicBread;
import siramnot.mods.dmi.items.ItemGem;
import siramnot.mods.dmi.items.ItemRainController;
import siramnot.mods.dmi.items.ScrollExample;
import siramnot.mods.dmi.items.Staff;
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
public class ItemManager implements IDManager
{
	
	public static Item	crystals;
	public static Item	foodMagicBread;
	public static Item	debug_flight;
	public static Item	boom_staff;
	public static Item	lightning_staff;
	public static Item	fire_staff;
	public static Item 	stop_rain;
	
	public static void load()
	{
		crystals = new ItemGem(gems);
		foodMagicBread = new ItemFoodMagicBread(magicBread);
		debug_flight = new ItemFlight(flightItem);
		boom_staff = new Staff.ExplodingStaff(tntStaff);
		lightning_staff = new Staff.LightningStaff(stormStaff);
		fire_staff = new Staff.FireStaff(flameStaff);
		stop_rain = new ItemRainController(stopRain);
		
		languageRegistry(LanguageRegistry.instance());
		miscRegisters();
	}
	
	private static void languageRegistry(LanguageRegistry lr)
	{
		lr.addName(debug_flight, "CHEATZOR!");
		lr.addName(boom_staff, "Staff of Explosion");
		lr.addName(lightning_staff, "Staff of Lightning");
		lr.addName(fire_staff, "Staff of Fire");
		lr.addName(stop_rain, "Stop Rain");
	}
	
	private static void miscRegisters()
	{
		((ItemFoodMagicBread) foodMagicBread).doRegisters();
		((ItemGem) crystals).doRegisters();
	}
	
}

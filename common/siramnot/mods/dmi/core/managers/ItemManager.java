package siramnot.mods.dmi.core.managers;


import net.minecraft.item.*;
import siramnot.mods.dmi.items.*;
import siramnot.mods.dmi.items.debug.*;
import cpw.mods.fml.common.registry.*;


/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author JiffyJay, SirAmNot, MTH, Tombenpotter
 * 
 */
public class ItemManager
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
		crystals = new ItemGem(IDManager.gems);
		foodMagicBread = new ItemFoodMagicBread(IDManager.magicBread);
		debug_flight = new ItemFlight(IDManager.flightItem);
		boom_staff = new Staff.ExplodingStaff(IDManager.tntStaff);
		lightning_staff = new Staff.LightningStaff(IDManager.stormStaff);
		fire_staff = new Staff.FireStaff(IDManager.flameStaff);
		stop_rain = new ItemRainController(IDManager.stopRain);
		
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

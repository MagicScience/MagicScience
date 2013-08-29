package siramnot.mods.dmi.core.managers;

import java.io.File;

import siramnot.mods.dmi.DMI;

import net.minecraftforge.common.Configuration;

/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * 
 * @author SirAmNot
 * 
 */
public class ConfigManager {

	private static final String CATEGORY = "Dominus ex Magica et Machina";

	public static boolean doWorldGen;
	public static boolean doOreGen;
	public static boolean doStructureGen;
	public static boolean isModEnabled;

	private static String modid = DMI.MOD_ID.toUpperCase();

	private static final String[] ERR = new String[] { "You managed to do something to error world-related stuff.",
		"You managed to do something to error block-related stuff.",
		"You managed to do something to error item-related stuff.",
		"You managed to cause an unknown error. Try reinstalling the mod to fix this."
	};

	private static final int ERR_WORLD = 0;
	private static final int ERR_BLOCK = 1;
	private static final int ERR_ITEM = 2;
	private static final int ERR_OTHER = 3;

	public static void init(File file) {
		// Creates configuration file, if doesn't already exist
		Configuration cfg = new Configuration(file);

		// Load configuration file
		cfg.load();

		{
			load(cfg);
		}

		// Save configuration file
		cfg.save();
	}

	private static void load(Configuration cfg) {
		doWorldStuff(cfg);
		doItemStuff(cfg);
		isModEnabled = cfg.get(cfg.CATEGORY_GENERAL, modid + "_enableMod", true).getBoolean(true); // Enable or disable the mod.
	}

	private static void doWorldStuff(Configuration cfg) {
		try { // This is just in case. To help debug crashes and stuff

			doWorldGen = cfg.get(CATEGORY, modid + "_worldGen", true).getBoolean(true); // Enable world generation
			doOreGen = cfg.get(CATEGORY, modid + "_oreGen", true).getBoolean(true); // Enable ore generation
			doStructureGen = cfg.get(CATEGORY, modid + "_structureGen", true).getBoolean(true); // Enable structure generation

			if (!doWorldGen) {
				doOreGen = false;
				doStructureGen = false;
			}

		} catch (Exception e) { // Catch exceptions, print them. We need the log to help you
			System.err.println(ERR[ERR_WORLD]);
			e.printStackTrace();
		}
	}
	
	private static void doItemStuff(Configuration cfg) {
		
	}

}

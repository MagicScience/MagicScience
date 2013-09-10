package siramnot.mods.dmi.core.managers;

import java.io.File;
import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;

/**
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class ConfigManager {

	private static short startBlockID;

	private static File file;
	private static Configuration cfg;

	private static HashMap<String, Integer> blocks;
	private static HashMap<String, Integer> items;

	public ConfigManager(File file) {
		this.file = file;
		this.cfg = new Configuration(file);

		blocks = new HashMap<String, Integer>();
		items = new HashMap<String, Integer>();

		startBlockID = 1400;

		this.cfg.load();
	}

	public void read(Configuration cfg) {
		readBlocks();

		for (ItemNames name : ItemNames.value()) {

		}
	}

	private void readBlocks() {
		for (BlockNames name : BlockNames.values()) {
			int blockID = cfg.getBlock(name.getUnlocalizedName(), startBlockID++).getInt();
			blocks.put(name.getUnlocalizedName(), blockID);
		}
	}

	/**
	 * Reads an ItemID from the HashMap
	 * 
	 * @param key
	 *            The key index to read from
	 * @return ItemID
	 */
	public static int getItemID(String key) {
		if (!items.containsKey(key)) {
			return 0;
		}
		return items.get(key);
	}

	/**
	 * Reads a BlockID from the HashMap
	 * 
	 * @param key
	 *            The key index to read from
	 * @return BlockID
	 */
	public static int getBlockID(String key) {
		if (!blocks.containsKey(key))
			return 0;
		return blocks.get(key);
	}

	public static File getConfigFile() {
		return file;
	}

	public static Configuration getConfig() {
		return cfg;
	}

}

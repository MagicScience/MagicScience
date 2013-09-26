package siramnot.mods.dmi;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;

/**
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class BlockRegistry implements IReference {
	// List of blocks that are loaded
	static List<Block> blocks;
	
	public static void registerBlock(Block block, String name) {
		if (block == null) { return; }
		
		LanguageRegistry.instance().addName(block, name);
		GameRegistry.registerBlock(block, name);
		
		addToBlockList(block.blockID, block);
	}
	
	private static void addToBlockList(int index, Block element) {
		blocks.add(index, element);
	}
	
}

package siramnot.mods.dmi;

import net.minecraft.block.Block;
import siramnot.mods.dmi.blocks.BlockDMIOres;
import siramnot.mods.dmi.blocks.BlockLiquidator;
import siramnot.mods.dmi.blocks.BlockMagicGlass;
import siramnot.mods.dmi.blocks.TileEntityWorkStationBlock;
import siramnot.mods.dmi.blocks.tileeents.TileEntityLiquidator;
import siramnot.mods.dmi.blocks.tileeents.TileEntityWorkStationBlockEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * 
 * @author SirAmNot, Jay
 * 
 */
public class DMIBlockManager {

	//Blocks
	public static Block liquidator;
	public static Block workStation;
	public static Block ores;
	public static Block magicGlass;

	// Load the blocks
	public static void load() {
		// workStation = new TileEntityWorkStationBlock(IDManager.WORK_STATION); Doesn't work
		liquidator = new BlockLiquidator(IDManager.LIQUIDATOR, false);
		//		workStation = new BlockWorkstation(IDManager.WORK_STATION_BLOCK);
		workStation = new TileEntityWorkStationBlock(IDManager.WORK_STATION_BLOCK);
		ores = new BlockDMIOres(IDManager.ORES);
		magicGlass = new BlockMagicGlass(IDManager.MAGIC_GLASS);

		languageRegistry(LanguageRegistry.instance());
		gameRegistry();

		BlockDMIOres.doRegisters();
	}

	// Register the blocks, gives them mod-unique names
	private static void gameRegistry() {
		GameRegistry.registerBlock(liquidator, "Liquidator");
		GameRegistry.registerBlock(workStation, "Work Station");
		GameRegistry.registerBlock(magicGlass, "Elemental Glass");

		GameRegistry.registerTileEntity(TileEntityLiquidator.class, "Tile Entity Liquidator");
		GameRegistry.registerTileEntity(TileEntityWorkStationBlockEntity.class, "Tile Entity Workstation");

	}

	// Name the blocks in-game
	private static void languageRegistry(LanguageRegistry lr) {
		lr.addName(liquidator, "Liquidator");
		lr.addName(workStation, "Work Station");

		lr.addName(magicGlass, "Elemental Glass");
	}
}

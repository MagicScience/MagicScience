package siramnot.mods.dmi.core.managers;

import net.minecraft.block.Block;
import siramnot.mods.dmi.blocks.BlockDMICrystals;
import siramnot.mods.dmi.blocks.BlockDMIOres;
import siramnot.mods.dmi.blocks.BlockInfuser;
import siramnot.mods.dmi.blocks.BlockLiquidator;
import siramnot.mods.dmi.blocks.BlockMagicGlass;
import siramnot.mods.dmi.blocks.BlockWorkstation;
import siramnot.mods.dmi.blocks.tileeents.TileEntityInfuser;
import siramnot.mods.dmi.blocks.tileeents.TileEntityLiquidator;
import siramnot.mods.dmi.blocks.tileeents.TileEntityWorkStation;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot, JiffyJay
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class BlockManager {

	//Blocks
	public static Block liquidator;
	public static Block workStation;
	public static Block ores;
	public static Block crystals;
	public static Block magicGlass;
	public static Block infuserCore;

	// Load the blocks
	public static void load() {
		// workStation = new TileEntityWorkStationBlock(IDManager.WORK_STATION); Doesn't work
		liquidator = new BlockLiquidator(IDManager.liquidator, false);
		workStation = new BlockWorkstation(IDManager.workstation);
		infuserCore = new BlockInfuser(IDManager.infuserCore);
		
		ores = new BlockDMIOres(IDManager.ores);
		crystals = new BlockDMICrystals(IDManager.oreStorage);
		magicGlass = new BlockMagicGlass(IDManager.magicGlass);

		languageRegistry(LanguageRegistry.instance());
		gameRegistry();

		BlockDMIOres.doRegisters();
		BlockDMICrystals.doRegisters();
	}

	// Register the blocks, gives them mod-unique names
	private static void gameRegistry() {
		GameRegistry.registerBlock(liquidator, "Liquidator");
		GameRegistry.registerBlock(workStation, "Work Station");
		GameRegistry.registerBlock(infuserCore, "Infuser Core");
		GameRegistry.registerBlock(magicGlass, "Elemental Glass");

		GameRegistry.registerTileEntity(TileEntityLiquidator.class, "blockEntityLiquidator");
		GameRegistry.registerTileEntity(TileEntityWorkStation.class, "blockEntityWorkstation");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "blockEntityInfuser");
	}

	// Name the blocks in-game
	private static void languageRegistry(LanguageRegistry lr) {
		lr.addName(liquidator, "Liquidator");
		lr.addName(workStation, "Work Station");

		lr.addName(magicGlass, "Elemental Glass");
	}
}

package siramnot.mods.dmi.core.managers;

import net.minecraft.block.Block;
import siramnot.mods.dmi.blocks.BlockDMICrystals;
import siramnot.mods.dmi.blocks.BlockDMIOres;
import siramnot.mods.dmi.blocks.BlockInfuser;
import siramnot.mods.dmi.blocks.BlockLiquidator;
import siramnot.mods.dmi.blocks.BlockMagicGlass;
import siramnot.mods.dmi.blocks.BlockWorkstation;
import siramnot.mods.dmi.blocks.liquids.BlockDMIFluid;
import siramnot.mods.dmi.entity.tile.TileEntityInfuser;
import siramnot.mods.dmi.entity.tile.TileEntityLiquidator;
import siramnot.mods.dmi.entity.tile.TileEntityWorkstation;
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
//	public static Block magicWater;

	// Load the blocks
	public static void load() {
		liquidator = new BlockLiquidator(IDManager.liquidator, false);
		workStation = new BlockWorkstation(IDManager.workstation);
		infuserCore = new BlockInfuser(IDManager.infuserCore);
		
		ores = new BlockDMIOres(IDManager.ores);
		crystals = new BlockDMICrystals(IDManager.oreStorage);
		magicGlass = new BlockMagicGlass(IDManager.magicGlass);
		
//		magicWater = new BlockDMIFluid(IDManager.fluids, 0);

		languageRegistry(LanguageRegistry.instance());
		gameRegistry();
		miscRegisters();
	}

	// Register the blocks, gives them mod-unique names
	private static void gameRegistry() {
		GameRegistry.registerBlock(liquidator, "Liquidator");
		GameRegistry.registerBlock(workStation, "Work Station");
		GameRegistry.registerBlock(infuserCore, "Infuser Core");
		GameRegistry.registerBlock(magicGlass, "Elemental Glass");
//		GameRegistry.registerBlock(magicWater, "Magic Water");

		GameRegistry.registerTileEntity(TileEntityLiquidator.class, "blockEntityLiquidator");
		GameRegistry.registerTileEntity(TileEntityWorkstation.class, "blockEntityWorkstation");
		GameRegistry.registerTileEntity(TileEntityInfuser.class, "blockEntityInfuser");
	}

	// Name the blocks in-game
	private static void languageRegistry(LanguageRegistry lr) {
		lr.addName(liquidator, "Liquidator");
		lr.addName(workStation, "Work Station");
//		lr.addName(((BlockDMIFluid)magicWater).getAsItemStack(), "Magic Water");

		lr.addName(magicGlass, "Elemental Glass");
	}
	
	private static void miscRegisters() {
		BlockDMIOres.doRegisters();
		BlockDMICrystals.doRegisters();
	}
}

package siramnot.mods.dmi;

import net.minecraft.block.Block;
import siramnot.mods.dmi.blocks.BlockAqueousCrystal;
import siramnot.mods.dmi.blocks.BlockAqueousCrystalOre;
import siramnot.mods.dmi.blocks.BlockLiquidator;
import siramnot.mods.dmi.blocks.tileeents.TileEntityLiquidator;
import siramnot.mods.dmi.lib.IDManager;
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
	
	public static BlockAqueousCrystalOre aqueousOre;
	public static Block aqueousBlock;	
	
	// Load the blocks
	public static void load() {
//		workStation = new TileEntityWorkStationBlock(IDManager.WORK_STATION); Doesn't work
		liquidator = new BlockLiquidator(IDManager.LIQUIDATOR, false);
		
		aqueousOre = new BlockAqueousCrystalOre(IDManager.AQUEOUS_CRYSTAL_ORE);
		aqueousBlock = new BlockAqueousCrystal(IDManager.AQUEOUS_CRYSTAL_BLOCK);
		
		
		languageRegistry(LanguageRegistry.instance());
		gameRegistry();
		
	}

	// Register the blocks, gives them mod-unique names
	private static void gameRegistry() {
		GameRegistry.registerBlock(aqueousOre, "Aqueous Ore");
		GameRegistry.registerBlock(aqueousBlock, "Aqueous Crystal Block");
		GameRegistry.registerBlock(liquidator, "Liquidator");
		
		GameRegistry.registerTileEntity(TileEntityLiquidator.class, "Tile Entity Liquidator");
	}

	// Name the blocks in-game
	private static void languageRegistry(LanguageRegistry lr) {
		lr.addName(aqueousOre, "Aqueous Ore");
		lr.addName(aqueousBlock, "Aqueous Block");
		
		lr.addName(liquidator, "Liquidator");
	}
}

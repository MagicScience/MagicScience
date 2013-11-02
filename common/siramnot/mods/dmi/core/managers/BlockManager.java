package siramnot.mods.dmi.core.managers;


import net.minecraft.block.*;
import siramnot.mods.dmi.blocks.*;
import siramnot.mods.dmi.entity.tile.*;
import cpw.mods.fml.common.registry.*;


/**
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot, JiffyJay
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class BlockManager
{
	
	//Blocks
	public static Block	liquidator;
	public static Block	workStation;
	public static Block	ores;
	public static Block	crystals;
	public static Block	magicGlass;
	public static Block	infuserCore;
	public static Block	battery;
	
	// Load the blocks
	public static void load()
	{
		liquidator = new BlockLiquidator(IDManager.liquidator, false);
		workStation = new BlockWorkstation(IDManager.workstation);
//		infuserCore = new BlockInfuser(IDManager.infuserCore);
		ores = new BlockDMIOres(IDManager.ores);
		crystals = new BlockDMICrystals(IDManager.oreStorage);
		magicGlass = new BlockMagicGlass(IDManager.magicGlass);
		battery = new BlockBattery(IDManager.blockBattery);
		
		languageRegistry(LanguageRegistry.instance());
		gameRegistry();
		miscRegisters();
	}
	
	// Register the blocks, gives them mod-unique names
	private static void gameRegistry()
	{
		GameRegistry.registerBlock(liquidator, liquidator.getUnlocalizedName());
		GameRegistry.registerBlock(workStation, workStation.getUnlocalizedName());
//		GameRegistry.registerBlock(infuserCore, infuserCore.getUnlocalizedName());
		GameRegistry.registerBlock(magicGlass, magicGlass.getUnlocalizedName());
		GameRegistry.registerBlock(battery, battery.getUnlocalizedName());
		
		GameRegistry.registerTileEntity(TileEntityLiquidator.class, liquidator.getUnlocalizedName());
		GameRegistry.registerTileEntity(TileEntityWorkstation.class, workStation.getUnlocalizedName());
//		GameRegistry.registerTileEntity(TileEntityInfuser.class, infuserCore.getUnlocalizedName());
		GameRegistry.registerTileEntity(TileEntityBatteryBlock.class, battery.getUnlocalizedName());
	}
	
	// Name the blocks in-game
	private static void languageRegistry(LanguageRegistry lr)
	{
		lr.addName(liquidator, "Liquidator");
		lr.addName(workStation, "Work Station");
		lr.addName(battery, "Battery Block");
		
		lr.addName(magicGlass, "Elemental Glass");
	}
	
	private static void miscRegisters()
	{
		BlockDMIOres.doRegisters();
		BlockDMICrystals.doRegisters();
	}
}

package siramnot.mods.dmi.core.managers;


import java.util.ArrayList;
import java.util.List;


/**
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot, Tombenpotter
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class IDManager
{
	public static int	blocksStartID	= 1400;
	public static int nextBlock() // Returns the next available block ID
	{
		return blocksStartID++;
	}
	
	public static int	itemsStartID	= 14000;
	public static int nextItem() // Returns the next available item ID
	{
		return itemsStartID++;
	}
	
	// Blocks
	public static int	liquidator		= nextBlock();
	public static int	workstation		= nextBlock();
	public static int	ores			= nextBlock();
	public static int	oreStorage		= nextBlock();
	public static int	infuserCore		= nextBlock();
	public static int	fluids			= nextBlock();
	public static int	magicGlass		= nextBlock();
	public static int	blockBattery	= nextBlock();
	
	// Items
	public static int	gems			= nextItem();
	public static int	magicBread		= nextItem();
	public static int	flightItem		= nextItem();
	public static int	tntStaff		= nextItem();
	public static int	stormStaff		= nextItem();
	public static int	flameStaff		= nextItem();
	public static int	stopRain		= nextItem();
	
}

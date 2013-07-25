
package siramnot.mods.dmi.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.DMIBlockManager;
import siramnot.mods.dmi.DMIItemManager;
/**
 * 
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author SirAmNot
 *
 */
public class BlockAqueousCrystalOre extends DMIOre {

	private static String path = "aqueousCrystalOre";
	private static ItemStack drop = new ItemStack(DMIItemManager.aqueousCrystal);
	
	public BlockAqueousCrystalOre(int id) {
		super(id);
	}

	public String setTexture() {
		return path;
	}

	public ItemStack setDropped() {
		return drop;
	}
}

package siramnot.mods.dmi.blocks;

import siramnot.mods.dmi.DMIItemManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockConsistoriumCrystalOre extends DMIOre {

	private String path = "consistoriumCrystalOre";
	private ItemStack drop = new ItemStack(DMIItemManager.consistoriumCrystal);
	
	public BlockConsistoriumCrystalOre(int id) {
		super(id);
	}
	
	public String setTexture() {
		return path;
	}

	public ItemStack setDropped() {
		return drop;
	}
}

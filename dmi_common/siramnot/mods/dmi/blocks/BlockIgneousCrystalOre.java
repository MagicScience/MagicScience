package siramnot.mods.dmi.blocks;

import siramnot.mods.dmi.DMIItemManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockIgneousCrystalOre extends DMIOre {

	private String path = "igneousCrystalOre";
	private ItemStack drop = new ItemStack(DMIItemManager.igneousCrystal);
	
	public BlockIgneousCrystalOre(int id) {
		super(id);
	}

	public String setTexture() {
		return path;
	}

	public ItemStack setDropped() {
		return drop;
	}
}
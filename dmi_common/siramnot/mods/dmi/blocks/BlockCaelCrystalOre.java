package siramnot.mods.dmi.blocks;

import siramnot.mods.dmi.DMIItemManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockCaelCrystalOre extends DMIOre {

	private String path = "caelCrystalOre";
	private ItemStack drop = new ItemStack(DMIItemManager.caelCrystal);
	
	public BlockCaelCrystalOre(int id) {
		super(id);
	}
	
	public String setTexture() {
		return path;
	}

	public ItemStack setDropped() {
		return drop;
	}
}

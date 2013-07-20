package siramnot.mods.dmi.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.DMIBlockManager;
import siramnot.mods.dmi.DMIItemManager;

public class BlockAqueousCrystalOre extends DMIOre {
	private ItemStack toDrop;
	private int randomDrops;

	public BlockAqueousCrystalOre(int id) {
		super(id);
		
		// Method to call methods
		main(); 
	}

	private void main() {
		setXpDropped(4);
		setEnchantability(2);
	}
	
	protected void updateOnMine() {
		randomDrops = super.random.nextInt(3) + 2;
		toDrop = new ItemStack(DMIItemManager.aqueousCrystal, randomDrops);
		setDrop(toDrop);
	}

	protected String setTexture() {
		return "aqueousCrystalOre";
	}

	protected CreativeTabs setCreativeTab() {
		return DMI.TAB_CREATIVE;
	}

	protected int setHarvestLevel() {
		return 2;
	}
	
	protected int fortune(int meta, int fortune, Random random) {
		return randomDrops + (getEnchantModifier() * fortune);
	}
}

package siramnot.mods.dmi.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import siramnot.mods.dmi.DMI;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockDMICrystals extends Block {

	public static BlockDMICrystals dmiCrystal;

	private static final int WATER_ORE = 0;
	private static final int EARTH_ORE = 1;
	private static final int FIRE_ORE = 2;
	private static final int AIR_ORE = 3;

	private static final String UNLOCALIZED_NAME = "dmiCrytals";
	private static final String TEXTURE_PREFIX = DMI.MOD_ID + ":";
	private static final float HARDNESS = 1.7f;

	private static final String[] NAMES = new String[] {
		"Aqueous Crystal Block",
		"Terran Crystal Block",
		"Igneous Crystal Block",
		"Aereous Crystal Block"
	};

	private static final String[] TEXTURE_ARRAY = new String[] {

	};

	public BlockDMICrystals(int id) {
		super(id, Material.iron);
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.setHardness(HARDNESS);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 1);

		dmiCrystal = this;
	}

	public static void doRegisters() {
		GameRegistry.registerBlock(dmiCrystal, ItemBlockDMICrystals.class, UNLOCALIZED_NAME);
		for (int meta = 0; meta < NAMES.length; ++meta) {
			ItemStack item = new ItemStack(dmiCrystal, 1, meta);
			LanguageRegistry.instance().addName(item, NAMES[meta]);
		}
	}

	private static class ItemBlockDMICrystals extends ItemBlock {


		public ItemBlockDMICrystals(int id) {
			super(id);
		}

	}
}
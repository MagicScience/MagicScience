package siramnot.mods.dmi.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.DMIItemManager;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author SirAmNot
 * @license Maybe GPLv3
 * 
 */

public class BlockDMIOres extends Block {

	public static BlockDMIOres dmiOre;

	private static final int WATER_ORE = 0;
	private static final int EARTH_ORE = 1;
	private static final int FIRE_ORE = 2;
	private static final int AIR_ORE = 3;

	private static final String UNLOCALIZED_NAME = "dmiOres";
	private static final String TEXTURE_PREFIX = DMI.MOD_ID + ":";
	private static final float HARDNESS = 3.0f;
	private static final int XP_DROPPED = 4;


	private static final String[] NAMES = new String[] {
		"Aqueous Ore", // Water ore
		"Terran Ore", // Earth ore 
		"Igneous Ore", // Fire ore
		"Aereous Ore" // Air ore
	};

	private static final Item[] DROPS = new Item[] {
		DMIItemManager.aqueousCrystal, // Water ore
		DMIItemManager.consistoriumCrystal, // Earth ore
		DMIItemManager.igneousCrystal, // Fire ore
		Item.arrow
		// Air ore {-placeholder-}
	};

	private static final String[] TEXTURE_ARRAY = new String[] {
		ItemBlockDMIOres.getName(WATER_ORE), // Water
		ItemBlockDMIOres.getName(EARTH_ORE), // Earth
		ItemBlockDMIOres.getName(FIRE_ORE), // Fire
		ItemBlockDMIOres.getName(AIR_ORE)
		// Air
	};

	private static Icon[] iconArray;

	// Costructor
	public BlockDMIOres(int id) {
		super(id, Material.rock);
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.setHardness(HARDNESS);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 2);

		dmiOre = this;
	}

	// Game registry things and similar
	public static void doRegisters() {
		GameRegistry.registerBlock(dmiOre, ItemBlockDMIOres.class, UNLOCALIZED_NAME, DMI.MOD_ID);
		for (int meta = 0; meta < NAMES.length; ++meta) {
			ItemStack item = new ItemStack(dmiOre, 1, meta);
			LanguageRegistry.instance().addName(item, NAMES[meta]);
		}
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
		for (int i = 0; i < world.playerEntities.size(); ++i) {
			Entity entity = (Entity) world.playerEntities.get(i);
			if (entity instanceof EntityPlayer) {
				if (((EntityPlayer) entity).capabilities.isCreativeMode) {
					return;
				}
			}
		}
		this.dropXpOnBlockBreak(world, x, y, z, XP_DROPPED);
	}

	// Determines damage dropped
	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	// Determines what is dropped
	@Override
	public int idDropped(int meta, Random random, int id) {
		return DROPS[meta].itemID;
	}

	// Amount to drop
	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		int drop = 1 + random.nextInt(3);
		if (fortune == 0) {
			return drop;
		}

		return drop * (fortune + 1);
	}

	// Register icons
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		iconArray = new Icon[TEXTURE_ARRAY.length];

		for (int i = 0; i < TEXTURE_ARRAY.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon(TEXTURE_PREFIX + TEXTURE_ARRAY[i]);
		}
	}

	// Set icons
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return iconArray[meta];
	}

	// Register creative tabs for all of the sub-blocks
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int meta, CreativeTabs tab, List list) {
		for (int i = 0; i < NAMES.length; ++i) {
			list.add(new ItemStack(this, 1, i));
		}
	}

	public static class ItemBlockDMIOres extends ItemBlock {

		private static final String[] PRIVATE_NAMES = new String[] {
			"aqueousCrystalOre", // Water ore
			"terranCrystalOre", // Earth ore
			"igneousCrystalOre", // Fire ore
			"aereousCrystalOre" // Air ore
		};

		private static Icon[] iconArray;

		public ItemBlockDMIOres(int id) {
			super(id);
			this.setHasSubtypes(true);
		}

		@Override
		public String getUnlocalizedName(ItemStack item) {
			return this.getUnlocalizedName() + "." + PRIVATE_NAMES[item.getItemDamage()];
		}

		@Override
		public int getMetadata(int meta) {
			return meta;
		}

		public static String getName(int loc) {
			return PRIVATE_NAMES[loc];
		}

	}
}

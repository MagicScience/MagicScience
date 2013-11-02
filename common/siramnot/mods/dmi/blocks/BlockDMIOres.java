package siramnot.mods.dmi.blocks;


import java.util.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import siramnot.mods.dmi.*;
import siramnot.mods.dmi.core.*;
import siramnot.mods.dmi.core.managers.*;
import siramnot.mods.dmi.items.*;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.relauncher.*;


/**
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class BlockDMIOres extends Block
{
	
	public static BlockDMIOres			dmiOre;
	
	private static final int			WATER_ORE			= 0;
	private static final int			EARTH_ORE			= 1;
	private static final int			FIRE_ORE			= 2;
	private static final int			AIR_ORE				= 3;
	
	private static final String			UNLOCALIZED_NAME	= "dmiOres";
	private static final float			HARDNESS			= 3.0f;
	private static final int			XP_DROPPED			= 4;
	
	private static final String[]		NAMES				= new String[]
															{
						"Aqueous Ore", // Water ore
						"Terran Ore", // Earth ore 
						"Igneous Ore", // Fire ore
						"Aereous Ore" // Air ore
															};
	
	private static final ItemStack[]	DROPS				= new ItemStack[]
															{
						((ItemGem) ItemManager.crystals).getSubItem(0, 1),
						((ItemGem) ItemManager.crystals).getSubItem(1, 1),
						((ItemGem) ItemManager.crystals).getSubItem(2, 1),
						((ItemGem) ItemManager.crystals).getSubItem(3, 1),
															};
	
	private static final String[]		TEXTURE_ARRAY		= new String[]
															{
						ItemBlockDMIOres.getName(WATER_ORE), // Water
						ItemBlockDMIOres.getName(EARTH_ORE), // Earth
						ItemBlockDMIOres.getName(FIRE_ORE), // Fire
						ItemBlockDMIOres.getName(AIR_ORE) // Air
															};
	
	private static Icon[]				iconArray;
	
	// Constructor
	public BlockDMIOres(int id)
	{
		super(id, Material.rock);
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.setHardness(HARDNESS);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 2);
		
		dmiOre = this;
	}
	
	// Game registry things and similar
	public static void doRegisters()
	{
		try
		{
			GameRegistry.registerBlock(dmiOre, ItemBlockDMIOres.class, UNLOCALIZED_NAME, Reference.MOD_ID);
			for (int meta = 0; meta < NAMES.length; ++meta)
			{
				ItemStack item = new ItemStack(dmiOre, 1, meta);
				LanguageRegistry.instance().addName(item, NAMES[meta]);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta)
	{
		for (int i = 0; i < world.playerEntities.size(); ++i)
		{
			Entity entity = (Entity) world.playerEntities.get(i);
			if (entity instanceof EntityPlayer)
			{
				if (((EntityPlayer) entity).capabilities.isCreativeMode)
				{
					return;
				}
			}
		}
		this.dropXpOnBlockBreak(world, x, y, z, XP_DROPPED);
	}
	
	// Determines damage dropped
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	
	// Determines what is dropped
	@Override
	public int idDropped(int meta, Random random, int id)
	{
		return DROPS[meta].itemID;
//		return 1;
	}
	
	// Amount to drop
	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		int drop = 1 + random.nextInt(3);
		if (fortune == 0)
		{
			return drop;
		}
		
		return drop * (fortune + 1);
	}
	
	// Register icons
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		iconArray = new Icon[TEXTURE_ARRAY.length];
		
		for (int i = 0; i < TEXTURE_ARRAY.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(Reference.BLOCK_TEXTURE_LOCATION + TEXTURE_ARRAY[i]);
		}
	}
	
	// Set icons
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		return iconArray[meta];
	}
	
	// Register creative tabs for all of the sub-blocks
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int meta, CreativeTabs tab, List list)
	{
		for (int i = 0; i < NAMES.length; ++i)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	public static class ItemBlockDMIOres extends ItemBlock
	{
		
		private static final String[]	PRIVATE_NAMES	= new String[]
														{
																			"aqueousCrystalOre", // Water ore
																			"terranCrystalOre", // Earth ore
																			"igneousCrystalOre", // Fire ore
																			"aereousCrystalOre" // Air ore
														};
		
		public ItemBlockDMIOres(int id)
		{
			super(id);
			this.setHasSubtypes(true);
		}
		
		@Override
		public String getUnlocalizedName(ItemStack item)
		{
			return this.getUnlocalizedName() + "." + PRIVATE_NAMES[item.getItemDamage()];
		}
		
		@Override
		public int getMetadata(int meta)
		{
			return meta;
		}
		
		public static String getName(int loc)
		{
			return PRIVATE_NAMES[loc];
		}
	}
}

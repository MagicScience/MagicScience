package siramnot.mods.dmi.blocks;


import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import siramnot.mods.dmi.*;
import siramnot.mods.dmi.core.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


/**
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class BlockDMICrystals extends Block
{
	
	public static BlockDMICrystals	dmiCrystals;
	
	public static final int			WATER_ORE			= 0;
	public static final int			EARTH_ORE			= 1;
	public static final int			FIRE_ORE			= 2;
	public static final int			AIR_ORE				= 3;
	
	private static final String		UNLOCALIZED_NAME	= "dmiCrytals";
	private static final float		HARDNESS			= 1.7f;
	
	private static Icon[]			iconArray;
	
	private static final String[]	NAMES				= new String[] { "Aqueous Crystal Block", "Terreous Crystal Block", "Igneous Crystal Block", "Aereous Crystal Block"  };
	private static final String[]	TEXTURE_ARRAY		= new String[] {
						ItemBlockDMICrystals.getName(WATER_ORE),	// Water
						ItemBlockDMICrystals.getName(EARTH_ORE),	// Earth
						ItemBlockDMICrystals.getName(FIRE_ORE),		// Fire
						ItemBlockDMICrystals.getName(AIR_ORE)		// Air 
					};
	
	// Constructor
	public BlockDMICrystals(int id)
	{
		super(id, Material.iron);
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.setHardness(HARDNESS);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 1);
		
		dmiCrystals = this;
	}
	
	// Registry stuff 
	public static void doRegisters()
	{
		GameRegistry.registerBlock(dmiCrystals, ItemBlockDMICrystals.class, UNLOCALIZED_NAME, Reference.MOD_ID);
		for (int meta = 0; meta < NAMES.length; ++meta)
		{
			ItemStack item = new ItemStack(dmiCrystals, 1, meta);
			LanguageRegistry.instance().addName(item, NAMES[meta]);
		}
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		return iconArray[meta];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int meta, CreativeTabs tab, List list)
	{
		for (int i = 0; i < NAMES.length; ++i)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}
	
	public static class ItemBlockDMICrystals extends ItemBlock
	{
		
		private static final String[]	PRIVATE_NAMES	= new String[]
														{
																			"aqueousCrystalBlock", // Water ore 
																			"terranCrystalBlock", // Earth ore
																			"igneousCrystalBlock", // Fire ore 
																			"aereousCrystalBlock" // Air ore 
														};
		
		public ItemBlockDMICrystals(int id)
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

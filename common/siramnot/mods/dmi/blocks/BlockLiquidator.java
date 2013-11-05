package siramnot.mods.dmi.blocks;


import java.util.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import siramnot.mods.dmi.*;
import siramnot.mods.dmi.core.*;
import siramnot.mods.dmi.core.managers.*;
import siramnot.mods.dmi.entity.tile.*;
import cpw.mods.fml.relauncher.*;


public class BlockLiquidator extends BlockContainer
{
	private final Random		furnaceRand	= new Random();
	
	private final boolean		isActive;
	
	public static final String	NAME		= "liquidator";
	public static final float	HARDNESS	= 4.0f;
	
	private static boolean		keepFurnaceInventory;
	@SideOnly(Side.CLIENT)
	private Icon				furnaceIconTop;
	@SideOnly(Side.CLIENT)
	private Icon				furnaceIconFront;
	
	public BlockLiquidator(int par1, boolean par2)
	{
		super(par1, Material.rock);
		this.isActive = par2;
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.setHardness(HARDNESS);
		MinecraftForge.getBlockHarvestLevel(this, 0, "pickaxe");
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if (!world.isRemote)
		{
			player.openGui(DMI.instance, GuiHandler.LIQUIDATOR_ID, world, x, y, z);
		}
		return true;
	}
	
	@Override
	public void registerIcons(IconRegister ir)
	{
		this.blockIcon = ir.registerIcon(Reference.BLOCK_TEXTURE_LOCATION);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityLiquidator();
	}
}

package siramnot.mods.dmi.blocks;


import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import siramnot.mods.dmi.*;
import cpw.mods.fml.relauncher.*;

/**
 * 
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 *
 */
public class BlockBattery extends BlockContainer
{
	private EntityPlayer	placer;
	private boolean debug = false;
	
	public BlockBattery(int id)
	{
		super(id, Material.iron);
		setUnlocalizedName("battery");
		setCreativeTab(DMI.TAB_CREATIVE);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityBatteryBlock(null);
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int meta)
	{
		return meta;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
	{
		if (entity instanceof EntityPlayer)
		{
			placer = (EntityPlayer) entity;
		}
		else
		{
			world.setBlock(x, y, z, 0);
		}
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		return false;
	}
	
}

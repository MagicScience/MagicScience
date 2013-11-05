package siramnot.mods.dmi.blocks;


import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import siramnot.mods.dmi.*;
import siramnot.mods.dmi.core.Reference.ChatFormat;
import siramnot.mods.dmi.core.managers.*;
import siramnot.mods.dmi.entity.tile.*;


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
	private boolean			debug	= false;
	
	public BlockBattery(int id)
	{
		super(id, Material.iron);
		setUnlocalizedName("battery");
		setCreativeTab(DMI.TAB_CREATIVE);
		blockBounds();
	}
	
	private void blockBounds()
	{
		float minX = 0.3f, maxX = 0.7f;
		float minY = 0.0f, maxY = 0.95f;
		float minZ = 0.3f, maxZ = 0.7f;
		setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityBatteryBlock(null);
	}
	
	@Override
	public int getRenderType()
	{
		return -2;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
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
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int sideHit, float hitX, float hitY, float hitZ)
	{
		if (player.isSneaking())
		{
			return false;
		}
		
		player.openGui(DMI.instance, GuiHandler.BATTERY_BLOCK_ID, world, x, y, z);
		return true;
	}

}

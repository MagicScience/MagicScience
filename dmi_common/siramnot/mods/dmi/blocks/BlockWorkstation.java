package siramnot.mods.dmi.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.blocks.tileeents.TileEntityWorkStation;
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
public class BlockWorkstation extends BlockContainer {
	// vars and consts
	private static final float[] BOUNDS = new float[] {
			0.0f, 0.0f, 0.0f, 1.0f, 0.94f, 1.0f
		// 0.94f
	};

	private static final int MIN_X = 0, MIN_Y = 1, MIN_Z = 2, MAX_X = 3, MAX_Y = 4, MAX_Z = 5;

	// constructor
	public BlockWorkstation(int id) {
		super(id, Material.iron);
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.setBlockBounds(BOUNDS[MIN_X], BOUNDS[MIN_Y], BOUNDS[MIN_Z], BOUNDS[MAX_X], BOUNDS[MAX_Y], BOUNDS[MAX_Z]);
	}

	// Adds the TileEntity thing
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWorkStation();
	}

	// Render type; -2 for us.
	@Override
	public int getRenderType() {
		int renderType = -2;
		return renderType;
	}

	// Self explanatory. Not a cube hence false
	@Override
	public boolean isOpaqueCube() {
		boolean tof = false;
		return tof;
	}

	// Not a normal block. Don't render as one.
	@Override
	public boolean renderAsNormalBlock() {
		boolean tof = false;
		return tof;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack) {
		final int check = 1;
		boolean noAirOver = !(world.isAirBlock(x, y + check, z));
		boolean airUnder = world.isAirBlock(x, y - check, z);

		final int north = 2;
		final int south = 0;
		final int east = 3;
		final int west = 1;

		int facing = MathHelper.floor_double(((entityLiving.rotationYaw * 4.0F) / 360.0F) + 0.5D) & 3;

		switch (facing) {
		case north:
			this.setFacing(world, x, y, z, north);
			break;
		case south:
			this.setFacing(world, x, y, z, south);
			break;
		case east:
			this.setFacing(world, x, y, z, east);
			break;
		case west:
			this.setFacing(world, x, y, z, west);
			break;
		}
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		final int check = 1;
		final boolean tof = (world.isAirBlock(x, y + check, z) && world.doesBlockHaveSolidTopSurface(x, y - check, z) ? true : false);

		return tof;
	}

	private void setFacing(World world, int x, int y, int z, int initDir) {
		final int i = 2;
		final int dir_count = 3;
		final int invert_dir = 2;

		final int dir = (initDir + invert_dir) & dir_count;
		world.setBlockMetadataWithNotify(x, y, z, dir, i);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		String dir = "items/workstation";
		this.blockIcon = icon.registerIcon(DMI.MOD_ID + ":" + dir);
	}

}

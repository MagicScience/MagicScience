package siramnot.mods.dmi.blocks;

import java.util.Random;

import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.DMIItemManager;
import siramnot.mods.dmi.blocks.tileeents.TileEntityLiquidator;
import siramnot.mods.dmi.blocks.tileeents.TileEntityWorkStationBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockWorkstation extends BlockContainer {

	private static final String NAME = "test";
	private static final String TEXTUREPATH = NAME;
	private static final StepSound SOUND = Block.soundStoneFootstep;
	private static final float HARDNESS = 3.0F;
	private static final int XP_DROP = 4;
	private static final int ENCHANT_MODIFIER = 2;

	public BlockWorkstation(int par1) {
		super(par1, Material.rock);
		setCreativeTab(DMI.TAB_CREATIVE);
		setStepSound(SOUND);
		setHardness(HARDNESS);
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}


	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType()
	{
		return -2;
	}

	/**
	 * Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
	{
		int rotation = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 2.5D) & 3;
		world.setBlock(i, j, k, this.blockID, rotation-1, 2);
	}

	public TileEntity createNewTileEntity(World par1World)
	{
		return new TileEntityWorkStationBlockEntity();
	}
	public void registerIcons(IconRegister ir) {
	}

}
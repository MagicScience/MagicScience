package siramnot.mods.dmi.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import siramnot.mods.dmi.DMI;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMagicGlass extends Block {

	public BlockMagicGlass(int id) {
		super(id, Material.glass);
	}

	private static final String NAME = "magicGlassBlock";
	private static final String TEXTURELOCATION = DMI.MOD_ID + ":" + NAME;
	private static final float HARDNESS = 0.3F;
	private static final StepSound SOUND = Block.soundGlassFootstep;

	private Icon[] icons = new Icon[16];
	private boolean shouldRenderSelectionBox = true;
	protected String folder;
	private int renderPass;

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		// If you put 0, the block will be totally transparent (you won't see it at all).
		// If you put 1, the block will be semi-transparent

		return 0;
	}

	{
		this.setHardness(HARDNESS);
		this.setStepSound(SOUND);
		this.setUnlocalizedName(NAME);
		this.setCreativeTab(DMI.TAB_CREATIVE);

	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	/**
	 * This is checked to see if the texture should connect to this block
	 * 
	 * @param par2
	 *            x
	 * @param par3
	 *            y
	 * @param par4
	 *            z
	 * @param par5
	 *            ID this block is asking to connect to (may be 0 if there is no
	 *            block)
	 * @param par6
	 *            Metadata of the block this block is trying to connect to
	 * @return true if should connect
	 */
	public boolean shouldConnectToBlock(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5, int par6) {
		return par5 == this.blockID;
	}

	@Override
	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		return this.getConnectedBlockTexture(par1IBlockAccess, par2, par3, par4, par5, this.icons);
	}

	public Icon getConnectedBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5, Icon[] icons) {
		boolean isOpenUp = false, isOpenDown = false, isOpenLeft = false, isOpenRight = false;

		switch (par5) {
		case 0:
			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
				isOpenDown = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
				isOpenUp = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
				isOpenLeft = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
				return icons[15];
			} else if (isOpenUp && isOpenDown && isOpenLeft) {
				return icons[11];
			} else if (isOpenUp && isOpenDown && isOpenRight) {
				return icons[12];
			} else if (isOpenUp && isOpenLeft && isOpenRight) {
				return icons[13];
			} else if (isOpenDown && isOpenLeft && isOpenRight) {
				return icons[14];
			} else if (isOpenDown && isOpenUp) {
				return icons[5];
			} else if (isOpenLeft && isOpenRight) {
				return icons[6];
			} else if (isOpenDown && isOpenLeft) {
				return icons[8];
			} else if (isOpenDown && isOpenRight) {
				return icons[10];
			} else if (isOpenUp && isOpenLeft) {
				return icons[7];
			} else if (isOpenUp && isOpenRight) {
				return icons[9];
			} else if (isOpenDown) {
				return icons[3];
			} else if (isOpenUp) {
				return icons[4];
			} else if (isOpenLeft) {
				return icons[2];
			} else if (isOpenRight) {
				return icons[1];
			}
			break;
		case 1:
			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
				isOpenDown = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
				isOpenUp = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
				isOpenLeft = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
				return icons[15];
			} else if (isOpenUp && isOpenDown && isOpenLeft) {
				return icons[11];
			} else if (isOpenUp && isOpenDown && isOpenRight) {
				return icons[12];
			} else if (isOpenUp && isOpenLeft && isOpenRight) {
				return icons[13];
			} else if (isOpenDown && isOpenLeft && isOpenRight) {
				return icons[14];
			} else if (isOpenDown && isOpenUp) {
				return icons[5];
			} else if (isOpenLeft && isOpenRight) {
				return icons[6];
			} else if (isOpenDown && isOpenLeft) {
				return icons[8];
			} else if (isOpenDown && isOpenRight) {
				return icons[10];
			} else if (isOpenUp && isOpenLeft) {
				return icons[7];
			} else if (isOpenUp && isOpenRight) {
				return icons[9];
			} else if (isOpenDown) {
				return icons[3];
			} else if (isOpenUp) {
				return icons[4];
			} else if (isOpenLeft) {
				return icons[2];
			} else if (isOpenRight) {
				return icons[1];
			}
			break;
		case 2:
			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
				isOpenDown = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
				isOpenUp = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
				isOpenLeft = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
				return icons[15];
			} else if (isOpenUp && isOpenDown && isOpenLeft) {
				return icons[13];
			} else if (isOpenUp && isOpenDown && isOpenRight) {
				return icons[14];
			} else if (isOpenUp && isOpenLeft && isOpenRight) {
				return icons[11];
			} else if (isOpenDown && isOpenLeft && isOpenRight) {
				return icons[12];
			} else if (isOpenDown && isOpenUp) {
				return icons[6];
			} else if (isOpenLeft && isOpenRight) {
				return icons[5];
			} else if (isOpenDown && isOpenLeft) {
				return icons[9];
			} else if (isOpenDown && isOpenRight) {
				return icons[10];
			} else if (isOpenUp && isOpenLeft) {
				return icons[7];
			} else if (isOpenUp && isOpenRight) {
				return icons[8];
			} else if (isOpenDown) {
				return icons[1];
			} else if (isOpenUp) {
				return icons[2];
			} else if (isOpenLeft) {
				return icons[4];
			} else if (isOpenRight) {
				return icons[3];
			}
			break;
		case 3:
			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
				isOpenDown = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
				isOpenUp = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
				isOpenLeft = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
				return icons[15];
			} else if (isOpenUp && isOpenDown && isOpenLeft) {
				return icons[14];
			} else if (isOpenUp && isOpenDown && isOpenRight) {
				return icons[13];
			} else if (isOpenUp && isOpenLeft && isOpenRight) {
				return icons[11];
			} else if (isOpenDown && isOpenLeft && isOpenRight) {
				return icons[12];
			} else if (isOpenDown && isOpenUp) {
				return icons[6];
			} else if (isOpenLeft && isOpenRight) {
				return icons[5];
			} else if (isOpenDown && isOpenLeft) {
				return icons[10];
			} else if (isOpenDown && isOpenRight) {
				return icons[9];
			} else if (isOpenUp && isOpenLeft) {
				return icons[8];
			} else if (isOpenUp && isOpenRight) {
				return icons[7];
			} else if (isOpenDown) {
				return icons[1];
			} else if (isOpenUp) {
				return icons[2];
			} else if (isOpenLeft) {
				return icons[3];
			} else if (isOpenRight) {
				return icons[4];
			}
			break;
		case 4:
			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
				isOpenDown = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
				isOpenUp = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
				isOpenLeft = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
				return icons[15];
			} else if (isOpenUp && isOpenDown && isOpenLeft) {
				return icons[14];
			} else if (isOpenUp && isOpenDown && isOpenRight) {
				return icons[13];
			} else if (isOpenUp && isOpenLeft && isOpenRight) {
				return icons[11];
			} else if (isOpenDown && isOpenLeft && isOpenRight) {
				return icons[12];
			} else if (isOpenDown && isOpenUp) {
				return icons[6];
			} else if (isOpenLeft && isOpenRight) {
				return icons[5];
			} else if (isOpenDown && isOpenLeft) {
				return icons[10];
			} else if (isOpenDown && isOpenRight) {
				return icons[9];
			} else if (isOpenUp && isOpenLeft) {
				return icons[8];
			} else if (isOpenUp && isOpenRight) {
				return icons[7];
			} else if (isOpenDown) {
				return icons[1];
			} else if (isOpenUp) {
				return icons[2];
			} else if (isOpenLeft) {
				return icons[3];
			} else if (isOpenRight) {
				return icons[4];
			}
			break;
		case 5:
			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
				isOpenDown = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
				isOpenUp = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
				isOpenLeft = true;
			}

			if (this.shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
				isOpenRight = true;
			}

			if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
				return icons[15];
			} else if (isOpenUp && isOpenDown && isOpenLeft) {
				return icons[13];
			} else if (isOpenUp && isOpenDown && isOpenRight) {
				return icons[14];
			} else if (isOpenUp && isOpenLeft && isOpenRight) {
				return icons[11];
			} else if (isOpenDown && isOpenLeft && isOpenRight) {
				return icons[12];
			} else if (isOpenDown && isOpenUp) {
				return icons[6];
			} else if (isOpenLeft && isOpenRight) {
				return icons[5];
			} else if (isOpenDown && isOpenLeft) {
				return icons[9];
			} else if (isOpenDown && isOpenRight) {
				return icons[10];
			} else if (isOpenUp && isOpenLeft) {
				return icons[7];
			} else if (isOpenUp && isOpenRight) {
				return icons[8];
			} else if (isOpenDown) {
				return icons[1];
			} else if (isOpenUp) {
				return icons[2];
			} else if (isOpenLeft) {
				return icons[4];
			} else if (isOpenRight) {
				return icons[3];
			}
			break;
		}

		return icons[0];
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		int i1 = par1IBlockAccess.getBlockId(par2, par3, par4);
		return i1 == this.blockID ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		return this.icons[0];
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		if (this.shouldRenderSelectionBox) {
			return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
		} else {
			return AxisAlignedBB.getAABBPool().getAABB(0D, 0D, 0D, 0D, 0D, 0D);
		}
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.icons[0] = par1IconRegister.registerIcon("dmi:glass/glass");
		this.icons[1] = par1IconRegister.registerIcon("dmi:glass/glass_1_d");
		this.icons[2] = par1IconRegister.registerIcon("dmi:glass/glass_1_u");
		this.icons[3] = par1IconRegister.registerIcon("dmi:glass/glass_1_l");
		this.icons[4] = par1IconRegister.registerIcon("dmi:glass/glass_1_r");
		this.icons[5] = par1IconRegister.registerIcon("dmi:glass/glass_2_h");
		this.icons[6] = par1IconRegister.registerIcon("dmi:glass/glass_2_v");
		this.icons[7] = par1IconRegister.registerIcon("dmi:glass/glass_2_dl");
		this.icons[8] = par1IconRegister.registerIcon("dmi:glass/glass_2_dr");
		this.icons[9] = par1IconRegister.registerIcon("dmi:glass/glass_2_ul");
		this.icons[10] = par1IconRegister.registerIcon("dmi:glass/glass_2_ur");
		this.icons[11] = par1IconRegister.registerIcon("dmi:glass/glass_3_d");
		this.icons[12] = par1IconRegister.registerIcon("dmi:glass/glass_3_u");
		this.icons[13] = par1IconRegister.registerIcon("dmi:glass/glass_3_l");
		this.icons[14] = par1IconRegister.registerIcon("dmi:glass/glass_3_r");
		this.icons[15] = par1IconRegister.registerIcon("dmi:glass/glass_4");
	}

	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return true;
	}

}

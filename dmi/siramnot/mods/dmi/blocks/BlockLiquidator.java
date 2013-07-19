package siramnot.mods.dmi.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.blocks.tileeents.TileEntityLiquidator;
import siramnot.mods.dmi.gui.ContainerLiquidator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockLiquidator extends BlockContainer
{
	/**
	 * Is the random generator used by furnace to drop the inventory contents in random directions.
	 */
	private final Random furnaceRand = new Random();

	/** True if this is an active furnace, false if idle */
	private final boolean isActive;
	
	public static final String NAME = "liquidator";
	public static final String TEXTUREPATH = DMI.MOD_ID + ":" + NAME;

	/**
	 * This flag is used to prevent the furnace inventory to be dropped upon block removal, is used internally when the
	 * furnace block changes from idle to active and vice-versa.
	 */
	private static boolean keepFurnaceInventory;
	@SideOnly(Side.CLIENT)
	private Icon furnaceIconTop;
	@SideOnly(Side.CLIENT)
	private Icon furnaceIconFront;

	public BlockLiquidator(int par1, boolean par2)
	{
		super(par1, Material.rock);
		this.isActive = par2;
		setUnlocalizedName(NAME);
		setCreativeTab(DMI.TAB_CREATIVE);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer ep, int par6, float par7, float par8, float par9) {
		if(!world.isRemote){
			TileEntityLiquidator merchantBlock =    (TileEntityLiquidator)world.getBlockTileEntity(x, y, z);
			ep.openGui(DMI.instance, 0, world, x, y, z);
		}
		return true;
	}
	
	public void registerIcons(IconRegister ir) {
		this.blockIcon = ir.registerIcon(TEXTUREPATH);
	}



	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TileEntityLiquidator();
	}
}

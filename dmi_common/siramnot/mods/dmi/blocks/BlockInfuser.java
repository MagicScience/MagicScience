package siramnot.mods.dmi.blocks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.blocks.tileeents.TileEntityInfuser;
import siramnot.mods.dmi.core.managers.GuiHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class BlockInfuser extends BlockContainer {

	private TileEntityInfuser te; // The TileEntity for this block

	public BlockInfuser(int id) {
		super(id, Material.iron);
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.setUnlocalizedName("infuserCore");
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		TileEntity te_at = world.getBlockTileEntity(x, y, z);
		if (te_at != null) {
			System.out.printf("There already is a TileEntity @[x=%d;y=%d;z=%d]\nGetting it insted.\n", x, y, z);
			te = (TileEntityInfuser) ((te_at instanceof TileEntityInfuser) ? te_at : null);
			if (te == null) return;
		}
		this.createNewTileEntity(world);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float j, float k, float l) {
		/*if (player.isSneaking())
			return false;

		if (!te.getValidation()) {
			if (te.checkFormation())
				player.addChatMessage("Infuser succesfully created!");
		}*/

//		if (te.getValidation()) {
//		}
		
		player.openGui(DMI.instance, GuiHandler.INFUSER_ID, world, x, y, z);
		return true;
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
		TileEntityInfuser te = (TileEntityInfuser) world.getBlockTileEntity(x, y, z);
		if (te == null) {
			System.out.println("Killed a null " + this.getClass().getSimpleName());
			return;
		}
		te.unValidate();
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		te = new TileEntityInfuser();
		return te;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		String ul = this.getUnlocalizedName(); 
		String loc = ul.substring(ul.indexOf('t'), ul.indexOf('.'));
		this.blockIcon = icon.registerIcon(DMI.MOD_ID + ":" + loc);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int id) {
		te.unValidate();
	}
	

}

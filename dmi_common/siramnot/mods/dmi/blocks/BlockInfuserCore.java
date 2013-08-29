package siramnot.mods.dmi.blocks;

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
public class BlockInfuserCore extends BlockContainer {

	public BlockInfuserCore(int id) {
		super(id, Material.iron);
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.setUnlocalizedName("infuserCore");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float j, float k, float l) {
		if (player.isSneaking()) return false;
		
		TileEntityInfuser te = (TileEntityInfuser) world.getBlockTileEntity(x, y, z);
		if (te != null) {
			if (!te.getValidation() && te.checkFormation()) {
				player.addChatMessage("Infuser succesfully created!");
			}
			
			if (te.getValidation()) {
				player.openGui(DMI.instance, GuiHandler.INFUSER_ID, world, x, y, z);
			}
		}
		
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityInfuser();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		this.blockIcon = icon.registerIcon(DMI.MOD_ID + ":" + this.getUnlocalizedName());
	}

}

package siramnot.mods.dmi.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.blocks.tileeents.TileEntityWorkStationBlockEntity;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013.
 * 
 * 
 * @author SirAmNot
 * 
 */
public class TileEntityWorkStationBlock extends BlockContainer {
	// vars and consts
	
	// constructor
	public TileEntityWorkStationBlock(int id) {
		super(id, Material.iron);
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.1f, 0.1f);
	}

	// Adds the TileEntity thing
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityWorkStationBlockEntity();
	}
	
	// Render type; -1 for us.
	public int getRenderType() {
		return -1;
	}
	
	// Self explanatory. Not a cube hence false
	public boolean isOpaqueCube() {
		return false;
	}
	
	// Not a normal block. Don't render as one.
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	// Icon when block is in hand
	public void registerIcons(IconRegister ir) {
		this.blockIcon = ir.registerIcon("dmi:Ignore this");
	}

}

package siramnot.mods.dmi.blocks.liquids;

import siramnot.mods.dmi.DMI;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluidClassic;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * UNDER HEAVY WIP
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class BlockDMIFluid extends BlockFluidClassic {

	public static final int MAGIC_LIQUID = 0;
	private static int[] colors = new int[] { 0xB8F500 };
	private int meta;
	
	public BlockDMIFluid(int id, int meta) {
		this(id, meta, MaterialDMIFluid.instance());
	}
	
	public BlockDMIFluid(int id, int meta, Material material) {
		super(id, material);
		
		this.meta = meta;
		this.setCreativeTab(DMI.TAB_CREATIVE);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor() {
		return colors[meta];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		return (side != 0 && side != 1) ?super.theIcon[0] : super.theIcon[1];
	}
	
	
	public ItemStack getAsItemStack() {
		return new ItemStack(this.blockID, 1, 0);
	}
	
}

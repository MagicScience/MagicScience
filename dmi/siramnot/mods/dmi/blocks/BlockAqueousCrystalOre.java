package siramnot.mods.dmi.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import siramnot.mods.dmi.DMI;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockAqueousCrystalOre extends Block {

	public static final String NAME = "aqueousCrystalOre";
	public static final String TEXTURELOCATION = DMI.MOD_ID+":" + NAME;
	public static final float HARDNESS = 1.5F;
	public static final StepSound SOUND = Block.soundGlassFootstep;
	
	public BlockAqueousCrystalOre(int id) {
		super(id,Material.rock);
			
		setHardness(HARDNESS);
		setStepSound(SOUND);
		setUnlocalizedName(NAME);
		setCreativeTab(DMI.TAB_CREATIVE);
	}
	
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir)
	{
			this.blockIcon = ir.registerIcon(TEXTURELOCATION);
	}

}

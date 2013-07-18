package siramnot.mods.dmi.blocks;

import siramnot.mods.dmi.DMI;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockLiquidator extends Block {
	
	public static final String NAME = "liquidator";
	public static final String TEXTURELOCATION = DMI.MOD_ID+":" + NAME;
	public static final float HARDNESS = 1.5F;
	public static final StepSound SOUND = Block.soundGlassFootstep;

	public BlockLiquidator(int par1) {
		super(par1, Material.iron);
		setCreativeTab(DMI.TAB_CREATIVE);
		setHardness(HARDNESS);
		setStepSound(SOUND);
		setUnlocalizedName(NAME);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		player.openGui(DMI.instance, 0, world, x, y, z);
		
		
		return true;
	}

}

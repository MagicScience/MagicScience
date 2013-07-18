package siramnot.mods.dmi.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;

public class BlockAqueousCrystalOre extends DMIBlocks {

	public static final String NAME = "aqueousCrystalOre";
	public static final float HARDNESS = 1.5F;
	public static final StepSound SOUND = Block.soundGlassFootstep;
	
	public BlockAqueousCrystalOre(int id) {
		super(id,Material.rock);
		
		setHardness(HARDNESS);
		setStepSound(SOUND);
		setUnlocalizedName(NAME);
	}

}

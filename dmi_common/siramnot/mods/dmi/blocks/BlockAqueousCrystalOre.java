package siramnot.mods.dmi.blocks;

/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author JiffyJay, SirAmNot
 *
 */
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.DMIItemManager;
import siramnot.mods.dmi.lib.IDs;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.common.MinecraftForge;

public class BlockAqueousCrystalOre extends Block {

	private static final String NAME = "aqueousCrystalOre";
	private static final String TEXTURELOCATION = DMI.MOD_ID + ":" + NAME;
	private static final float HARDNESS = 3.0F;
	private static final int ITEM_DROPPED = DMIItemManager.aqueousCrystal.itemID;
	private static final StepSound SOUND = Block.soundGlassFootstep;

	public BlockAqueousCrystalOre(int id) {
		super(id, Material.rock);

		setHardness(HARDNESS);
		setStepSound(SOUND);
		setUnlocalizedName(NAME);
		setCreativeTab(DMI.TAB_CREATIVE);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 2);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		this.blockIcon = ir.registerIcon(TEXTURELOCATION);
	}

	public int idDropped(int meta, Random random, int fortune) {
		return ITEM_DROPPED;
	}

	public int quantityDropped(int meta, int fortune, Random random) {
		return random.nextInt(2) + 2;
	}

}

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
import siramnot.mods.dmi.lib.IDManager;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class BlockAqueousCrystalOre extends Block {

	private static final String NAME = "aqueousCrystalOre";
	private static final String TEXTURELOCATION = DMI.MOD_ID + ":" + NAME;
	private static final StepSound SOUND = Block.soundStoneFootstep;
	private static final float HARDNESS = 3.0F;
	private static final int ITEM_DROPPED = DMIItemManager.aqueousCrystal.itemID;
	private static final int XP_DROP = 4;
	
	private static final int ENCHANT_MODIFIER = 2;
	private static int ITEM_DROP;

	public BlockAqueousCrystalOre(int id) {
		super(id, Material.rock);

		setHardness(HARDNESS);
		setStepSound(SOUND);
		setUnlocalizedName(NAME);
		setCreativeTab(DMI.TAB_CREATIVE);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 2);
		
		ITEM_DROP = new Random().nextInt(2) + 2;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		this.blockIcon = ir.registerIcon(TEXTURELOCATION);
	}

	public int idDropped(int meta, Random random, int fortune) {
		return ITEM_DROPPED;
	}

	public int quantityDropped(int meta, int fortune, Random random) {
		int dropRate = ITEM_DROP;
		int dropped = dropRate + (ENCHANT_MODIFIER * fortune);

		return dropped;
	}

	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
		this.dropXpOnBlockBreak(par1World, par2, par3, par4, XP_DROP);
	}
	
	public static float getXpDropped() {
		return XP_DROP;
	}
	
	public static int getQuantityDropped() {
		return ITEM_DROP;
	}
	
	public static int getEnchantModifier() {
		return ENCHANT_MODIFIER;
	}

}

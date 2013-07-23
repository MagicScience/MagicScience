package siramnot.mods.dmi.blocks;

import java.util.Random;

import siramnot.mods.dmi.DMI;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

/**
 * 
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author SirAmNot
 * 
 */
public abstract class DMIOre extends Block {
	private int itemDropped;
	private int dropOffset;
	private int amountDropped;
	private String textureName;

	private int enchantModifier;
	private StepSound sound;
	private float hardness;
	private int xpDropped;
	private Random random;
	
	public DMIOre(int id) {
		super(id, Material.rock);

		sound = Block.soundStoneFootstep;
		random = new Random();
		enchantModifier = 2;
		hardness = 3.0f;
		xpDropped = 4;
		amountDropped = 3;
		
		load();
	}

	private void load() {
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 2);
		setHardness(hardness);
		setStepSound(sound);
		setCreativeTab(DMI.TAB_CREATIVE);
	}

	public abstract String setTexture();
	public abstract ItemStack setDropped();
	
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		textureName = setTexture();
		this.blockIcon = ir.registerIcon(DMI.MOD_ID + ":" + textureName);
	}

	public final void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l) {
		dropXpOnBlockBreak(world, i, j, k, l);
		amountDropped = random.nextInt(3) + 2;
	}
	
	public int idDropped(int id, Random random, int meta) {
		itemDropped = setDropped().itemID;
		return itemDropped;
	}
	
	public int quantityDropped(int meta, int fortune, Random random) {
		return amountDropped;
	}
	
}
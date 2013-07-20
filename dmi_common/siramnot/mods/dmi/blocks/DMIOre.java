package siramnot.mods.dmi.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import siramnot.mods.dmi.DMI;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author SirAmNot
 */
public abstract class DMIOre extends Block {
	/**
	 * Name of the sprite and the unlocalized name
	 */
	private String NAME;
	private String TEXTURELOCATION;
	private float hardness;
	private int itemDropped;
	private StepSound sound = Block.soundStoneFootstep;

	private static int enchantModifier;
	private static int dropQuantity;
	private static int xpDropped;
	
	protected static Random random;

	/**
	 * You'd want to invoke the superconstructor unless you want to override all
	 * the methods in this class
	 * 
	 * @param id
	 *            BlockID for the ore
	 */
	public DMIOre(int id) {
		super(id, Material.rock);

		random = new Random();
		
		load();
	}

	// Abstract methods
	/**
	 * Sets the ore's texture
	 * 
	 * @return The sprite's name
	 */
	protected abstract String setTexture();

	/**
	 * Sets the ore's creative tab
	 * 
	 * @return The creative tab to use
	 */
	protected abstract CreativeTabs setCreativeTab();

	/**
	 * Sets the lowest tier pickaxe required to use
	 * @usage
	 * 0 is Wood;
	 * 1 is Stone;
	 * 2 is Iron;
	 * 3 is Diamond
	 * 
	 * @return Effective pickaxe for use
	 */
	protected abstract int setHarvestLevel();
	/**
	 * update method
	 */
	protected abstract void updateOnMine();

	// DO NOT OVERRIDE THEESE!
	@Deprecated
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		this.blockIcon = ir.registerIcon(TEXTURELOCATION);
	}

	@Deprecated
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
		dropXpOnBlockBreak(par1World, par2, par3, par4, xpDropped);
	}

	@Deprecated
	public int idDropped(int meta, Random random, int fortune) {
		return itemDropped;
	}

	@Deprecated
	public int quantityDropped(int meta, int fortune, Random random) {
		updateOnMine();
		if (fortune >= 1)
			return fortune(meta, fortune, random);
		return dropQuantity;
	}

	private void load() {
		NAME = setTexture();
		TEXTURELOCATION = DMI.MOD_ID.toLowerCase() + ":" + NAME;

		hardness = 3.0f;
		itemDropped = this.blockID;

		xpDropped = 0;
		enchantModifier = 1;
		dropQuantity = 1;
		
		super.setCreativeTab(this.setCreativeTab());
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", this.setHarvestLevel());
		setHardness(hardness);
	}

	// Setters

	/**
	 * Changes the ore's sound
	 * 
	 * @param sound
	 *            The new sound to use for the ore
	 */
	protected void setSound(StepSound sound) {
		this.sound = sound;
	}

	/**
	 * Sets the ore's hardness
	 * 
	 * @param hardness
	 *            New hardness level
	 */
	protected void setOreHardness(float hardness) {
		this.hardness = hardness;
	}

	/**
	 * Changes the ore's dropped item
	 * 
	 * @param is
	 *            Dropped ItemStack when breaked
	 */
	protected void setDrop(ItemStack is) {
		int itemID = is.itemID;
		this.itemDropped = itemID;

		int amount = is.stackSize;
		this.dropQuantity = amount;
	}

	/**
	 * Changes the amount of xp dropped on break
	 * 
	 * @param xp
	 *            Amount of xp to drop
	 */
	protected void setXpDropped(int xp) {
		this.xpDropped = xp;
	}

	/**
	 * Sets effectiveness of fortune
	 * 
	 * @param amount
	 *            That^
	 */
	protected void setEnchantability(int amount) {
		this.enchantModifier = amount;
	}

	// others

	protected int fortune(int meta, int fortune, Random random) {
		return 0;
	}

	// Getters
	public static float getXpDropped() {
		return xpDropped;
	}

	public static int getQuantityDropped() {
		return dropQuantity;
	}

	public static int getEnchantModifier() {
		return enchantModifier;
	}
}

package siramnot.mods.dmi.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.DMIItemManager;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author SirAmNot
 */
public abstract class DMIOre extends Block {

	private final String NAME;
	private final String TEXTURELOCATION;
	private StepSound sound = Block.soundStoneFootstep;
	private float hardness;
	private int itemDropped;
	private static int xpDropped;

	private int enchantModifier;
	private int dropQuantity;

	public DMIOre(int id) {
		super(id, Material.rock);
		NAME = setTexture();
		TEXTURELOCATION = DMI.MOD_ID.toLowerCase() + ":" + NAME;

		hardness = 3.0f;
		itemDropped = this.blockID;
		xpDropped = 0;

		enchantModifier = 1;
		dropQuantity = 1;
	}

	/**
	 * Sets the ore's texture
	 * 
	 * @return The sprite's name
	 */
	protected abstract String setTexture();

	@Deprecated
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		this.blockIcon = ir.registerIcon(TEXTURELOCATION);
	}

	/**
	 * 
	 */
	@Deprecated
	public void onBlockDestroyedByPlayer() {

	}

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
	 * @param item
	 *            The new item the ore drops
	 */
	protected void setDroppedItem(Item item) {
		int itemID = item.itemID;
		this.itemDropped = itemID;
	}

	protected void setXpDropped(int xp) {

	}

	public static float getXpDropped() {
		return xpDropped;
	}

	public static int getQuantityDropped() {
		return itemDropped;
	}

	public static int getEnchantModifier() {
		return ENCHANT_MODIFIER;
	}
}

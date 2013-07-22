package siramnot.mods.dmi.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
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
	private ItemStack itemDropped;
	private EntityPlayer player;
	private String textureName;
	private int dropOffset;

	private int enchantModifier;
	private StepSound sound;
	private float hardness;
	private int xpDropped;
	
	public DMIOre(int id) {
		super(id, Material.rock);

		sound = Block.soundStoneFootstep;
		enchantModifier = 2;
		hardness = 3.0f;
		xpDropped = 4;

		load();
	}

	private void load() {
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 2);
		setHardness(hardness);
		setStepSound(sound);
	}

	public abstract String setTexture();
	public abstract ItemStack setDropped();
	public abstract int setDropOffset();
	

	public final void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l) {
		if (player.capabilities.isCreativeMode)
			return;
		dropXpOnBlockBreak(world, i, j, k, l);
		
	}
	
	public int idDropped(int id, Random random, int meta) {
		return setDropped().itemID;
	}
	
	public int quantityDropped(int meta, int fortune, Random random) {
		return 0;
	}
	
 	public final float getPlayerRelativeBlockHardness(EntityPlayer player, World world, int i, int j, int k) {
		this.player = player;
		return super.getPlayerRelativeBlockHardness(player, world, i, j, k);
	}

}
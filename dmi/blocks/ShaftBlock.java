package siramnot.mods.dmi.blocks;

import siramnot.mods.dmi.DMI;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * This classes are Devteam-exclusive.
 * 
 * @author SirAmNot
 * 
 */
public abstract class ShaftBlock extends Block {

	public ShaftBlock(int id, Material material) {
		super(id, material);
		this.setCreativeTab(DMI.TAB_CREATIVE); // Set creative tab for all blocks
		this.setHardness(1.5F); // Sets default hardness
		this.setResistance(10.0F); // Sets default resistance
		this.setStepSound(super.soundMetalFootstep); // Sets default step sound
		
		setName();
	}
	
	private void setName() {
		this.setUnlocalizedName(getName());
	}
	
	protected abstract String getName();

}

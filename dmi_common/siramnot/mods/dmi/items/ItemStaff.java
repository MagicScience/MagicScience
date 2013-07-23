package siramnot.mods.dmi.items;

import siramnot.mods.dmi.DMI;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
/**
 * 
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author SirAmNot
 *
 */
public class ItemStaff extends Item {

	private static final String U_NAME = "itemStaff";
	private static final String NAME = "Staff";
	private static final String PATH = "basicStaff";
	private static final String TEXTUREPATH = DMI.MOD_ID.toLowerCase() + ":" + PATH; 
	private static final int MAX_STACK_SIZE = 1;
	
	public ItemStaff(int id) {
		super(id);
		setUnlocalizedName(U_NAME);
		setMaxStackSize(MAX_STACK_SIZE);
	}
	
}

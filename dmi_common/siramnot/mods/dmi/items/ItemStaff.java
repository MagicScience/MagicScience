package siramnot.mods.dmi.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import siramnot.mods.dmi.DMI;

/**
 * 
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author SirAmNot
 * 
 */
public class ItemStaff extends Item {

	protected static String unlocalizedName;
	protected static String inGameName;
	protected static String textureName;
	protected static String texturePath;
	protected static int stackSize;
	
	protected int durability;

	public ItemStaff(int id, EnumStaff etm) {
		super(id);
		unlocalizedName = "itemStaff";
		inGameName = "Staff";
		textureName = "basicStaff";
		texturePath = DMI.MOD_ID.toLowerCase() + ":" + textureName;
		stackSize = 1;
		
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		return itemStack;
	}
	
	public static String getName() {
		return inGameName;
	}

}

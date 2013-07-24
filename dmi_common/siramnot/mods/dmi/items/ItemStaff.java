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

	protected String inGameName;
	protected String unlocalizedName;
	protected String textureName;
	protected String texturePath;
	protected int stackSize;
	protected EnumStaff es;
	private static int subclassCount = 0;


	public ItemStaff(int id, EnumStaff es) {
		super(id);
		unlocalizedName = "itemStaff";
		inGameName = "Staff";
		textureName = "basicStaff";
		texturePath = DMI.MOD_ID.toLowerCase() + ":" + textureName;
		stackSize = 1;

		this.es = es;
	}

	protected void isSubclass() {
		subclassCount++;
	}

	private void load() {
		setCreativeTab(DMI.TAB_CREATIVE);
		setMaxDamage(es.getDurability());
	}

	public final ItemStack onItemRightClick(ItemStack is, World w, EntityPlayer p) {
		if (!(this instanceof ItemStaff))
			return is;
		is.damageItem(1, p);
		return doSpecialRightClickAction(is, w, p);
	}

	protected ItemStack doSpecialRightClickAction(ItemStack is, World w, EntityPlayer p) {
		System.err.println("You just crashed because you are stupid. You forgot to add the staff's right click action. Numbnutz.\nGo to" + this.getULN() + "and override the doSpecialRightClickAction() method.\nHope this helps dummy.");
		return null;
	}

	protected final void setIGN(String ign) {
		this.inGameName = ign;
	}

	protected final void setULN(String uln) {
		this.unlocalizedName = uln;
	}

	protected final void setTexture(String path) {
		this.textureName = path;
		this.texturePath = DMI.MOD_ID.toLowerCase() + ":" + this.textureName;
	}

	public final String getIGN() {
		return inGameName;
	}

	public final String getULN() {
		return unlocalizedName;
	}

	public final String getTexutreLocation(boolean fullpath) {
		if (fullpath)
			return texturePath;
		return textureName;
	}
	
	public static int getSubclassCount() {
		System.out.println(subclassCount);
		return subclassCount;
	}
}

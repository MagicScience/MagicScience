package siramnot.mods.dmi.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
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
	
	public ItemStaff(int id) {
		super(id);
		unlocalizedName = "itemStaff";
		inGameName = "Staff";
		textureName = "basicStaff";
		texturePath = DMI.MOD_ID.toLowerCase() + ":" + textureName;
		stackSize = 1;

		setFull3D();
		
		load();
	}

	public ItemStaff(int id, EnumStaff es) {
		super(id);
		new ItemStaff(id);

		this.es = es;
	}

	private void load() {
		setCreativeTab(DMI.TAB_CREATIVE);
		if (es != null) {
			setMaxDamage(es.getDurability());
		}
	}

	public final ItemStack onItemRightClick(ItemStack is, World w, EntityPlayer p) {
		if (is.getItem().itemID == this.itemID)
			return is;
		is.damageItem(1, p);
		return doSpecialRightClickAction(is, w, p);
	}

	protected ItemStack doSpecialRightClickAction(ItemStack is, World w, EntityPlayer p) {
		System.err.println("You just crashed because you are stupid. You forgot to add the staff's right click action. Numbnutz.\nGo to" + this + "and override the doSpecialRightClickAction() method.\nHope this helps dummy.");
		return null;
	}

	public final String getIGN() {
		return inGameName;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon(texturePath);
	}

}

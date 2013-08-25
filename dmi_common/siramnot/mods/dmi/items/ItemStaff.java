package siramnot.mods.dmi.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import siramnot.mods.dmi.DMI;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
		this.unlocalizedName = "itemStaff";
		this.inGameName = "Staff";
		this.textureName = "basicStaff";
		this.texturePath = DMI.MOD_ID.toLowerCase() + ":" + this.textureName;
		this.stackSize = 1;

		this.setFull3D();

		this.load();
	}

	public ItemStaff(int id, EnumStaff es) {
		super(id);
		new ItemStaff(id);

		this.es = es;
	}

	private void load() {
		this.setCreativeTab(DMI.TAB_CREATIVE);
		if (this.es != null) {
			this.setMaxDamage(this.es.getDurability());
		}
	}

	@Override
	public final ItemStack onItemRightClick(ItemStack is, World w, EntityPlayer p) {
		if (is.getItem().itemID == this.itemID) {
			return is;
		}
		is.damageItem(1, p);
		return this.doSpecialRightClickAction(is, w, p);
	}

	protected ItemStack doSpecialRightClickAction(ItemStack is, World w, EntityPlayer p) {
		System.err.println("You just crashed because you are stupid. You forgot to add the staff's right click action. Numbnutz.\nGo to" + this + "and override the doSpecialRightClickAction() method.\nHope this helps dummy.");
		return null;
	}

	public final String getIGN() {
		return this.inGameName;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon(this.texturePath);
	}

}

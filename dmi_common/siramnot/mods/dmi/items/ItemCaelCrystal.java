package siramnot.mods.dmi.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import siramnot.mods.dmi.DMI;

public class ItemCaelCrystal extends Item {

	// Do not change to public!!
	private static final String U_NAME = "caelCrystal";
	private static final String NAME = "Cael Crystal";
	private static final String PATH = "caelCrystal";
	private static final String TEXTUREPATH = DMI.MOD_ID.toLowerCase() + ":" + PATH; // mod-id before the colon (:) must be lowercase
	private static final int MAX_STACK_SIZE = 64;

	public ItemCaelCrystal(int id) { // I like id over the obfuscated par1.
		super(id);
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.setUnlocalizedName(U_NAME);
		this.setMaxStackSize(MAX_STACK_SIZE);
	}

	// Registers the texture in game
	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon(TEXTUREPATH);
	}

	// Static method to get the item's name
	public static String getName() {
		return NAME;
	}

}

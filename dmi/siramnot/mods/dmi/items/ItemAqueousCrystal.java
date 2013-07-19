package siramnot.mods.dmi.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import siramnot.mods.dmi.DMI;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemAqueousCrystal extends Item {

	// Do not change to public!!
	private static final String NAME = "aqueousCrystal";
	private static final String TEXTUREPATH = DMI.MOD_ID.toLowerCase() + ":" + NAME; // mod-id before the colon (:) must be lowercase
	private static final int MAX_STACK_SIZE = 64;

	public ItemAqueousCrystal(int id) { // I like id over the obfuscated par1.
		super(id);
		setCreativeTab(DMI.TAB_CREATIVE);
		setUnlocalizedName(NAME);
		setMaxStackSize(MAX_STACK_SIZE);
	}

	// Registers the texture in game
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon(TEXTUREPATH);
	}

	// Static method to get the item's name
	public static String getName() {
		return NAME;
	}
}

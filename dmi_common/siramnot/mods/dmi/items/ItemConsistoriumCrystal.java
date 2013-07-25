package siramnot.mods.dmi.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import siramnot.mods.dmi.DMI;

public class ItemConsistoriumCrystal extends Item {

	// Do not change to public!!
	private static final String U_NAME = "consistoriumCrystal";
	private static final String NAME = "Consistorium Crystal";
	private static final String PATH = "consistoriumCrystal";
	private static final String TEXTUREPATH = DMI.MOD_ID.toLowerCase() + ":" + PATH; // mod-id before the colon (:) must be lowercase
	private static final int MAX_STACK_SIZE = 64;

	public ItemConsistoriumCrystal(int id) { // I like id over the obfuscated par1.
		super(id);
		setCreativeTab(DMI.TAB_CREATIVE);
		setUnlocalizedName(U_NAME);
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
package siramnot.mods.dmi.items;

import java.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import siramnot.mods.dmi.*;
import siramnot.mods.dmi.core.*;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.relauncher.*;
public class ItemFoodMagicBread extends ItemFood {

	@SideOnly(Side.CLIENT)
	private static Icon[] icons;
	private static final int HEAL_AMOUNT = 6, MAX_DAMAGE = 0, MAX_STACKSIZE = 4, EFFECT_DURATION = 450, EFFECT_MODIFIER = 1;
	private static final float SATURATION_MODIFIER = 0.6f;
	private static final boolean IS_WOLF_FOOD = false, IS_SNACK = true;
	private static final String NAME_SUFFIX = "Bread";
	private static final String[] NAMES = new String[] { "Aqueous " + NAME_SUFFIX, "Terreous " + NAME_SUFFIX, "Igneous " + NAME_SUFFIX, "Aereous " + NAME_SUFFIX, "Elemental " + NAME_SUFFIX, "IceDrug " + NAME_SUFFIX };
	private static final String[] U_NAMES = new String[] { "water" + NAME_SUFFIX, "earth" + NAME_SUFFIX, "fire" + NAME_SUFFIX, "air" + NAME_SUFFIX, "elemental" + NAME_SUFFIX, "icedrug" + NAME_SUFFIX };
	private static final PotionEffect WATER_EFFECT = new PotionEffect(Potion.waterBreathing.id, EFFECT_DURATION, EFFECT_MODIFIER, false);
	private static final PotionEffect EARTH_EFFECT = new PotionEffect(Potion.digSpeed.id, EFFECT_DURATION, EFFECT_MODIFIER, false);
	private static final PotionEffect FIRE_EFFECT = new PotionEffect(Potion.fireResistance.id, EFFECT_DURATION, EFFECT_MODIFIER, false);
	private static final PotionEffect AIR_EFFECT = new PotionEffect(Potion.moveSpeed.id, EFFECT_DURATION, EFFECT_MODIFIER, false);
	private static final PotionEffect ELEMENTAL_EFFECT = new PotionEffect(Potion.regeneration.id, EFFECT_DURATION, EFFECT_MODIFIER, false);
	private static final PotionEffect ICEDRUG_EFFECT = new PotionEffect(Potion.jump.id, EFFECT_DURATION, 49, false);
	private static ItemFood instance;

	public ItemFoodMagicBread(int id) {
		super(id, HEAL_AMOUNT, SATURATION_MODIFIER, IS_WOLF_FOOD);

		this.setHasSubtypes(true);
		this.setMaxDamage(MAX_DAMAGE);
		this.setMaxStackSize(MAX_STACKSIZE);
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.instance = this;

		if (this.IS_SNACK) {
			this.setAlwaysEdible();
		}
	}

	public static void doRegisters() {
		GameRegistry.registerItem(instance, instance.getUnlocalizedName(), Reference.MOD_ID);
		for (int meta = 0; meta < NAMES.length; ++meta) {
			ItemStack item = new ItemStack(instance, 1, meta);
			LanguageRegistry.instance().addName(item, NAMES[meta]);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return damage < 4 ? icons[damage] : bread.getIconFromDamage(0);
	}

	@Override
	public String getUnlocalizedName(ItemStack items) {
		String j = super.getUnlocalizedName() + "." + U_NAMES[items.getItemDamage()];
		return j;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int i, CreativeTabs tab, List list) {
		for (int iter = 0; iter < NAMES.length; ++iter) {
			ItemStack item = new ItemStack(i, 1, iter);
			list.add(item);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[U_NAMES.length];
		for (int i = 0; i < U_NAMES.length; ++i) {
			icons[i] = register.registerIcon(Reference.ITEM_TEXTURE_LOCATION + U_NAMES[i]);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack item) {
		return item.getItemDamage() >= 4 ? EnumRarity.rare : EnumRarity.uncommon;
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onEaten(stack, world, player);
		ItemStack milk = (new ItemStack(Item.bucketMilk));
		player.curePotionEffects(milk);
		
		switch (stack.getItemDamage()) {
		case 0: // water
			player.addPotionEffect(WATER_EFFECT);
			break;

		case 1: // earth
			player.addPotionEffect(EARTH_EFFECT);
			break;

		case 2: // fire
			player.addPotionEffect(FIRE_EFFECT);
			break;

		case 3: // air
			player.addPotionEffect(AIR_EFFECT);
			break;

		case 4: // elemental
			player.addPotionEffect(ELEMENTAL_EFFECT);
			break;
			
		case 5: //IceDrug
			player.addPotionEffect(ICEDRUG_EFFECT);
			break;
		}
		return stack;
	}

	/**
	 * @param meta
	 *            0 = water; 1 = earth; 2 = fire; 3 = air, 4 = elemental, 5= icedrug
	 * 
	 * @param stackSize
	 *            The size of the ItemStack
	 * 
	 * @return The ItemStack
	 */
	public ItemStack getItem(int meta, int stackSize) {
		ItemStack stack = new ItemStack(instance, stackSize, meta);
		return stack;
	}
	
}
 
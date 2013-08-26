package siramnot.mods.dmi.items;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.blocks.BlockDMICrystals;
import siramnot.mods.dmi.blocks.BlockDMICrystals.ItemBlockDMICrystals;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFoodMagicBread extends ItemFood {

	@SideOnly(Side.CLIENT)
	private static Icon[] icons;
	private static final int HEAL_AMOUNT = 6, MAX_DAMAGE = 0, MAX_STACKSIZE = 4, EFFECT_DURATION = 450, EFFECT_MODIFIER = 1;
	private static final float SATURATION_MODIFIER = 0.6f;
	private static final boolean IS_WOLF_FOOD = false, IS_SNACK = true;
	private static final String NAME_SUFFIX = "Bread";
	private static final String[] NAMES = new String[] { "Aqueous " + NAME_SUFFIX, "Terreous " + NAME_SUFFIX, "Igneous " + NAME_SUFFIX, "Aereous " + NAME_SUFFIX };
	private static final String[] U_NAMES = new String[] { "water" + NAME_SUFFIX, "earth" + NAME_SUFFIX, "fire" + NAME_SUFFIX, "air" + NAME_SUFFIX };
	private static final PotionEffect WATER_EFFECT = new PotionEffect(Potion.digSpeed.id, EFFECT_DURATION, EFFECT_MODIFIER, false);
	private static final PotionEffect EARTH_EFFECT = new PotionEffect(Potion.resistance.id, EFFECT_DURATION, EFFECT_MODIFIER, false);
	private static final PotionEffect FIRE_EFFECT = new PotionEffect(Potion.fireResistance.id, EFFECT_DURATION, EFFECT_MODIFIER, false);
	private static final PotionEffect AIR_EFFECT = new PotionEffect(Potion.jump.id, EFFECT_DURATION, EFFECT_MODIFIER, false);
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
		GameRegistry.registerItem(instance, instance.getUnlocalizedName(), DMI.MOD_ID);
		for (int meta = 0; meta < NAMES.length; ++meta) {
			ItemStack item = new ItemStack(instance, 1, meta);
			LanguageRegistry.instance().addName(item, NAMES[meta]);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		int i = MathHelper.clamp_int(damage, 0, NAMES.length - 1);
		return icons[i];
	}

	@Override
	public String getUnlocalizedName(ItemStack items) {
		int i = MathHelper.clamp_int(items.getItemDamage(), 0, NAMES.length - 1);
		String j = super.getUnlocalizedName() + "." + U_NAMES[i];
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
			icons[i] = register.registerIcon(DMI.MOD_ID + ":" + U_NAMES[i]);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack item) {
		return item.stackSize == MAX_STACKSIZE ? EnumRarity.rare : EnumRarity.uncommon;
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onEaten(stack, world, player);

		switch (stack.getItemDamage()) {
		case BlockDMICrystals.WATER_ORE:
			player.addPotionEffect(WATER_EFFECT);
			break;
			
		case BlockDMICrystals.EARTH_ORE:
			player.addPotionEffect(EARTH_EFFECT);
			break;
			
		case BlockDMICrystals.FIRE_ORE:
			player.addPotionEffect(FIRE_EFFECT);
			break;
			
		case BlockDMICrystals.AIR_ORE:
			player.addPotionEffect(AIR_EFFECT);
			break;
		}
		return stack;
	}
}

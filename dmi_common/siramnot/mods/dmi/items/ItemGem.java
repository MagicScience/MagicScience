package siramnot.mods.dmi.items;

import java.util.List;

import siramnot.mods.dmi.DMI;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGem extends Item {

	@SideOnly(Side.CLIENT)
	private static Icon[] icons;
	private static final String NAME_SUFFIX = "Crystal";
	private static final String[] NAMES = new String[] { "Aqueous " + NAME_SUFFIX, "Terreous " + NAME_SUFFIX, "Igneous " + NAME_SUFFIX, "Aereous " + NAME_SUFFIX };
	private static final String[] U_NAMES = new String[] { "water" + NAME_SUFFIX, "fire" + NAME_SUFFIX, "earth" + NAME_SUFFIX, "air" + NAME_SUFFIX };
	private static ItemGem instance;

	public ItemGem(int id) {
		super(id);
		this.setHasSubtypes(true);
		this.setMaxDamage(0); // This means, no damage bar
		this.setCreativeTab(DMI.TAB_CREATIVE);
		
		this.setUnlocalizedName("itemGem");

		this.instance = this;
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
		return icons[damage];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		String j = super.getUnlocalizedName() + "." + U_NAMES[stack.getItemDamage()];
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

	/**
	 * @param meta
	 *            0 = water; 1 = earth; 2 = fire; 3 = air
	 * 
	 * @param stackSize
	 *            The size of the ItemStack
	 * 
	 * @return The ItemStack
	 */
	public ItemStack getSubItem(int meta, int stackSize) {
		ItemStack stack = new ItemStack(instance, stackSize, meta);
		return stack;
	}

}
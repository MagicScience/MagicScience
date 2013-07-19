package siramnot.mods.dmi.items;

import siramnot.mods.dmi.DMI;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemAqueousCrystal extends Item{

	public static final String NAME = "aqueousCrystal";
	public static final String TEXTUREPATH = DMI.MOD_ID+":"+NAME;
	
	
	
	public ItemAqueousCrystal(int par1) {
		super(par1);
		setCreativeTab(DMI.TAB_CREATIVE);
		setUnlocalizedName(NAME);
	}
	
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon(TEXTUREPATH);
	}

	
	
}

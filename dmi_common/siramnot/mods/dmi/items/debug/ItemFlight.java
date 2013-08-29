package siramnot.mods.dmi.items.debug;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemFlight extends Item {

	private static boolean flightEnabled = false;
	private static final String unlocal = "flightItem";
	private IconRegister iconThing;

	public ItemFlight(int id) {
		super(id);
		this.setUnlocalizedName(unlocal);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.iconThing = iconRegister;
		this.itemIcon = updateTexture(iconRegister);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player.isAirBorne)
			return stack;
		player.capabilities.allowFlying = !player.capabilities.allowFlying;
		flightEnabled = player.capabilities.allowFlying;

		if (iconThing != null) {
			this.itemIcon = updateTexture(iconThing);
		}
		return stack;
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
		player.capabilities.allowFlying = flightEnabled = false;
		if (iconThing != null)
			updateTexture(iconThing);
		
		return true;
	}

	private Icon updateTexture(IconRegister iconRegister) {
		return (flightEnabled) ? Item.emerald.getIconFromDamage(0) : Item.flint.getIconFromDamage(0);
	}
}

package siramnot.mods.dmi.items.debug;

import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.core.managers.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlight extends Item {

	private static final String unlocal = "flightItem";
	private IconRegister iconThing;
	private EntityPlayer playuhr;

	public ItemFlight(int id) {
		super(id);
		this.setUnlocalizedName(unlocal);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		this.iconThing = iconRegister;
		updateTexture(-1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player.isAirBorne) {
			return stack;
		}
		
		ItemStack metastack = new ItemStack(Block.cloth, 1, 7);
		ItemStack metastack_ = new ItemStack(metastack.getItem());
		player.inventory.addItemStackToInventory(metastack_);

		PlayerCapabilities p = player.capabilities;
		p.allowFlying = !p.allowFlying;
		updateTexture(p.allowFlying ? 1 : 0);

		playuhr = player;
		return stack;
	}

	private void updateTexture(int textureIndex) {
		Icon emerald = Item.emerald.getIconFromDamage(0);
		Icon flint = Item.flint.getIconFromDamage(0);
		Icon apple = Item.appleRed.getIconFromDamage(0);

		if (playuhr == null) {
			this.itemIcon = apple;
			return;
		}

		this.itemIcon = (textureIndex == 1) ? emerald : (textureIndex == -1) ? apple : flint;
	}
}

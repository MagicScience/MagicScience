package siramnot.mods.dmi.items.debug;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.core.managers.GuiHandler;
import siramnot.mods.dmi.worldgen.structures.ShackStructure;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
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

	/**
	 * @Override public ItemStack onItemRightClick(ItemStack stack, World world,
	 *           EntityPlayer player) { if (player.isAirBorne) { return stack; }
	 * 
	 *           ItemStack metastack = new ItemStack(Block.cloth, 1, 7);
	 *           ItemStack metastack_ = new ItemStack(metastack.getItem());
	 *           player.inventory.addItemStackToInventory(metastack_);
	 * 
	 *           PlayerCapabilities p = player.capabilities; p.allowFlying =
	 *           !p.allowFlying; updateTexture(p.allowFlying ? 1 : 0);
	 * 
	 *           playuhr = player; return stack; }
	 */

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		System.out.println("Attempting to spawn a strucuture...");
		int x = (int) par3EntityPlayer.posX;
		int y = (int) par3EntityPlayer.posY;
		int z = (int) par3EntityPlayer.posZ;
		
		boolean generated = ShackStructure.getInstance().generate(par2World, new Random(), x, y, z);
		String msg = (generated) ? String.format("Success! Generated a structure @[%d : %d : %d]", x,y,z) : "Failed to generate structure";
		
		System.out.println(msg);
		
		if(generated) { par1ItemStack.stackSize--; }
		
		return par1ItemStack;
	}

	public ItemStack ronItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		render();
		return par1ItemStack;
	}

	private void render() {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
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

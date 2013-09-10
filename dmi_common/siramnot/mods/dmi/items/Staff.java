package siramnot.mods.dmi.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.entity.EntityExplode;
import siramnot.mods.dmi.entity.EntityExplosiveBall;

/**
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot, Tombenpotter
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public abstract class Staff extends Item {

	public Staff(int id) {
		super(id);

		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.setMaxStackSize(1);
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.bow;
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

	public static class ExplodingStaff extends Staff {

		public ExplodingStaff(int id) {
			super(id);

		}

		@Override
		public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int itemCount) {
			EntityExplode proj = new EntityExplode(world);
		}

	}
}

package siramnot.mods.dmi.items;

import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.entity.mobs.EntityExplodingBall;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public abstract class Staff extends ItemBow{

	 public Staff(int par1) {
		super(par1);
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.setMaxStackSize(1);
	}
	public static class ExplodingStaff extends Staff { 
		 
		 public ExplodingStaff(int par1) {
			super(par1);
			
		}
		@Override 
		 public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
		    {
		        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;

		        ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
		        MinecraftForge.EVENT_BUS.post(event);
		        if (event.isCanceled())
		        {
		            return;
		        }
		        j = event.charge;

		       float f = (float)j / 20.0F;
		            f = (f * f + f * 2.0F) / 3.0F;

		            if ((double)f < 0.1D)
		            {
		                return;
		            }

		            if (f > 1.0F)
		            {
		                f = 1.0F;
		          
		            EntityExplodingBall entityboom = new EntityExplodingBall(par2World);

		            if (f == 1.0F)
		            {
		                entityboom.setIsCritical(true);
		            }

		           
		            par1ItemStack.damageItem(1, par3EntityPlayer);
		            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

		            
		            if (!par2World.isRemote)
		            {
		                par2World.spawnEntityInWorld(entityboom);
		            }
		        }
		    }

		    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
		    {
		        return par1ItemStack;
		    }

	}
		 
	
	 public EnumAction getItemUseAction(ItemStack par1ItemStack) {
	return EnumAction.bow;
	 }	 		
	 public int getMaxItemUseDuration(ItemStack par1ItemStack)
	    {
	        return 72000;
	    }
}

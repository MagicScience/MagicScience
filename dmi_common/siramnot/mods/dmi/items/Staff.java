package siramnot.mods.dmi.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
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
		this.setMaxDamage(800);
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.bow;
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}

// The exploding staff
	
	public static class ExplodingStaff extends Staff {


		    public ExplodingStaff(int par1)
		    {
		        super(par1);
		    }

		    
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
		            }

		            EntityExplode entityboom = new EntityExplode(par2World, par3EntityPlayer, f * 2.0F);         

		            par1ItemStack.damageItem(1, par3EntityPlayer);		            

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

		    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
		    {
		        ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
		        MinecraftForge.EVENT_BUS.post(event);
		        if (event.isCanceled())
		        {
		            return event.result;
		        }

		        if (par3EntityPlayer.capabilities.isCreativeMode)
		        {
		            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		        }
		        else
		        {
		        	 par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		        }
		        return par1ItemStack;
		    }

		   

	}

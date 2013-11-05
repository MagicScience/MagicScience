package siramnot.mods.dmi.entity.tile;


import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;


/**
 * 
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 *
 */
public class TileEntityBatteryBlock extends TileEntity implements ISidedInventory
{
	public static final int		SLOT_RECHARGE	= 0;	// Items placed in this slot will recharge
	public static final int		SLOT_DISCHARGE	= 1;	// Items placed in this slot will discharge
	public static final int		BUFFER_SIZE		= 10;	// Power of two size of the energy buffer
	private static final int	INVENTORY_SIZE	= 2;	// The size of the inventory
														
	private ItemStack[]			inventory;				// The contents of the inventory are stored here
	private EntityPlayer		owner;					// The owner of this block
														
	public TileEntityBatteryBlock(EntityPlayer player)
	{
		inventory = new ItemStack[INVENTORY_SIZE];
		owner = player;
	}
	
	@Override
	public int getSizeInventory()
	{
		return INVENTORY_SIZE;
	}
	
	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return inventory[slot];
	}
	
	@Override
	public ItemStack decrStackSize(int itemCount, int itemsRemoved)
	{
		if (this.inventory[itemCount] != null)
		{
			ItemStack itemstack;
			
			if (this.inventory[itemCount].stackSize <= itemsRemoved)
			{
				itemstack = this.inventory[itemCount];
				this.inventory[itemCount] = null;
				return itemstack;
			}
			else
			{
				itemstack = this.inventory[itemCount].splitStack(itemsRemoved);
				
				if (this.inventory[itemCount].stackSize == 0)
				{
					this.inventory[itemCount] = null;
				}
				
				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		if (this.inventory[slot] != null)
		{
			ItemStack itemstack = this.inventory[slot];
			this.inventory[slot] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		inventory[slot] = stack;
	}
	
	@Override
	public String getInvName()
	{
		String name = "container.batteryblock";
		return name;
	}
	
	@Override
	public boolean isInvNameLocalized()
	{
		return false;
	}
	
	@Override
	public int getInventoryStackLimit()
	{
		int maxStackSize = 64;
		return maxStackSize;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		// Returns true if the right-clicker's username is the same as the placer's 
//		if (owner == null) { return false; }
//		return player.username.equals(owner.username);
		return true; // TODO: fixme
	}
	
	@Override
	public void openChest()
	{
	}
	
	@Override
	public void closeChest()
	{
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return false;
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int var1)
	{
		return null;
	}
	
	@Override
	public boolean canInsertItem(int slot, ItemStack stack, int side)
	{
		return false;
	}
	
	@Override
	public boolean canExtractItem(int slot, ItemStack stack, int side)
	{
		return false;
	}
}

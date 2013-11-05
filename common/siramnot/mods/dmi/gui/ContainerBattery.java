package siramnot.mods.dmi.gui;


import siramnot.mods.dmi.core.managers.*;
import siramnot.mods.dmi.entity.tile.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;


public class ContainerBattery extends Container
{
	
	private TileEntityBatteryBlock	battery;
	
	public ContainerBattery(InventoryPlayer playerInventory, TileEntityBatteryBlock battery)
	{
		this.battery = battery;
		
		for (int i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				addSlotToContainer(new Slot(playerInventory, (j + i * 9 + 9), (8 + j * 18), (82 + i * 18)));
			}
		}
		
		for (int i = 0; i < 9; ++i)
		{
			addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 140));
		}
	}
	
	public void detectAndSendChanges()
	{	
		
	}
	
	public void updateProgressBar(int par1, int par2)
	{	
		
	}
	
	public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	{
		return battery.isUseableByPlayer(par1EntityPlayer);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotnumber)
	{
		return null;
	}
}

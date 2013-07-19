package siramnot.mods.dmi.gui;

import siramnot.mods.dmi.blocks.tileeents.TileEntityLiquidator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerLiquidator extends Container {

	public ContainerLiquidator(InventoryPlayer player, TileEntityLiquidator entity) {


		this.addSlotToContainer(new Slot(entity, 0, 54, 56));
		this.addSlotToContainer(new Slot(entity, 1, 90, 56));
		this.addSlotToContainer(new SlotFurnace(player.player, entity, 2, 51, 17));
		int i;

		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
		}
	}







	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        Slot slot = (Slot)this.inventorySlots.get(par2);
        return slot != null ? slot.getStack() : null;
    }





}
package siramnot.mods.dmi.gui;
import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

import siramnot.mods.dmi.blocks.tileeents.TileEntityLiquidator;
import siramnot.mods.dmi.recipes.RecipesLiquidator;

public class ContainerLiquidator extends Container
{
	private TileEntityLiquidator liquidator;
	private int lastGoldOvenCookTime;
	private int lastGoldOvenBurnTime;
	private int lastGoldOvenItemBurnTime;
	private int liquid;

	public ContainerLiquidator(InventoryPlayer par1InventoryPlayer, TileEntityLiquidator teliquidator)
	{
		lastGoldOvenCookTime = 0;
		lastGoldOvenBurnTime = 0;
		lastGoldOvenItemBurnTime = 0;
		liquidator = teliquidator;
		liquid = 0;
		addSlotToContainer(new Slot(teliquidator, 0, 90, 56));
		addSlotToContainer(new Slot(teliquidator, 1, 54, 56));
        addSlotToContainer(new SlotLiquidator(par1InventoryPlayer.player, teliquidator, 2, 51, 17));

		for (int i = 0; i < 3; i++)
		{
			for (int k = 0; k < 9; k++)
			{
				addSlotToContainer(new Slot(par1InventoryPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}
		}

		for (int j = 0; j < 9; j++)
		{
			addSlotToContainer(new Slot(par1InventoryPlayer, j, 8 + j * 18, 142));
		}
	}

	/**
	 * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
	 */
	 public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		Iterator var1 = this.crafters.iterator();
		while (var1.hasNext())
		{
			ICrafting var2 = (ICrafting)var1.next();
			if (this.lastGoldOvenCookTime != this.liquidator.goldCookTime)
			{
				var2.sendProgressBarUpdate(this, 0, this.liquidator.goldCookTime);
			}
			if (this.lastGoldOvenBurnTime != this.liquidator.goldBurnTime)
			{
				var2.sendProgressBarUpdate(this, 1, this.liquidator.goldBurnTime);
			}
			if (this.lastGoldOvenItemBurnTime != this.liquidator.goldItemBurnTime)
			{
				var2.sendProgressBarUpdate(this, 2, this.liquidator.goldItemBurnTime);
			}
			if (this.liquid != this.liquidator.liquid) {
				var2.sendProgressBarUpdate(this, 3, this.liquidator.liquid);
			}
		}
		this.lastGoldOvenCookTime = this.liquidator.goldCookTime;
		this.lastGoldOvenBurnTime = this.liquidator.goldBurnTime;
		this.lastGoldOvenItemBurnTime = this.liquidator.goldItemBurnTime;
	}

	 public void updateProgressBar(int par1, int par2)
	 {
		 if (par1 == 0)
		 {
			 liquidator.goldCookTime = par2;
		 }

		 if (par1 == 1)
		 {
			 liquidator.goldBurnTime = par2;
		 }

		 if (par1 == 2)
		 {
			 liquidator.goldItemBurnTime = par2;
		 }
		 if (par1 == 3) {
			 liquidator.liquid = par2;
		 }
	 }

	 public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	 {
		 return true;
	 }

	 /**
	  * Called to transfer a stack from one inventory to the other eg. when shift clicking.
	  */
	 @Override
	 public ItemStack transferStackInSlot(EntityPlayer player, int slotnumber)
	 {
		 ItemStack itemstack = null;
		 Slot slot = (Slot)inventorySlots.get(slotnumber);

		 if (slot != null && slot.getHasStack())
		 {
			 ItemStack itemstack1 = slot.getStack();
			 itemstack = itemstack1.copy();

			 if (slotnumber == 2)
			 {
				 if (!mergeItemStack(itemstack1, 3, 39, true))
				 {
					 return null;
				 }

				 slot.onSlotChange(itemstack1, itemstack);
			 }
			 else if (slotnumber == 1 || slotnumber == 0)
			 {
				 if (!mergeItemStack(itemstack1, 3, 39, false))
				 {
					 return null;
				 }
			 }
			 else if (RecipesLiquidator.liquidating().getRefiningResult(itemstack1.getItem().itemID) != null)
			 {
				 if (!mergeItemStack(itemstack1, 0, 1, false))
				 {
					 return null;
				 }
			 }
			 else if (TileEntityLiquidator.isItemFuel(itemstack1))
			 {
				 if (!mergeItemStack(itemstack1, 1, 2, false))
				 {
					 return null;
				 }
			 }
			 else if (slotnumber >= 3 && slotnumber < 30)
			 {
				 if (!mergeItemStack(itemstack1, 30, 39, false))
				 {
					 return null;
				 }
			 }
			 else if (slotnumber >= 30 && slotnumber < 39 && !mergeItemStack(itemstack1, 3, 30, false))
			 {
				 return null;
			 }

			 if (itemstack1.stackSize == 0)
			 {
				 slot.putStack(null);
			 }
			 else
			 {
				 slot.onSlotChanged();
			 }

			 if (itemstack1.stackSize == itemstack.stackSize)
			 {
				 return null;
			 }

			 slot.onPickupFromSlot(player, itemstack);
		 }

		 return itemstack;
	 }

}
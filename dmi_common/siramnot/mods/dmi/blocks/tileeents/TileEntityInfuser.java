package siramnot.mods.dmi.blocks.tileeents;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import siramnot.mods.dmi.core.managers.BlockManager;

public class TileEntityInfuser extends TileEntity implements IInventory {

	private boolean isValid = false;
	private int infuseTime, slotQty;
	private ItemStack[] slots;
	private EntityPlayer somePlayer;
	private static ItemStack[] allowedItems = new ItemStack[] {

	};

	public TileEntityInfuser() {
		isValid = false;
		infuseTime = 0;
		slotQty = 5;

		slots = new ItemStack[slotQty];
	}

	public boolean checkFormation() {
		boolean flag = true;
		for (int x = -1; x <= 1; ++x) {
			for (int y = -1; y <= 1; ++y) {
				for (int z = -1; z <= 1; ++z) {
					System.out.printf("Maybe one of this is null: [x=%d;y=%d;z=%d]-[xCoord=%d,yCoord=%d,zCoord=%d]\n", xCoord + x, yCoord + y, zCoord + z, xCoord, yCoord, zCoord);
					int id = worldObj.getBlockId(xCoord + x, yCoord + y, zCoord + z);

					if (id != BlockManager.infuserCore.blockID)
						flag = false;

				}
			}
		}
		return flag;
	}

	public void validate() {
		System.out.println("valid: " + isValid);
		isValid = true;
	}

	public void unValidate() {
		isValid = false;
	}

	/**
	 * Gets the Tile Entity's state.
	 * 
	 * @return The validation state for the tileEntity<br/>
	 *         * Returns true if block is operable
	 */
	public boolean getValidation() {
		return isValid;
	}

	@Override
	public int getSizeInventory() {
		return this.slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.slots[i];
	}

	/**
	 * Decrease the size of the stack in slot (first int arg) by the amount of
	 * the second int arg. Returns the new stack.
	 */
	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.slots[par1] != null) {
			if (this.slots[par1].stackSize <= par2) {
				ItemStack itemstack = this.slots[par1];
				this.slots[par1] = null;
				return itemstack;
			}

			ItemStack itemstack1 = this.slots[par1].splitStack(par2);

			if (this.slots[par1].stackSize == 0) {
				this.slots[par1] = null;
			}

			return itemstack1;
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		if (this.slots[par1] != null) {
			ItemStack itemstack = this.slots[par1];
			this.slots[par1] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		this.slots[par1] = par2ItemStack;

		if ((par2ItemStack != null) && (par2ItemStack.stackSize > this.getInventoryStackLimit())) {
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() {
		return "container.infuser";
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		if (this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
			return false;
		}

		return par1EntityPlayer.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64D;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		for (int j = 0; j < allowedItems.length; ++j) {
			if (itemstack.getItem() != allowedItems[i].getItem())
				return false;
		}

		return true;
	}

	private boolean canInfuse() {
		return true;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public boolean isInvNameLocalized() {
		return true;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger(((Boolean) isValid).toString(), ((isValid) ? 1 : 0));
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		int validRaw = nbt.getInteger(((Boolean) isValid).toString());
		isValid = validRaw == 1 ? true : false;
	}

	private void burp() {
		Entity nearestEntity = worldObj.getClosestPlayer(xCoord, yCoord, zCoord, -1);
		worldObj.playSoundAtEntity(nearestEntity, "random.burp", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
	}

}

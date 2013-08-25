package siramnot.mods.dmi.blocks.tileeents;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import siramnot.mods.dmi.DMI;

public class TileEntityWorkStation extends TileEntity implements IInventory {

	private ItemStack[] inventory;

	// Values used by the book animation
	private int tickCount;
	private int pageFlip;
	private int pageFlipPrev;
	private float bookSpread;
	private float bookSpreadPrev;
	private float bookRotation;
	private float bookRotation2;
	private float bookRotationPrev;
	private static Random rand = new Random();

	@Override
	public void updateEntity() {
		super.updateEntity();
		this.bookSpreadPrev = this.bookSpread;
		this.bookRotationPrev = this.bookRotation2;
		EntityPlayer entityplayer = this.worldObj.getClosestPlayer(this.xCoord + 0.5F, this.yCoord + 0.5F, this.zCoord + 0.5F, 3.0D);

		if (entityplayer != null) {
			double d0 = entityplayer.posX - (this.xCoord + 0.5F);
			double d1 = entityplayer.posZ - (this.zCoord + 0.5F);
			this.bookRotation = (float) Math.atan2(d1, d0);
			this.bookSpread += 0.1F;

			if ((this.bookSpread < 0.5F) || (rand.nextInt(40) == 0)) {
			} else {
				this.bookRotation += 0.02F;
				this.bookSpread -= 0.1F;
			}

			while (this.bookRotation2 >= (float) Math.PI) {
				this.bookRotation2 -= ((float) Math.PI * 2F);
			}

			while (this.bookRotation2 < -(float) Math.PI) {
				this.bookRotation2 += ((float) Math.PI * 2F);
			}

			while (this.bookRotation >= (float) Math.PI) {
				this.bookRotation -= ((float) Math.PI * 2F);
			}

			while (this.bookRotation < -(float) Math.PI) {
				this.bookRotation += ((float) Math.PI * 2F);
			}

			float f1;

			for (f1 = this.bookRotation - this.bookRotation2; f1 >= (float) Math.PI; f1 -= ((float) Math.PI * 2F)) {
				;
			}

			while (f1 < -(float) Math.PI) {
				f1 += ((float) Math.PI * 2F);
			}

			this.bookRotation2 += f1 * 0.4F;

			if (this.bookSpread < 0.0F) {
				this.bookSpread = 0.0F;
			}

			if (this.bookSpread > 1.0F) {
				this.bookSpread = 1.0F;
			}

			++this.tickCount;
			this.pageFlipPrev = this.pageFlip;
			float f3 = 0.2F;
		}

	}

	public TileEntityWorkStation() {
		this.inventory = new ItemStack[1];
	}

	@Override
	public int getSizeInventory() {
		return this.inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.inventory[slot];
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		this.inventory[slot] = stack;
		stack.stackSize = (((stack != null) && (stack.stackSize > this.getInventoryStackLimit())) ? stack.stackSize = this.getInventoryStackLimit() : stack.stackSize);
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = this.getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize <= amount) {
				this.setInventorySlotContents(slot, null);
			} else {
				stack = stack.splitStack(amount);
				if (stack.stackSize == 0) {
					this.setInventorySlotContents(slot, null);
				}
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = this.getStackInSlot(slot);
		if (stack != null) {
			this.setInventorySlotContents(slot, null);
		}
		return stack;
	}

	@Override
	public int getInventoryStackLimit() {
		int limit = 64;
		return limit;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		double i = 0.5D;
		int j = 64;
		return (this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) == this) && (player.getDistanceSq(this.xCoord + i, this.yCoord + i, this.zCoord + i) < j);

	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);

		NBTTagList tagList = tagCompound.getTagList("Inventory");
		for (int i = 0; i < tagList.tagCount(); ++i) {
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tag.getByte("Slot");
			this.inventory[slot] = ((slot >= 0) && (slot < this.inventory.length)) ? ItemStack.loadItemStackFromNBT(tag) : this.inventory[slot];
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < this.inventory.length; ++i) {
			ItemStack stack = this.inventory[i];

			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
	}

	@Override
	public String getInvName() {
		String name = "lol";
		return DMI.MOD_ID + "." + name;
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}

}

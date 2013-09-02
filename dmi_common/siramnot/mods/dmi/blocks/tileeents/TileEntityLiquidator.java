package siramnot.mods.dmi.blocks.tileeents;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import siramnot.mods.dmi.recipes.RecipesLiquidator;

public class TileEntityLiquidator extends TileEntity implements IInventory {
	private ItemStack goldItemStacks[];

	/** The number of ticks that the furnace will keep burning */
	public int goldBurnTime;

	public double liquid;
	public int maxLiquid = 5600; // 5,600

	private boolean isActive;

	/**
	 * The number of ticks that a fresh copy of the currently-burning item would
	 * keep the furnace burning for
	 */
	public int goldItemBurnTime;

	/** The number of ticks that the current item has been cooking for */
	public int goldCookTime;

	public int front;

	public TileEntityLiquidator() {
		this.goldItemStacks = new ItemStack[3];
		this.goldBurnTime = 0;
		this.goldItemBurnTime = 0;
		this.goldCookTime = 0;
		this.liquid = 0;
	}

	public void setFrontDirection(int f) {
		this.front = f;
	}

	public int getFrontDirection() {
		return this.front;
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory() {
		return this.goldItemStacks.length;
	}

	/**
	 * Returns the stack in slot i
	 */
	@Override
	public ItemStack getStackInSlot(int par1) {
		return this.goldItemStacks[par1];
	}

	/**
	 * Decrease the size of the stack in slot (first int arg) by the amount of
	 * the second int arg. Returns the new stack.
	 */
	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.goldItemStacks[par1] != null) {
			if (this.goldItemStacks[par1].stackSize <= par2) {
				ItemStack itemstack = this.goldItemStacks[par1];
				this.goldItemStacks[par1] = null;
				return itemstack;
			}

			ItemStack itemstack1 = this.goldItemStacks[par1].splitStack(par2);

			if (this.goldItemStacks[par1].stackSize == 0) {
				this.goldItemStacks[par1] = null;
			}

			return itemstack1;
		} else {
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then drop
	 * whatever it returns as an EntityItem - like when you close a workbench
	 * GUI.
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		if (this.goldItemStacks[par1] != null) {
			ItemStack itemstack = this.goldItemStacks[par1];
			this.goldItemStacks[par1] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be
	 * crafting or armor sections).
	 */
	@Override
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		this.goldItemStacks[par1] = par2ItemStack;

		if ((par2ItemStack != null) && (par2ItemStack.stackSize > this.getInventoryStackLimit())) {
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	/**
	 * Returns the name of the inventory.
	 */
	@Override
	public String getInvName() {
		return "container.liquidator";
	}

	/**
	 * Reads a tile entity from NBT.
	 */
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
		this.goldItemStacks = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagCompound nbttagcompound = (NBTTagCompound) nbttaglist.tagAt(i);
			byte byte0 = nbttagcompound.getByte("Slot");

			if ((byte0 >= 0) && (byte0 < this.goldItemStacks.length)) {
				this.goldItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound);
			}

		}

		this.front = par1NBTTagCompound.getInteger("FrontDirection");
		this.goldBurnTime = par1NBTTagCompound.getShort("BurnTime");
		this.goldCookTime = par1NBTTagCompound.getShort("CookTime");
		this.goldItemBurnTime = getItemBurnTime(this.goldItemStacks[1]);

		this.liquid = par1NBTTagCompound.getDouble("liquid");
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("FrontDirection", this.front);
		par1NBTTagCompound.setShort("BurnTime", (short) this.goldBurnTime);
		par1NBTTagCompound.setShort("CookTime", (short) this.goldCookTime);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.goldItemStacks.length; i++) {
			if (this.goldItemStacks[i] != null) {
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte) i);
				this.goldItemStacks[i].writeToNBT(nbttagcompound);
				nbttaglist.appendTag(nbttagcompound);
			}
		}

		par1NBTTagCompound.setTag("Items", nbttaglist);
		par1NBTTagCompound.setDouble("liquid", this.liquid);
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be
	 * 64, possibly will be extended. *Isn't this more of a set than a get?*
	 */
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	/**
	 * Returns an integer between 0 and the passed value representing how close
	 * the current item is to being completely cooked
	 */
	public int getCookProgressScaled(int par1) {
		return (this.goldCookTime * par1) / 200;
	}

	/**
	 * Returns an integer between 0 and the passed value representing how much
	 * burn time is left on the current fuel item, where 0 means that the item
	 * is exhausted and the passed value means that the item is fresh
	 */
	public int getBurnTimeRemainingScaled(int par1) {
		if (this.goldItemBurnTime == 0) {
			this.goldItemBurnTime = 200;
		}

		return (this.goldBurnTime * par1) / this.goldItemBurnTime;
	}

	public int getLiquidScaled() {
		if (this.liquid == 0) {
			return 56;
		}
		return 56 - ((int) this.liquid / 10);
	}

	/**
	 * Returns true if the furnace is currently burning
	 */
	public boolean isBurning() {
		return this.goldBurnTime > 0;
	}

	/**
	 * Allows the entity to update its state. Overridden in most subclasses,
	 * e.g. the mob spawner uses this to count ticks and creates a new spawn
	 * inside its implementation.
	 */
	@Override
	public void updateEntity() {
		boolean var1 = this.goldBurnTime > 0;
		boolean var2 = false;

		if (this.goldBurnTime > 0) {
			--this.goldBurnTime;
		}
		if (this.isBurning()) {

		}
		if (!this.worldObj.isRemote) {
			if ((this.goldBurnTime == 0) && this.canSmelt()) {
				this.goldItemBurnTime = this.goldBurnTime = getItemBurnTime(this.goldItemStacks[1]);
				if (this.goldBurnTime > 0) {
					var2 = true;
					if (this.goldItemStacks[1] != null) {
						--this.goldItemStacks[1].stackSize;
						if (this.goldItemStacks[1].stackSize == 0) {
							Item var3 = this.goldItemStacks[1].getItem().getContainerItem();
							this.goldItemStacks[1] = var3 == null ? null : new ItemStack(var3);
						}
					}
				}
			}
			if (this.isBurning() && this.canSmelt()) {
				++this.goldCookTime;
				this.liquid += .1;

				if (this.goldCookTime == 200) {
					this.goldCookTime = 0;
					this.smeltItem();
					var2 = true;

				}
			} else {
				this.goldCookTime = 0;
			}
			if (var1 != (this.goldBurnTime > 0)) {
				var2 = true;
				this.validate();
			}
		}
		boolean check = this.isActive;
		this.isActive = this.isBurning();
		if (this.isActive != check) {
			this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
		}
		if (var2) {
			this.onInventoryChanged();
		}
	}

	/**
	 * Returns true if the furnace can smelt an item, i.e. has a source item,
	 * destination stack isn't full, etc.
	 */
	private boolean canSmelt() {
		if (this.goldItemStacks[0] == null) {
			return false;
		}

		ItemStack itemstack = RecipesLiquidator.liquidating().getRefiningResult(this.goldItemStacks[0].getItem().itemID);

		if (itemstack == null) {
			return false;
		}

		if (this.goldItemStacks[2] == null) {
			return true;
		}

		if (!this.goldItemStacks[2].isItemEqual(itemstack)) {
			return false;
		}

		if ((this.goldItemStacks[2].stackSize < this.getInventoryStackLimit()) && (this.goldItemStacks[2].stackSize < this.goldItemStacks[2].getMaxStackSize())) {
			return true;
		}

		return this.goldItemStacks[2].stackSize < itemstack.getMaxStackSize();
	}

	/**
	 * Turn one item from the furnace source stack into the appropriate smelted
	 * item in the furnace result stack
	 */
	public void smeltItem() {
		if (this.canSmelt()) {
			ItemStack var1 = RecipesLiquidator.liquidating().getRefiningResult(this.goldItemStacks[0].getItem().itemID);
			if (this.goldItemStacks[2] == null) {
				this.goldItemStacks[2] = var1.copy();
			} else if (this.goldItemStacks[2].itemID == var1.itemID) {
				++this.goldItemStacks[2].stackSize;
			}
			--this.goldItemStacks[0].stackSize;
			if (this.goldItemStacks[0].stackSize == 0) {
				Item var2 = this.goldItemStacks[0].getItem().getContainerItem();
				this.goldItemStacks[0] = var2 == null ? null : new ItemStack(var2);
			}
		}
	}

	/**
	 * Return true if item is a fuel source (getItemBurnTime() > 0).
	 */
	public static boolean isItemFuel(ItemStack par0ItemStack) {
		return getItemBurnTime(par0ItemStack) > 0;
	}

	/**
	 * Returns the number of ticks that the supplied fuel item will keep the
	 * furnace burning, or 0 if the item isn't fuel
	 */
	public static int getItemBurnTime(ItemStack is) {

		if (is == null) {
			return 0;
		}

		int i = is.getItem().itemID;

		if ((i < 256) && (Block.blocksList[i].blockMaterial == Material.wood)) {
			return 300;
		}

		if (i == Item.stick.itemID) {
			return 100;
		}

		if (i == Item.coal.itemID) {
			return 1600;
		}

		if (i == Item.bucketLava.itemID) {
			return 20000;
		}

		if (i == Block.sapling.blockID) {
			return 100;
		}

		if (i == Item.blazeRod.itemID) {
			return 2400;
		}
		if (i == Block.dirt.blockID) {
			return 200;
		} else {
			return ModLoader.addAllFuel(is.itemID, is.getItemDamage());
		}
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes
	 * with Container
	 */
	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		if (this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
			return false;
		}

		return par1EntityPlayer.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64D;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	public boolean isActive() {
		return this.isActive;
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
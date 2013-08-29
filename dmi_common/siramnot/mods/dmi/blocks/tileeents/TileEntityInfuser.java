package siramnot.mods.dmi.blocks.tileeents;

import siramnot.mods.dmi.core.managers.BlockManager;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInfuser extends TileEntity {

	private boolean isValid = false;

	public boolean checkFormation() {
		for (int x = -1; x <= 1; ++x) {
			for (int y = -1; y <= 1; ++y) {
				for (int z = -1; z <= 1; ++z) {
					int id = worldObj.getBlockId(xCoord + x, yCoord + y, zCoord + z);

					if (x == 0 && y == 0 && z == 0) {
						continue;

					} else if (Math.abs(x) == 1 || Math.abs(y) == 1 | Math.abs(z) == 1) {
						if (id == BlockManager.crystals.blockID && BlockManager.crystals.getDamageValue(worldObj, xCoord, yCoord, zCoord) == 0)
							continue;

					} else {
						if (id == Block.stone.blockID)
							continue;
						else
							return false;

					}
				}
			}
		}

		return true;
	}

	public void validate() {
		// FIXME: Add validation code
		isValid = true;
	}

	public void unvalidate() {
		// FIXME: Add un-validation code
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
}
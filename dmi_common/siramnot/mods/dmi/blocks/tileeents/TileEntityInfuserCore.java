package siramnot.mods.dmi.blocks.tileeents;

import siramnot.mods.dmi.blocks.BlockInfuserCore;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInfuserCore extends TileEntity {

	private boolean isValid = false;

	public boolean getIsValid() {
		return isValid;
	}

	public void nullify() {
		isValid = false;
		int metadata = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		metadata = metadata & BlockInfuserCore.MASK_DIR;
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, metadata, 2);
	}

}

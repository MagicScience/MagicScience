package siramnot.mods.dmi.power;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Cable extends BlockContainer {
	
	protected Cable(int id) {
		super(id, MaterialCable.getInstace());
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}
	
}
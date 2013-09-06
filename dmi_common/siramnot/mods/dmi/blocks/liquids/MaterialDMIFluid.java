package siramnot.mods.dmi.blocks.liquids;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialDMIFluid extends Material {

	private static MaterialDMIFluid instance;
	
	public MaterialDMIFluid(MapColor mapColor) {
		super(mapColor);
		this.setNoPushMobility();
		instance = this;
	}
	
	@Override
	public boolean isLiquid() {
		return true;
	}
	
	@Override
	public boolean isSolid() {
		return false;
	}
	
	@Override
	public boolean getCanBlockGrass() {
		return false;
	}
	
	@Override
	public boolean blocksMovement() {
		return false;
	}
	
	@Override
	public boolean getCanBurn() {
		return false;
	}
	
	public static MaterialDMIFluid instance() {
		if(instance == null) return null;
		return instance;
	}

}

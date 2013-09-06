package siramnot.mods.dmi.power;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialCable extends Material {

	private static MaterialCable instance;
	
	public MaterialCable() {
		super(MapColor.ironColor);
		
		this.setImmovableMobility();
	}
	
	@Override
	public boolean getCanBlockGrass() {
		return false;
	}
	
	@Override
	public boolean isOpaque() {
		return false;
	}
	
	public static MaterialCable getInstace() {
		if (instance == null) {
			instance = new MaterialCable();
		}
		
		return instance; 
	}
	
}

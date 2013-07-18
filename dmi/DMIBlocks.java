package siramnot.mods.dmi;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DMIBlocks extends Block {
	
	// variables and constants
	private static boolean CALL_ONCE = false;
	
	// blocks
	
	
	public DMIBlocks(int id, Material material) {
		super(id, material);
	}
	
	public void execute() {
		if (CALL_ONCE) return;
		load();
		name();
		
		CALL_ONCE = true;
	}
	
	private void load() {
		// TODO Add code here
	}
	
	private void name() {
		// TODO Add code here
	}
	
}

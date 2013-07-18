package siramnot.mods.dmi.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DMIBlocks {
	
	public static Block aqueousOre;
	
	
	public static void load() {
		
		aqueousOre = new BlockAqueousCrystalOre(600);
		
		languageRegistry();
		gameRegistry();
		
	}


	private static void gameRegistry() {
		GameRegistry.registerBlock(aqueousOre, "Aqueous Ore");
		
	}


	private static void languageRegistry() {
		// TODO Auto-generated method stub
		LanguageRegistry.addName(aqueousOre, "Aqueous Ore");
	}
}

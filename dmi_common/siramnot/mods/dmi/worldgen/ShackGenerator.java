package siramnot.mods.dmi.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class ShackGenerator implements IWorldGenerator {
	
	private static ShackGenerator instance;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

	}
	
	public static ShackGenerator getInstance() {
		if (instance == null) {
			instance = new ShackGenerator();
		}
		
		return instance;
	}

}

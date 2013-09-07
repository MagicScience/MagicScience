package siramnot.mods.dmi.worldgen;

import java.util.Random;

import siramnot.mods.dmi.worldgen.structures.ShackStructure;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class ShackGenerator implements IWorldGenerator {
	
	private static ShackGenerator instance;

	@Override
	public void generate(Random random, int x, int z, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		int xCoord = x + random.nextInt(16);
		int yCoord = 50 + random.nextInt(50);
		int zCoord = z + random.nextInt(16);
		
		ShackStructure.getInstance().generate(world, random, xCoord, yCoord, zCoord);
	}
	
	public static ShackGenerator getInstance() {
		if (instance == null) {
			instance = new ShackGenerator();
		}
		
		return instance;
	}

}

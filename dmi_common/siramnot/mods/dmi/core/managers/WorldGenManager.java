package siramnot.mods.dmi.core.managers;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class WorldGenManager implements IWorldGenerator {

	private static WorldGenManager instance = new WorldGenManager();

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			this.generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			this.generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	private void generateNether(World world, Random random, int x, int z) {
	}

	private void generateSurface(World world, Random random, int x, int z) {
		int y = world.getActualHeight();
	}

	private void generateEnd(World world, Random random, int x, int z) {

	}

	public static WorldGenManager getInstance() {
		return instance;
	}
}

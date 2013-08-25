package siramnot.mods.dmi.core.managers;

import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * Dominus ex Magica et Industra mod. (C) Copyright SirAmNot 2013
 * 
 * @author SirAmNot
 */
public class DMIWorldGenManager implements IWorldGenerator {

	private static DMIWorldGenManager instance = new DMIWorldGenManager();

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
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

	private void generateNether(World world, Random random, int i, int j) { }
	private void generateSurface(World world, Random random, int i, int j) { }
	private void generateEnd(World world, Random random, int i, int j) { }

	public static DMIWorldGenManager getInstance() {
		return instance;
	}
}

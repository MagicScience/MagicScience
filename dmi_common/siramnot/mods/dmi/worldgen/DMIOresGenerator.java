package siramnot.mods.dmi.worldgen;

import java.util.Random;

import siramnot.mods.dmi.core.managers.BlockManager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class DMIOresGenerator implements IWorldGenerator{
	
	public DMIOresGenerator()
	
	{
		air = new WorldGenMinable(BlockManager.ores.blockID, 3, 7, Block.stone.blockID);
		fire = new WorldGenMinable(BlockManager.ores.blockID, 2, 7, Block.stone.blockID);
		water = new WorldGenMinable(BlockManager.ores.blockID, 0, 7, Block.stone.blockID);
		earth = new WorldGenMinable(BlockManager.ores.blockID, 1, 7, Block.stone.blockID);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		int xPos, yPos, zPos;
		{
			for (int r = 0; r <= 10; r++)
			{
				 xPos = chunkX + random.nextInt(16);
				 yPos = 5 + random.nextInt(5 - 100);
				 zPos = chunkZ + random.nextInt(16);
	             air.generate(world, random, xPos, yPos, zPos);
			}
			
			for (int r = 0; r <= 10; r++)
			{
				 xPos = chunkX + random.nextInt(16);
				 yPos = 5 + random.nextInt(5 - 100);
				 zPos = chunkZ + random.nextInt(16);
	             fire.generate(world, random, xPos, yPos, zPos);
			}
			
			for (int r = 0; r <= 10; r++)
			{
				 xPos = chunkX + random.nextInt(16);
				 yPos = 5 + random.nextInt(5 - 100);
				 zPos = chunkZ + random.nextInt(16);
	             water.generate(world, random, xPos, yPos, zPos);
			}
			
			for (int r = 0; r <= 10; r++)
			{
				 xPos = chunkX + random.nextInt(16);
				 yPos = 5 + random.nextInt(5 - 100);
				 zPos = chunkZ + random.nextInt(16);
	             earth.generate(world, random, xPos, yPos, zPos);
			}
		}
		
	}
	
	 WorldGenMinable air;
	 WorldGenMinable fire;
	 WorldGenMinable water;
	 WorldGenMinable earth;
}

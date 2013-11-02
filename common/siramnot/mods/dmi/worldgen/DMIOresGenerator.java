package siramnot.mods.dmi.worldgen;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.feature.*;
import siramnot.mods.dmi.*;
import siramnot.mods.dmi.core.*;
import siramnot.mods.dmi.core.managers.*;

/**
 * 
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 *
 */
public class DMIOresGenerator {

	static WorldGenMinable water, earth, fire, air;
	static {
		water = new WorldGenMinable(BlockManager.ores.blockID, 0, 7, Block.stone.blockID);
		earth = new WorldGenMinable(BlockManager.ores.blockID, 1, 7, Block.stone.blockID);
		fire = new WorldGenMinable(BlockManager.ores.blockID, 2, 7, Block.stone.blockID);
		air = new WorldGenMinable(BlockManager.ores.blockID, 3, 7, Block.stone.blockID);
	}

	public static void generate(Random random, int chunkX, int chunkZ, World world, WorldGenMinable ore) {
		int xPos, yPos, zPos;
		int blocksPerChunk = 16, k = 5, j = 100;

		if (ore.equals(water)) {
			for (int i = 0; i <= 10; i++) {
				xPos = chunkX + random.nextInt(blocksPerChunk);
				yPos = k + random.nextInt(j - k);
				zPos = chunkZ + random.nextInt(blocksPerChunk);
				water.generate(world, random, xPos, yPos, zPos);
			}
			return;
		}

		if (ore.equals(earth)) {
			for (int i = 0; i <= 10; i++) {
				xPos = chunkX + random.nextInt(blocksPerChunk);
				yPos = k + random.nextInt(j - k);
				zPos = chunkZ + random.nextInt(blocksPerChunk);
				earth.generate(world, random, xPos, yPos, zPos);
			}
			return;
		}

		if (ore.equals(fire)) {
			for (int i = 0; i <= 10; i++) {
				xPos = chunkX + random.nextInt(blocksPerChunk);
				yPos = k + random.nextInt(j - k);
				zPos = chunkZ + random.nextInt(blocksPerChunk);
				fire.generate(world, random, xPos, yPos, zPos);
			}
			return;
		}

		if (ore.equals(air)) {
			for (int i = 0; i <= 10; i++) {
				xPos = chunkX + random.nextInt(blocksPerChunk);
				yPos = k + random.nextInt(j - k);
				zPos = chunkZ + random.nextInt(blocksPerChunk);
				air.generate(world, random, xPos, yPos, zPos);
			}
			return;
		}
		
		String err = String.format("[%s] [/!\\] Failed to generate ore \"%1\".", Reference.MOD_ID, ore);
		System.err.println(err);

	}

}

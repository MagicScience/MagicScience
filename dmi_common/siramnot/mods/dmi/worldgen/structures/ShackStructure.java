package siramnot.mods.dmi.worldgen.structures;

import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ShackStructure extends WorldGenerator {
	public List<Integer> whitelist = getListOnArray(1, 2, 12);
	public int xDim = 7;
	public int yDim = 5;
	public int zDim = 7;
	public int solids = 80;
	public int nonsolids = 60;
	private static ShackStructure instance;

	public List<Integer> getListOnArray(int... ints) {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i : ints) {
			intList.add(i);
		}
		return intList;
	}

	public boolean checkSpawn(World world, int x, int y, int z) {
		int solidBlocksInPlatform = 0, freeBlocksInSpace = 0;
		for (int i = 0; i < xDim; ++i)
			for (int k = 0; k < zDim; ++k) {
				if (world.getBlockId(x + i, y - 1, z + k) != 0 && whitelist.contains(world.getBlockId(x + i, y - 1, z + k)) && !Block.blocksList[world.getBlockId(x + i, y - 1, z + k)].blockMaterial.isReplaceable())
					solidBlocksInPlatform++;
				for (int j = 0; j < yDim; ++j) {
					if (world.isAirBlock(x + i, y + j, z + k) || Block.blocksList[world.getBlockId(x + i, y + j, z + k)].blockMaterial.isReplaceable())
						freeBlocksInSpace++;
				}
			}
		return Math.round((freeBlocksInSpace / (xDim * zDim * yDim)) * 100.0f) > solids && Math.round((solidBlocksInPlatform / xDim * zDim) * 100.0f) > nonsolids;
	}

	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
		if (checkSpawn(par1World, par3, par4, par5)) {
			generateShack(par1World, par2Random, par3, par4, par5);
			return true;
		} else
			return false;
	}

	public boolean generateShack(World worldObj, Random par2Random, int origin_x, int origin_y, int origin_z) {
		worldObj.setBlock(origin_x + 0, origin_y + 0, origin_z + 0, 0, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 0, origin_z + 0, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 0, origin_z + 0, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 0, origin_z + 0, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 0, origin_z + 0, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 0, origin_z + 0, 0, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 0, origin_z + 0, 0, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 0, origin_z + 1, 0, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 0, origin_z + 1, 5, 2, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 0, origin_z + 1, 5, 2, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 0, origin_z + 1, 5, 2, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 0, origin_z + 1, 5, 2, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 0, origin_z + 1, 5, 2, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 0, origin_z + 1, 0, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 0, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 0, origin_z + 2, 5, 2, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 0, origin_z + 2, 5, 2, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 0, origin_z + 2, 5, 2, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 0, origin_z + 2, 5, 2, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 0, origin_z + 2, 5, 2, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 0, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 0, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 0, origin_z + 3, 5, 2, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 0, origin_z + 3, 5, 2, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 0, origin_z + 3, 5, 2, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 0, origin_z + 3, 5, 2, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 0, origin_z + 3, 5, 2, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 0, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 0, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 0, origin_z + 4, 5, 2, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 0, origin_z + 4, 5, 2, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 0, origin_z + 4, 5, 2, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 0, origin_z + 4, 5, 2, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 0, origin_z + 4, 5, 2, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 0, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 0, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 0, origin_z + 5, 5, 2, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 0, origin_z + 5, 5, 2, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 0, origin_z + 5, 5, 2, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 0, origin_z + 5, 5, 2, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 0, origin_z + 5, 5, 2, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 0, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 0, origin_z + 6, 0, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 0, origin_z + 6, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 0, origin_z + 6, 5, 2, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 0, origin_z + 6, 5, 2, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 0, origin_z + 6, 5, 2, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 0, origin_z + 6, 0, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 0, origin_z + 6, 0, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 1, origin_z + 0, 109, 2, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 1, origin_z + 0, 109, 2, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 1, origin_z + 0, 109, 2, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 1, origin_z + 0, 109, 2, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 1, origin_z + 0, 109, 2, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 1, origin_z + 0, 109, 2, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 1, origin_z + 0, 109, 2, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 1, origin_z + 1, 109, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 1, origin_z + 1, 26, 10, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 1, origin_z + 1, 113, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 1, origin_z + 1, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 1, origin_z + 1, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 1, origin_z + 1, 58, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 1, origin_z + 1, 109, 1, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 1, origin_z + 2, 109, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 1, origin_z + 2, 26, 2, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 1, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 1, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 1, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 1, origin_z + 2, 121, 1, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 1, origin_z + 2, 109, 1, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 1, origin_z + 3, 109, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 1, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 1, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 1, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 1, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 1, origin_z + 3, 61, 4, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 1, origin_z + 3, 109, 1, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 1, origin_z + 4, 109, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 1, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 1, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 1, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 1, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 1, origin_z + 4, 54, 4, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 1, origin_z + 4, 109, 1, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 1, origin_z + 5, 109, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 1, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 1, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 1, origin_z + 5, 72, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 1, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 1, origin_z + 5, 54, 4, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 1, origin_z + 5, 109, 1, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 1, origin_z + 6, 109, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 1, origin_z + 6, 109, 3, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 1, origin_z + 6, 130, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 1, origin_z + 6, 64, 3, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 1, origin_z + 6, 130, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 1, origin_z + 6, 109, 3, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 1, origin_z + 6, 109, 3, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 2, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 2, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 2, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 2, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 2, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 2, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 2, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 2, origin_z + 1, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 2, origin_z + 1, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 2, origin_z + 1, 171, 12, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 2, origin_z + 1, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 2, origin_z + 1, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 2, origin_z + 1, 0, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 2, origin_z + 1, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 2, origin_z + 2, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 2, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 2, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 2, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 2, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 2, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 2, origin_z + 2, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 2, origin_z + 3, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 2, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 2, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 2, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 2, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 2, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 2, origin_z + 3, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 2, origin_z + 4, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 2, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 2, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 2, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 2, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 2, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 2, origin_z + 4, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 2, origin_z + 5, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 2, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 2, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 2, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 2, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 2, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 2, origin_z + 5, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 2, origin_z + 6, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 2, origin_z + 6, 102, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 2, origin_z + 6, 130, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 2, origin_z + 6, 64, 8, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 2, origin_z + 6, 130, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 2, origin_z + 6, 102, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 2, origin_z + 6, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 3, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 3, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 3, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 3, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 3, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 3, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 3, origin_z + 0, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 3, origin_z + 1, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 3, origin_z + 1, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 3, origin_z + 1, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 3, origin_z + 1, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 3, origin_z + 1, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 3, origin_z + 1, 0, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 3, origin_z + 1, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 3, origin_z + 2, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 3, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 3, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 3, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 3, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 3, origin_z + 2, 0, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 3, origin_z + 2, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 3, origin_z + 3, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 3, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 3, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 3, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 3, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 3, origin_z + 3, 0, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 3, origin_z + 3, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 3, origin_z + 4, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 3, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 3, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 3, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 3, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 3, origin_z + 4, 0, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 3, origin_z + 4, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 3, origin_z + 5, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 3, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 3, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 3, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 3, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 3, origin_z + 5, 0, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 3, origin_z + 5, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 3, origin_z + 6, 102, 0, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 3, origin_z + 6, 102, 0, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 3, origin_z + 6, 130, 0, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 3, origin_z + 6, 130, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 3, origin_z + 6, 130, 0, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 3, origin_z + 6, 102, 0, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 3, origin_z + 6, 102, 0, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 4, origin_z + 0, 109, 4, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 4, origin_z + 0, 109, 6, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 4, origin_z + 0, 109, 6, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 4, origin_z + 0, 109, 6, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 4, origin_z + 0, 109, 6, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 4, origin_z + 0, 109, 6, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 4, origin_z + 0, 109, 6, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 4, origin_z + 1, 109, 4, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 4, origin_z + 1, 44, 13, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 4, origin_z + 1, 44, 13, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 4, origin_z + 1, 44, 13, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 4, origin_z + 1, 44, 13, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 4, origin_z + 1, 44, 13, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 4, origin_z + 1, 109, 5, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 4, origin_z + 2, 109, 4, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 4, origin_z + 2, 44, 13, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 4, origin_z + 2, 44, 13, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 4, origin_z + 2, 44, 13, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 4, origin_z + 2, 44, 13, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 4, origin_z + 2, 44, 13, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 4, origin_z + 2, 109, 5, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 4, origin_z + 3, 109, 4, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 4, origin_z + 3, 44, 13, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 4, origin_z + 3, 44, 13, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 4, origin_z + 3, 89, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 4, origin_z + 3, 44, 13, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 4, origin_z + 3, 44, 13, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 4, origin_z + 3, 109, 5, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 4, origin_z + 4, 109, 4, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 4, origin_z + 4, 44, 13, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 4, origin_z + 4, 44, 13, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 4, origin_z + 4, 44, 13, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 4, origin_z + 4, 44, 13, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 4, origin_z + 4, 44, 13, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 4, origin_z + 4, 109, 5, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 4, origin_z + 5, 109, 4, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 4, origin_z + 5, 44, 13, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 4, origin_z + 5, 44, 13, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 4, origin_z + 5, 44, 13, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 4, origin_z + 5, 44, 13, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 4, origin_z + 5, 44, 13, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 4, origin_z + 5, 109, 5, 1);
		worldObj.setBlock(origin_x + 0, origin_y + 4, origin_z + 6, 109, 4, 1);
		worldObj.setBlock(origin_x + 1, origin_y + 4, origin_z + 6, 109, 7, 1);
		worldObj.setBlock(origin_x + 2, origin_y + 4, origin_z + 6, 109, 4, 1);
		worldObj.setBlock(origin_x + 3, origin_y + 4, origin_z + 6, 98, 0, 1);
		worldObj.setBlock(origin_x + 4, origin_y + 4, origin_z + 6, 109, 5, 1);
		worldObj.setBlock(origin_x + 5, origin_y + 4, origin_z + 6, 109, 7, 1);
		worldObj.setBlock(origin_x + 6, origin_y + 4, origin_z + 6, 109, 7, 1);
		return true;
	}

	public static ShackStructure getInstance() {
		if (instance == null) {
			instance = new ShackStructure();
		}
		
		return instance;
	}
}

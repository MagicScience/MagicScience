package siramnot.mods.dmi.util;


import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;


public class Utils
{
	Icon k;
	
	static Utils		instance;
	static final float	RAYTRACE_TICK_TIME	= 1.0f;
	
	private Utils()
	{
		;
	}
	
	public Vec3 getBlockLookingAt(EntityPlayer plr, double distance)
	{
		MovingObjectPosition pos = plr.rayTrace(distance, RAYTRACE_TICK_TIME);
		if (pos == null)
		{
			if (!plr.worldObj.isRemote)
			{
				plr.addChatMessage("Unable to raycast, contact SirAmNot");
			}
			return Vec3.createVectorHelper(0.0f, 0.0f, 0.0f);
		}
		double posX = pos.blockX;
		double posY = pos.blockY;
		double posZ = pos.blockZ;
		
		return Vec3.createVectorHelper(posX, posY, posZ);
	}
	
	public Vec3 getEntityLookingAt(EntityPlayer plr, double distance)
	{
		MovingObjectPosition pos;
		return null;
	}
	
	public int getBlockSide(EntityPlayer plr, int distance)
	{
		int blockFace = plr.rayTrace(distance, RAYTRACE_TICK_TIME).sideHit;
		
		return blockFace;
	}
	
	public static Utils getInstance()
	{
		if (instance == null)
		{
			instance = new Utils();
		}
		
		return instance;
	}
	
}

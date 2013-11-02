package siramnot.mods.dmi.entity.mobs.render;


import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import siramnot.mods.dmi.*;
import siramnot.mods.dmi.core.*;


/**
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author Tombenpotter
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class RenderVolatileSkeleton extends RenderSkeleton
{
	
	private static final String				TEXTUREPATH	= Reference.MOB_TEXTURE_LOCATION + "/EntityVolatileSkeleton.png";
	private static final ResourceLocation	TEXTURE		= new ResourceLocation(Reference.MOD_ID, TEXTUREPATH);
	
	public RenderVolatileSkeleton()
	{
		super();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return TEXTURE;
	}
	
}

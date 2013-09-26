package siramnot.mods.dmi.entity.mobs.render;


import siramnot.mods.dmi.DMI;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


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
	
	private static final String				TEXTUREPATH	= "textures/mobs/EntityVolatileSkeleton.png";
	private static final ResourceLocation	TEXTURE		= new ResourceLocation(DMI.MOD_ID.toLowerCase(), TEXTUREPATH);
	
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

package siramnot.mods.dmi.entity.mobs.render;


import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import siramnot.mods.dmi.*;
import siramnot.mods.dmi.core.*;


public class RenderExplosiveBall extends Render
{
	
	private static final String PATH = Reference.MOB_TEXTURE_LOCATION + "/ExplosiveBall.png";
	private static ResourceLocation	textureLocation	= new ResourceLocation(Reference.MOD_ID, PATH);
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return textureLocation;
	}
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1)
	{	
		;
	}
	
}

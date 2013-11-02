package siramnot.mods.dmi.entity.mobs.render;


import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import siramnot.mods.dmi.*;
import siramnot.mods.dmi.core.*;
import siramnot.mods.dmi.models.*;


public class RenderKaldymBoss extends RenderLiving
{
	private static final String		PATH			= Reference.MOB_TEXTURE_LOCATION + "/KaldymModel.png";
	private static ModelBase		model			= new KaldymModel();
	private static float			shadowSize		= 2.5f;
	private static ResourceLocation	textureLocation	= new ResourceLocation(Reference.MOD_ID.toLowerCase(), PATH);
	
	public RenderKaldymBoss()
	{
		super(model, shadowSize);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return textureLocation;
	}
	
}

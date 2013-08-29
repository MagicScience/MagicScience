package siramnot.mods.dmi.mobs;

import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;



public class BlazeSpiderRender extends RenderSpider {
	
	public BlazeSpiderRender()
	{
		super();
	}

	@Override
	
	protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return texture;
    }
    
    static final ResourceLocation texture = new ResourceLocation("dmi", "textures/mob/entityblazepider.png");


}

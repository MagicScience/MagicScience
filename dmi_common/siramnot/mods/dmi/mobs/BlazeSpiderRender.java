package siramnot.mods.dmi.mobs;

import siramnot.mods.dmi.DMI;
import net.minecraft.client.renderer.entity.RenderSpider;
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
public class BlazeSpiderRender extends RenderSpider {

	private static final String TEXTUREPATH = "textures/mobs/EntityBlazeSpider.png";
	private static final ResourceLocation texture = new ResourceLocation(DMI.MOD_ID.toLowerCase(), TEXTUREPATH);

	public BlazeSpiderRender() {
		super();
	}

	@Override
	protected ResourceLocation func_110775_a(Entity par1Entity) {
		return texture;
	}

}

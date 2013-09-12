package siramnot.mods.dmi.entity.mobs.render;

import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.models.ExplosiveBallModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderExplosiveBall extends Render{

	private static ModelBase model = new ExplosiveBallModel();
	private static float shadowSize = 2.5f;
	private static ResourceLocation textureLocation = new ResourceLocation(DMI.MOD_ID.toLowerCase(), "textures/mobs/ExplosiveBall.png");


	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return textureLocation;
	}

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2,
			float f, float f1) {
		// TODO Auto-generated method stub
		
	}

}

package siramnot.mods.dmi.mobs.render;

import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.models.ModelKaldymBoss;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderKaldymBoss extends RenderLiving {

	private static ModelBase model = new ModelKaldymBoss();
	private static float shadowSize = 2.5f;
	private static ResourceLocation textureLocation = new ResourceLocation(DMI.MOD_ID.toLowerCase(), "textures/mobs/KaldymBoss.png");

	public RenderKaldymBoss() {
		super(model, shadowSize);
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return textureLocation;
	}

}

package siramnot.mods.dmi.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

/**
 * 
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 *
 */
public class ModelBatteryBlock extends ModelBase
{
	//fields
	ModelRenderer	body;
	ModelRenderer	cap;
	
	public ModelBatteryBlock()
	{
		textureWidth = 32;
		textureHeight = 32;
		
		body = new ModelRenderer(this, 0, 0);
		body.addBox(0F, 0F, 0F, 6, 15, 6);
		body.setRotationPoint(-3F, 9F, -3F);
		body.setTextureSize(32, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		cap = new ModelRenderer(this, 18, 3);
		cap.addBox(0F, 0F, 0F, 2, 1, 2);
		cap.setRotationPoint(-1F, 8F, -1F);
		cap.setTextureSize(32, 32);
		cap.mirror = true;
		setRotation(cap, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		body.render(f5);
		cap.render(f5);
	}
	
	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
}

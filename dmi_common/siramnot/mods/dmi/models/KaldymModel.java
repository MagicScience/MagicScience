package siramnot.mods.dmi.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class KaldymModel extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer head2;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer neck2;
    ModelRenderer neck1;
    ModelRenderer linktoarm1;
    ModelRenderer linktoarm2;
  
  public KaldymModel()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(-5F, -8F, 1F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      head2 = new ModelRenderer(this, 0, 35);
      head2.addBox(0F, 0F, 0F, 8, 8, 8);
      head2.setRotationPoint(1F, -16F, -3F);
      head2.setTextureSize(64, 32);
      head2.mirror = true;
      setRotation(head2, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, -4F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-8F, 0F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, -1.570796F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(8F, 0F, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, -1.570796F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 14, 4);
      rightleg.setRotationPoint(-2F, 10F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 14, 4);
      leftleg.setRotationPoint(2F, 10F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      neck2 = new ModelRenderer(this, 56, 16);
      neck2.addBox(0F, 0F, 0F, 2, 4, 2);
      neck2.setRotationPoint(2F, -8F, -1F);
      neck2.setTextureSize(64, 32);
      neck2.mirror = true;
      setRotation(neck2, 0F, 0F, 0.0174533F);
      neck1 = new ModelRenderer(this, 36, 0);
      neck1.addBox(0F, 0F, 0F, 2, 4, 2);
      neck1.setRotationPoint(-4F, -8F, -1F);
      neck1.setTextureSize(64, 32);
      neck1.mirror = true;
      setRotation(neck1, 0F, 0F, 0F);
      linktoarm1 = new ModelRenderer(this, 34, 35);
      linktoarm1.addBox(0F, 0F, 0F, 3, 4, 2);
      linktoarm1.setRotationPoint(-7F, -2F, 0F);
      linktoarm1.setTextureSize(64, 32);
      linktoarm1.mirror = true;
      setRotation(linktoarm1, 0F, 0F, 0F);
      linktoarm2 = new ModelRenderer(this, 34, 42);
      linktoarm2.addBox(0F, 0F, 0F, 3, 4, 2);
      linktoarm2.setRotationPoint(4F, -2F, 0F);
      linktoarm2.setTextureSize(64, 32);
      linktoarm2.mirror = true;
      setRotation(linktoarm2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    head2.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    neck2.render(f5);
    neck1.render(f5);
    linktoarm1.render(f5);
    linktoarm2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) 
  {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		//That gives the correct movement of its legs
		this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.rightleg.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleY = 0.0F;
        
        //That gives the correct movement of its arm
        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;
        this.rightarm.rotateAngleY = -(0.1F - f4 * 0.6F);
        this.leftarm.rotateAngleY = 0.1F - f4 * 0.6F;
        this.rightarm.rotateAngleX = -((float)Math.PI / 2F);
        this.leftarm.rotateAngleX = -((float)Math.PI / 2F);
        this.rightarm.rotateAngleX -= f4 * 1.2F - f5 * 0.4F;
        this.leftarm.rotateAngleX -= f4 * 1.2F - f5 * 0.4F;
        this.rightarm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        this.leftarm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        this.rightarm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
        this.leftarm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;

}
}

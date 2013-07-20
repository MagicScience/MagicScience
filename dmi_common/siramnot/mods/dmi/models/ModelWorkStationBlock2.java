package siramnot.mods.dmi.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWorkStationBlock2 extends ModelBase
{
  //fields
    ModelRenderer leg0;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer bookLeft;
    ModelRenderer bookStandLeveler;
    ModelRenderer bookRight;
    ModelRenderer bookStandBody;
    ModelRenderer bookStandFoot;
    ModelRenderer bookPageLeft;
    ModelRenderer desk;
    ModelRenderer wrenchBody;
    ModelRenderer wrenchTopRight;
    ModelRenderer wrenchTopLeft;
    ModelRenderer wrenchMidBottom;
    ModelRenderer wandBody;
  
  public ModelWorkStationBlock2()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      leg0 = new ModelRenderer(this, 0, 0);
      leg0.addBox(0F, 0F, 0F, 1, 14, 1);
      leg0.setRotationPoint(7F, 10F, -8F);
      leg0.setTextureSize(64, 32);
      leg0.mirror = true;
      setRotation(leg0, 0F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 0);
      leg1.addBox(0F, 0F, 0F, 1, 14, 1);
      leg1.setRotationPoint(7F, 10F, 7F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 0);
      leg2.addBox(0F, 0F, 0F, 1, 14, 1);
      leg2.setRotationPoint(-8F, 10F, 7F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 0);
      leg3.addBox(0F, 0F, 0F, 1, 14, 1);
      leg3.setRotationPoint(-8F, 10F, -8F);
      leg3.setTextureSize(64, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      bookLeft = new ModelRenderer(this, 48, 0);
      bookLeft.addBox(-3.1F, 0F, 0F, 3, 1, 5);
      bookLeft.setRotationPoint(0F, 8F, -6F);
      bookLeft.setTextureSize(64, 32);
      bookLeft.mirror = true;
      setRotation(bookLeft, 0.6108652F, 0F, 0F);
      bookStandLeveler = new ModelRenderer(this, 48, 6);
      bookStandLeveler.addBox(-0.5F, 0F, 3F, 1, 2, 0);
      bookStandLeveler.setRotationPoint(0F, 8F, -6F);
      bookStandLeveler.setTextureSize(64, 32);
      bookStandLeveler.mirror = true;
      setRotation(bookStandLeveler, 0.2094395F, 0F, 0F);
      bookRight.mirror = true;
      bookRight = new ModelRenderer(this, 48, 0);
      bookRight.addBox(0.1F, 0F, 0F, 3, 1, 5);
      bookRight.setRotationPoint(0F, 8F, -6F);
      bookRight.setTextureSize(64, 32);
      bookRight.mirror = true;
      setRotation(bookRight, 0.6108652F, 0F, 0F);
      bookRight.mirror = false;
      bookStandBody = new ModelRenderer(this, 41, 26);
      bookStandBody.addBox(-3F, 1.1F, 0F, 6, 0, 5);
      bookStandBody.setRotationPoint(0F, 8F, -6F);
      bookStandBody.setTextureSize(64, 32);
      bookStandBody.mirror = true;
      setRotation(bookStandBody, 0.5934119F, 0F, 0F);
      bookStandFoot = new ModelRenderer(this, 52, 6);
      bookStandFoot.addBox(-0.5F, 0F, 0F, 1, 1, 4);
      bookStandFoot.setRotationPoint(0F, 8.75F, -5.3F);
      bookStandFoot.setTextureSize(64, 32);
      bookStandFoot.mirror = true;
      setRotation(bookStandFoot, 0F, 0F, 0F);
      bookPageLeft = new ModelRenderer(this, 4, 23);
      bookPageLeft.addBox(-2.5F, 0.5F, 0F, 5, 1, 4);
      bookPageLeft.setRotationPoint(0F, 7F, -6F);
      bookPageLeft.setTextureSize(64, 32);
      bookPageLeft.mirror = true;
      setRotation(bookPageLeft, 0.6108652F, 0F, 0F);
      desk = new ModelRenderer(this, 0, 0);
      desk.addBox(0F, 0F, 0F, 16, 1, 16);
      desk.setRotationPoint(-8F, 9F, -8F);
      desk.setTextureSize(64, 32);
      desk.mirror = true;
      setRotation(desk, 0F, 0F, 0F);
      wrenchBody = new ModelRenderer(this, 15, 17);
      wrenchBody.addBox(0F, 0F, 0F, 1, 1, 4);
      wrenchBody.setRotationPoint(-5F, 8F, 0F);
      wrenchBody.setTextureSize(64, 32);
      wrenchBody.mirror = true;
      setRotation(wrenchBody, 0F, 0.2617994F, 0F);
      wrenchTopRight = new ModelRenderer(this, 9, 17);
      wrenchTopRight.addBox(-1F, 0F, 3F, 1, 1, 2);
      wrenchTopRight.setRotationPoint(-5F, 8F, 0F);
      wrenchTopRight.setTextureSize(64, 32);
      wrenchTopRight.mirror = true;
      setRotation(wrenchTopRight, 0F, 0.2617994F, 0F);
      wrenchTopLeft = new ModelRenderer(this, 9, 17);
      wrenchTopLeft.addBox(1F, 0F, 3F, 1, 1, 2);
      wrenchTopLeft.setRotationPoint(-5F, 8F, 0F);
      wrenchTopLeft.setTextureSize(64, 32);
      wrenchTopLeft.mirror = true;
      setRotation(wrenchTopLeft, 0F, 0.2617994F, 0F);
      wrenchMidBottom = new ModelRenderer(this, 9, 20);
      wrenchMidBottom.addBox(-1F, 0F, 2F, 2, 1, 1);
      wrenchMidBottom.setRotationPoint(-4.5F, 8F, 0.5F);
      wrenchMidBottom.setTextureSize(64, 32);
      wrenchMidBottom.mirror = true;
      setRotation(wrenchMidBottom, 0F, 0.2617994F, 0F);
      wandBody = new ModelRenderer(this, 43, 17);
      wandBody.addBox(0F, 0F, 0F, 1, 1, 5);
      wandBody.setRotationPoint(4F, 8F, 0F);
      wandBody.setTextureSize(64, 32);
      wandBody.mirror = true;
      setRotation(wandBody, 0F, -0.2617994F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    leg0.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    bookLeft.render(f5);
    bookStandLeveler.render(f5);
    bookRight.render(f5);
    bookStandBody.render(f5);
    bookStandFoot.render(f5);
    bookPageLeft.render(f5);
    desk.render(f5);
    wrenchBody.render(f5);
    wrenchTopRight.render(f5);
    wrenchTopLeft.render(f5);
    wrenchMidBottom.render(f5);
    wandBody.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}

package siramnot.mods.dmi.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWorkStation extends ModelBase {
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

	ModelRenderer wrenchBody;
	ModelRenderer wrenchTopRight;
	ModelRenderer wrenchTopLeft;
	ModelRenderer wrenchMidBottom;

	ModelRenderer desk;
	ModelRenderer wandBody;

	public ModelWorkStation() {
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.leg0 = new ModelRenderer(this, 0, 0);
		this.leg0.addBox(0F, 0F, 0F, 1, 14, 1);
		this.leg0.setRotationPoint(7F, 10F, -8F);
		this.leg0.setTextureSize(64, 32);
		this.leg0.mirror = true;
		this.setRotation(this.leg0, 0F, 0F, 0F);

		this.leg1 = new ModelRenderer(this, 0, 0);
		this.leg1.addBox(0F, 0F, 0F, 1, 14, 1);
		this.leg1.setRotationPoint(7F, 10F, 7F);
		this.leg1.setTextureSize(64, 32);
		this.leg1.mirror = true;
		this.setRotation(this.leg1, 0F, 0F, 0F);

		this.leg2 = new ModelRenderer(this, 0, 0);
		this.leg2.addBox(0F, 0F, 0F, 1, 14, 1);
		this.leg2.setRotationPoint(-8F, 10F, 7F);
		this.leg2.setTextureSize(64, 32);
		this.leg2.mirror = true;
		this.setRotation(this.leg2, 0F, 0F, 0F);

		this.leg3 = new ModelRenderer(this, 0, 0);
		this.leg3.addBox(0F, 0F, 0F, 1, 14, 1);
		this.leg3.setRotationPoint(-8F, 10F, -8F);
		this.leg3.setTextureSize(64, 32);
		this.leg3.mirror = true;
		this.setRotation(this.leg3, 0F, 0F, 0F);

		this.bookLeft = new ModelRenderer(this, 48, 0);
		this.bookLeft.addBox(-3.1F, 0F, 0F, 3, 1, 5);
		this.bookLeft.setRotationPoint(0F, 8F, -6F);
		this.bookLeft.setTextureSize(64, 32);
		this.bookLeft.mirror = true;
		this.setRotation(this.bookLeft, 0.6108652F, 0F, 0F);

		this.bookStandLeveler = new ModelRenderer(this, 48, 6);
		this.bookStandLeveler.addBox(-0.5F, 0F, 3F, 1, 2, 0);
		this.bookStandLeveler.setRotationPoint(0F, 8F, -6F);
		this.bookStandLeveler.setTextureSize(64, 32);
		this.bookStandLeveler.mirror = true;
		this.setRotation(this.bookStandLeveler, 0.2094395F, 0F, 0F);

		this.bookRight = new ModelRenderer(this, 48, 0);
		this.bookRight.addBox(0.1F, 0F, 0F, 3, 1, 5);
		this.bookRight.setRotationPoint(0F, 8F, -6F);
		this.bookRight.setTextureSize(64, 32);
		this.bookRight.mirror = true;
		this.setRotation(this.bookRight, 0.6108652F, 0F, 0F);

		this.bookRight.mirror = false;
		this.bookStandBody = new ModelRenderer(this, 41, 26);
		this.bookStandBody.addBox(-3F, 1.1F, 0F, 6, 0, 5);
		this.bookStandBody.setRotationPoint(0F, 8F, -6F);
		this.bookStandBody.setTextureSize(64, 32);
		this.bookStandBody.mirror = true;
		this.setRotation(this.bookStandBody, 0.5934119F, 0F, 0F);

		this.bookStandFoot = new ModelRenderer(this, 52, 6);
		this.bookStandFoot.addBox(-0.5F, 0F, 0F, 1, 1, 4);
		this.bookStandFoot.setRotationPoint(0F, 8.75F, -5.3F);
		this.bookStandFoot.setTextureSize(64, 32);
		this.bookStandFoot.mirror = true;
		this.setRotation(this.bookStandFoot, 0F, 0F, 0F);

		this.bookPageLeft = new ModelRenderer(this, 4, 23);
		this.bookPageLeft.addBox(-2.5F, 0.5F, 0F, 5, 1, 4);
		this.bookPageLeft.setRotationPoint(0F, 7F, -6F);
		this.bookPageLeft.setTextureSize(64, 32);
		this.bookPageLeft.mirror = true;
		this.setRotation(this.bookPageLeft, 0.6108652F, 0F, 0F);

		this.desk = new ModelRenderer(this, 0, 0);
		this.desk.addBox(0F, 0F, 0F, 16, 1, 16);
		this.desk.setRotationPoint(-8F, 9F, -8F);
		this.desk.setTextureSize(64, 32);
		this.desk.mirror = true;
		this.setRotation(this.desk, 0F, 0F, 0F);

		this.wrenchBody = new ModelRenderer(this, 15, 17);
		this.wrenchBody.addBox(0F, 0F, 0F, 1, 1, 4);
		this.wrenchBody.setRotationPoint(-5F, 8.5F, 0F);
		this.wrenchBody.setTextureSize(64, 32);
		this.wrenchBody.mirror = true;
		this.setRotation(this.wrenchBody, 0F, 0.2617994F, 0F);

		this.wrenchTopRight = new ModelRenderer(this, 9, 17);
		this.wrenchTopRight.addBox(-1F, 0F, 3F, 1, 1, 2);
		this.wrenchTopRight.setRotationPoint(-5F, 8.5F, 0F);
		this.wrenchTopRight.setTextureSize(64, 32);
		this.wrenchTopRight.mirror = true;
		this.setRotation(this.wrenchTopRight, 0F, 0.2617994F, 0F);

		this.wrenchTopLeft = new ModelRenderer(this, 9, 17);
		this.wrenchTopLeft.addBox(1F, 0F, 3F, 1, 1, 2);
		this.wrenchTopLeft.setRotationPoint(-5F, 8.5F, 0F);
		this.wrenchTopLeft.setTextureSize(64, 32);
		this.wrenchTopLeft.mirror = true;
		this.setRotation(this.wrenchTopLeft, 0F, 0.2617994F, 0F);

		this.wrenchMidBottom = new ModelRenderer(this, 9, 20);
		this.wrenchMidBottom.addBox(-1F, 0F, 2F, 2, 1, 1);
		this.wrenchMidBottom.setRotationPoint(-4.5F, 8.5F, 0.5F);
		this.wrenchMidBottom.setTextureSize(64, 32);
		this.wrenchMidBottom.mirror = true;
		this.setRotation(this.wrenchMidBottom, 0F, 0.2617994F, 0F);

		this.wandBody = new ModelRenderer(this, 43, 17);
		this.wandBody.addBox(0F, 0F, 0F, 1, 1, 5);
		this.wandBody.setRotationPoint(4F, 8.5F, 0F);
		this.wandBody.setTextureSize(64, 32);
		this.wandBody.mirror = true;
		this.setRotation(this.wandBody, 0F, -0.2617994F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.leg0.render(f5);
		this.leg1.render(f5);
		this.leg2.render(f5);
		this.leg3.render(f5);

//		this.bookLeft.render(f5);
		this.bookStandLeveler.render(f5);
//		this.bookRight.render(f5);
		this.bookStandBody.render(f5);
		this.bookStandFoot.render(f5);
//		this.bookPageLeft.render(f5);

		this.wrenchBody.render(f5);
		this.wrenchTopRight.render(f5);
		this.wrenchTopLeft.render(f5);
		this.wrenchMidBottom.render(f5);

		this.desk.render(f5);
		this.wandBody.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}

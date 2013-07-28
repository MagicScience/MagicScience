package siramnot.mods.dmi.mobs;

import siramnot.mods.dmi.DMI;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpiderEffectsGroupData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * 
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author Tombenpotter
 * 
 */
public class EntityBlazeSpider extends EntitySpider {
	private int field_70846_g;
	private Icon EntityBlazeSpider;
	private String texture;

	public EntityBlazeSpider(World par1World) {
		super(par1World);
		this.isImmuneToFire = true;
		texture = "assets/mods/dmi/mob/EntityBlazeSpider.png";
		
	}

	public void EntitySpider(World par1World) {
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(20, new Byte((byte) 0));
	}

	public void onUpdate() {
		super.onUpdate();

		if (!this.worldObj.isRemote) {
			this.setBesideClimbableBlock(this.isCollidedHorizontally);
		}
	}

	public void setBesideClimbableBlock(boolean isCollidedHorizontally) {
		
	}

	protected void func_110147_ax() {
		super.func_110147_ax();
		this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(16.0D);
		this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.800000011920929D);
	}

	protected Entity findPlayerToAttack() {
		float f = this.getBrightness(1.0F);

		if (f < 0.5F) {
			double d0 = 16.0D;
			return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
		} else {
			return null;
		}
	}

	protected String getLivingSound() {
		return "mob.spider.say";
	}

	protected String getHurtSound() {
		return "mob.spider.say";
	}

	protected String getDeathSound() {
		return "mob.spider.death";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.playSound("mob.spider.step", 0.15F, 1.0F);
	}

	protected void attackEntity(Entity par1Entity, float par2) {
		if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY) {
			this.attackTime = 10;
			this.attackEntityAsMob(par1Entity);
		} else if (par2 < 30.0F) {
			double d0 = par1Entity.posX - this.posX;
			double d1 = par1Entity.boundingBox.minY + (double) (par1Entity.height / 2.0F) - (this.posY + (double) (this.height / 2.0F));
			double d2 = par1Entity.posZ - this.posZ;

			if (this.attackTime == 0) {
				++this.field_70846_g;

				if (this.field_70846_g == 1) {
					this.attackTime = 5;
					this.func_70844_e(true);
				} else if (this.field_70846_g <= 4) {
					this.attackTime = 5;
				} else {
					this.attackTime = 15;
					this.field_70846_g = 0;
					this.func_70844_e(false);
				}

				if (this.field_70846_g > 1) {
					float f1 = MathHelper.sqrt_float(par2) * 0.5F;
					this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1009, (int) this.posX, (int) this.posY, (int) this.posZ, 0);

					for (int i = 0; i < 1; ++i) {
						EntityLargeFireball entityLargefireball = new EntityLargeFireball(this.worldObj, this, d0 + this.rand.nextGaussian() * (double) f1, d1, d2 + this.rand.nextGaussian() * (double) f1);
						entityLargefireball.posY = this.posY + (double) (this.height / 2.0F) + 0.5D;
						this.worldObj.spawnEntityInWorld(entityLargefireball);
					}
				}
			}

			this.rotationYaw = (float) (Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
			this.hasAttacked = true;
		}
	}

	private void func_70844_e(boolean b) {
		// TODO Auto-generated method stub

	}


	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	protected void dropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);

		if (par1 && (this.rand.nextInt(3) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(Item.spiderEye.itemID, 1);
			this.dropItem(Item.silk.itemID, 2);
			this.dropItem(Item.blazePowder.itemID, 1);
		}
	}
	{

	//Trying to make the spider tameable, but still working on it
	/*
	 * public void setTamed(boolean par1) { if (par1) {
	 * this.func_110148_a(SharedMonsterAttributes
	 * .field_111267_a).func_111128_a(20.0D); } else {
	 * this.func_110148_a(SharedMonsterAttributes
	 * .field_111267_a).func_111128_a(8.0D); } }
	 */

	
	
}
}

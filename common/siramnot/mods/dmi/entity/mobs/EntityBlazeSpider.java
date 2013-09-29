package siramnot.mods.dmi.entity.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @license CC BY-NC-SA 3.0
 * @author Tombenpotter, SirAmNot
 * 
 */
public class EntityBlazeSpider extends EntitySpider {
	private int field_70846_g;

	private int hitpoints;
	private boolean isHostile;
	private boolean isRidden;

	private static String isHostileTagName = "isHostile";
	private static String isRiddenTagName = "isRidden";

	public EntityBlazeSpider(World par1World) {
		super(par1World);
		this.isImmuneToFire = true;
		this.setSize(0.8F, 0.4F);

	}

	@Override
	protected void entityInit() {
		this.dataWatcher.addObject(20, new Byte((byte) 0));
	}


	@Override
	protected Entity findPlayerToAttack() {
		float f = this.getBrightness(1.0F);

		if (f < 0.5F) {
			double d0 = 16.0D;
			return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
		} else {
			return null;
		}
	}

	@Override
	protected void attackEntity(Entity par1Entity, float par2) {
		if ((this.attackTime <= 0) && (par2 < 2.0F) && (par1Entity.boundingBox.maxY > this.boundingBox.minY) && (par1Entity.boundingBox.minY < this.boundingBox.maxY)) {
			this.attackTime = 10;
			this.attackEntityAsMob(par1Entity);
		} else if (par2 < 30.0F) {
			double d0 = par1Entity.posX - this.posX;
			double d1 = (par1Entity.boundingBox.minY + par1Entity.height / 2.0F) - (this.posY + this.height / 2.0F);
			double d2 = par1Entity.posZ - this.posZ;

			if (this.attackTime == 0) {
				++this.field_70846_g;

				if (this.field_70846_g == 1) {
					this.attackTime = 5;
					//this.func_70844_e(true);
				} else if (this.field_70846_g <= 4) {
					this.attackTime = 5;
				} else {
					this.attackTime = 15;
					this.field_70846_g = 0;
					//this.func_70844_e(false);
				}

				if (this.field_70846_g > 1) {
					float f1 = MathHelper.sqrt_float(par2) * 0.5F;
					this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1009, (int) this.posX, (int) this.posY, (int) this.posZ, 0);

					for (int i = 0; i < 1; ++i) {
						EntityLargeFireball entityLargefireball = new EntityLargeFireball(this.worldObj, this, d0 + (this.rand.nextGaussian() * f1), d1, d2 + (this.rand.nextGaussian() * f1));
						entityLargefireball.posY = this.posY + this.height / 2.0F + 0.5D;
						this.worldObj.spawnEntityInWorld(entityLargefireball);
					}
				}
			}

			this.rotationYaw = (float) ((Math.atan2(d2, d0) * 180.0D) / Math.PI) - 90.0F;
			this.hasAttacked = true;
		}
	}

	/*private void func_70844_e(boolean flag) {
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (flag)
        {
            b0 = (byte)(b0 | 1);
        }
        else
        {
            b0 &= -2;
        }

        this.dataWatcher.updateObject(16, Byte.valueOf(b0));
	}
*/
	/**
	 * Drop 0-2 items of this living's type. @param par1 - Whether this entity
	 * has recently been hit by a player. @param par2 - Level of Looting used to
	 * kill this mob.
	 */
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		if (par1 && ((this.rand.nextInt(3) == 0) || (this.rand.nextInt(1 + par2) > 0))) {
			this.dropItem(Item.spiderEye.itemID, 1);
			this.dropItem(Item.silk.itemID, 2);
			this.dropItem(Item.blazePowder.itemID, 1);
			this.dropItem(Item.ghastTear.itemID, 1);
		}
	}

	@Override
	protected boolean interact(EntityPlayer player) {
		String secret = "Congratulations, " + player.username + "! You have found a secret!";
		ItemStack item = player.inventory.getCurrentItem();
		
		if (this.riddenByEntity != null) {
			return false;
		}
		
		if (item.getItem().itemID != Item.diamond.itemID || player.isSneaking()) {
			return false;
		}

		if (!worldObj.isRemote) {
			player.addChatMessage(secret);
		}
		
		player.mountEntity(this);

		return true;
	}

	@Override
	public boolean canBeSteered() {
		return true;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		nbt.setBoolean(isHostileTagName, this.isHostile);
		nbt.setBoolean(isRiddenTagName, this.isRidden);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		this.isHostile = nbt.getBoolean(isHostileTagName);
		this.isRidden = nbt.getBoolean(isRiddenTagName);
	}

}

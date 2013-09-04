package siramnot.mods.dmi.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * 
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author Tombenpotter
 * 
 */

public class EntityKaldymBoss extends EntityMob implements IBossDisplayData {

	private float moveSpeed;

	public EntityKaldymBoss(World par1World) {
		super(par1World);
		this.isImmuneToFire = true;
		this.moveSpeed = 0.55F;
		this.experienceValue = 70;

		addTasks();
	}

	private void addTasks() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(3, new EntityAIWander(this, this.moveSpeed));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	}

	public int getAttackStrength(Entity par1Entity) {
		return 15;
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	@Override
	protected boolean isAIEnabled() {
		return true;
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
		if (super.attackEntityAsMob(par1Entity)) {

			((EntityLivingBase) par1Entity).addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 0));
			((EntityLivingBase) par1Entity).addPotionEffect(new PotionEffect(Potion.wither.id, 100, 0));

		}

		return true;

	}

	@Override
	protected void func_110147_ax() {
		super.func_110147_ax();
		this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(70.0D);
	}

	public int getBossHealth() {
		return (int) this.func_110138_aP();
	}

	protected String getLivingSound() {
		return "mob.zombie.say";
	}

	protected String getHurtSound() {
		return "mob.skeleton.hurt";
	}

	protected String getDeathSound() {
		return "mob.creeper.death";
	}

	
	protected void dropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);

		if (par1 && ((this.rand.nextInt(3) == 0) || (this.rand.nextInt(1 + par2) > 0))) {
			this.dropItem(Item.ingotIron.itemID, 1);
			this.dropItem(Item.appleRed.itemID, 2);
		}
		
	}
}
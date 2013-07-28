package siramnot.mods.dmi.mobs;

import siramnot.mods.dmi.DMI;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;


/**
 * 
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author Tombenpotter
 * 
 */

public class EntityKaldymBoss extends EntityMob implements IBossDisplayData, IMob
{


	private float moveSpeed;
	private String health;
	

	public EntityKaldymBoss(World par1World) {
		super(par1World);
		this.isImmuneToFire = true;
		this.moveSpeed = 0.6F;
		 this.tasks.addTask(0, new EntityAISwimming(this));
	        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
	        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
	        this.tasks.addTask(3, new EntityAIWander(this, this.moveSpeed));
	        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	        this.experienceValue = 70;
	        this.getMaxHealth();
		// TODO Auto-generated constructor stub
	}

	
	public int getMaxHealth(){
		
		return 100;
       
	}
	
	public int getAttackStrength(Entity par1Entity)
    {
    return 15;
    }
	
	public EnumCreatureAttribute getCreatureAttribute()
	    {
	        return EnumCreatureAttribute.UNDEAD;
	    }
	
	protected boolean isAIEnabled()
    {
        return true;
    }
	
	
	 public boolean attackEntityAsMob(Entity par1Entity)
	    {
	        if (super.attackEntityAsMob(par1Entity))
	        {
	            if (par1Entity instanceof EntityLivingBase)
	            {
	                byte b0 = 0;

	                if (this.worldObj.difficultySetting > 0)
	                {
	                    if (this.worldObj.difficultySetting == 2)
	                    {
	                        b0 = 7;
	                    }
	                    else if (this.worldObj.difficultySetting == 3)
	                    {
	                        b0 = 15;
	                    }
	                }

	                if (b0 > 0)
	                {
	                    ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.confusion.id, b0 * 20, 0));
	                    ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.wither.id, b0 * 20, 0));
	                }
	            }

	            return true;
	        }
	        else
	        {
	            return false;
	        }
	    }

}


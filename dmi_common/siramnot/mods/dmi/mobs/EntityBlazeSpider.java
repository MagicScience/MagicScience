package siramnot.mods.dmi.mobs;



	import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpiderEffectsGroupData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

	public class EntityBlazeSpider extends EntityMob
	{
	    public EntityBlazeSpider(World par1World) {
			super(par1World);
			// TODO Auto-generated constructor stub
		}

		public void EntitySpider(World par1World) {
		}
	    

	    protected void entityInit()
	    {
	        super.entityInit();
	        this.dataWatcher.addObject(16, new Byte((byte)0));
	    }

	  
	    public void onUpdate()
	    {
	        super.onUpdate();

	        if (!this.worldObj.isRemote)
	        {
	            this.setBesideClimbableBlock(this.isCollidedHorizontally);
	        }
	    }

	    private void setBesideClimbableBlock(boolean isCollidedHorizontally) {
			
			
		}

		protected void func_110147_ax()
	    {
	        super.func_110147_ax();
	        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(16.0D);
	        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.800000011920929D);
	    }

	    protected Entity findPlayerToAttack()
	    {
	        float f = this.getBrightness(1.0F);

	        if (f < 0.5F)
	        {
	            double d0 = 16.0D;
	            return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
	        }
	        else
	        {
	            return null;
	        }
	    }

	    protected String getLivingSound()
	    {
	        return "mob.spider.say";
	    }

     protected String getHurtSound()
	    {
	        return "mob.spider.say";
	    }

	    protected String getDeathSound()
	    {
	        return "mob.spider.death";
	    }

	    protected void playStepSound(int par1, int par2, int par3, int par4)
	    {
	        this.playSound("mob.spider.step", 0.15F, 1.0F);
	    }

}

package siramnot.mods.dmi.entity.mobs;

import java.util.Random;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityVolatileSkeleton extends EntitySkeleton
{

	public EntityVolatileSkeleton(World par1World) {
		super(par1World);
		this.isImmuneToFire = true;
		
	}
	
	@Override
	 public void onDeath(DamageSource par1DamageSource)
    {
        super.onDeath(par1DamageSource);

        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3, true);
}
	

	
}
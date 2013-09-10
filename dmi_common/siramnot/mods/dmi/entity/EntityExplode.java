package siramnot.mods.dmi.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityExplode extends Entity implements IProjectile{
	private EntityPlayer thrower;
	private int ticksInGround;
    private int ticksInAir;

	public EntityExplode(World par1World) {
		super(par1World);
		this.renderDistanceWeight = 20.0D;
	}

	@Override
	public void setThrowableHeading(double d0, double d1, double d2, float f,
			float f1) {
		
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		if (this.isCollided) {
			onImpact();
		}
	}
	
	public void onImpact() {
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2, true);
	}
	
	@Override
	protected void entityInit() {
		this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		
	}

}

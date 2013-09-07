package siramnot.mods.dmi.entity;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityExplosiveBall extends Entity implements IProjectile {

	private EntityPlayer owner;

	public EntityExplosiveBall(World world, EntityPlayer player) {
		super(world);

		owner = player;

		this.setThrowableHeading(this.posX, this.posY, this.posZ, 1.0f, 1.5f);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		if (this.isCollided) {
			onImpact();
		}
	}
	
	public void onImpact() {
		
	}

	@Override
	public void setThrowableHeading(double x, double y, double z, float i, float j) {
		float sqrtXYZ = MathHelper.sqrt_double(x * x + y * y + z * z);

		x /= sqrtXYZ;
		y /= sqrtXYZ;
		z /= sqrtXYZ;

		double rG = this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * j;
		x += rG;
		y += rG;
		z += rG;

		x *= i;
		y *= i;
		z *= i;

		this.motionX = x;
		this.motionY = y;
		this.motionZ = z;

		float sqrtXZ = MathHelper.sqrt_double(x * x + z * z);
		double deg180 = 180.0D;
		this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(x, z) * deg180 / Math.PI);
		this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(y, sqrtXZ) * deg180 / Math.PI);

	}

	@Override
	protected void entityInit() {

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
	}

}

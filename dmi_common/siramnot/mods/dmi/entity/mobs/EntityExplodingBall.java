package siramnot.mods.dmi.entity.mobs;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityExplodingBall extends EntityArrow{

	public EntityExplodingBall(World par1World) {
		super(par1World);
	}

	public void onCollide() {
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2, true);
	}

@Override
public void setVelocity(double par1, double par3, double par5)
{
    this.motionX = par1;
    this.motionY = par3;
    this.motionZ = par5;

    if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
    {
        float f = MathHelper.sqrt_double(par1 + par5);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 90.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, (double)f) * 90.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch;
        this.prevRotationYaw = this.rotationYaw;
        this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        this.ticksInGround = 0;
    }
}




private int ticksInGround;
private int ticksInAir;
}

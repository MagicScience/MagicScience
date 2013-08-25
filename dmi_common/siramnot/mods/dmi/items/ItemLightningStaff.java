package siramnot.mods.dmi.items;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemLightningStaff extends ItemStaff {

	public ItemLightningStaff(int id, EnumStaff toolMaterial) {
		super(id, toolMaterial);
		this.inGameName = "Lightning Staff";
		this.unlocalizedName = "lightningStaff";
		this.setFull3D();
	}

	@Override
	public ItemStack doSpecialRightClickAction (ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if ((world.provider.dimensionId == -1) && (entityplayer.capabilities.isCreativeMode == false)) {
			entityplayer.addPotionEffect(new PotionEffect(Potion.harm.getId(), 1, 1));
			return itemstack;
		}
		float f = 1.0F;
		float f1 = entityplayer.prevRotationPitch + ((entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f);
		float f2 = entityplayer.prevRotationYaw + ((entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f);
		double d = entityplayer.prevPosX + ((entityplayer.posX - entityplayer.prevPosX) * f);
		double d1 = (entityplayer.prevPosY + ((entityplayer.posY - entityplayer.prevPosY) * f) + 1.6200000000000001D) - entityplayer.yOffset;
		double d2 = entityplayer.prevPosZ + ((entityplayer.posZ - entityplayer.prevPosZ) * f);
		Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
		float f3 = MathHelper.cos((-f2 * 0.01745329F) - 3.141593F);
		float f4 = MathHelper.sin((-f2 * 0.01745329F) - 3.141593F);
		float f5 = -MathHelper.cos(-f1 * 0.01745329F);
		float f6 = MathHelper.sin(-f1 * 0.01745329F);
		float f7 = f4 * f5;
		float f8 = f6;
		float f9 = f3 * f5;
		double d3 = 5000D;
		Vec3 vec3d1 = vec3d.addVector(f7 * d3, f8 * d3, f9 * d3);
		MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);
		if (movingobjectposition == null) {
			return itemstack;
		}
		if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) {
			int i = movingobjectposition.blockX;
			int j = movingobjectposition.blockY;
			int k = movingobjectposition.blockZ;
			world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
		}
		if (entityplayer.capabilities.isCreativeMode) {
			return itemstack;
		} else {
			itemstack.damageItem(1, entityplayer);
			return itemstack;
		}
	}

}

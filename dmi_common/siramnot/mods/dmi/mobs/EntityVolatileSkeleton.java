package siramnot.mods.dmi.mobs;

import siramnot.mods.dmi.core.managers.ItemManager;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 *
 */
public class EntityVolatileSkeleton extends EntitySkeleton {

	public EntityVolatileSkeleton(World par1World) {
		super(par1World);
		this.isImmuneToFire = true;
		this.setSize(0.72F, 2.0F);

	}

	@Override
	public void onDeath(DamageSource par1DamageSource) {
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 2.0f, flag);
	}

	boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");

	protected int getDropItemID() {
		return Item.arrow.itemID;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2) {
		super.dropFewItems(par1, par2);

		if (par1 && ((this.rand.nextInt(3) == 0) || (this.rand.nextInt(1 + par2) > 0))) {
			this.dropItem(Item.arrow.itemID, 1);
			this.dropItem(Item.bone.itemID, 2);
			this.dropItem(Item.fireballCharge.itemID, 1);

		}
	}
}
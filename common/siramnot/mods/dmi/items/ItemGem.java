package siramnot.mods.dmi.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import siramnot.mods.dmi.DMI;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGem extends Item {

	@SideOnly(Side.CLIENT)
	private static Icon[] icons;
	private static final String NAME_SUFFIX = "Crystal";
	private static final String[] NAMES = new String[] { "Aqueous " + NAME_SUFFIX, "Terreous " + NAME_SUFFIX, "Igneous " + NAME_SUFFIX, "Aereous " + NAME_SUFFIX };
	private static final String[] U_NAMES = new String[] { "water" + NAME_SUFFIX, "fire" + NAME_SUFFIX, "earth" + NAME_SUFFIX, "air" + NAME_SUFFIX };
	private static ItemGem instance;

	public ItemGem(int id) {
		super(id);
		this.setHasSubtypes(true);
		this.setMaxDamage(0); // This means, no damage bar
		this.setCreativeTab(DMI.TAB_CREATIVE);
		
		this.setUnlocalizedName("itemGem");

		this.instance = this;
	}

	public static void doRegisters() {
		GameRegistry.registerItem(instance, instance.getUnlocalizedName(), DMI.MOD_ID);
		for (int meta = 0; meta < NAMES.length; ++meta) {
			ItemStack item = new ItemStack(instance, 1, meta);
			LanguageRegistry.instance().addName(item, NAMES[meta]);
		}

	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage) {
		return icons[damage];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		String j = super.getUnlocalizedName() + "." + U_NAMES[stack.getItemDamage()];
		return j;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int i, CreativeTabs tab, List list) {
		for (int iter = 0; iter < NAMES.length; ++iter) {
			ItemStack item = new ItemStack(i, 1, iter);
			list.add(item);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[U_NAMES.length];
		for (int i = 0; i < U_NAMES.length; ++i) {
			icons[i] = register.registerIcon(DMI.MOD_ID + ":" + U_NAMES[i]);
		}
	}

	/**
	 * @param meta
	 *            0 = water; 1 = earth; 2 = fire; 3 = air
	 * 
	 * @param stackSize
	 *            The size of the ItemStack
	 * 
	 * @return The ItemStack
	 */
	public ItemStack getSubItem(int meta, int stackSize) {
		ItemStack stack = new ItemStack(instance, stackSize, meta);
		return stack;
	}
	
//	@Override
	public ItemStack ronItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
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
			} else if (movingobjectposition.typeOfHit == EnumMovingObjectType.ENTITY) {
				Entity entityhit = movingobjectposition.entityHit;
				double x = entityhit.posX;
				double y = entityhit.posY;
				double z = entityhit.posZ;
				world.spawnEntityInWorld(new EntityLightningBolt(world,x,y,z));
			}
			if (entityplayer.capabilities.isCreativeMode) {
				return itemstack;
			} else {
				itemstack.damageItem(1, entityplayer);
				return itemstack;
			}
		
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.bow;
	}
	
	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		return par1ItemStack;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 7200;
	}

}
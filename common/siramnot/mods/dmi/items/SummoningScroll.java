package siramnot.mods.dmi.items;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import siramnot.mods.dmi.*;
import siramnot.mods.dmi.core.*;

/**
 * 
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 *
 */
public class SummoningScroll extends BasicScroll {

	private static final String U_NAME = "scrollOfSummoning";
	private static final String NAME = "Scroll of Summoning";
	private static final String PATH = "SummoningScroll";
	private static final String TEXTUREPATH = Reference.ITEM_TEXTURE_LOCATION + PATH;
	private static final int MAX_STACK_SIZE = 16;
	private Entity entity;

	public SummoningScroll(int id, Entity entity) {
		super(id);
		this.entity = entity;
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.setUnlocalizedName(U_NAME);
		this.setMaxStackSize(MAX_STACK_SIZE);;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (!world.isRemote) {
			world.spawnEntityInWorld(this.entity);
			return true;
		}
		return false;
	}




}

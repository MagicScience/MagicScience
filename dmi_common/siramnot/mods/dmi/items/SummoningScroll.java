package siramnot.mods.dmi.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import siramnot.mods.dmi.DMI;

public class SummoningScroll extends BasicScroll {

	private static final String U_NAME = "ScrollOfSummoning";
	private static final String NAME = "Scroll of Summoning";
	private static final String PATH = "SummoningScroll";
	private static final String TEXTUREPATH = DMI.MOD_ID.toLowerCase() + ":" + PATH; 
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
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (!par3World.isRemote) {

			par3World.spawnEntityInWorld(this.entity);
		}
		return true;

	}




}

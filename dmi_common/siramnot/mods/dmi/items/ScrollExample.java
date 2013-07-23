package siramnot.mods.dmi.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import siramnot.mods.dmi.DMI;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;


public class ScrollExample extends Item {

	// Do not change to public ! It would screw everything up and the world would explode !
	private static final String U_NAME = "Scroll";
	private static final String NAME = "Scroll";
	private static final String PATH = "Scroll";
	private static final String TEXTUREPATH = DMI.MOD_ID.toLowerCase() + ":" + PATH; 
	private static final int MAX_STACK_SIZE = 16;

	public ScrollExample(int id) {
		super(id);
		setCreativeTab(DMI.TAB_CREATIVE);
		setUnlocalizedName(U_NAME);
		setMaxStackSize(MAX_STACK_SIZE);
	}


	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon(TEXTUREPATH);
	}

	

	public static String getName() {
		return NAME;
	}

public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
{
    if (!par3EntityPlayer.capabilities.isCreativeMode)
    {
        --par1ItemStack.stackSize;
    }

    par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

    if (!par2World.isRemote)
    {
        par2World.spawnEntityInWorld(new EntityExpBottle(par2World, par3EntityPlayer));
    }

    return par1ItemStack;
}

}

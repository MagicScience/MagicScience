package siramnot.mods.dmi.items.debug;


import net.minecraft.block.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import siramnot.mods.dmi.*;
import siramnot.mods.dmi.util.*;
import cpw.mods.fml.relauncher.*;


public class ItemFlight extends ItemFlintAndSteel
{
	
	public ItemFlight(int id)
	{
		super(id);
		this.setCreativeTab(DMI.TAB_CREATIVE);
		this.itemIcon = Block.blockIron.blockIcon;
	}
	
	{
		setUnlocalizedName("debugItem");
	}
}

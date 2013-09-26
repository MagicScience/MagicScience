package siramnot.mods.dmi.blocks.tileeents;


import static org.lwjgl.opengl.GL11.*;
import javax.swing.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.item.*;
import net.minecraftforge.client.*;
import siramnot.mods.dmi.entity.tile.*;
import siramnot.mods.dmi.models.*;


public class ItemBlockWorkStationRenderer implements IItemRenderer
{

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type) {
			case EQUIPPED: return true;
			default: return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type) {
			case EQUIPPED:
			{
				
			}
			default:
				break;
		}
	}
	
}

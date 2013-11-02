/*package siramnot.mods.dmi.render;


import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.item.*;
import net.minecraftforge.client.*;
import siramnot.mods.dmi.entity.tile.*;
import siramnot.mods.dmi.models.*;

import static org.lwjgl.opengl.GL11.*; 


public class ItemBlockWorkStationRenderer implements IItemRenderer
{
	private ModelWorkstation	model;
	
	public ItemBlockWorkStationRenderer()
	{
		model = new ModelWorkstation();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
//		switch (type)
//		{
//			case EQUIPPED:
				return true;
//			default:
//				return false;
//		}
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
//		return false;
		return true;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{	
		switch(type)
		{
			case EQUIPPED:
			{
				glPushMatrix();
				
					TileEntityRenderer.instance.renderTileEntityAt(new TileEntityWorkstation(), 0.0f, 0.0f, 0.0f, 0.0f);
				
				glPopMatrix();
			}
			
			default: break;
		}
	}
}
*/

package siramnot.mods.dmi.render;


import siramnot.mods.dmi.entity.tile.*;
import siramnot.mods.dmi.models.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.item.*;
import net.minecraftforge.client.*;
import static org.lwjgl.opengl.GL11.*;


public class ItemBlockWorkStationRenderer implements IItemRenderer
{
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		glPushMatrix();
		switch (type)
		{
			case EQUIPPED:
			{
				render();
				glPopMatrix();
				break;
			}
			
			case INVENTORY:
			{
				float scale = 0.95f;
				
				glTranslatef(-1.0f, 2.0f, 0.0f);
//				render();
				
				glPopMatrix();
				
				break;
			}
			
			default:
			{
				glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
				glTranslatef(-0.5f, -0.5f, -0.25f);
				render();
				
				glPopMatrix();
				
				break;
			}
		}
	}
	
	private void render()
	{
		try
		{
			TileEntityRenderer.instance.renderTileEntityAt(new TileEntityWorkstation(false), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

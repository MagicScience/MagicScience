package siramnot.mods.dmi.render;


import siramnot.mods.dmi.entity.tile.*;
import siramnot.mods.dmi.models.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraftforge.client.*;
import static org.lwjgl.opengl.GL11.*;


public class ItemBlockBatteryBlockRenderer implements IItemRenderer
{
	
	private ModelBatteryBlock model;
	private ResourceLocation texture;
	
	public ItemBlockBatteryBlockRenderer()
	{
		 model = new ModelBatteryBlock();
		 texture = new ResourceLocation("dmi", "textures/blocks/models/battery.png");
	}
	
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
		glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
		switch (type)
		{
			case INVENTORY:
				glScalef(1.5f, 1.25f, 1.5f);
				glTranslatef(-0.95f, -2.225f, -0.025f);
				break;
			case ENTITY:
				glTranslatef(-0.5f, -2.0f, -0.5f);
				break;
			case EQUIPPED:
				glScalef(2.0f, 2.0f, 2.0f);
				/* Fall-through */
			default:
				glTranslatef(-1.0f,-2.5f, -0.2f);
				break;
		}
		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityBatteryBlock(null), 0.0D, 0.0D, 0.0D, 0.0F);
		glPopMatrix();
	}
	
}

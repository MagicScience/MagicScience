package siramnot.mods.dmi.render;


import org.lwjgl.opengl.*;
import siramnot.mods.dmi.core.*;
import siramnot.mods.dmi.entity.tile.*;
import siramnot.mods.dmi.models.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;


public class TileEntityBatteryBlockRenderer extends TileEntitySpecialRenderer
{
	
	private ModelBatteryBlock model;
	private ResourceLocation texture;
	
	public TileEntityBatteryBlockRenderer()
	{
		 model = new ModelBatteryBlock();
		 texture = new ResourceLocation("dmi", "textures/blocks/models/battery.png");
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale)
	{
		TileEntityBatteryBlock tebb = (TileEntityBatteryBlock) tileEntity;
		this.renderModelAt(tebb, x, y, z);
	}
	
	private void renderModelAt(TileEntityBatteryBlock tile, double x, double y, double z)
	{
		GL11.glPushMatrix();
		
		float vertical_fix = 0.5F, horizontal_fix = 0.75F;						
		GL11.glTranslatef((float) x + vertical_fix, (float) y + horizontal_fix, (float) z + vertical_fix);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(this.texture);
		
		GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
		
		if (y != 0) // If the block is not placed in the inventory
		{
			GL11.glRotatef(180.0f, 1.0f, 0.0f, 1.0f);
			GL11.glTranslatef(0.0f, -0.75f, 0.0f);
		}
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		
		GL11.glPopMatrix();
	}
	
}

package siramnot.mods.dmi.render;


import net.minecraft.block.*;
import net.minecraft.client.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import org.lwjgl.opengl.*;
import siramnot.mods.dmi.*;
import siramnot.mods.dmi.entity.tile.*;
import siramnot.mods.dmi.models.*;
import cpw.mods.fml.client.*;


/**
 * 
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author SirAmNot
 * 
 */
public class TileEntityWorkStationRenderer extends TileEntitySpecialRenderer
{
	
	private static final ResourceLocation	enchantingTableBookTextures	= new ResourceLocation("textures/entity/enchanting_table_book.png");
	private ModelBook						enchantmentBook				= new ModelBook();
	private final ModelWorkstation			model						= new ModelWorkstation();
	private ResourceLocation				tileent						= new ResourceLocation(DMI.MOD_ID.toLowerCase(), IReference.TILE_ENTITY_TEXTURE_LOCATION + "/workstation.png");
	
	private static final float[]			BOOK_OFFSET					= new float[] { };
	private static final int				KEY_X						= 0;
	private static final int				KEY_Y						= 1;
	private static final int				KEY_Z						= 2;
	private static final float				BOOK_SCALE_SIZE				= 0.5F;
	private static final float[] 			BOOK_MODEL_TRANSLATE		= new float[] {  0.5f, 0.0f, 0.0f };
	
	private void renderBookAt(TileEntityWorkstation tile, double x, double y, double z, float scale)
	{
		if (!tile.getShouldRenderBook()) { return; }
		
		GL11.glPushMatrix();
		
			float vertical_fix = 0.5F, horizontal_fix = 0.75F;														// Fix modifiers						
			GL11.glTranslatef((float) x + vertical_fix, (float) y + horizontal_fix, (float) z + vertical_fix);		// Takes the book out of the player's head, and puts it in the table
		
			float f1 = tile.tickCount + scale;																	// "time" variable
			GL11.glTranslatef(0.0F, 0.1F + MathHelper.sin(f1 * 0.1F) * 0.01F, 0.0F);								// Makes the book bob up and down
		
			GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);																// Angles the book, without this the book would be totally vertical
			GL11.glTranslatef(0.5f, 0.0f, 0.0f);
			
			this.bindTexture(enchantingTableBookTextures);															// Binds the model's texture, making it accessible on rendered
			GL11.glScalef(this.BOOK_SCALE_SIZE, this.BOOK_SCALE_SIZE, this.BOOK_SCALE_SIZE);						// Scales the model, without this it'd be too big	
			
			/* Book flip animation code */
			float f4 = tile.pageFlipPrev + (tile.pageFlip - tile.pageFlipPrev) * scale + 0.25F;
			float f5 = tile.pageFlipPrev + (tile.pageFlip - tile.pageFlipPrev) * scale + 0.75F;
			f4 = (f4 - (float) MathHelper.truncateDoubleToInt((double) f4)) * 1.6F - 0.3F;
			f5 = (f5 - (float) MathHelper.truncateDoubleToInt((double) f5)) * 1.6F - 0.3F;
		
			if (f4 < 0.0F)
			{
				f4 = 0.0F;
			}
		
			if (f5 < 0.0F)
			{
			f5 = 0.0F;
			}
		
			if (f4 > 1.0F)
			{
				f4 = 1.0F;
			}
			
			if (f5 > 1.0F)
			{
				f5 = 1.0F;
			}
		
			float f6 = tile.bookSpreadPrev + (tile.bookSpread - tile.bookSpreadPrev) * scale;	// Rotation angle calculation (?)
			GL11.glEnable(GL11.GL_CULL_FACE);															// Face cull to improve performance
			this.enchantmentBook.render((Entity) null, f1, f4, f5, f6, 0.0F, 0.0625F);					// Render the model
		GL11.glPopMatrix();
	}
	
	private void renderModelAt(TileEntityWorkstation tile, double x, double y, double z, float f)
	{
		int rotation = 0;
		
		if (tile.worldObj != null)
		{
			rotation = tile.getBlockMetadata();
		}
		
		GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(this.tileent);
		
			GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
			GL11.glScalef(1.0F, -1F, -1F);
			GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
		
			GL11.glEnable(GL11.GL_CULL_FACE);
			this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
	{
		TileEntityWorkstation tews = (TileEntityWorkstation) te;
		
		this.renderModelAt(tews, x, y, z, scale);
		this.renderBookAt(tews, x,y,z,scale);
	}
	
}

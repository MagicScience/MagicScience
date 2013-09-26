package siramnot.mods.dmi.blocks.tileeents;


import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.entity.tile.TileEntityWorkstation;
import siramnot.mods.dmi.models.ModelWorkStation;
import cpw.mods.fml.client.FMLClientHandler;


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
	private final ModelWorkStation			model						= new ModelWorkStation();
	private ResourceLocation				tileent						= new ResourceLocation(DMI.MOD_ID.toLowerCase(), "textures/models/workstation.png");
	
	private static final double[][]			BOOK_OFFSET					= new double[][] { {}, {}, {}, {} };
	private static final int				KEY_X						= 0;
	private static final int				KEY_Y						= 1;
	private static final int				KEY_Z						= 2;
	private final float						modelBookScale				= 0.5F;
	
	/*private void adjustRotationWithMeta(World world, int x, int y, int z)
	{
		
		int meta = world.getBlockMetadata(x, y, z);
		GL11.glPushMatrix();
		GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 0.0F);
		GL11.glPopMatrix();
	}*/
	
	private void renderBookAt(TileEntityWorkstation tileent, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.75F, (float) z + 0.5F);
		float f1 = (float) tileent.tickCount + scale;
		GL11.glTranslatef(0.0F, 0.1F + MathHelper.sin(f1 * 0.1F) * 0.01F, 0.0F);
		float f2;
		
//		for (f2 = tileent.bookRotation2 - tileent.bookRotationPrev; f2 >= (float) Math.PI; f2 -= ((float) Math.PI * 2F))
//		{
//			;
//		}
		
//		while (f2 < -(float) Math.PI)
//		{
//			f2 += ((float) Math.PI * 2F);
//		}
		
//		float f3 = tileent.bookRotationPrev + f2 * scale;
//		GL11.glRotatef(-f3 * 180.0F / (float) Math.PI, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(80.0F, 0.0F, 0.0F, 1.0F);
		this.bindTexture(enchantingTableBookTextures);
		GL11.glScalef(this.modelBookScale, this.modelBookScale, this.modelBookScale);
		float f4 = tileent.pageFlipPrev + (tileent.pageFlip - tileent.pageFlipPrev) * scale + 0.25F;
		float f5 = tileent.pageFlipPrev + (tileent.pageFlip - tileent.pageFlipPrev) * scale + 0.75F;
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
		
		float f6 = tileent.bookSpreadPrev + (tileent.bookSpread - tileent.bookSpreadPrev) * scale;
		GL11.glEnable(GL11.GL_CULL_FACE);
		this.enchantmentBook.render((Entity) null, f1, f4, f5, f6, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
	
	private void renderAModelAt(TileEntityWorkstation tile, double x, double y, double z, float f)
	{
		int rotation = 0;
		
		if (tile.worldObj != null)
		{
			rotation = tile.getBlockMetadata();
		}
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.tileent);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix(); // end
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale)
	{
		TileEntityWorkstation tews = (TileEntityWorkstation) te;
		this.renderAModelAt(tews, x, y, z, scale);
		this.renderBookAt(tews, x,y,z,scale);
	}
	
	private void lightingFix(World world, int x, int y, int z, Block block)
	{
		Tessellator tessellator = Tessellator.instance;
		float currentBlockBrightness = block.getBlockBrightness(world, x, y, z);
		int skyBrightness = world.getLightBrightnessForSkyBlocks(x, y, z, 0);
		int i = 65536;
		int j = skyBrightness % i;
		int k = skyBrightness / i;
		tessellator.setColorOpaque_F(currentBlockBrightness, currentBlockBrightness, currentBlockBrightness);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j, k);
	}
	
}

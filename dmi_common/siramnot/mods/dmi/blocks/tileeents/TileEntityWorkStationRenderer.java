package siramnot.mods.dmi.blocks.tileeents;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import siramnot.mods.dmi.DMI;

public class TileEntityWorkStationRenderer extends TileEntitySpecialRenderer {

	private final ModelWorkStationBlock model;
	protected ResourceLocation tileent;

	public TileEntityWorkStationRenderer() {
		this.model = new ModelWorkStationBlock();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		GL11.glPushMatrix();
		GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
		GL11.glPopMatrix();
	}

	public void renderAModelAt(TileEntityWorkStationBlockEntity tile, double d, double d1, double d2, float f) {

		int rotation = 0;
		
		if(tile.worldObj != null)
		{
			rotation = tile.getBlockMetadata();
		}
		tileent = new ResourceLocation("dmi:Block/test");
		this.func_110628_a(tileent);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		GL11.glRotatef(rotation*90, 0.0F, 1.0F, 0.0F);
		model.renderAll();
		GL11.glPopMatrix(); //end
	}

	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		renderAModelAt((TileEntityWorkStationBlockEntity) te, x, y, z, scale);
	}

	private void adjustLightFixture(World world, int i, int j, int k, Block block) {
		Tessellator tess = Tessellator.instance;
		float brightness = block.getBlockBrightness(world, i, j, k);
		int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
		int modulousModifier = skyLight % 65536;
		int divModifier = skyLight / 65536;
		tess.setColorOpaque_F(brightness, brightness, brightness);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) modulousModifier, divModifier);
	}
}
package siramnot.mods.dmi.gui;


import net.minecraft.client.gui.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import siramnot.mods.dmi.*;
import siramnot.mods.dmi.core.*;
import siramnot.mods.dmi.entity.tile.*;


/**
 * 
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 *
 */
public class LiquidatorGui extends GuiContainer
{
	
	private TileEntityLiquidator			inv;
	private static final String				NAME	= Reference.GUI_TEXTURE_LOCATION + "/LiquidatorGUI.png";
	protected static final ResourceLocation	gui		= new ResourceLocation(Reference.MOD_ID, NAME);
	
	public LiquidatorGui(InventoryPlayer inventory, TileEntityLiquidator liquidator)
	{
		super(new ContainerLiquidator(inventory, liquidator));
		this.inv = liquidator;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, (this.ySize - 96) + 2, 0xffffff);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int j = (this.width - this.xSize) / 2;
		int k = (this.height - this.ySize) / 2;
		this.mc.getTextureManager().bindTexture(gui);
		this.drawTexturedModalRect(j, k, 0, 0, this.xSize, this.ySize);
		
		if (this.inv.isBurning())
		{
			int burn = this.inv.getBurnTimeRemainingScaled(14);
			this.drawTexturedModalRect(j + 73, k + 59, 176, 64, burn, 10);
		}
		
		int update = this.inv.getLiquidScaled();
		this.drawTexturedModalRect(j + 130, k + 12, 176, 0, 30, update);
		
	}
}

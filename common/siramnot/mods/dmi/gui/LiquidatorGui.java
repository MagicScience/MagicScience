package siramnot.mods.dmi.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.entity.tile.TileEntityLiquidator;

public class LiquidatorGui extends GuiContainer {

	private TileEntityLiquidator inv;
	private static final String NAME = "textures/gui/LiquidatorGUI.png"; // Make it easier to change path.
	protected static final ResourceLocation gui = new ResourceLocation(DMI.MOD_ID.toLowerCase(), NAME); // DMI has to be lowercases, AFAIK. That doesn't matter in the code, only in the file system. 
	//You still have to recompile it and put it inside minecraft for the GUI to show.

	public LiquidatorGui(InventoryPlayer inventory, TileEntityLiquidator liquidator) {
		super(new ContainerLiquidator(inventory, liquidator));
		this.inv = liquidator;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everythin in front of the
	 * items)
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, (this.ySize - 96) + 2, 0xffffff);
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the
	 * items)
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int j = (this.width - this.xSize) / 2;
		int k = (this.height - this.ySize) / 2;
		this.mc.getTextureManager().bindTexture(gui);
		this.drawTexturedModalRect(j, k, 0, 0, this.xSize, this.ySize);

		if (this.inv.isBurning()) {
			int burn = this.inv.getBurnTimeRemainingScaled(14);
			this.drawTexturedModalRect(j + 73, k + 59, 176, 64, burn, 10);
		}

		int update = this.inv.getLiquidScaled();
		this.drawTexturedModalRect(j+130, k+12, 176, 0, 30, update);

	}
}
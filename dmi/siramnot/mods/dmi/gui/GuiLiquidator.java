	package siramnot.mods.dmi.gui;

	import org.lwjgl.opengl.GL11;

import siramnot.mods.dmi.blocks.tileeents.TileEntityLiquidator;

	import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

	public class GuiLiquidator extends GuiContainer {

		private TileEntityLiquidator RefinerInventory;
		protected static final ResourceLocation gui = new ResourceLocation("Block/FurnaceGui.png");

		public GuiLiquidator(InventoryPlayer par1IP, TileEntityLiquidator par2TileEntityRefiner){
			super(new ContainerLiquidator(par1IP, par2TileEntityRefiner));
			RefinerInventory = par2TileEntityRefiner;
		}
		
		protected void drawGuiContainerForegroundLayer(int par1, int par2)
		{
		         fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, (ySize - 96) + 2, 0xffffff);
		}
		
		int xSizeOfTexture = 235;
		int ySizeOfTexture = 75;
		
		int posX = (this.width + xSizeOfTexture) / 2;
		int posY = (this.height + ySizeOfTexture) / 2;



		protected void drawGuiContainerBackgroundLayer(int par1, int par2) {
			fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, (ySize - 96) + 2, 0xffffff);

		}




		protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

	        this.mc.func_110434_K().func_110577_a(gui);
	        

	        int k = (this.width - this.xSize) / 2;
	        int l = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		}

	}
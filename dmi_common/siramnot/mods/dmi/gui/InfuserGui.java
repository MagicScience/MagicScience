package siramnot.mods.dmi.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.blocks.tileeents.TileEntityInfuser;

/**
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 *
 */
public class InfuserGui extends GuiContainer {

	private TileEntityInfuser entityInfuser;
	private ResourceLocation guiLocation = new ResourceLocation(DMI.MOD_ID.toLowerCase(), "textures/gui/InfuserGUI.png");
	private InventoryPlayer invPlayer;

	public InfuserGui(InventoryPlayer invPlayer, TileEntityInfuser entityInfuser) {
		super(new ContainerInfuser(invPlayer, entityInfuser)); // TODO: fix this
		this.entityInfuser = entityInfuser;
		this.invPlayer = invPlayer;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		String className = this.getClass().getSimpleName();
		int lastG = className.lastIndexOf('G');
		String str = className.substring(0, lastG);
		
		int col = 0x0;
		int x = 1;
		int y = 1;
		fontRenderer.drawString(str, x, y, col);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		int j = (this.width - this.xSize) / 2;
		int k = (this.height - this.ySize) / 2;
		this.mc.func_110434_K().func_110577_a(guiLocation);
		this.drawTexturedModalRect(j, k, 0, 0, this.xSize, this.ySize);
		
//		if (this.entityInfuser.isInfusing) { }
	}
}

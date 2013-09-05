package siramnot.mods.dmi.gui;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.List;

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
		
		/*glColor3f(0.5f, 0.5f, 0.5f);
		glBegin(GL_QUADS);
			glVertex2f(10, 10);
			glVertex2f(20, 10);
			glVertex2f(10, 20);
			glVertex2f(20, 20);
		glEnd();
		*/
		
		List<List<List<List>>> list;
		
		glBegin(GL_TRIANGLES);
			glColor3f(1, 0, 0);
			glVertex2f(-1, -1);
			
			glColor3f(0, 1, 0);
			glVertex2f(0, 1);
			
			glColor3f(0, 0, 1);
			glVertex2f(1, -1);
		glEnd();
		
		int col = 220 >> 16 | 030 >> 8 | 200; // RGB(220,30,200) 
		int x = 1;
		int y = 1;
		fontRenderer.drawString(str, x, y, col);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		ySize = 256;
		glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.func_110434_K().func_110577_a(guiLocation);
		this.drawTexturedModalRect(50, 50, 0, 0, xSize, ySize);
		
//		if (this.entityInfuser.isInfusing) { }
	}
}

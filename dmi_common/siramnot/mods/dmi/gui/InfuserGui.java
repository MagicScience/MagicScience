package siramnot.mods.dmi.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import siramnot.mods.dmi.blocks.tileeents.TileEntityInfuser;

public class InfuserGui extends GuiContainer {

	TileEntityInfuser entityInfuser;

	public InfuserGui(InventoryPlayer invPlayer, TileEntityInfuser entityInfuser) {
		super(null); // TODO: fix this
		this.entityInfuser = entityInfuser;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		String className = this.getClass().toString();
		int lastG = className.lastIndexOf('G');
		String str = className.substring(0, lastG);
		int col = 0x0;
		int x = 1;
		int y = 1;
		fontRenderer.drawString(str, x, y, col);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

	}
}

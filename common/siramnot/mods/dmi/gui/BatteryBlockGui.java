package siramnot.mods.dmi.gui;


import javax.swing.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import siramnot.mods.dmi.core.*;
import siramnot.mods.dmi.core.managers.*;
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
public class BatteryBlockGui extends GuiContainer
{
	
	private TileEntityBatteryBlock	battery;
	private GuiButton				button0;
	
	public BatteryBlockGui(InventoryPlayer inventory, TileEntityBatteryBlock battery)
	{
		super(new ContainerBattery(inventory, battery));
		this.battery = battery;
		
		button0 = new GuiButton(0, 10, 10, 100, 20, "") {
			
			private boolean active;
			
			@Override
			public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3)
			{
				final boolean flag = super.mousePressed(par1Minecraft, par2, par3);
				active = flag;
				return flag;
			}
			
			private boolean foo(int x, int y)
			{
				EntityPlayer plr = Minecraft.getMinecraft().thePlayer; 
				plr.addChatMessage(x + " : " + y);
				return false;
			}
			
			boolean getIsActivated()
			{
				return active;
			}
			
		};
	}
	
	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		
		this.buttonList.add(button0);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		int x = 100;
		int y = 100;
		int color = 0xC0C0C0;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		
		ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, Reference.GUI_TEXTURE_LOCATION + "/BatteryGUI.png");
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		
		mc.renderEngine.bindTexture(texture);
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
	
}

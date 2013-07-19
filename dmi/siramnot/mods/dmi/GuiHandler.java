package siramnot.mods.dmi;

import siramnot.mods.dmi.blocks.tileeents.TileEntityLiquidator;
import siramnot.mods.dmi.gui.GuiLiquidator;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.tileentity.*;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {	
		
		switch (ID) {
		case 0:
			return new GuiLiquidator(player.inventory, (TileEntityLiquidator)world.getBlockTileEntity(x, y, z));
		
		}
		return null;
	}

}

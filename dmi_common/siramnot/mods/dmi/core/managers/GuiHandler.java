package siramnot.mods.dmi.core.managers;

import siramnot.mods.dmi.blocks.tileeents.TileEntityLiquidator;
import siramnot.mods.dmi.gui.ContainerLiquidator;
import siramnot.mods.dmi.gui.GuiLiquidator;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.tileentity.*;

public class GuiHandler implements IGuiHandler {

	public static final int LIQUIDATOR_ID = 0;
	public static final int INFUSER_ID = 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		
		case LIQUIDATOR_ID:
			return new ContainerLiquidator(player.inventory, (TileEntityLiquidator) world.getBlockTileEntity(x, y, z));
			
		case INFUSER_ID:
			return new Object();
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case LIQUIDATOR_ID:
			return new GuiLiquidator(player.inventory, (TileEntityLiquidator) world.getBlockTileEntity(x, y, z));
		case INFUSER_ID:
			return new Object();
		}

		return null;
	}

}

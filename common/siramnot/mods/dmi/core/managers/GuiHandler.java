package siramnot.mods.dmi.core.managers;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import siramnot.mods.dmi.entity.tile.*;
import siramnot.mods.dmi.gui.*;
import cpw.mods.fml.common.network.IGuiHandler;


/**
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class GuiHandler implements IGuiHandler
{
	
	public static final int	LIQUIDATOR_ID		= 0;
	public static final int	INFUSER_ID			= 1;
	public static final int	BATTERY_BLOCK_ID	= 2;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch (ID)
		{
			case LIQUIDATOR_ID:
				return new ContainerLiquidator(player.inventory, (TileEntityLiquidator) world.getBlockTileEntity(x, y, z));
				
			case INFUSER_ID:
				return new ContainerInfuser(player.inventory, (TileEntityInfuser) world.getBlockTileEntity(x, y, z));
				
			case BATTERY_BLOCK_ID:
				return new ContainerBattery(player.inventory, (TileEntityBatteryBlock) world.getBlockTileEntity(x, y, z));
				
			default:
				return null;
		}
		
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch (ID)
		{
			case LIQUIDATOR_ID:
				return new LiquidatorGui(player.inventory, (TileEntityLiquidator) world.getBlockTileEntity(x, y, z));
				
			case INFUSER_ID:
				return new InfuserGui(player.inventory, (TileEntityInfuser) world.getBlockTileEntity(x, y, z));
				
			case BATTERY_BLOCK_ID:
				return new BatteryBlockGui(player.inventory, (TileEntityBatteryBlock) world.getBlockTileEntity(x, y, z));
				
			default:
				return null;
		}
		
	}
	
}

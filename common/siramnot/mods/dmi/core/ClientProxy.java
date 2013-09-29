package siramnot.mods.dmi.core;

import net.minecraftforge.client.MinecraftForgeClient;
import siramnot.mods.dmi.core.managers.BlockManager;
import siramnot.mods.dmi.entity.tile.TileEntityWorkstation;
import siramnot.mods.dmi.render.*;
import cpw.mods.fml.client.registry.ClientRegistry;

/**
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
// Client Proxy
public class ClientProxy extends CommonProxy {
	
	@Override
	public void doProxyStuff() {
		bindEntities();
		registerRenderers();
	}
	
	private void bindEntities() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWorkstation.class, new TileEntityWorkStationRenderer());
	}
	
	private void registerRenderers() {
		MinecraftForgeClient.registerItemRenderer(BlockManager.workStation.blockID, new ItemBlockWorkStationRenderer());
	}
}

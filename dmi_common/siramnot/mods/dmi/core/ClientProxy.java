package siramnot.mods.dmi.core;

import net.minecraft.client.renderer.WorldRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import siramnot.mods.dmi.blocks.tileeents.ItemWorkStationRenderer;
import siramnot.mods.dmi.blocks.tileeents.TileEntityWorkStation;
import siramnot.mods.dmi.blocks.tileeents.TileEntityWorkStationRenderer;
import siramnot.mods.dmi.core.managers.BlockManager;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */// Client Proxy
public class ClientProxy extends CommonProxy {
	
	@Override
	public void doProxyStuff() {
		bindEntities();
		registerRenderers();
	}
	
	private void bindEntities() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWorkStation.class, new TileEntityWorkStationRenderer());
	}
	
	private void registerRenderers() {
		MinecraftForgeClient.registerItemRenderer(BlockManager.workStation.blockID, new ItemWorkStationRenderer());
	}
}

package siramnot.mods.dmi.core;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import siramnot.mods.dmi.blocks.tileeents.ItemWorkStationRenderer;
import siramnot.mods.dmi.blocks.tileeents.TileEntityWorkStation;
import siramnot.mods.dmi.blocks.tileeents.TileEntityWorkStationRenderer;
import siramnot.mods.dmi.core.managers.DMIBlockManager;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
/**
 * 
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author Jay
 *
 */
public class ClientProxy extends CommonProxy {
	

	public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWorkStation.class, new TileEntityWorkStationRenderer());
		MinecraftForgeClient.registerItemRenderer(DMIBlockManager.workStation.blockID, new ItemWorkStationRenderer());
	}
}

package siramnot.mods.dmi.core;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import siramnot.mods.dmi.DMIBlockManager;
import siramnot.mods.dmi.blocks.tileeents.ItemWorkStationRenderer;
import siramnot.mods.dmi.blocks.tileeents.TileEntityWorkStationBlockEntity;
import siramnot.mods.dmi.blocks.tileeents.TileEntityWorkStationRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	

	public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWorkStationBlockEntity.class, new TileEntityWorkStationRenderer());
		MinecraftForgeClient.registerItemRenderer(DMIBlockManager.workStation.blockID, new ItemWorkStationRenderer());
		
	}
}

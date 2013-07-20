package siramnot.mods.dmi;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class DMIEntityManager {
	public static void load() {
		/**
		 * Do not uncomment until we get the tileents fixed
		 * 
		 * 
		 * machine_workStation = new TileEntityWorkStationBlock(1402);
		 * GameRegistry.registerTileEntity(TileEntityWorkStationBlockEntity.class, "tileEntiyWorkStationBlock");
		 * 
		 * 
		 * 
		 */
		
		DMI.proxy.registerRenderers();
	}

}

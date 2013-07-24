package siramnot.mods.dmi;

import net.minecraft.entity.Entity;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import siramnot.mods.dmi.mobs.EntityBlazeSpider;
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

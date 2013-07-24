package siramnot.mods.dmi;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.world.biome.BiomeGenBase;
import siramnot.mods.dmi.mobs.EntityBlazeSpider;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class DMIEntityManager {
	public static void load(DMI dmi) {
		/**
		 * Do not uncomment until we get the tileents fixed
		 * 
		 * 
		 * machine_workStation = new TileEntityWorkStationBlock(1402);
		 * GameRegistry
		 * .registerTileEntity(TileEntityWorkStationBlockEntity.class,
		 * "tileEntiyWorkStationBlock");
		 * 
		 * 
		 * 
		 */
		entityRegistry(EntityRegistry.instance(), dmi);

		DMI.proxy.registerRenderers();
	}

	private static void entityRegistry(EntityRegistry er, DMI dmi) {
		er.registerModEntity(EntityBlaze.class, "Blazing Spider", 1, DMI.instance, 80, 3, true);
		er.addSpawn(EntityBlazeSpider.class, 7, 1, 3, EnumCreatureType.monster, BiomeGenBase.hell);
		LanguageRegistry.instance().addStringLocalization("entity."+ DMI.MOD_ID + ".Blazing Spider.name", "Blazing Spider");
	}

}

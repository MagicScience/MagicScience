package siramnot.mods.dmi;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.world.biome.BiomeGenBase;
import siramnot.mods.dmi.mobs.EntityBlazeSpider;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import siramnot.mods.dmi.mobs.EntityKaldymBoss;

public class DMIEntityManager {

	private static int startEID = 300;

	public static void load() {
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
		entityRegistry(EntityRegistry.instance());
		languageRegistry(LanguageRegistry.instance());
		registerSpawnEggs();
		
		DMI.proxy.registerRenderers();
	}

	private static void registerSpawnEggs() {
		registerEntityEgg(EntityBlazeSpider.class, 0x99360F, 0xE4E864);
		registerEntityEgg(EntityKaldymBoss.class, 0x99111F, 0xE5685);
	}

	private static void languageRegistry(LanguageRegistry lr) {
		LanguageRegistry.instance().addStringLocalization("entity.DMI.Blazing Spider.name", "Blazing Spider");
		LanguageRegistry.instance().addStringLocalization("entity.DMI.Kaldym the Necromancer.name", "Kaldym the Necromancer");
	}

	private static void entityRegistry(EntityRegistry er) {
		er.registerModEntity(EntityBlazeSpider.class, "Blazing Spider", 1, DMI.instance, 64, 3, true);
		er.addSpawn(EntityBlazeSpider.class, 70, 1, 3, EnumCreatureType.monster, BiomeGenBase.hell);
		er.registerModEntity(EntityKaldymBoss.class, "Kaldym the Necromancer", 1, DMI.instance, 64, 3, true);
		er.addSpawn(EntityKaldymBoss.class, 50, 1, 3, EnumCreatureType.monster, BiomeGenBase.swampland);
	}

	private static int getUniqueEntityID() {
		do {
			startEID++;
		} while (EntityList.getStringFromID(startEID) != null);

		return startEID;
	}

	
	
	/*
	 * How to add custom spawn egg:
	 * param1 = Entity's class
	 * param2 = Egg's color
	 * param3 = Egg's little spots color
	 */
	public static void registerEntityEgg(Class<? extends Entity> entity, int colPrim, int colSec) {
		int id = getUniqueEntityID();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, colPrim, colSec));
		return;
	}

}

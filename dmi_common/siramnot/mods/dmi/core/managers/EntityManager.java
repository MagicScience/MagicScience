package siramnot.mods.dmi.core.managers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.world.biome.BiomeGenBase;
import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.mobs.EntityBlazeSpider;
import siramnot.mods.dmi.mobs.EntityVolatileCreeper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import siramnot.mods.dmi.mobs.EntityKaldymBoss;
import siramnot.mods.dmi.mobs.render.RenderBlazeSpider;
import siramnot.mods.dmi.mobs.render.RenderKaldymBoss;

/**
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class EntityManager {

	private static int startEID = 300;
	private static int entityIDs = 0;
	private static String entityLoc = "entity.DMI.";
	private static String nameSuff = ".name";

	private static final String FIRE_SPIDER_NAME = "Blazing Spider";
	private static final String KALDYM_BOSS_NAME = "Kaldym the Necromancer";
	private static final String VOLATILE_SKELLY_NAME = "Volatile Skeleton";

	private static final Class<? extends EntityLiving> FIRE_SPIDER_CLASS = EntityBlazeSpider.class;
	private static final Class<? extends EntityLiving> KALDYM_BOSS_CLASS = EntityKaldymBoss.class;
	private static final Class<? extends EntityLiving> VOLATILE_SKELLY_CLASS = EntityVolatileCreeper.class;

	public static void load() {
		try {
			entityRegistry();
			renderEntityModels();
			languageRegistry();
			registerSpawnEggs();
		} catch (Exception e) {
			e.printStackTrace();
		}

		DMI.proxy.doProxyStuff();
	}

	private static void renderEntityModels() {
		RenderingRegistry.registerEntityRenderingHandler(FIRE_SPIDER_CLASS, new RenderBlazeSpider());
		RenderingRegistry.registerEntityRenderingHandler(KALDYM_BOSS_CLASS, new RenderKaldymBoss());
		RenderingRegistry.registerEntityRenderingHandler(VOLATILE_SKELLY_CLASS, new RenderKaldymBoss());
	}

	private static void registerSpawnEggs() {
		registerEntityEgg(FIRE_SPIDER_CLASS, 0x99360F, 0xE4E864);
		registerEntityEgg(KALDYM_BOSS_CLASS, 0x99111F, 0xE5685);
		registerEntityEgg(VOLATILE_SKELLY_CLASS, 0x990564, 0xE54);
	}

	private static void languageRegistry() {
		LanguageRegistry.instance().addStringLocalization(entityLoc + FIRE_SPIDER_NAME + nameSuff, FIRE_SPIDER_NAME);
		LanguageRegistry.instance().addStringLocalization(entityLoc + KALDYM_BOSS_NAME + nameSuff, KALDYM_BOSS_NAME);
		LanguageRegistry.instance().addStringLocalization(entityLoc + VOLATILE_SKELLY_NAME + nameSuff, VOLATILE_SKELLY_NAME);
	}

	private static void entityRegistry() {
		System.out.println("FireSpiderID: " + entityIDs);
		EntityRegistry.registerModEntity(FIRE_SPIDER_CLASS, FIRE_SPIDER_NAME, entityIDs++, DMI.instance, 64, 3, true);
		System.out.println("KaldymBossID: " + entityIDs);
		EntityRegistry.registerModEntity(KALDYM_BOSS_CLASS, KALDYM_BOSS_NAME, entityIDs++, DMI.instance, 64, 3, true);
		System.out.println("VolatileSkellyID: " + entityIDs);
		EntityRegistry.registerModEntity(VOLATILE_SKELLY_CLASS, VOLATILE_SKELLY_NAME, entityIDs++, DMI.instance, 64, 3, true);

		EntityRegistry.addSpawn(KALDYM_BOSS_CLASS, 25, 1, 3, EnumCreatureType.monster, BiomeGenBase.swampland);
		EntityRegistry.addSpawn(FIRE_SPIDER_CLASS, 70, 1, 3, EnumCreatureType.monster, BiomeGenBase.hell);
		EntityRegistry.addSpawn(VOLATILE_SKELLY_CLASS, 40, 1, 3, EnumCreatureType.monster, BiomeGenBase.hell);
		
	}

	private static int getUniqueEntityID() {
		do {
			startEID++;
		} while (EntityList.getStringFromID(startEID) != null);

		return startEID;
	}

	/**
	 * Add custom mob spawning eggs.<br/>
	 * <br/>
	 * <strong>For example: </strong><br/>
	 * The following code would create a Green egg with blue spots that spawns
	 * zombies.
	 * 
	 * <pre>
	 * registerEntityEgg(EntityZombie.class, 0x00ff00, 0x0000ff);
	 * </pre>
	 * 
	 * @param entity
	 *            Desired entity's class
	 * @param colPrim
	 *            Desired background color
	 * @param colSec
	 *            Desired foreground color
	 */
	public static void registerEntityEgg(Class<? extends Entity> entity, int colPrim, int colSec) {
		int id = getUniqueEntityID();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, colPrim, colSec));
		return;
	}

}

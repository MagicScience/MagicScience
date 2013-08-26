package siramnot.mods.dmi;

import buildcraft.BuildCraftCore;
import net.minecraft.creativetab.CreativeTabs;
import siramnot.mods.dmi.core.ClientProxy;
import siramnot.mods.dmi.core.managers.DMIBlockManager;
import siramnot.mods.dmi.core.managers.DMIConfigManager;
import siramnot.mods.dmi.core.managers.DMIEntityManager;
import siramnot.mods.dmi.core.managers.DMIItemManager;
import siramnot.mods.dmi.core.managers.DMIRecipeManager;
import siramnot.mods.dmi.core.managers.DMIWorldGenManager;
import siramnot.mods.dmi.core.managers.DMIGuiManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @license Creative-Commons Attribution Non-commercial v3.0
 * @author SirAmNot <br/>
 *         JiffyJay
 * 
 */
@Mod(modid = DMI.MOD_ID, name = DMI.MOD_NAM, version = DMI.MOD_VER, dependencies = DMI.REQ_POST
		+ "FML")
@NetworkMod(channels = { "" }, clientSideRequired = true, serverSideRequired = true)
public class DMI {

	@Instance(DMI.MOD_ID)
	public static DMI instance = new DMI();

	/*
	 * I use proxies for rendering, but a GUI Handler for GUI's and Containers
	 */
	public static final String PROXY_LOCATION = "siramnot.mods.dmi.core";
	@SidedProxy(clientSide = PROXY_LOCATION + ".ClientProxy", serverSide = PROXY_LOCATION
			+ ".CommonProxy")
	public static ClientProxy proxy;

	// Static constants and variables
	public static final String MC_VER = "1.6.2";
	public static final String MOD_VER_RAW = "0.0.1A";

	public static final String MOD_ID = "DMI";
	public static final String MOD_NAM = "Dominus ex Magica et Industria";
	public static final String MOD_VER = "[" + MC_VER + "]" + " " + MOD_VER_RAW;
	public static final String REQ_POST = "required-after:";

	public static final CreativeTabs TAB_CREATIVE = new CreativeTabs(0, "DMI");

	// Pre Init. Config here.
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		DMIConfigManager.init(e.getSuggestedConfigurationFile());
		DMIItemManager.load();
		DMIBlockManager.load();
	}

	// Load the mod itself.
	@EventHandler
	public void load(FMLInitializationEvent e) {
		// Create custom creative tab for items
		DMIEntityManager.load();
		DMIRecipeManager.load();

		GameRegistry.registerWorldGenerator(DMIWorldGenManager.getInstance());
		NetworkRegistry.instance().registerGuiHandler(this, new DMIGuiManager());
	}

	// Post init.
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
//		Loader.isModLoaded(modname)
	}
}

package siramnot.mods.dmi;

import net.minecraft.creativetab.CreativeTabs;
import siramnot.mods.dmi.core.ClientProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author SirAmNot, JiffyJay
 */

@Mod(modid = DMI.MOD_ID, name = DMI.MOD_NAM, version = DMI.MOD_VER)
@NetworkMod(channels = { "" }, clientSideRequired = true, serverSideRequired = true)
public class DMI {

	@Instance(DMI.MOD_ID)
	public static DMI instance = new DMI();

	/**
	 * I use proxies for rendering, but a GUI Handler for GUI's and Containers
	 */
	public static final String PROXY_LOCATION = "siramnot.mods.dmi.core";
	@SidedProxy(clientSide = PROXY_LOCATION + ".ClientProxy", serverSide = PROXY_LOCATION + ".CommonProxy")
	public static ClientProxy proxy;

	// Static constants and variables
	public static final String MC_VER = "1.6.2";
	public static final String MOD_VER_RAW = "0.0.1A";

	public static final String MOD_ID = "DMI";
	public static final String MOD_NAM = "Dominus ex Magica et Industria";
	public static final String MOD_VER = "[" + MC_VER + "] " + MOD_VER_RAW;

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
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());

		/*
		 * JFrame f = new JFrame("test"); f.setSize(10, 10); f.setVisible(true);
		 * f.setDefaultCloseOperation(f.HIDE_ON_CLOSE);
		 */
	}

	// Post init.
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
	}
}
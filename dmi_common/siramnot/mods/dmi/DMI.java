package siramnot.mods.dmi;

import java.util.logging.Logger;

import buildcraft.BuildCraftCore;
import net.minecraft.creativetab.CreativeTabs;
import siramnot.mods.dmi.core.ClientProxy;
import siramnot.mods.dmi.core.PacketHandler;
import siramnot.mods.dmi.core.managers.BlockManager;
import siramnot.mods.dmi.core.managers.ConfigManager;
import siramnot.mods.dmi.core.managers.EntityManager;
import siramnot.mods.dmi.core.managers.ItemManager;
import siramnot.mods.dmi.core.managers.DMIRecipeManager;
import siramnot.mods.dmi.core.managers.WorldGenManager;
import siramnot.mods.dmi.core.managers.GuiHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IPacketHandler;
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
@Mod(modid = DMI.MOD_ID, name = DMI.MOD_NAM, version = DMI.MOD_VER, dependencies = DMI.REQ_POST + "FML")
@NetworkMod(channels = { DMI.MOD_ID }, packetHandler = PacketHandler.class, clientSideRequired = true, serverSideRequired = false)
public class DMI {

	@Instance(DMI.MOD_ID)
	public static DMI instance = new DMI();

	public static final String PROXY_LOCATION = "siramnot.mods.dmi.core";
	@SidedProxy(clientSide = PROXY_LOCATION + ".ClientProxy", serverSide = PROXY_LOCATION + ".CommonProxy")
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
		checkOS();
		
		ConfigManager.init(e.getSuggestedConfigurationFile());
		if (!ConfigManager.isModEnabled) {
			System.out.println("Mod disabled via the config file!");
			return;
		}
		instance = this;

		ItemManager.load();
		BlockManager.load();
	}

	// Load the mod itself.
	@EventHandler
	public void load(FMLInitializationEvent e) {
		// Create custom creative tab for items
		if (!ConfigManager.isModEnabled)
			return;
		EntityManager.load();
		DMIRecipeManager.load();

		GameRegistry.registerWorldGenerator(WorldGenManager.getInstance());
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
	}

	// Post init.
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}
	
	private void checkOS() {
		String os = System.getProperty("os.name");
		String mac = "mac";
		if (os.substring(0,mac.length()).toLowerCase().equals(mac)) {
			System.err.printf("[%s] Looks like you are using a Mac. Please don't whine about Mac support.\n", MOD_ID);
		}
	}
}

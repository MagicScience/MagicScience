package siramnot.mods.dmi;

import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glVertex2d;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.creativetab.CreativeTabs;
import siramnot.mods.dmi.core.ClientProxy;
import siramnot.mods.dmi.core.PacketHandler;
import siramnot.mods.dmi.core.managers.BlockManager;
import siramnot.mods.dmi.core.managers.ConfigManager;
import siramnot.mods.dmi.core.managers.DMIRecipeManager;
import siramnot.mods.dmi.core.managers.EntityManager;
import siramnot.mods.dmi.core.managers.GuiHandler;
import siramnot.mods.dmi.core.managers.ItemManager;
import siramnot.mods.dmi.worldgen.WorldGenManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

/**
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @license Creative-Commons Attribution Non-commercial v3.0
 * @author SirAmNot <br/>
 * 
 */
@Mod(
	modid						=	IReference.MOD_ID,
	name						=	IReference.MOD_NAME,
	version						=	IReference.MOD_VERSION,
	dependencies				=	"required-after:FML",
	acceptedMinecraftVersions	=	IReference.MC_VERSION
	)
@NetworkMod(channels = { DMI.MOD_ID }, packetHandler = PacketHandler.class, clientSideRequired = true, serverSideRequired = false)
public class DMI implements IReference {

	// Instance of this mod
	@Instance(MOD_ID)
	public static DMI instance;

	// Proxy instance. Used for rendering and similar.
	@SidedProxy(clientSide = CLIENT_PROXY_LOCATION, serverSide = SERVER_PROXY_LOCATION)
	public static ClientProxy proxy;
	public static final CreativeTabs TAB_CREATIVE = new CreativeTabs(CreativeTabs.getNextID(), MOD_ID);

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		EntityClientPlayerMP plr = Minecraft.getMinecraft().thePlayer;
		
		
		ConfigManager cfm = new ConfigManager(e, MOD_ID);
		instance = this;

		ItemManager.load();
		BlockManager.load();
	}

	@EventHandler
	public void load(FMLInitializationEvent e) {
		EntityManager.load();
		DMIRecipeManager.load();

		WorldGenManager.registerGenerators();
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		// interaction with other mods goes here.
	}

}
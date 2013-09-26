package siramnot.mods.dmi.core.managers;

import java.io.File;
import java.util.HashMap;

import net.minecraftforge.common.Configuration;
import siramnot.mods.dmi.IReference;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class ConfigManager implements IReference {

	private File configFile;
	private Configuration conf;
	
	private ConfigManager(File file) {
		configFile = file;
		conf = new Configuration(file);
	}

	public ConfigManager(FMLPreInitializationEvent e, String modID) {
		this(new File(e.getModConfigurationDirectory(), String.format("\\%s\\%s.txt", MOD_ID, modID)));
	}
	
	void read() {
		
	}
	
	void write() {
		
	}

}

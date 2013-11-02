package siramnot.mods.dmi.core.managers;

import java.io.File;
import java.util.HashMap;

import net.minecraftforge.common.Configuration;
import siramnot.mods.dmi.core.*;
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
public class ConfigManager {

	private File configFile;
	private Configuration conf;
	
	private ConfigManager(File file) {
		configFile = file;
		conf = new Configuration(file);
	}

	public ConfigManager(FMLPreInitializationEvent e, String id) {
		this(new File(e.getModConfigurationDirectory(), String.format("\\%s\\%s.txt",  Reference.MOD_ID, id)));
	}
	
	void read() {
		
	}
	
	void write() {
		
	}

}

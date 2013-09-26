/**
 * 
 */
package siramnot.mods.dmi;

/**
 * 
 * Dominus ex Magica et Industria mod.
 *
 * <p> Reference class. </p>
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public interface IReference {
	
	public final String MOD_ID					=	"DMI";							// Mod's ID
	public final String MOD_NAME				= 	"Dominus ex Magica et Machina";	// Mod's human-readable name
	public final String MOD_VERSION				=	"0.0.1A";						// Mod's version, still in early alpha stage
	public final String MC_VERSION				=	"1.6.2";						// Accepted Minecraft version
	public final String CORE_LOCATION			=	"siramnot.mods.dmi.core";		// Proxy (and similar)-containing package location
	public final String SERVER_PROXY_LOCATION	=	CORE_LOCATION + ".CommonProxy";	// Common (server) proxy location
	public final String CLIENT_PROXY_LOCATION	=	CORE_LOCATION + ".ClientProxy";	// Client proxy location
	
	
}

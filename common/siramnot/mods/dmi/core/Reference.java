/**
 * 
 */
package siramnot.mods.dmi.core;


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
public class Reference
{
	public final static String	MOD_ID							= "dmi";									// Mod's ID
	public final static String	MOD_NAME						= "Dominus ex Magica et Machina";			// Mod's human-readable name
	public final static String	MOD_VERSION						= "0.0.1A";									// Mod's version, still in early alpha stage
	public final static String	MC_VERSION						= "1.6.2";									// Accepted Minecraft version
	public final static String	CORE_LOCATION					= "siramnot.mods.dmi.core";					// Proxy (and similar)-containing package location
	public final static String	SERVER_PROXY_LOCATION			= CORE_LOCATION + ".CommonProxy";			// Common (server) proxy location
	public final static String	CLIENT_PROXY_LOCATION			= CORE_LOCATION + ".ClientProxy";			// Client proxy location
																											
	public final static String	TEXTURE_LOCATION				= "textures";								// Textures are located here
	public final static String	BLOCK_TEXTURE_LOCATION			= MOD_ID.toLowerCase() + ":";				// Block textures are here
	public final static String	TILE_ENTITY_TEXTURE_LOCATION	= TEXTURE_LOCATION + "/blocks/models";
	public final static String	ITEM_TEXTURE_LOCATION			= BLOCK_TEXTURE_LOCATION;
	public final static String	ITEM_BLOCK_TEXTURE_LOCATION		= BLOCK_TEXTURE_LOCATION + "itemblocks";
	public final static String	GUI_TEXTURE_LOCATION			= TEXTURE_LOCATION + "/gui";				// GUI textures
	public final static String	MOB_TEXTURE_LOCATION			= TEXTURE_LOCATION + "/mobs";				// Mob textures, for models
	
	/**
	 * Chat formatting codes.<br/>
	 * Using:  
	 * <pre>player.addChatMessage(ChatFormat.DARK_RED + "Hello!");</pre> 
	 * Will result in dark red text appearing on the player's chat area, on-screen
	 */
	public static class ChatFormat
	{
		public static final String	FORMAT_SYMBOL	= "§";
		public static final String	BLACK			= FORMAT_SYMBOL + "0";
		public static final String	DARK_BLUE		= FORMAT_SYMBOL + "1";
		public static final String	DARK_GREEN		= FORMAT_SYMBOL + "2";
		public static final String	DARK_RED		= FORMAT_SYMBOL + "3";
		public static final String	DARK_PURPLE		= FORMAT_SYMBOL + "4";
		public static final String	GOLD			= FORMAT_SYMBOL + "6";
		public static final String	GRAY			= FORMAT_SYMBOL + "7";
		public static final String	DARK_GRAY		= FORMAT_SYMBOL + "8";
		public static final String	BLUE			= FORMAT_SYMBOL + "9";
		public static final String	GREEN			= FORMAT_SYMBOL + "A";
		public static final String	AQUA			= FORMAT_SYMBOL + "B";
		public static final String	RED				= FORMAT_SYMBOL + "C";
		public static final String	LIGHT_PURPLE	= FORMAT_SYMBOL + "D";
		public static final String	YELLOW			= FORMAT_SYMBOL + "E";
		public static final String	WHITE			= FORMAT_SYMBOL + "F";
		
		public static final String	OBFUSCATE		= FORMAT_SYMBOL + "K";
		public static final String	BOLD			= FORMAT_SYMBOL + "L";
		public static final String	STRIKEOUT		= FORMAT_SYMBOL + "M";
		public static final String	UNDERLINE		= FORMAT_SYMBOL + "N";
		public static final String	ITALIC			= FORMAT_SYMBOL + "O";
		public static final String	RESET			= FORMAT_SYMBOL + "R";
		
	}
	
	/**
	 * A class containing various miscellaneous functions
	 */
	public static class Util
	{
		/**
		 * Used to calculate the power of two of the index
		 * @param index Desired power<br/>
		 * @return <pre>Math.pow(2.0, index);</pre>
		 */
		public static int pow2(int index)
		{
			return 1 << index;
		}
	}
}

package siramnot.mods.dmi.power;

import net.minecraft.util.Vec3;

/**
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * @see #IPowerConsumer
 */
public interface IPowerProvider {
	/**
	 * The amount of power produced per tick
	 */
	int powerProduced();
	
	/**
	 * True if providing power
	 */
	boolean isProvidingPower();
	
	/**
	 * Type of power created
	 * @return "magic" for Magical and "mech" for Mechanical power.
	 */
	String powerType();
	
	/**
	 * Internal power buffer size
	 */
	int bufferSize();
	
	/**
	 * @see #IPowerProvider
	 */
	Vec3 location();
}

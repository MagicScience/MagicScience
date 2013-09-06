package siramnot.mods.dmi.power;

import net.minecraft.util.Vec3;

public interface IPowerConsumer {
	/**
	 * The amount of power consumed per tick
	 */
	int powerConsumed();
	
	/**
	 * True if requesting power
	 */
	boolean isRequestingPower();
	
	/**
	 * Type of power used
	 * @return "magic" for Magical and "mech" for Mechanical power.
	 */
	String powerType();
	
	/**
	 * The maximum amount of power this machine can receive before exploding
	 */
	int maxPower();
	
	/**
	 * Internal power buffer size
	 */
	int bufferSize();
	
	/**
	 * Returns the location for this block
	 */
	Vec3 location();
}

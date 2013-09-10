package siramnot.mods.dmi.core.managers;

/**
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public enum BlockNames {

	LIQUIDATOR		("Liquidator", "liquidator"),
	WORKSTATION		("Workstation", "workstation"),
	ORE				("Unknow ore", "ores"),							// Has meta
	ORE_STORAGE		("Unknown ore-storage block", "oreStorage"),	// Has meta
	INFUSER			("Infuser", "infuserCore"),
	FLUIDS			("Unknown Liquid", "liquid"),					// Has meta
	MAGIC_GLASS		("Elemental Glass", "magicGlass");
	
	BlockNames(String name, String unlocal) {
		this.name = name;
		this.unlocal = unlocal;
	}

	public String getName() {
		return name;
	}

	public String getUnlocalizedName() {
		return unlocal;
	}

	private String name, unlocal;
}

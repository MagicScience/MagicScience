package siramnot.mods.dmi.items;

/**
 * 
 * Dominus ex Magica et Industria mod. (C) Copyright SirAmNot 2013
 * 
 * @author SirAmNot
 * @disclaimer
 * THIS CLASS IS WIP
 * 
 */
public enum EnumStaff {
	LIGHTNING(150, 22);
	
	/**
	 * 
	 * @param i
	 *            harvestLevel
	 * @param j
	 *            maxUses
	 * @param k
	 *            efficiency
	 * @param l
	 *            damageVsEntities
	 * @param m
	 *            enchantability
	 */
	private EnumStaff(int uses, int enchant) {
		this.harvestLevel = 0;
		this.durability = uses;
		this.enchant = enchant;
		this.efficiency = 0.0f;
	}
	
	private EnumStaff(int uses, int enchant, int damage) {
		
	}
	
	private int harvestLevel, durability, enchant;
	private float efficiency, damage;

}

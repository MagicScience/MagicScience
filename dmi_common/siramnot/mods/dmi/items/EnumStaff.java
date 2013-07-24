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
		this.durability = uses;
		this.enchant = enchant;
		this.harvestLevel = 0;
		this.efficiency = 0.0f;
		this.damage = 1.0f;
	}
	
	private EnumStaff(int uses, int enchant, int damage) {
		this.harvestLevel = 0;
		this.efficiency = 0.0f;
		this.durability = uses;
		this.enchant = enchant;
		this.damage = damage;
	}
	
	private int harvestLevel, durability, enchant;
	private float efficiency, damage;
	
	// Getters
	public int getHarvestLevel() {
		return harvestLevel;
	}
	
	public int getDurability() {
		return durability;
	}
	
	public int getEnchantability() {
		return enchant;
	}
	
	public float getEfficiency() {
		return efficiency;
	}
	
	public float getDamageDone() {
		return damage;
	}

}

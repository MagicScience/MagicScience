package siramnot.mods.dmi.core.managers;

public enum ItemNames {

	ITEMLOL("","");
	
	ItemNames(String name, String unlocal) {
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
package siramnot.mods.dmi;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class ItemInfusedWater extends Item {
	
	private static final String[] names = new String[] {
		"Water-infused bottle", // water infused
		"Earth-infused bottle", // earth infused
		"Fire-infused bottle", // fire infused
		"Air-infused bottle" // air infused
	};

	public ItemInfusedWater(int id) {
		super(id);
		
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(int meta, CreativeTabs tab, List list) {
		
	}
		
}

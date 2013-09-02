package siramnot.mods.dmi.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import siramnot.mods.dmi.blocks.tileeents.TileEntityInfuser;

/**
 * 
 * 
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 *
 */
public class ContainerInfuser extends Container {
	
	private TileEntityInfuser tei;
	private int lastInfuseTime;
	private static int slotID = 0;
	
	public ContainerInfuser(InventoryPlayer invPlr, TileEntityInfuser tei) {
		this.slotID = 0;
		this.lastInfuseTime = 0;
		this.tei= tei;
		
		addSlots();
	}
	
	private void addSlots() {
		addSlotToContainer(new Slot(tei, slotID++, 80, 78)); // middle slot
		addSlotToContainer(new Slot(tei, slotID++, 80, 48)); // top slot
		addSlotToContainer(new Slot(tei, slotID++, 80, 108)); // bottom slot
		addSlotToContainer(new Slot(tei, slotID++, 50, 78)); // left slot
		addSlotToContainer(new Slot(tei, slotID++, 110, 78)); // right slot
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
	
	public static int getSlotAmount() {
		int flag = slotID;
		return ++flag; 
	}

}
 
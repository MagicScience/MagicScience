package siramnot.mods.dmi.entity.tile;


import java.util.Random;
import java.util.logging.Logger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import siramnot.mods.dmi.DMI;


public class TileEntityWorkstation extends TileEntity
{
	/** Used by the render to make the book 'bounce' */
	public int				tickCount;
	
	/** Value used for determining how the page flip should look. */
	public float			pageFlip;
	
	/** The last tick's pageFlip value. */
	public float			pageFlipPrev;
	public float			field_70373_d;
	public float			field_70374_e;
	
	/** The amount that the book is open. */
	public float			bookSpread;
	
	/** The amount that the book is open. */
	public float			bookSpreadPrev;
//	public float			bookRotation2;
//	public float			bookRotationPrev;
//	public float			bookRotation;
	private static Random	rand	= new Random();
	private String			field_94136_s;
	
	public void updateEntity()
	{
		super.updateEntity();
		this.renderBook();
	}
	
	private void renderBook()
	{
		this.bookSpreadPrev = this.bookSpread;
//		this.bookRotationPrev = this.bookRotation2;
		EntityPlayer entityplayer = this.worldObj.getClosestPlayer((double) ((float) this.xCoord + 0.5F), (double) ((float) this.yCoord + 0.5F), (double) ((float) this.zCoord + 0.5F), 3.0D);
		
		if (entityplayer != null)
		{
			double d0 = entityplayer.posX - (double) ((float) this.xCoord + 0.5F);
			double d1 = entityplayer.posZ - (double) ((float) this.zCoord + 0.5F);
//			this.bookRotation = (float) Math.atan2(d1, d0);
			this.bookSpread += 0.1F;
			
			if (this.bookSpread < 0.5F || rand.nextInt(40) == 0)
			{
				float f = this.field_70373_d;
				
				do
				{
					this.field_70373_d += (float) (rand.nextInt(4) - rand.nextInt(4));
				} while (f == this.field_70373_d);
			}
		} else
		{
//			this.bookRotation += 0.02F;
			this.bookSpread -= 0.1F;
		}
		
//		while (this.bookRotation2 >= (float) Math.PI)
//		{
//			this.bookRotation2 -= ((float) Math.PI * 2F);
//		}
		
//		while (this.bookRotation2 < -(float) Math.PI)
//		{
//			this.bookRotation2 += ((float) Math.PI * 2F);
//		}
		
//		while (this.bookRotation >= (float) Math.PI)
//		{
//			this.bookRotation -= ((float) Math.PI * 2F);
//		}
		
//		/*while (this.bookRotation < -(float) Math.PI)
//		{
//			this.bookRotation += ((float) Math.PI * 2F);
//		}
//		*/
//		float f1;
		
//		for (f1 = this.bookRotation - this.bookRotation2; f1 >= (float) Math.PI; f1 -= ((float) Math.PI * 2F))
//		{
//			;
//		}
		
//		while (f1 < -(float) Math.PI)
//		{
//			f1 += ((float) Math.PI * 2F);
//		}
		
//		this.bookRotation2 += f1 * 0.4F;
		
		if (this.bookSpread < 0.0F)
		{
			this.bookSpread = 0.0F;
		}
		
		if (this.bookSpread > 1.0F)
		{
			this.bookSpread = 1.0F;
		}
		
		++this.tickCount;
		this.pageFlipPrev = this.pageFlip;
		float f2 = (this.field_70373_d - this.pageFlip) * 0.4F;
		float f3 = 0.2F;
		
		if (f2 < -f3)
		{
			f2 = -f3;
		}
		
		if (f2 > f3)
		{
			f2 = f3;
		}
		
		this.field_70374_e += (f2 - this.field_70374_e) * 0.9F;
		this.pageFlip += this.field_70374_e;
		
	}
}

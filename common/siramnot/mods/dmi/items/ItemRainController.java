package siramnot.mods.dmi.items;

import java.util.Random;

import siramnot.mods.dmi.DMI;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class ItemRainController extends Item{

	public ItemRainController(int par1) {
		super(par1);
		
	}
	int i = (300 + (new Random()).nextInt(600)) * 20;
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
			
		WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
		WorldInfo worldinfo = worldserver.getWorldInfo();
		
		worldinfo.setRaining(false);
		worldinfo.setThundering(false);
		worldinfo.setRainTime(i);	
		
		
		return par1ItemStack;
			
	}
	
}
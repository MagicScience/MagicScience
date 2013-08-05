package siramnot.mods.dmi.blocks;

import siramnot.mods.dmi.DMI;
import siramnot.mods.dmi.blocks.tileeents.TileEntityInfuserCore;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class BlockInfuserCore extends BlockContainer implements ICommandSender {

	protected BlockInfuserCore(int par1, Material par2Material) {
		super(par1, par2Material);
	}

	public TileEntity createNewTileEntity(World world) {
		return new TileEntity();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (player.isSneaking()) return false;
		TileEntityInfuserCore te = (TileEntityInfuserCore)world.getBlockTileEntity(x, y, z);
		
		if (te != null) {
			if (te.checkShape()) {
				te.convertDummies();
				if(world.isRemote) player.sendChatToPlayer("lolgg");
			}
		}
		
		if (te.getIsValid())
			player.openGui(DMI.instance, 10, world, x, y, z);
	}

	public String getCommandSenderName() {
		return null;
	}

	public void sendChatToPlayer(ChatMessageComponent chatmessagecomponent) {
		
	}

	public boolean canCommandSenderUseCommand(int i, String s) {
		return false;
	}

	public ChunkCoordinates getPlayerCoordinates() {
		return null;
	}

	public World func_130014_f_() {
		return null;
	}

}

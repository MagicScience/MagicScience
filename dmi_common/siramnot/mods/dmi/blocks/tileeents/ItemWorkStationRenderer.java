package siramnot.mods.dmi.blocks.tileeents;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import siramnot.mods.dmi.models.ModelWorkStation;

public class ItemWorkStationRenderer implements IItemRenderer {

	private ModelWorkStation model;

	public ItemWorkStationRenderer() {

		this.model = new ModelWorkStation();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {

		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityWorkStation(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
}

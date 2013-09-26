package siramnot.mods.dmi.recipes;

import java.util.HashMap;
import java.util.Map;

import siramnot.mods.dmi.core.managers.IDManager;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class RecipesLiquidator {

	private static final RecipesLiquidator recipesRefiner = new RecipesLiquidator();

	private Map refinerList = new HashMap();
	private Map refinerExperience = new HashMap();
	
	/**
	 * Add recipes for the liquidator like this
	 * Parameter one : Input Block Two
	 * Parameter two : Output Block Itemstack
	 * Parameter three : Experience
	 */

	private RecipesLiquidator(){
//		addRecipe(Block.dirt.blockID, new ItemStack(Block.cobblestone, 1, 0), 0.7F);
//		addRecipe(Block.obsidian.blockID,null, 0.0f); // convert obsidian into raw lava, test recipe for now
	}

	public void addRecipe(int par1ItemID, ItemStack par2ItemStack, float par3Float) {
		refinerList.put(Integer.valueOf(par1ItemID), par2ItemStack);

		this.refinerExperience.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3Float));

	}

	public ItemStack getRefiningResult(int par1){
		return (ItemStack) refinerList.get(Integer.valueOf(par1));
	}

	public Map getRefininingList(){
		return refinerList;
	}

	public float getExperience(int par1){
		return this.refinerExperience.containsKey(Integer.valueOf(par1)) ? ((Float) this.refinerExperience.get(Integer.valueOf(par1))).floatValue() : 0.0F;
	}

	public static final RecipesLiquidator liquidating() {
		return recipesRefiner;

	}

}
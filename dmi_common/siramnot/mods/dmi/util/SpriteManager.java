/**
 * 
 */
package siramnot.mods.dmi.util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.HashMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

/**
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class SpriteManager {

	private static HashMap<String, int[]> sprites = new HashMap<String, int[]>();
	private static SpriteManager instance;

	private SpriteManager() { }

	public static void loadSpriteFromSheet(String key, String sheet, int width, int height, int xCoord, int yCoord) {
		int[] load = load(sheet, width, height, xCoord, yCoord);
		putToHash(key, sheet, load);
	}
	
	public static void putToHash(String key, String sheet, int[] value) {
		HashMap hash = sprites; // "Loads" the HashMap
		hash.put(sheet + Reference.SPRITESHEET_SHEET_JOINER + key, value);
		
		sprites = hash; // "Saves" the HashMap
	}
	
	public static void putToHash(String key, String sheet, BufferedImage value) {
		int[] pixels = ((DataBufferInt) value.getRaster().getDataBuffer()).getData();
		HashMap hash = sprites; // "Loads" the HashMap
		hash.put(sheet + Reference.SPRITESHEET_SHEET_JOINER + key, pixels);
		
		sprites = hash; // "Saves" the HashMap
	}
	
	public static BufferedImage getFromHash(String key, String sheet) {
		HashMap hash = sprites;
		BufferedImage img = (BufferedImage) hash.get(sheet + Reference.SPRITESHEET_SHEET_JOINER + key);
		
		if (img != null) {
			return img;
		} else {
			throw new NullPointerException(Reference.CRASH_MESSAGE);
		}
	}
	
	public Icon registerIcons() {
		return null;
	}
	
	private static int[] load(String sheet, int width, int height, int xCoord, int yCoord) {
		BufferedImage buffer = SpritesheetManager.getFromHash(sheet);
		int[] buffer_pixels = ((DataBufferInt) buffer.getRaster().getDataBuffer()).getData();
		BufferedImage sprite;
		int[] sprite_pixels = new int[width * height];

		for (int y = yCoord; y < yCoord + height + 1; ++y) {
			for (int x = xCoord; x < xCoord + width + 1; ++x) {
				sprite_pixels[(x - xCoord) + (y - yCoord) * width] = buffer_pixels[x + y * buffer.getWidth()];
			}
		}
		
		return sprite_pixels;
	}

	public static SpriteManager instance() {
		if (instance == null) {
			instance = new SpriteManager();
		}

		return instance;
	}

}

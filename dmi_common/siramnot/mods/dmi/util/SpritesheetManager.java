/**
 * 
 */
package siramnot.mods.dmi.util;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

/**
 * Dominus ex Magica et Industria mod.
 * 
 * @author SirAmNot
 * @license Creative-Commons Attribution Non-commercial v3.0
 * 
 */
public class SpritesheetManager {
	private static HashMap<String, BufferedImage> spriteSheets = new HashMap<String, BufferedImage>();
	private static SpritesheetManager instance;

	
	private SpritesheetManager() {	}

	private static BufferedImage load(String path) {
		try {
			BufferedImage input = ImageIO.read(SpritesheetManager.class.getResource(path));
			return input;
		} catch (IOException e) {
			System.out.println(Reference.CRASH_MESSAGE);
			e.printStackTrace();
		}

		return null;
	}

	public static void putToHash(String key, BufferedImage value) {
		HashMap hash = spriteSheets; // "Loads" the HashMap
		hash.put(key, value);
		
		spriteSheets = hash; // "Saves" the HashMap
	}
	
	private static Point getSlashAndDot(String path) {
		char dot = '.';
		char _slash = '\\';
		char slash_ = '/';
		Integer nil = null;

		@SuppressWarnings("null")
		int dotAt = nil;
		for (int i = 0; i < path.length(); ++i) {
			char current = path.charAt(i);
			if (current != dot)
				continue;

			dotAt = i;
		}

		int slashAt = nil;
		for (int i = 0; i < path.length(); ++i) {
			char current = path.charAt(i);
			if (current != _slash || current != slash_)
				continue;

			slashAt = i;
		}

		if (dotAt == nil || slashAt == nil) {
			try {
				throw new FileNotFoundException(Reference.CRASH_MESSAGE);
			} catch (Exception e) {
				throw new RuntimeException(Reference.CRASH_MESSAGE);
			}
		}
		return new Point(slashAt, dot);
	}

	public static void loadSpriteSheet(String path, String description) {
		BufferedImage load = load(path);
		putToHash(description, load);
	}

	public static void loadSpirteSheet(String path) {
		BufferedImage load = load(path);
		putToHash(getSpriteSheetFileName(path), load);
	}

	public static String getSpriteSheetFileName(String path) {
		Point point = getSlashAndDot(path);
		int slash = (int) point.getX();
		int dot = (int) point.getY();

		String name = "";
		for (int i = slash + 1; i < dot; ++i) {
			char currentlyAt = path.charAt(i);
			name += currentlyAt;
		}

		return ((name.equals("")) ? null : name);
	}
	
	public static BufferedImage getFromHash(String key) {
		HashMap hash = spriteSheets;
		BufferedImage img = (BufferedImage) hash.get(key);
		
		if (img != null) {
			return img;
		} else {
			throw new NullPointerException(Reference.CRASH_MESSAGE);
		}
	}
	
	public static SpritesheetManager instance() {
		if (instance == null) {
			instance = new SpritesheetManager();
		}

		return instance;
	}

}

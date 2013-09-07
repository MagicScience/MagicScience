package siramnot.mods.dmi.core.managers;

import net.minecraft.client.Minecraft;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.storage.ISaveHandler;

public class GameRuleManager {

	private static GameRules rules;
	private static World world;
	private static GameRuleManager instance;

	public GameRuleManager(World world) {
		if (instance != null)
			return;

		this.world = world;
		this.rules = world.getGameRules();
		this.instance = this;
	}

	public static void addOrSetGameRule(String name, String value) {
		rules.setOrCreateGameRule(name, value);
	}
}

package simpleexplosivesnowball.teamkarbon.com;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	protected ArrayList<String> players = new ArrayList<String>(0);

	@Override
	public void onEnable() {
		
		getCommand("ESB").setExecutor(new Commandexecutor(this));
		
		PluginManager manager = this.getServer().getPluginManager();
		manager.registerEvents(new SBListener(this), this);
		
		getLogger().info("SimpleExplosiveSnowBall Plugin" + ChatColor.GREEN + "Enabled");
	}

	@Override
	public void onDisable() {
		getLogger().info(
				"SimpleExplosiveSnowBall Plugin has been safely" + ChatColor.DARK_RED
						+ "Disabled");
	}
}

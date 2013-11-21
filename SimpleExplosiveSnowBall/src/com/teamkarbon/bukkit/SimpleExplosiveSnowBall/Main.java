package simpleexplosivesnowball.teamkarbon.com;

import java.util.ArrayList;

import org.bukkit.ChatColor;
package com.teamkarbon.bukkit.SimpleExplosiveSnowBall;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	
	ArrayList<String> players = new ArrayList<String>(0);

	@Override
	public void onEnable() {
		
		getCommand("ESB").setExecutor(new Commandexecutor(this));
		
		File file = new File(getDataFolder() + File.separator + "config.yml");
		if (file.exists() == false) {
			getLogger().info("Config not found, generating....");			
			getConfig().options().copyDefaults(true);
			saveConfig();
		}
		
		PluginManager manager = this.getServer().getPluginManager();
		manager.registerEvents(new SBListener(this), this);
		
		try {
		    MetricsLite metrics = new MetricsLite(this);
		    metrics.start();
		} catch (IOException e) {
			
		}
		
		getLogger().info("SimpleExplosiveSnowBall Plugin" + ChatColor.GREEN + "Enabled");
	}

	@Override
	public void onDisable() {
		saveConfig();
		getLogger().info(
				"SimpleExplosiveSnowBall Plugin has been safely" + ChatColor.DARK_RED
						+ "Disabled");
	}
}

package simpleexplosivesnowball.teamkarbon.com;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
package com.teamkarbon.bukkit.SimpleExplosiveSnowBall;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class SBListener implements Listener {

	private Main plugin;

	public SBListener(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {

		Entity entity = event.getEntity();

		// Config
		float size = plugin.getConfig().getInt("Size of Explosion");
		boolean damage = plugin.getConfig().getBoolean("Block Damage");
		boolean fire = plugin.getConfig().getBoolean("Set Fire");

		if (entity instanceof Snowball) {
			Snowball snowball = (Snowball) entity;
			Entity shooter = snowball.getShooter();

			if (shooter instanceof Player) {
				Player player = (Player) shooter;
				Location sb = snowball.getLocation();

				if (plugin.players.contains(player.getName())) {
					player.getWorld().createExplosion(sb.getX(), sb.getY(),
							sb.getZ(), size, fire, damage);
				}
			}
		}
	}
}

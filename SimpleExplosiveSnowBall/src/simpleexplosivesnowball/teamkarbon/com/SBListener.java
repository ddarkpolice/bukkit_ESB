package simpleexplosivesnowball.teamkarbon.com;

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

		if (entity instanceof Snowball) {
			Snowball snowball = (Snowball) entity;
			Entity shooter = snowball.getShooter();
			
			if (shooter instanceof Player) {
				Player player = (Player) shooter;
				
				if (plugin.players.contains(player.getName())) {
					player.getWorld().createExplosion(snowball.getLocation(), 3F);
				}
				
			}
			
		}		
	}
}

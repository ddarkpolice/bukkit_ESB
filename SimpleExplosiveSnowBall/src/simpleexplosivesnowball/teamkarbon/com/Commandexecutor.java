package simpleexplosivesnowball.teamkarbon.com;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandexecutor implements CommandExecutor{
	
	private Main plugin;
	
	public Commandexecutor(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("ESB")) {
			if (args.length == 0) {
				if (sender instanceof Player == true) {
					if (plugin.players.contains(player.getName())) {
						plugin.players.remove(player.getName());
						Bukkit.broadcastMessage(ChatColor.GRAY + "["
								+ ChatColor.DARK_PURPLE + "ESB"
								+ ChatColor.GRAY + "] " + ChatColor.GREEN
								+ "Explosive Snow Ball has been disabled!");
						return true;
					} else {
						plugin.players.add(player.getName());
						Bukkit.broadcastMessage(ChatColor.GRAY
								+ "["
								+ ChatColor.DARK_PURPLE
								+ "ESB"
								+ ChatColor.GRAY
								+ "] "
								+ ChatColor.RED
								+ "Explosive Snow Ball has been enabled! Be Careful!");
						return true;
					}
				} else {
					Bukkit.broadcastMessage(ChatColor.GRAY + "["
							+ ChatColor.DARK_PURPLE + "ESB" + ChatColor.GRAY
							+ "] " + ChatColor.DARK_RED
							+ "Sorry, this command can only be used in-game.");
					return true;
				}
			} else if (args.length == 1) {
				
			}
		}

		return false;
	}

}

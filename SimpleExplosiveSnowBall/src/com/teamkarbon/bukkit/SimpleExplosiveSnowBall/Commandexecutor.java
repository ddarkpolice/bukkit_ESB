package com.teamkarbon.bukkit.SimpleExplosiveSnowBall;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandexecutor implements CommandExecutor {

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
					if (player.hasPermission("esb.use") == true) {
						if (plugin.players.contains(player.getName())) {
							plugin.players.remove(player.getName());
							player.sendMessage(ChatColor.GRAY + "["
									+ ChatColor.DARK_PURPLE + "ESB"
									+ ChatColor.GRAY + "] " + ChatColor.GREEN
									+ "Explosive Snow Ball has been disabled!");
							return true;
						} else {
							plugin.players.add(player.getName());
							player.sendMessage(ChatColor.GRAY
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
						player.sendMessage(ChatColor.GRAY + "["
								+ ChatColor.DARK_PURPLE + "ESB"
								+ ChatColor.GRAY + "] " + ChatColor.DARK_RED
								+ "You do not have permission.");
						return true;
					}
				} else {
					player.sendMessage(ChatColor.GRAY + "["
							+ ChatColor.DARK_PURPLE + "ESB" + ChatColor.GRAY
							+ "] " + ChatColor.DARK_RED
							+ "Sorry, this command can only be used in-game.");
					return true;
				}
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("stat")
						|| args[0].equalsIgnoreCase("status")) {
					if (player.hasPermission("ebs.stats") == true) {
						if (plugin.players.contains(player.getName())) {
							player.sendMessage(ChatColor.GRAY + "["
									+ ChatColor.DARK_PURPLE + "ESB"
									+ ChatColor.GRAY + "] " + ChatColor.BLUE
									+ "Explosive Snowball is activiated!");
							return true;
						} else {
							player.sendMessage(ChatColor.GRAY
									+ "["
									+ ChatColor.DARK_PURPLE
									+ "ESB"
									+ ChatColor.GRAY
									+ "] "
									+ ChatColor.BLUE
									+ "Explosive Snowball is not activiated! Type /esb to turn it on.");
							return true;
						}
					} else {
						player.sendMessage(ChatColor.GRAY + "["
								+ ChatColor.DARK_PURPLE + "ESB"
								+ ChatColor.GRAY + "] " + ChatColor.DARK_RED
								+ "You do not have permission.");
						return true;
					}
				} else if (args[0].equalsIgnoreCase("?")
						|| args[0].equalsIgnoreCase("help")) {
					player.sendMessage("" + ChatColor.BLACK
							+ ChatColor.STRIKETHROUGH + "==============="
							+ ChatColor.AQUA + ChatColor.BOLD
							+ " Explosive SnowBall " + ChatColor.BLACK
							+ ChatColor.STRIKETHROUGH + "===============");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Info:");
					player.sendMessage(ChatColor.YELLOW
							+ "SimpleExplosiveSnowBall Plugin (V 1.1.0) is made by ddarkpolice from the Karbon Group.");
					player.sendMessage(ChatColor.YELLOW
							+ "Website: www.teamkarbon.com");
					player.sendMessage(ChatColor.YELLOW
							+ "Bukkit Dev Link: www.dev.bukkit.org/bukkit-plugins/esb/");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "Commands:");
					player.sendMessage(ChatColor.GRAY + "1)" + ChatColor.GREEN
							+ "/esb" + ChatColor.WHITE// FIX
							+ " - Toggle the Explosive Snowball On and Off");
					player.sendMessage(ChatColor.GRAY + "2)" + ChatColor.GREEN
							+ "/esb ? | /esb help" + ChatColor.WHITE
							+ " - This menu would appear");
					player.sendMessage(ChatColor.GRAY
							+ "3)"
							+ ChatColor.GREEN
							+ "/esb stat | /esb status"
							+ ChatColor.WHITE
							+ " - Check if Explosive Snowball is Toggled  On or Off");
					return true;
				} else if (args[0].equalsIgnoreCase("reload")) {
					if (player.hasPermission("ebs.reload") == true) {
						plugin.reloadConfig();
						sender.sendMessage(ChatColor.GRAY + "["
								+ ChatColor.DARK_PURPLE + "ESB"
								+ ChatColor.GRAY + "] " + ChatColor.BLUE + "Configuration has been reloaded!");
						return true;
					} else {
						player.sendMessage(ChatColor.GRAY + "["
								+ ChatColor.DARK_PURPLE + "ESB"
								+ ChatColor.GRAY + "] " + ChatColor.DARK_RED
								+ "You do not have permission.");
						return true;
					}
				}
			}
		}
		return false;
	}
}

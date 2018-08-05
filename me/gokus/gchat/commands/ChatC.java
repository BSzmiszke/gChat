package me.gokus.gchat.commands;

import me.gokus.gchat.GChat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatC implements CommandExecutor {
    GChat plugin = GChat.getPlugin();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("gchat.management")) {
                if (strings.length >= 1) {
                    if (strings[0].equalsIgnoreCase("reload") || strings[0].equalsIgnoreCase("rl")) {
                        plugin.reloadConfig();
                        p.sendMessage(plugin.t(plugin.getConfig().getString("messages.reloaded")));
                    } else if (strings[0].equalsIgnoreCase("on")) {
                        if (plugin.getConfig().getBoolean("chat.status")) {
                            p.sendMessage(plugin.t(plugin.getConfig().getString("messages.enabled")));
                        } else {
                            Bukkit.broadcastMessage(plugin.t(plugin.getConfig().getString("messages.enable").replace("{player}", p.getName())));
                            plugin.reloadConfig();
                            plugin.getConfig().set("chat.status", true);
                            plugin.saveConfig();
                        }
                    } else if (strings[0].equalsIgnoreCase("off")) {
                        if (plugin.getConfig().getBoolean("chat.status")) {
                            if (strings.length > 1) {
                                String r = "";
                                for (int i = 1; i < strings.length; i++) {
                                    if(i + 1 < strings.length) {
                                        String reason = (strings[i] + " ");
                                        r = (r + reason);
                                    } else {
                                        String reason = (strings[i]);
                                        r = (r + reason);
                                    }
                                }
                                Bukkit.broadcastMessage(plugin.t(plugin.getConfig().getString("messages.disable.reason").replace("{player}", p.getName()).replace("{reason}", r)));
                                plugin.reloadConfig();
                                plugin.getConfig().set("chat.status", false);
                                plugin.saveConfig();
                            } else {
                                Bukkit.broadcastMessage(plugin.t(plugin.getConfig().getString("messages.disable.normal").replace("{player}", p.getName())));
                                plugin.reloadConfig();
                                plugin.getConfig().set("chat.status", false);
                                plugin.saveConfig();
                            }
                        } else {
                            p.sendMessage(plugin.t(plugin.getConfig().getString("messages.disabled")));
                        }
                    } else if (strings[0].equalsIgnoreCase("clear") || strings[0].equalsIgnoreCase("cc")) {
                        if (strings.length > 1) {
                            String r = "";
                            for (int i = 1; i < strings.length; i++) {
                                if(i + 1 < strings.length) {
                                    String reason = (strings[i] + " ");
                                    r = (r + reason);
                                } else {
                                    String reason = (strings[i]);
                                    r = (r + reason);
                                }
                            }
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n" + plugin.t(plugin.getConfig().getString("messages.cleared.reason").replace("{player}", p.getName()).replace("{reason}", r)));
                            }
                        } else {
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n" + plugin.t(plugin.getConfig().getString("messages.cleared.normal").replace("{player}", p.getName())));
                            }
                        }
                    } else {
                        p.sendMessage(plugin.t(plugin.getConfig().getString("messages.usage")));
                    }
                } else {
                    p.sendMessage(plugin.t(plugin.getConfig().getString("messages.usage")));
                }
            } else {
                p.sendMessage(plugin.t(plugin.getConfig().getString("messages.perm")));
            }
        } else {
            commandSender.sendMessage(plugin.t(plugin.getConfig().getString("messages.console")));
        }
        return true;
    }
}

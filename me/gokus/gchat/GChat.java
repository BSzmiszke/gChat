package me.gokus.gchat;

import me.gokus.gchat.commands.ChatC;
import me.gokus.gchat.listeners.ChatL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class GChat extends JavaPlugin {
    private static GChat plugin;
    private void loadConfiguration() {
        getConfig().addDefault("chat.status", true);
        getConfig().addDefault("messages.perm", "&cNie masz uprawnien do tej komendy. (&7gchat.management&c)");
        getConfig().addDefault("messages.reloaded", "&aPomyslnie przeladowano plik konfiguracyjny!");
        getConfig().addDefault("messages.usage", "&7Aby poprawnie uzyc komendy wpisz &3/gchat <on/off/clear/reload> [powod]&7!");
        getConfig().addDefault("messages.cleared", "&aCzat zostal wyczyszczony przez &7{player}&a!");
        getConfig().addDefault("messages.enabled", "&cCzat jest juz wlaczony!");
        getConfig().addDefault("messages.disabled", "&cCzat jest juz wylaczony!");
        getConfig().addDefault("messages.disable.normal", "&aCzat zostal wylaczony przez &7{player}&a!");
        getConfig().addDefault("messages.disable.reason", "&aCzat zostal wylaczony przez &7{player}&a, powod &7{reason}&a!");
        getConfig().addDefault("messages.enable", "&aCzat zostal wlaczony przez &7{player}&a!");
        getConfig().addDefault("messages.blocked", "&cNie mozesz pisac na czacie poniewaz jest wylaczony!");
        getConfig().addDefault("messages.console", "Nie mozesz wykonac tej komendy bedac konsola!");
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    @Override
    public void onEnable() {
        plugin = this;
        getCommand("gchat").setExecutor(new ChatC());
        Bukkit.getPluginManager().registerEvents(new ChatL(), this);
        loadConfiguration();
    }
    @Override
    public void onDisable() {
        plugin = null;
    }
    public static String t(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
    public static GChat getPlugin() {
        return plugin;
    }
}

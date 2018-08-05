package me.gokus.gchat.listeners;

import me.gokus.gchat.GChat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatL implements Listener {
    GChat plugin = GChat.getPlugin();
    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        if (!plugin.getConfig().getBoolean("chat.status")) {
            if (!event.getPlayer().hasPermission("gchat.bypass")) {
                event.getPlayer().sendMessage(plugin.t(plugin.getConfig().getString("messages.blocked")));
                event.setCancelled(true);
            }
        }
    }
}

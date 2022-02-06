package de.filios.spigot.plugin.helloworld;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinServerListener implements Listener {

    private JavaPlugin plugin;

    public JoinServerListener(JavaPlugin plugin) {
        plugin.getLogger().info("JoinServerListener registered");
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGH) //An EventHandler annotation
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getLogger().info("JOIN EVENT: " + event.getPlayer().getName());
        event.setJoinMessage(ChatColor.RED + "Turing08080 heisst dich Willkommen, " + ChatColor.BLUE + event.getPlayer().getName() + "!");
    }

    @EventHandler(priority = EventPriority.HIGH) //An EventHandler annotation
    public void onPlayerLogin(PlayerLoginEvent event) {
        String playersName = event.getPlayer().getName();

        plugin.getLogger().info("LOGIN EVENT: " + playersName);
        BanList banList = Bukkit.getBanList(BanList.Type.NAME);
        if (banList.isBanned(playersName)) {
            String grund = banList.getBanEntry(playersName).getReason();
            String von = banList.getBanEntry(playersName).getSource();
            String message = FinalMessageHelper.formatKickMessage("GEBANNT", von, grund);
            event.setKickMessage(message);
        }
    }

    /**
     * A Event with NORMAL (default) priority
     */
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        plugin.getLogger().info("LOGOUT EVENT: " + event.getPlayer().getName());
        Bukkit.broadcastMessage(event.getPlayer().getName() + " left the Server.");
    }
}

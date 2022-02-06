package de.filios.spigot.plugin.helloworld;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class FinalMessageHelper {

    public static String formatKickMessage(String header, String from, String message) {
        return ChatColor.RED + header + "\n"
                + ChatColor.YELLOW + " Von: " + ChatColor.GRAY + from + "\n"
                + ChatColor.YELLOW + " Grund: " + ChatColor.GRAY + message + "\n";
    }

}

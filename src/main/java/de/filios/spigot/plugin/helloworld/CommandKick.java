package de.filios.spigot.plugin.helloworld;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Date;

public class CommandKick implements CommandExecutor {

    private Server server;

    public CommandKick(Server server) {
        super();
        this.server = server;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return false;
        if (args.length == 0) {
            sender.sendMessage(ChatColor.BLUE + " Bitte einen Spieler nennen der Gekicked werden soll");
            return false;
        }
        Player tplayer = server.getPlayer(args[0]);
        if (tplayer != null) {
            String message = FinalMessageHelper.formatKickMessage("Gekickt", ((Player) sender).getDisplayName(), constructMessage(args));
            tplayer.kickPlayer(message);
        } else {
            sender.sendMessage("Der Spieler den du kicken möchtest ist offline!");
        }
        return true;
    }


    private String constructMessage(String[] args) {
        if (args.length < 2) return "";

        StringBuilder message = new StringBuilder();

        for (int i = 1; i < args.length; i++) {
            message.append(args[i]);
            message.append(" ");
        }
        return message.toString();
    }
}

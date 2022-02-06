package de.filios.spigot.plugin.helloworld;

import org.bukkit.plugin.java.JavaPlugin;

public class TuringPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("ENABLED: Turing-Plugin");
        this.getCommand("elias").setExecutor(new CommandKit());
        this.getCommand("pban").setExecutor(new CommandPBan(getServer()));
        this.getCommand("kick").setExecutor(new CommandKick(getServer()));
        new JoinServerListener(this);
    }
    @Override
    public void onDisable() {
        getLogger().info("DISABLED: Turing-Plugin");
    }
}

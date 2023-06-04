package me.lava.noitemdrop;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class RejectCore extends JavaPlugin {
    public static RejectCore instance;
    public boolean denyBreak;
    public boolean denyDrop;
    public boolean denyBuild;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        FileConfiguration config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
        denyDrop = config.getBoolean("denyItemDropping");
        denyBreak = config.getBoolean("denyBlockBreaking");
        denyBuild = config.getBoolean("denyBuilding");
        getServer().getPluginManager().registerEvents(new BlockItemDrop(), this);
        getServer().getPluginManager().registerEvents(new DenyBlockBreak(), this);
        getServer().getPluginManager().registerEvents(new BlockBuilding(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

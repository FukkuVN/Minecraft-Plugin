package com.fukkuplugin.pvparenaplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class PvPArenaPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("PvPArenaPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("PvPArenaPlugin has been disabled.");
    }
}

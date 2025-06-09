package com.fukkuplugin.bedwarsplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class BedwarsPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("BedwarsPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("BedwarsPlugin has been disabled.");
    }
}

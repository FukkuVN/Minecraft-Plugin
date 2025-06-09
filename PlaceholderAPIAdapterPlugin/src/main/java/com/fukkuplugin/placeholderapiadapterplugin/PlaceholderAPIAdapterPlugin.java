package com.fukkuplugin.placeholderapiadapterplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class PlaceholderAPIAdapterPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("PlaceholderAPIAdapterPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("PlaceholderAPIAdapterPlugin has been disabled.");
    }
}

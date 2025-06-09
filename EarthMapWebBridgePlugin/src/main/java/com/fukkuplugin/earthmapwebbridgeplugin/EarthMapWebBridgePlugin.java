package com.fukkuplugin.earthmapwebbridgeplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class EarthMapWebBridgePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("EarthMapWebBridgePlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("EarthMapWebBridgePlugin has been disabled.");
    }
}

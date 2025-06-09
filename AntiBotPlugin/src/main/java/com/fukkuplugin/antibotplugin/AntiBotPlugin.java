package com.fukkuplugin.antibotplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class AntiBotPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("AntiBotPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("AntiBotPlugin has been disabled.");
    }
}

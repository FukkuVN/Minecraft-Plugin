package com.fukkuplugin.automessageplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class AutoMessagePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("AutoMessagePlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("AutoMessagePlugin has been disabled.");
    }
}

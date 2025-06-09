package com.fukkuplugin.economyplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class EconomyPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("EconomyPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("EconomyPlugin has been disabled.");
    }
}

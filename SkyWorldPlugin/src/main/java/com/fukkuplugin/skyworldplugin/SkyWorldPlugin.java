package com.fukkuplugin.skyworldplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class SkyWorldPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("SkyWorldPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("SkyWorldPlugin has been disabled.");
    }
}

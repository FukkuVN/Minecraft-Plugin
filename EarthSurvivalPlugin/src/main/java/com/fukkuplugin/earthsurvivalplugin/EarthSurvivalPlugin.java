package com.fukkuplugin.earthsurvivalplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class EarthSurvivalPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("EarthSurvivalPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("EarthSurvivalPlugin has been disabled.");
    }
}

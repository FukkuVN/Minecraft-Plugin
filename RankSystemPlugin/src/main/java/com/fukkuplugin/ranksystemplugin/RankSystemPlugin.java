package com.fukkuplugin.ranksystemplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class RankSystemPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("RankSystemPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("RankSystemPlugin has been disabled.");
    }
}

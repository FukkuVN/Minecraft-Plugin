package com.fukkuplugin.spawnprotectionplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class SpawnProtectionPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("SpawnProtectionPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("SpawnProtectionPlugin has been disabled.");
    }
}

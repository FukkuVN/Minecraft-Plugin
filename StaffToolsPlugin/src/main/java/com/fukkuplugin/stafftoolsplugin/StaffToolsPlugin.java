package com.fukkuplugin.stafftoolsplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class StaffToolsPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("StaffToolsPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("StaffToolsPlugin has been disabled.");
    }
}

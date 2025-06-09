package com.fukkuplugin.lobbyhubplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class LobbyHubPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("LobbyHubPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("LobbyHubPlugin has been disabled.");
    }
}

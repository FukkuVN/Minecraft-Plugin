package com.fukkuplugin.chatfilterplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class ChatFilterPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("ChatFilterPlugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("ChatFilterPlugin has been disabled.");
    }
}

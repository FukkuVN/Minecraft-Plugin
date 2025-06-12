package com.fukkuplugin.lobbyprotect;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyProtect extends JavaPlugin {

    private static LobbyProtect instance;
    private DataManager dataManager;
    private CommandHandler commandHandler;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        dataManager = new DataManager(this);
        commandHandler = new CommandHandler(this);

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);

        getCommand("login").setExecutor(new LoginCommand(this));
        getCommand("register").setExecutor(new RegisterCommand(this));
        getCommand("tpopen").setExecutor(commandHandler);
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));

        getLogger().info("LobbyProtect plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("LobbyProtect plugin disabled!");
    }

    public static LobbyProtect getInstance() {
        return instance;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public CommandHandler getCommandHandler() {
        return commandHandler;
    }
}

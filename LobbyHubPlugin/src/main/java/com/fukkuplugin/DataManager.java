package com.fukkuplugin.lobbyprotect;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class DataManager {

    private LobbyProtect plugin;
    private File playerDataFile;
    private FileConfiguration playerDataConfig;
    private HashMap<UUID, String> passwords = new HashMap<>();
    private HashMap<UUID, Boolean> loggedIn = new HashMap<>();

    public DataManager(LobbyProtect plugin) {
        this.plugin = plugin;
        playerDataFile = new File(plugin.getDataFolder(), "players.yml");
        if (!playerDataFile.exists()) {
            plugin.saveResource("players.yml", false);
        }
        playerDataConfig = YamlConfiguration.loadConfiguration(playerDataFile);
        loadPasswords();
    }

    private void loadPasswords() {
        for (String key : playerDataConfig.getKeys(false)) {
            passwords.put(UUID.fromString(key), playerDataConfig.getString(key + ".password"));
            loggedIn.put(UUID.fromString(key), false);
        }
    }

    public boolean isRegistered(Player player) {
        return passwords.containsKey(player.getUniqueId());
    }

    public boolean checkPassword(Player player, String password) {
        String pass = passwords.get(player.getUniqueId());
        return pass != null && pass.equals(password);
    }

    public void register(Player player, String password) {
        passwords.put(player.getUniqueId(), password);
        loggedIn.put(player.getUniqueId(), true);
        playerDataConfig.set(player.getUniqueId().toString() + ".password", password);
        saveData();
    }

    public boolean isLoggedIn(Player player) {
        return loggedIn.getOrDefault(player.getUniqueId(), false);
    }

    public void setLoggedIn(Player player, boolean status) {
        loggedIn.put(player.getUniqueId(), status);
    }

    public void saveData() {
        try {
            playerDataConfig.save(playerDataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

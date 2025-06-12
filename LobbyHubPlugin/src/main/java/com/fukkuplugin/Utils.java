package com.fukkuplugin.lobbyprotect;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

public class Utils {

    public static Location getLocationFromConfig(ConfigurationSection section) {
        String world = section.getString("world");
        double x = section.getDouble("x");
        double y = section.getDouble("y");
        double z = section.getDouble("z");
        float yaw = (float) section.getDouble("yaw");
        float pitch = (float) section.getDouble("pitch");

        return new Location(org.bukkit.Bukkit.getWorld(world), x, y, z, yaw, pitch);
    }

    public static List<String> colorList(List<String> list) {
        List<String> colored = new ArrayList<>();
        for (String s : list) {
            colored.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        return colored;
    }
}

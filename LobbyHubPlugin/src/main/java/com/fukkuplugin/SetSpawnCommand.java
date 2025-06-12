package com.fukkuplugin.lobbyprotect;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private LobbyProtect plugin;

    public SetSpawnCommand(LobbyProtect plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Chỉ người chơi mới có thể sử dụng lệnh này.");
            return true;
        }
        if (!player.hasPermission("op")) {
            player.sendMessage(ChatColor.RED + plugin.getConfig().getString("messages.no_permission"));
            return true;
        }
        plugin.getConfig().set("spawn-location.world", player.getWorld().getName());
        plugin.getConfig().set("spawn-location.x", player.getLocation().getX());
        plugin.getConfig().set("spawn-location.y", player.getLocation().getY());
        plugin.getConfig().set("spawn-location.z", player.getLocation().getZ());
        plugin.getConfig().set("spawn-location.yaw", player.getLocation().getYaw());
        plugin.getConfig().set("spawn-location.pitch", player.getLocation().getPitch());
        plugin.saveConfig();
        player.sendMessage(ChatColor.GREEN + "Spawn lobby đã được cập nhật!");
        return true;
    }
}

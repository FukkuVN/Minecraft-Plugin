package com.fukkuplugin.lobbyprotect;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {

    private LobbyProtect plugin;

    public CommandHandler(LobbyProtect plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("tpopen")) {
            if (!(sender instanceof org.bukkit.entity.Player player)) {
                sender.sendMessage("Chỉ người chơi mới có thể sử dụng lệnh này.");
                return true;
            }
            if (!plugin.getDataManager().isLoggedIn(player)) {
                player.sendMessage(plugin.getConfig().getString("messages.not_logged_in"));
                return true;
            }
            new TeleportGUI(plugin).open(player);
            return true;
        }
        return false;
    }
}

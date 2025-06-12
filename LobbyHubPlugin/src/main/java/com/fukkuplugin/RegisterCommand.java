package com.fukkuplugin.lobbyprotect;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegisterCommand implements CommandExecutor {

    private LobbyProtect plugin;

    public RegisterCommand(LobbyProtect plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Chỉ người chơi mới có thể sử dụng lệnh này.");
            return true;
        }
        if (plugin.getDataManager().isRegistered(player)) {
            player.sendMessage(ChatColor.RED + "Bạn đã đăng ký rồi, vui lòng đăng nhập.");
            return true;
        }
        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Sử dụng: /register <mật khẩu>");
            return true;
        }
        String password = args[0];
        plugin.getDataManager().register(player, password);
        player.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("messages.register_success"));
        return true;
    }
}

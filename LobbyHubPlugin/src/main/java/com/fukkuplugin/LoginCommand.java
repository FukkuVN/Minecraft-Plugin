package com.fukkuplugin.lobbyprotect;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LoginCommand implements CommandExecutor {

    private LobbyProtect plugin;

    public LoginCommand(LobbyProtect plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Chỉ người chơi mới có thể sử dụng lệnh này.");
            return true;
        }
        if (plugin.getDataManager().isLoggedIn(player)) {
            player.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("messages.already_logged_in"));
            return true;
        }
        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Sử dụng: /login <mật khẩu>");
            return true;
        }
        if (!plugin.getDataManager().isRegistered(player)) {
            player.sendMessage(ChatColor.RED + "Bạn chưa đăng ký. Vui lòng dùng /register <mật khẩu>");
            return true;
        }
        if (plugin.getDataManager().checkPassword(player, args[0])) {
            plugin.getDataManager().setLoggedIn(player, true);
            player.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("messages.login_success"));
        } else {
            player.sendMessage(ChatColor.RED + plugin.getConfig().getString("messages.invalid_password"));
        }
        return true;
    }
}

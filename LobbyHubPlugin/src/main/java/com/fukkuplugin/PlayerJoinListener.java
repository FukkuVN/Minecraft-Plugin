package com.fukkuplugin.lobbyprotect;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerJoinListener implements Listener {

    private LobbyProtect plugin;

    public PlayerJoinListener(LobbyProtect plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // Gửi thông báo chào mừng
        plugin.getConfig().getStringList("messages.welcome").forEach(line -> {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
        });

        if (!plugin.getDataManager().isLoggedIn(player)) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("messages.login_hint")));
        }

        // Đặt vị trí spawn
        Location spawn = Utils.getLocationFromConfig(plugin.getConfig().getConfigurationSection("spawn-location"));
        player.teleport(spawn);

        // Cấp sách luật và la bàn
        ItemStack ruleBook = new ItemStack(Material.WRITTEN_BOOK);
        ItemMeta ruleMeta = ruleBook.getItemMeta();
        ruleMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("items.rule_book.name")));
        ruleMeta.setLore(Utils.colorList(plugin.getConfig().getStringList("items.rule_book.lore")));
        ruleBook.setItemMeta(ruleMeta);

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("items.compass.name")));
        compassMeta.setLore(Utils.colorList(plugin.getConfig().getStringList("items.compass.lore")));
        compass.setItemMeta(compassMeta);

        player.getInventory().clear();
        player.getInventory().addItem(ruleBook, compass);
    }
}

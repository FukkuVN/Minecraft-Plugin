package com.fukkuplugin.lobbyprotect;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class JoinListener implements Listener {

    private LobbyProtect plugin;

    public JoinListener(LobbyProtect plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (!plugin.getDataManager().isLoggedIn(player)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (!plugin.getDataManager().isLoggedIn(player)) {
            e.setCancelled(true);
            player.sendMessage(plugin.getConfig().getString("messages.must_login"));
            return;
        }
        if (player.getWorld().getName().equalsIgnoreCase("lobby")) {
            if (!isAllowedItem(player)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        if (!plugin.getDataManager().isLoggedIn(player)) {
            e.setCancelled(true);
        } else if (player.getWorld().getName().equalsIgnoreCase("lobby") && !isAllowedItem(player)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (!plugin.getDataManager().isLoggedIn(player)) {
            e.setCancelled(true);
        } else if (player.getWorld().getName().equalsIgnoreCase("lobby") && !isAllowedItem(player)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onSwapHand(PlayerSwapHandItemsEvent e) {
        Player player = e.getPlayer();
        if (!plugin.getDataManager().isLoggedIn(player)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickupItem(PlayerPickupItemEvent e) {
        Player player = e.getPlayer();
        if (!plugin.getDataManager().isLoggedIn(player)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        plugin.getDataManager().setLoggedIn(player, false);
    }

    private boolean isAllowedItem(Player player) {
        if (player.getInventory().getItemInMainHand() != null) {
            Material mat = player.getInventory().getItemInMainHand().getType();
            return mat == Material.WRITTEN_BOOK || mat == Material.COMPASS;
        }
        return false;
    }
}

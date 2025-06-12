package com.fukkuplugin.lobbyprotect;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeleportGUI implements Listener {

    private LobbyProtect plugin;
    private Inventory inv;

    public TeleportGUI(LobbyProtect plugin) {
        this.plugin = plugin;
        inv = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.BLUE + "Teleport Menu");
        initializeItems();
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private void initializeItems() {
        inv.clear();

        inv.setItem(0, createItem(Material.GRASS_BLOCK, ChatColor.GREEN + "Skyblock"));
        inv.setItem(1, createItem(Material.DIAMOND_SWORD, ChatColor.RED + "PvP"));
        inv.setItem(2, createItem(Material.BEDROCK, ChatColor.DARK_GRAY + "Survival"));
        inv.setItem(3, createItem(Material.NETHER_STAR, ChatColor.GOLD + "Lobby"));
    }

    private ItemStack createItem(Material mat, String name) {
        ItemStack item = new ItemStack(mat);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    public void open(Player player) {
        player.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Teleport Menu")) return;

        event.setCancelled(true);

        if (event.getCurrentItem() == null) return;
        Player player = (Player) event.getWhoClicked();

        switch (event.getCurrentItem().getType()) {
            case GRASS_BLOCK -> player.teleport(Bukkit.getWorld("skyblock").getSpawnLocation());
            case DIAMOND_SWORD -> player.teleport(Bukkit.getWorld("pvp").getSpawnLocation());
            case BEDROCK -> player.teleport(Bukkit.getWorld("survival").getSpawnLocation());
            case NETHER_STAR -> player.teleport(Bukkit.getWorld("lobby").getSpawnLocation());
            default -> player.sendMessage(ChatColor.RED + "Chức năng chưa hoàn thiện.");
        }
        player.closeInventory();
    }
}

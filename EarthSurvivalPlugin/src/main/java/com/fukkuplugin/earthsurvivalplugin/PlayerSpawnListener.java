package fukkuplugin;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.persistence.PersistentDataType;

public class PlayerSpawnListener implements Listener {

    private final FukkuPlugin plugin;
    private final RegionManager regionManager;
    private final Random random = new Random();

    private final NamespacedKey SPAWN_KEY;

    public PlayerSpawnListener(FukkuPlugin plugin, RegionManager regionManager) {
        this.plugin = plugin;
        this.regionManager = regionManager;
        this.SPAWN_KEY = new NamespacedKey(plugin, "spawnpoint");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        World world = Bukkit.getWorld(plugin.getConfig().getString("map.world"));
        if (world == null) {
            plugin.getLogger().warning("Không tìm thấy world trong config.yml");
            return;
        }

        if (!player.getPersistentDataContainer().has(SPAWN_KEY, PersistentDataType.STRING)) {
            setRandomSpawn(player, world);
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        World world = Bukkit.getWorld(plugin.getConfig().getString("map.world"));
        if (world == null) {
            plugin.getLogger().warning("Không tìm thấy world trong config.yml");
            return;
        }

        if (player.getPersistentDataContainer().has(SPAWN_KEY, PersistentDataType.STRING)) {
            String locStr = player.getPersistentDataContainer().get(SPAWN_KEY, PersistentDataType.STRING);
            String[] parts = locStr.split(",");
            if (parts.length == 3) {
                try {
                    double x = Double.parseDouble(parts[0]);
                    double y = Double.parseDouble(parts[1]);
                    double z = Double.parseDouble(parts[2]);
                    Location loc = new Location(world, x, y, z);
                    event.setRespawnLocation(loc);
                    sendTitle(player, loc);
                    return;
                } catch (NumberFormatException ignored) {}
            }
        }
        setRandomSpawn(player, world);
    }

    private void setRandomSpawn(Player player, World world) {
        RegionManager.Region region = regionManager.getRandomRegion();
        if (region == null) {
            plugin.getLogger().warning("Không có region để spawn!");
            return;
        }
        int x = region.getRandomX(random);
        int z = region.getRandomZ(random);
        int y = world.getHighestBlockYAt(x, z);
        Location loc = new Location(world, x + 0.5, y + 1, z + 0.5);
        player.teleport(loc);

        String locStr = loc.getX() + "," + loc.getY() + "," + loc.getZ();
        player.getPersistentDataContainer().set(SPAWN_KEY, PersistentDataType.STRING, locStr);

        sendTitle(player, loc);
    }

    private void sendTitle(Player player, Location loc) {
        RegionManager.Region region = regionManager.getRegionByCoords(loc.getBlockX(), loc.getBlockZ());
        if (region != null) {
            player.sendTitle(region.getTitle(), region.getSubtitle(), 10, 70, 20);
        } else {
            player.sendTitle("Trái Đất", "Bạn đã đến thế giới", 10, 70, 20);
        }
    }
}

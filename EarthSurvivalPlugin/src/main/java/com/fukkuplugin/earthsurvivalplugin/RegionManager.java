package fukkuplugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class RegionManager {

    private final JavaPlugin plugin;
    private final Map<String, Region> regions = new HashMap<>();
    private final Random random = new Random();

    public RegionManager(JavaPlugin plugin) {
        this.plugin = plugin;
        loadRegions();
    }

    private void loadRegions() {
        File regionsFile = new File(plugin.getDataFolder(), "regions.yml");
        if (!regionsFile.exists()) {
            plugin.saveResource("regions.yml", false);
        }

        FileConfiguration config = YamlConfiguration.loadConfiguration(regionsFile);
        for (String key : config.getConfigurationSection("regions").getKeys(false)) {
            int minX = config.getInt("regions." + key + ".minX");
            int maxX = config.getInt("regions." + key + ".maxX");
            int minZ = config.getInt("regions." + key + ".minZ");
            int maxZ = config.getInt("regions." + key + ".maxZ");
            String title = config.getString("regions." + key + ".title");
            String subtitle = config.getString("regions." + key + ".subtitle");

            regions.put(key, new Region(minX, maxX, minZ, maxZ, title, subtitle));
        }
        plugin.getLogger().info("Đã load " + regions.size() + " vùng spawn.");
    }

    public Region getRandomRegion() {
        if (regions.isEmpty()) return null;
        Object[] keys = regions.keySet().toArray();
        return regions.get(keys[random.nextInt(keys.length)]);
    }

    public Region getRegionByCoords(int x, int z) {
        for (Region region : regions.values()) {
            if (region.isInside(x, z)) return region;
        }
        return null;
    }

    public static class Region {
        private final int minX, maxX, minZ, maxZ;
        private final String title, subtitle;

        public Region(int minX, int maxX, int minZ, int maxZ, String title, String subtitle) {
            this.minX = minX;
            this.maxX = maxX;
            this.minZ = minZ;
            this.maxZ = maxZ;
            this.title = title;
            this.subtitle = subtitle;
        }

        public boolean isInside(int x, int z) {
            return x >= minX && x <= maxX && z >= minZ && z <= maxZ;
        }

        public int getRandomX(Random random) {
            return random.nextInt(maxX - minX + 1) + minX;
        }

        public int getRandomZ(Random random) {
            return random.nextInt(maxZ - minZ + 1) + minZ;
        }

        public String getTitle() {
            return title;
        }

        public String getSubtitle() {
            return subtitle;
        }
    }
}

package fukkuplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class FukkuPlugin extends JavaPlugin {

    private RegionManager regionManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        saveResource("regions.yml", false);
        regionManager = new RegionManager(this);

        getServer().getPluginManager().registerEvents(new PlayerSpawnListener(this, regionManager), this);
        getLogger().info("FukkuPlugin đã được kích hoạt!");
    }

    @Override
    public void onDisable() {
        getLogger().info("FukkuPlugin đã được tắt!");
    }
}

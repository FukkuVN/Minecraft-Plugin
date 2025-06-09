# FukkuPlugin

This project contains multiple Minecraft server plugins developed under the FukkuPlugin umbrella. Each plugin provides specific features to enhance gameplay and server management.

## Plugins Overview

### 1. EarthSurvivalPlugin
- **Main Function:** Provides Earth Map to players on first join, random teleportation within Earth world, and retains the map on death.
- **Purpose:** Create a survival and exploration experience in a large Minecraft world.

### 2. EarthMapWebBridgePlugin
- **Main Function:** Offers an online web map and API for player location and status.
- **Purpose:** Enable remote player tracking and web-based map viewing.

### 3. RankSystemPlugin
- **Main Function:** Manages and displays player ranks, integrates with permission plugins.
- **Purpose:** Display player ranks and manage permissions.

### 4. LobbyHubPlugin
- **Main Function:** Provides a rules book and teleport menu for players in the lobby.
- **Purpose:** Facilitate easy navigation and inform players of server rules.

### 5. EconomyPlugin
- **Main Function:** Implements virtual currency (FCoin), balance checking, and payments.
- **Purpose:** Create an in-game economy system.

### 6. PvPArenaPlugin
- **Main Function:** Creates PvP arenas with kits and kill/death tracking.
- **Purpose:** Provide competitive PvP gameplay.

### 7. SkyWorldPlugin
- **Main Function:** Implements Skyblock islands with protection and team systems.
- **Purpose:** Offer Skyblock gameplay mode.

### 8. BedwarsPlugin
- **Main Function:** Implements Bedwars game mode with teams and shops.
- **Purpose:** Provide team-based Bedwars gameplay.

### 9. ChatFilterPlugin
- **Main Function:** Filters inappropriate chat messages based on configurable banned words.
- **Purpose:** Maintain clean chat environment.

### 10. AutoMessagePlugin
- **Main Function:** Sends periodic automated messages to players.
- **Purpose:** Keep players informed with regular announcements.

### 11. SpawnProtectionPlugin
- **Main Function:** Protects spawn area from player modifications.
- **Purpose:** Prevent griefing in spawn area.

### 12. AntiBotPlugin
- **Main Function:** Detects and blocks bot connections.
- **Purpose:** Protect server from bot attacks.

### 13. StaffToolsPlugin
- **Main Function:** Provides staff with teleport, freeze, and vanish tools.
- **Purpose:** Assist staff in server moderation.

### 14. PlaceholderAPIAdapterPlugin
- **Main Function:** Integrates PlaceholderAPI for dynamic information display.
- **Purpose:** Enable dynamic placeholders in chat and scoreboard.

## Usage

Each plugin can be configured via its respective `config.yml` or `rules.yml` file located in the `src/main/resources` directory.

## Build

This is a multi-module Maven project. Use the root `pom.xml` to build all plugins:

```bash
mvn clean install
```

## License

[Specify your license here]

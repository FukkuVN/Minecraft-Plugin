package com.fukkuplugin.lobbyprotect;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class BungeeMessageListener implements PluginMessageListener {

    private LobbyProtect plugin;

    public BungeeMessageListener(LobbyProtect plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equalsIgnoreCase("BungeeCord")) return;

        try (DataInputStream in = new DataInputStream(new ByteArrayInputStream(message))) {
            String subchannel = in.readUTF();

            if (subchannel.equals("SomeSubchannel")) {
                // Xử lý dữ liệu từ subchannel cụ thể
                String data = in.readUTF();
                // Ví dụ: Log dữ liệu nhận được
                plugin.getLogger().info("Received data from BungeeCord: " + data);

                // Thực hiện logic tùy theo dữ liệu nhận được
            }
            // Bạn có thể thêm các subchannel khác xử lý ở đây
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

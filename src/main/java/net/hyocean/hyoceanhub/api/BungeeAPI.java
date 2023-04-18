package net.hyocean.hyoceanhub.api;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.hyocean.hyoceanhub.Main;
import org.bukkit.entity.Player;

@SuppressWarnings("ALL")
public class BungeeAPI {

    public void sendPlayerToServer(Player p, String server) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
            p.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package io._7Gv.antimateriaclient.message;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import io._7Gv.antimateriaclient.AntimateriaClient;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class AntimateriaMessenger implements PluginMessageListener {

    private Plugin plugin;
    private AntimateriaClient instance;

    public AntimateriaMessenger(Plugin plugin) {
        this.plugin = plugin;
        this.instance = (AntimateriaClient) plugin;
    }

    /**
     * A method that will be thrown when a PluginMessageSource sends a plugin
     * message on a registered channel.
     *
     * @param channel Channel that the message was sent through.
     * @param player  Source of the message.
     * @param message The raw message that was sent.
     */
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("#antimateria")) {
            return;
        }


        ByteArrayDataInput in = ByteStreams.newDataInput(message);

        String subchannel = in.readUTF();
        if (subchannel.equals(".vanish")) {
            // TODO: doing the magic...
        }
    }

    /**
     * Vanish an online Player
     * @param player Player to vanish
     * @param server Server on which to be performed
     */
    public void vanishPlayer(Player player, String server) {
        ByteArrayDataOutput output = ByteStreams.newDataOutput();

        output.writeUTF(player.getUniqueId().toString());
        output.writeUTF(server);

        player.sendPluginMessage(plugin, "#antimateria", output.toByteArray());
    }


}

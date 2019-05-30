package io._7Gv.antimateriaclient.command;

import io._7Gv.antimateriaclient.AntimateriaClient;
import io._7Gv.antimateriaclient.util.Lang;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class VanishCommand extends Subcommand {

    public VanishCommand(AntimateriaClient instance) {
        super("vanish", instance, "antimateria.mod.vanish");
    }

    private final HashMap<Lang, String> LM = instance.langMap;
    private final String PREFIX = LM.get(Lang.PREFIX);

    @Override
    public boolean onCommand(CommandSender commandSender, String[] args) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(PREFIX + "§7- §c[!] Executor not player.");
            return true;
        }

        if (args.length == 0) {
            commandSender.sendMessage(PREFIX + "§7- §fusage: /vanish <player>");
        }

        return false;
    }
}

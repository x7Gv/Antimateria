package io._7Gv.antimateriaclient.command;

import io._7Gv.antimateriaclient.AntimateriaClient;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashSet;
import java.util.Set;

public class AntimateriaCommand implements CommandExecutor {

    private AntimateriaClient instance;
    private Set<Subcommand> subcommands = new HashSet<>();

    public AntimateriaCommand(AntimateriaClient instance) {
        this.instance = instance;
        subcommands.add(new VanishCommand(instance));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        for (Subcommand sub : subcommands) {
            if (args[0].equalsIgnoreCase(sub.getLabel())) {
                sub.onCommand(sender, args);
            }
        }

        return false;
    }
}

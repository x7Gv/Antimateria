package io._7Gv.antimateriaclient.command;

import io._7Gv.antimateriaclient.AntimateriaClient;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class Subcommand {

    protected final AntimateriaClient instance;

    private final String label;
    private final String permission;

    /**
     * Called by subclass with the appropriate label.
     * @param label Label of the subcommand.
     */
    public Subcommand(String label, AntimateriaClient instance, String permission) {
        this.instance = instance;
        this.label = label;
        this.permission = permission;
    }

    /**
     * Getter for the label of the subcommand.
     * @return The label of the subcommand.
     */
    public final String getLabel() {
        return this.label;
    }

    /**
     * Getter for the permission node of the subcommand.
     * @return The permission node of the subcommand.
     */
    public final String getPermission() {
        return this.permission;
    }

    /**
     * Exucute the subcommand if the name matches the first argument of the main command.
     * @param commandSender Sender instance of the command.
     * @param args Arguments
     * @return true if the command was processed successfully.
     */
    public abstract boolean onCommand(CommandSender commandSender, String[] args);

}

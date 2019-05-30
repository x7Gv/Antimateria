package io._7Gv.antimateriaclient.io;

import io._7Gv.antimateriaclient.AntimateriaClient;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

public class ConfigManager {

    private AntimateriaClient plugin;

    private FileConfiguration config;
    private File configFile;

    private File dataFolder;

    public ConfigManager(AntimateriaClient instance) {
        this.plugin = instance;
        this.dataFolder = plugin.getDataFolder();
    }

    /**
     * Reload the config
     */
    public void reloadConfig() {

        // Check validity of the file
        if (configFile == null)
            configFile = new File(dataFolder, "config.yml");

        config = YamlConfiguration.loadConfiguration(configFile);

        // Look for defaults in the jar.
        Reader defConfigStream = new InputStreamReader(plugin.getResource("config.yml"), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        config.setDefaults(defConfig);
    }

    /**
     * Get the config
     * @return FileConfiguration
     */
    public FileConfiguration getConfig() {
        if (configFile == null)
            reloadConfig();

        return config;
    }

    /**
     * Save the config
     */
    public void saveConfig() {
        if (config == null || configFile == null)
            return;

        try {
            getConfig().save(configFile);
        } catch (IOException ex) {
            plugin.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, ex);
        }
    }


    /**
     * Save default config
     */
    public void saveDefaultConfig() {
        if (configFile == null)
            configFile = new File(dataFolder, "config.yml");

        if (!configFile.exists()) {
            plugin.saveResource("config.yml", false);
        }
    }


}

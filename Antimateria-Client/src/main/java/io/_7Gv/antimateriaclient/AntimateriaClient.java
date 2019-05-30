package io._7Gv.antimateriaclient;

import io._7Gv.antimateriaclient.io.ConfigManager;
import io._7Gv.antimateriaclient.util.Lang;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class AntimateriaClient extends JavaPlugin {

    public FileConfiguration config;
    public HashMap<Lang, String> langMap;

    private ConfigManager cfgm;

    @Override
    public void onEnable() {
        setupConfig();
    }

    /**
     * Setup config manager and config for use
     */
    private void setupConfig() {
        this.cfgm = new ConfigManager(this);
        this.config = cfgm.getConfig();
        cfgm.saveDefaultConfig();
    }

    private void setupLang() {
        this.langMap = new HashMap<>();

        langMap.put(Lang.PREFIX, "§8[§7antimateria§8]");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}

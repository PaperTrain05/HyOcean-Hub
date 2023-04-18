package net.hyocean.hyoceanhub.manager;

import net.hyocean.hyoceanhub.Main;

public class PluginManager {

    private final Main plugin;

    public PluginManager(Main plugin){
        this.plugin = plugin;
    }

    public Main getPlugin(){
        return plugin;
    }

}

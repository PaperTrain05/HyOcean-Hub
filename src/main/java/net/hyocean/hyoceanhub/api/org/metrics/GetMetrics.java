package net.hyocean.hyoceanhub.api.org.metrics;

import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class GetMetrics {


    public Metrics registerMetrics(JavaPlugin plugin, Integer pluginID){
        return new Metrics(plugin, pluginID);
    }

}

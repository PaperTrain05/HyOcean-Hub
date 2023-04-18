package net.hyocean.hyoceanhub.api;

import net.hyocean.hyoceanhub.Main;
import org.bukkit.configuration.file.FileConfiguration;

@SuppressWarnings("all")
public class GetConfigRAW {

    public FileConfiguration main(){
        return Main.getInstance().getConfig();
    }

}
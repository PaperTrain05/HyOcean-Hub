package net.hyocean.hyoceanhub.api.messages;

import net.hyocean.hyoceanhub.Main;
import net.hyocean.hyoceanhub.api.Format;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

@SuppressWarnings("unused")
public class Messages {
    public static File lang_it = new File(Main.getInstance().getDataFolder() + "/lang/it_IT.yml");
    public static File lang_en = new File(Main.getInstance().getDataFolder() + "/lang/en_US.yml");
    public static FileConfiguration lang_it_config;
    public static FileConfiguration lang_en_config;
    public static String lang;
    Format format = new Format();


    public String lang(){
        return Main.getInstance().getConfig().getString("Lang");
    }
    public String CommandBlockedInConsoleIT(){
        return lang.equals("IT") ? format.color(lang_it_config.getString("Messages.CommandBlockedInConsole")) : "";
    }

    public String PrefixIT(){
        return lang.equals("IT") ? format.color(lang_it_config.getString("Messages.Prefix")) : "";
    }

    public String AlreadyInThisGameModeIT(){
        return lang.equals("IT") ? format.color(lang_it_config.getString("Messages.AlreadyInThisGameMode")) : "";
    }

    public String GameModeSetToCreativeIT(){
        return lang.equals("IT") ? format.color(lang_it_config.getString("Messages.GameModeSetToCreative")) : "";
    }

    public String GameModeSetToSurvivalIT(){
        return lang.equals("IT") ? format.color(lang_it_config.getString("Messages.GameModeSetToSurvival")) : "";
    }

    public String GameModeSetToAdventureIT(){
        return lang.equals("IT") ? format.color(lang_it_config.getString("Messages.GameModeSetToAdventure")) : "";
    }

    public String GameModeSetToSpectatorIT(){
        return lang.equals("IT") ? format.color(lang_it_config.getString("Messages.GameModeSetToSpectator")) : "";
    }

    public String GameModeSetToStrangeIT(){
        return lang.equals("IT") ? format.color(lang_it_config.getString("Messages.GameModeSetToStrange")) : "";
    }

    public String CommandBlockedInConsoleEN(){
        return lang.equals("EN") ? format.color(lang_en_config.getString("Messages.CommandBlockedInConsole")) : "";
    }

    public String PrefixEN(){
        return lang.equals("EN") ? format.color(lang_en_config.getString("Messages.Prefix")) : "";
    }

    public String AlreadyInThisGameModeEN(){
        return lang.equals("EN") ? format.color(lang_en_config.getString("Messages.AlreadyInThisGameMode")) : "";
    }

    public String GameModeSetToCreativeEN(){
        return lang.equals("EN") ? format.color(lang_en_config.getString("Messages.GameModeSetToCreative")) : "";
    }

    public String GameModeSetToSurvivalEN(){
        return lang.equals("EN") ? format.color(lang_en_config.getString("Messages.GameModeSetToSurvival")) : "";
    }

    public String GameModeSetToAdventureEN(){
        return lang.equals("EN") ? format.color(lang_en_config.getString("Messages.GameModeSetToAdventure")) : "";
    }

    public String GameModeSetToSpectatorEN(){
        return lang.equals("EN") ? format.color(lang_en_config.getString("Messages.GameModeSetToSpectator")) : "";
    }

    public String GameModeSetToStrangeEN(){
        return lang.equals("EN") ? format.color(lang_en_config.getString("Messages.GameModeSetToStrange")) : "";
    }

    static {
        lang_it_config = YamlConfiguration.loadConfiguration(lang_it);
        lang_en_config = YamlConfiguration.loadConfiguration(lang_en);
        lang = Main.getInstance().getConfig().getString("Lang");
    }
}


package net.hyocean.hyoceanhub;

import net.hyocean.hyoceanhub.commands.general.GameMode;
import net.hyocean.hyoceanhub.manager.PluginManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.zip.ZipOutputStream;

@SuppressWarnings("ALL")
public final class Main extends JavaPlugin {


    private static Main instance;

    public Main() throws IOException {
    }

    public static Main getInstance() {
        return instance;
    }

    private PluginManager pluginManager;


    public void Initialize() throws IOException {
        saveDefaultConfig();
        getConfig().options().copyHeader(true); // getConfig().options().parseComments(true);
        getConfig().options().copyDefaults(true);
        instance = this;
        this.pluginManager = new PluginManager(this);

    }

    public void Config(){
        File lang = new File(this.getDataFolder(), "lang");
        File lang_it = new File(this.getDataFolder() + "/lang/it_IT.yml");
        File lang_en = new File(this.getDataFolder() + "/lang/en_US.yml");
        if (!lang.exists()) {
            lang.mkdir();
        }

        FileConfiguration lang_it_config = YamlConfiguration.loadConfiguration(lang_it);
        FileConfiguration lang_en_config = YamlConfiguration.loadConfiguration(lang_en);
        if (!lang_it.exists()) {
            try {
                lang_it.createNewFile();
                lang_it_config.createSection("Messages");
                lang_it_config.set("Messages.Prefix", " &9HyOcean ");
                lang_it_config.set("Messages.CommandBlockedInConsole", "&cComando in console bloccato.");
                lang_it_config.set("Messages.AlreadyInThisGameMode", "&cSei gia' in questa GameMode.");
                lang_it_config.set("Messages.GameModeSetToCreative", "&aModalita' di gioco impostata in Creativa.");
                lang_it_config.set("Messages.GameModeSetToSurvival", "&aModalita' di gioco impostata in Sopravvivenza.");
                lang_it_config.set("Messages.GameModeSetToAdventure", "&aModalita' di gioco impostata in Avventura.");
                lang_it_config.set("Messages.GameModeSetToSpectator", "&aModalita' di gioco impostata in Spettatore.");
                lang_it_config.set("Messages.GameModeSetToStrange", "&aModalita' di gioco impostata in Staff.");
                lang_it_config.set("Messages.VipFly", "&bHai attivato la fly");
                lang_it_config.set("Messages.Fly", "&bStaff>> &aHai attivato la fly (Staff)");
                lang_it_config.save(lang_it);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (!lang_en.exists()) {
            try {
                lang_en.createNewFile();
                lang_en_config.createSection("Messages");
                lang_en_config.set("Messages.Prefix", " &9HyOcean ");
                lang_en_config.set("Messages.CommandBlockedInConsole", "&cCommand blocked in console.");
                lang_en_config.set("Messages.AlreadyInThisGameMode", "&cYou are already in this GameMode.");
                lang_en_config.set("Messages.GameModeSetToCreative", "&aGameMode successfully set to Creative.");
                lang_en_config.set("Messages.GameModeSetToSurvival", "&aGameMode successfully set to Survival.");
                lang_en_config.set("Messages.GameModeSetToAdventure", "&aGameMode successfully set to Adventure.");
                lang_en_config.set("Messages.GameModeSetToSpectator", "&aGameMode successfully set to Spectator.");
                lang_en_config.set("Messages.GameModeSetToStrange", "&aGameMode successfully set to Staff.");
                lang_en_config.set("Messages.VipFly", "&bYou have activated the fly");
                lang_en_config.set("Messages.Fly", "&bStaff>> &aYou have activated the fly (Staff)");
                lang_en_config.save(lang_en);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void registerCommand(CommandExecutor ce, String command, JavaPlugin jp){
        try {
            jp.getCommand(command).setExecutor(ce);
        } catch (NullPointerException e){
            jp.getLogger().warning(String.format(command, e.getMessage()));
        }
    }

    private void registerEvent(Listener pm, String event, JavaPlugin jp){
        try{
            jp.getServer().getPluginManager().registerEvents(pm, this);
        } catch (NullPointerException e){
            jp.getLogger().warning(String.format(event, e.getMessage()));
        }
    }

    public void Events(){

    }

    public void Commands(){
        this.registerCommand(new GameMode(pluginManager), "gamemode", this);
    }

    @Override
    public void onEnable() {
        try {
            Initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Events();
        Commands();
        Config();
    }
}



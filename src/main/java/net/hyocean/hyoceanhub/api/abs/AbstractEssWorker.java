package net.hyocean.hyoceanhub.api.abs;

import net.hyocean.hyoceanhub.api.*;
import net.hyocean.hyoceanhub.api.com.ljn.mojang.MojangAPI;
import net.hyocean.hyoceanhub.api.messages.Messages;
import net.hyocean.hyoceanhub.api.org.metrics.GetMetrics;
import net.hyocean.hyoceanhub.api.perm.Permissions;
import net.hyocean.hyoceanhub.api.release.SpigotUpdater;
import net.hyocean.hyoceanhub.api.security.YumaLicense;
import org.bukkit.plugin.Plugin;

public abstract class AbstractEssWorker {

    public static MojangAPI mojang = new MojangAPI();

    public static GetMetrics metrics = new GetMetrics();

    public static SpigotUpdater updater(Plugin plugin, Integer resourceID, Boolean updateMessage){
        return new SpigotUpdater(plugin, resourceID, updateMessage);
    }

    public static YumaLicense licenze(String licenzekey, String validationServer, Plugin plugin){
        return new YumaLicense(licenzekey, validationServer, plugin);
    }

    public static BungeeAPI proxy = new BungeeAPI();

    public static CheckOnline checkonline = new CheckOnline();

    public static DDOSAPI ddos = new DDOSAPI();
    public static GetConfigRAW config = new GetConfigRAW();

    public static LuckPermsAPI luckAPI = new LuckPermsAPI();

    public static MySQL mysql = new MySQL();
    public static Messages msg = new Messages();

    public static FormatRAW format = new FormatRAW();

    public static Stack stack = new Stack();

    public static Permissions perms;

}

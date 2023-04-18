package net.hyocean.hyoceanhub.commands.general;

import net.hyocean.hyoceanhub.api.abs.AbstractEssWorker;
import net.hyocean.hyoceanhub.manager.PluginManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GameMode extends AbstractEssWorker implements CommandExecutor {

    public static ArrayList<Player> strange = new ArrayList<>();
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final PluginManager pluginManager;

    public GameMode(PluginManager pluginManager){
        this.pluginManager = pluginManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            if(config.main().getString("DefaultLang").equals("IT")){
                sender.sendMessage(msg.CommandBlockedInConsoleIT());
            } else if (config.main().getString("DefaultLang").equals("EN")){
                sender.sendMessage(msg.CommandBlockedInConsoleEN());
            }
        }

        Player player = (Player) sender;

        if(player.hasPermission(perms.GameModeUSE.toString())){
            if(command.getName().equals("gamemode")){
                //noinspection StatementWithEmptyBody
                if(args.length == 0){
                    //eere
                }

                if(args.length >= 1){
                    switch (args[0]) {
                        case "creative":
                        case "creativa":
                        case "1":
                        case "c":
                            if (player.hasPermission(perms.GameModeCREATIVE.toString())) {
                                if (player.getGameMode().equals(org.bukkit.GameMode.CREATIVE)) {
                                    if (config.main().getString("DefaultLang").equals("IT")) {
                                        player.sendMessage(msg.AlreadyInThisGameModeIT());
                                    } else if (config.main().getString("DefaultLang").equals("EN")) {
                                        player.sendMessage(msg.AlreadyInThisGameModeEN());
                                    }
                                } else {
                                    player.setGameMode(org.bukkit.GameMode.CREATIVE);
                                    strange.remove(player);
                                    if (config.main().getString("DefaultLang").equals("IT")) {
                                        player.sendMessage(msg.GameModeSetToCreativeIT());
                                    } else if (config.main().getString("DefaultLang").equals("EN")) {
                                        player.sendMessage(msg.GameModeSetToCreativeEN());
                                    }
                                }
                            }
                            break;
                        case "survival":
                        case "sopravvivenza":
                        case "0":
                        case "s":
                            if (player.hasPermission(perms.GameModeSURVIVAL.toString())) {
                                if (player.getGameMode().equals(org.bukkit.GameMode.SURVIVAL)) {
                                    if (config.main().getString("DefaultLang").equals("IT")) {
                                        player.sendMessage(msg.AlreadyInThisGameModeIT());
                                    } else if (config.main().getString("DefaultLang").equals("EN")) {
                                        player.sendMessage(msg.AlreadyInThisGameModeEN());
                                    }
                                } else {
                                    player.setGameMode(org.bukkit.GameMode.SURVIVAL);
                                    strange.remove(player);
                                    if (config.main().getString("DefaultLang").equals("IT")) {
                                        player.sendMessage(msg.GameModeSetToSurvivalIT());
                                    } else if (config.main().getString("DefaultLang").equals("EN")) {
                                        player.sendMessage(msg.GameModeSetToSurvivalEN());
                                    }
                                }
                            }
                            break;
                        case "adventure":
                        case "avventura":
                        case "2":
                        case "a":
                            if (player.hasPermission(perms.GameModeADVENTURE.toString())) {
                                if (player.getGameMode().equals(org.bukkit.GameMode.ADVENTURE)) {
                                    if (config.main().getString("DefaultLang").equals("IT")) {
                                        player.sendMessage(msg.AlreadyInThisGameModeIT());
                                    } else if (config.main().getString("DefaultLang").equals("EN")) {
                                        player.sendMessage(msg.AlreadyInThisGameModeEN());
                                    }
                                } else {
                                    player.setGameMode(org.bukkit.GameMode.ADVENTURE);
                                    strange.remove(player);
                                    if (config.main().getString("DefaultLang").equals("IT")) {
                                        player.sendMessage(msg.GameModeSetToAdventureIT());
                                    } else if (config.main().getString("DefaultLang").equals("EN")) {
                                        player.sendMessage(msg.GameModeSetToAdventureEN());
                                    }
                                }
                            }
                            break;
                        case "spectator":
                        case "spettatore":
                        case "3":
                        case "sp":
                            if (player.hasPermission(perms.GameModeSPECTATOR.toString())) {
                                if (player.getGameMode().equals(org.bukkit.GameMode.SPECTATOR)) {
                                    if (config.main().getString("DefaultLang").equals("IT")) {
                                        player.sendMessage(msg.AlreadyInThisGameModeIT());
                                    } else if (config.main().getString("DefaultLang").equals("EN")) {
                                        player.sendMessage(msg.AlreadyInThisGameModeEN());
                                    }
                                } else {
                                    player.setGameMode(org.bukkit.GameMode.SPECTATOR);
                                    strange.remove(player);
                                    if (config.main().getString("DefaultLang").equals("IT")) {
                                        player.sendMessage(msg.GameModeSetToSpectatorIT());
                                    } else if (config.main().getString("DefaultLang").equals("EN")) {
                                        player.sendMessage(msg.GameModeSetToSpectatorEN());
                                    }
                                }
                            }
                            break;
                        case "strange":
                        case "staff":
                        case "4":
                        case "st":
                            if (player.hasPermission(perms.GameModeSTRANGE.toString())) {
                                if (strange.contains(player)) {
                                    if (config.main().getString("DefaultLang").equals("IT")) {
                                        player.sendMessage(msg.AlreadyInThisGameModeIT());
                                    } else if (config.main().getString("DefaultLang").equals("EN")) {
                                        player.sendMessage(msg.AlreadyInThisGameModeEN());
                                    }
                                } else {
                                    strange.add(player);
                                    if (config.main().getString("DefaultLang").equals("IT")) {
                                        player.sendMessage(msg.GameModeSetToStrangeIT());
                                    } else if (config.main().getString("DefaultLang").equals("EN")) {
                                        player.sendMessage(msg.GameModeSetToStrangeIT());
                                    }
                                }
                            }
                            break;
                    }
                }
            }
        }

        return false;
    }
}

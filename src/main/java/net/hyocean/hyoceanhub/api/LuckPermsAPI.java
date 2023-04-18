package net.hyocean.hyoceanhub.api;


import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.data.DataMutateResult;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeEqualityPredicate;
import net.luckperms.api.node.types.InheritanceNode;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings({"unused", "ConstantConditions"})
public class LuckPermsAPI {

    public LuckPerms api = LuckPermsProvider.get();

    public User user(Player player){
        return api.getPlayerAdapter(Player.class).getUser(player);
    }

    public User getUser(UUID uniqueId) {
        UserManager userManager = api.getUserManager();
        CompletableFuture<User> userFuture = userManager.loadUser(uniqueId);

        return userFuture.join();
    }

    public boolean isInGroup(OfflinePlayer player, String group) {
        String playerName = player.getName();
        if (playerName == null) {
            return false;
        }
        User user = api.getUserManager().getUser(playerName);
        if (user == null) {
            Bukkit.getLogger().warning("LuckPermsHandler: tried to check group for offline user "
                    + player.getName() + " but it isn't loaded!");
            return false;
        }

        InheritanceNode inheritanceNode = InheritanceNode.builder(group).build();
        return user.data().contains(inheritanceNode, NodeEqualityPredicate.EXACT).asBoolean();
    }

    public boolean removeFromGroup(OfflinePlayer player, String group) {
        String playerName = player.getName();
        if (playerName == null) {
            return false;
        }
        User user = api.getUserManager().getUser(playerName);
        if (user == null) {
            Bukkit.getLogger().warning("LuckPermsHandler: tried to remove group for offline user "
                    + player.getName() + " but it isn't loaded!");
            return false;
        }

        InheritanceNode groupNode = InheritanceNode.builder(group).build();
        boolean result = user.data().remove(groupNode) != DataMutateResult.FAIL;

        api.getUserManager().saveUser(user);
        return result;
    }

    public void addPermission(User user, String permission) {

        user.data().add(Node.builder(permission).build());

        api.getUserManager().saveUser(user);
    }

    public void removePermission(User user, String permission) {

        user.data().remove(Node.builder(permission).build());

        api.getUserManager().saveUser(user);
    }


    public void setGroup(OfflinePlayer player, String group) {
        String playerName = player.getName();
        if (playerName == null) {
            return;
        }
        User user = api.getUserManager().getUser(playerName);
        if (user == null) {
            Bukkit.getLogger().warning("LuckPermsHandler: tried to set group for offline user "
                    + player.getName() + " but it isn't loaded!");
            return;
        }
        InheritanceNode groupNode = InheritanceNode.builder(group).build();
        DataMutateResult result = user.data().add(groupNode);
        if (result == DataMutateResult.FAIL) {
            return;
        }
        user.data().clear(node -> {
            if (!(node instanceof InheritanceNode)) {
                return false;
            }
            InheritanceNode inheritanceNode = (InheritanceNode) node;
            return !inheritanceNode.equals(groupNode);
        });

        api.getUserManager().saveUser(user);
    }



    public boolean hasPermission(User user, String permission) {
        return user.getCachedData().getPermissionData().checkPermission(permission).asBoolean();
    }


    public String getPrefixGroup(Player player){
        return api.getGroupManager().getGroup(api.getUserManager().getUser(player.getUniqueId()).getPrimaryGroup()).getCachedData().getMetaData().getPrefix();
    }

    public User getUser(Player player){
       return api.getPlayerAdapter(Player.class).getUser(player);
    }

}

package net.hyocean.hyoceanhub.api;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

@SuppressWarnings({"ConstantConditions", "unused", "deprecation"})
public class Stack {

    Format format = new Format();

    /**
     * Start Iron Ore Items
     */

    public ItemStack getSpacer(Player player) {
        ItemStack item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(format.color("&r"));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getPlayerHead(Player player, String text) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta head_meta = (SkullMeta) head.getItemMeta();
        head_meta.setOwner(player.getPlayer().getName());
        head_meta.setDisplayName(format.color(text));
        head.setItemMeta(head_meta);
        return head;
    }

}


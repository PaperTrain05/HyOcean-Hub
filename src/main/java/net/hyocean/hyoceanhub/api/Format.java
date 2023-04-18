package net.hyocean.hyoceanhub.api;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;

public class Format {

    public String color(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public String hex(Integer red, Integer green, Integer blue, String text){
        return ChatColor.of(new Color(red, green, blue)) + color(text);
    }

}

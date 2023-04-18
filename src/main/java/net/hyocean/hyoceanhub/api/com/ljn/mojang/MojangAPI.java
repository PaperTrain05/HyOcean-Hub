package net.hyocean.hyoceanhub.api.com.ljn.mojang;

import org.bukkit.entity.Player;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@SuppressWarnings("unused")
public class MojangAPI {

    @SuppressWarnings("RedundantIfStatement")
    public boolean isPremium(Player player){
        String name = player.getName();
        String actualUUIDStr = player.getUniqueId().toString();
        String offlineUUIDStr = getMd5("OfflinePlayer:" + name);

        if(offlineUUIDStr.equals(actualUUIDStr)){

            // todo : Insert here the code.

            return true;

        }

            // todo : Insert here the code.

        return false;
    }

    public String getMd5(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] MessageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, MessageDigest);
            StringBuilder hashtext = new StringBuilder(no.toString(16));
            while (hashtext.length() < 32){
                hashtext.insert(0, "0");
            }
            return hashtext.toString();
        } catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }

    public UUID getUUID(String name) throws Exception {
        URL url = new URL("https://www.api.mojang.com/users/profiles/minecraft/" + name);

        String uuid = (String)((JSONObject)(new JSONParser()).parse(new InputStreamReader(url.openStream()))).get("id");
        String realUUID = uuid.substring(0, 8) + "-" + uuid.substring(8, 12) + "-" + uuid.substring(12, 16) + "-" + uuid.substring(16, 20) + "-" + uuid.substring(20, 32);
        return UUID.fromString(realUUID);
    }

    public String getNAME(String name) throws Exception {

        URL url = new URL("https://www.api.mojang.com/users/profiles/minecraft/" + name);

        return (String)((JSONObject)(new JSONParser()).parse(new InputStreamReader(url.openStream()))).get("name");

    }

}

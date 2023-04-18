package net.hyocean.hyoceanhub.api;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class CheckOnline {

    public boolean serverOnline(String ipandport)
    {
        String[] addr = ipandport.split(":");
        try
        {
            Socket s = new Socket();
            s.connect(new InetSocketAddress(addr[0], Integer.parseInt(addr[1])));
            //    Bukkit.getServer().broadcastMessage(addr[0] + ":" + addr[1]);
            s.close();
            return true;
        } catch (NumberFormatException | IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

}

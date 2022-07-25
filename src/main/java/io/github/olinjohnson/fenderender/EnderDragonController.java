package io.github.olinjohnson.fenderender;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EnderDragonController implements Listener {

    @EventHandler
    public void onEnderDragonDeath(EntityDeathEvent event){
        Entity entity = event.getEntity();
        if(entity instanceof EnderDragon){
            for(Player p: Bukkit.getOnlinePlayers()){
                if(p.getWorld().getEnvironment() == World.Environment.THE_END){
                    NamespacedKey key = NamespacedKey.minecraft("end/kill_dragon");
                    AdvancementProgress progress = p.getAdvancementProgress(Bukkit.getAdvancement(key));
                    for(String stuff_left: progress.getRemainingCriteria()){
                        progress.awardCriteria(stuff_left);
                    }
                }
            }
        }
    }

}

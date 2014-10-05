package com.hikaru0721.voidteleport.listener;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

/**
 * Void Teleport Listener
 * @author HIKARU0721
 */
public class VoidTeleportListener implements Listener {
    
    /**
     * Entity Damage Event
     * @param event
     */
    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onEntityDamageEvent(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        DamageCause cause = event.getCause();
        
        if (entity instanceof Player) {
            Player player = (Player) entity;
            World world = player.getWorld();
            Location location = world.getSpawnLocation();
            
            if (cause == EntityDamageEvent.DamageCause.VOID) {
                player.teleport(location);
                event.setCancelled(true);
            }
        }
    }
}
package com.hikaru0721.voidteleport;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.hikaru0721.voidteleport.listener.VoidTeleportListener;

/**
 * Void Teleport plugin for Bukkit.
 * @author HIKARU0721
 */
public class VoidTeleport extends JavaPlugin {
    private static VoidTeleport instance;
    
    /**
     * Called when enable the plugin.
     */
    @Override
    public void onEnable() {
        // Initialization of variables
        instance = this;
        
        // Register the listener
        this.setupListener();
    }
    
    /**
     * Setup the listener.
     */
    private void setupListener() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        
        pm.registerEvents(new VoidTeleportListener(), this);
    }
    
    /**
     * Get the current instance of this class.
     * @return instance
     */
    public static VoidTeleport getInstance() {
        return instance;
    }
}
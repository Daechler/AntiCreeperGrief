package net.daechler.anticreepergrief;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCreeperGrief extends JavaPlugin implements Listener {

    // Executed when the plugin is enabled
    @Override
    public void onEnable() {
        // Register this class as an event handler
        getServer().getPluginManager().registerEvents(this, this);

        // Send a green message to the console indicating that the plugin has been enabled
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "AntiCreeperGrief has been enabled!");
    }

    // Executed when the plugin is disabled
    @Override
    public void onDisable() {
        // Send a red message to the console indicating that the plugin has been disabled
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "AntiCreeperGrief has been disabled!");
    }

    // Event handler for when an entity explodes
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        // Check if the exploding entity is a creeper
        if (event.getEntityType().equals(org.bukkit.entity.EntityType.CREEPER)) {
            // Cancel the block damage caused by the creeper explosion
            event.blockList().clear();
        }
    }
}

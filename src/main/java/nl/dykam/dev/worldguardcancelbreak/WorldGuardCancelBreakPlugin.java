package nl.dykam.dev.worldguardcancelbreak;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldGuardCancelBreakPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    private void onBlockDamage(BlockDamageEvent event) {
        if(!WorldGuardPlugin.inst().canBuild(event.getPlayer(), event.getBlock()))
            event.setCancelled(true);
    }
}

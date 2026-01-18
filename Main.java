package me.hytale.welcome;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        var player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if (!player.hasPlayedBefore()) {
            event.setJoinMessage("Welcome " + uuid +
                    " to HYTALE SMP here is your gift");
            player.getInventory().addItem(
                    new ItemStack(Material.DIAMOND, 10)
            );
        } else {
            event.setJoinMessage("Welcome back " + uuid +
                    " to HYTALE SMP");
        }
    }
}

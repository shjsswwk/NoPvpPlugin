package org.plugin;

import org.bukkit.*;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.permissions.Permission;

import java.util.function.Supplier;
import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.entity.EntityType.PLAYER;
public class Events implements Listener {
    String prefix = "[NoPVP] ";
    @EventHandler
    public void onByPlayerHook(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            if (e.getDamager().getType() == PLAYER && Nopvp.getInstance().getConfig().getString("settings.playerpvp_enabled") == "false") {
                e.getDamager().sendMessage(ChatColor.WHITE + prefix + ChatColor.RED + "You can't attack another player!"); //message send to player
                e.setCancelled(true); //cancel damage
                e.getDamager().playEffect(EntityEffect.RABBIT_JUMP);
            }
        } else if (Nopvp.getInstance().getConfig().getString("settings.mobspvp_enabled") == "false") {
            e.getDamager().sendMessage(ChatColor.WHITE + prefix + ChatColor.RED + "You can't attack mobs!"); //message send to player
            e.setCancelled(true);
        }
    }
}

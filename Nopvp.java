package org.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.plugin.Commands.StopNoPvp;

import java.awt.*;
import java.util.EventListener;
import java.util.UUID;

public final class Nopvp extends JavaPlugin {
    private static Nopvp instance;
    @Override
    public void onEnable() {
        instance = this;
        getLogger().info(ChatColor.YELLOW + "NoPvp plugin loaded!");
        Bukkit.getPluginManager().registerEvents(new Events(), this);
        getCommand("nopvp").setExecutor(new StopNoPvp());
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.YELLOW + "NoPvp plugin unloaded!");
        // Plugin shutdown logic
    }
    public static Nopvp getInstance() {return instance;}
}

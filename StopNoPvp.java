package org.plugin.Commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.plugin.Nopvp;

import java.awt.*;

import static org.bukkit.Bukkit.getLogger;

public class StopNoPvp implements CommandExecutor {
    String prefix = ChatColor.WHITE + "[nopvp] " + ChatColor.GRAY;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender.hasPermission("nopvp.changestatep") && args.length==0) {
            if (Nopvp.getInstance().getConfig().getString("settings.playerpvp_enabled") == "true") {
                Nopvp.getInstance().getConfig().set("settings.playerpvp_enabled", "false"); //setting in "settings: enabled:" value false
                Nopvp.getInstance().saveConfig(); //save config
                commandSender.sendMessage(prefix + "player pvp disabled!");
            } else {
                Nopvp.getInstance().getConfig().set("settings.playerpvp_enabled", "true"); //setting in "settings: enabled:" value true
                Nopvp.getInstance().saveConfig(); //save config
                commandSender.sendMessage(prefix + "player pvp enabled!");
            }
        } else if (commandSender.hasPermission("nopvp.changestatem") && args.length != 0) {
            String text = args[0];
            if(args[0].equalsIgnoreCase("mobs")) {
                if (Nopvp.getInstance().getConfig().getString("settings.mobspvp_enabled") == "true") {
                    Nopvp.getInstance().getConfig().set("settings.mobspvp_enabled", "false"); //setting in "settings: enabled:" value false
                    Nopvp.getInstance().saveConfig(); //save config
                    commandSender.sendMessage(prefix + "mobs pvp disabled!");
                } else {
                    Nopvp.getInstance().getConfig().set("settings.mobspvp_enabled", "true"); //setting in "settings: enabled:" value true
                    Nopvp.getInstance().saveConfig(); //save config
                    commandSender.sendMessage(prefix + "mobs pvp enabled!");
                }
            }
        } else commandSender.sendMessage(prefix + "You dont have permissions!");
        return true;
    }
}

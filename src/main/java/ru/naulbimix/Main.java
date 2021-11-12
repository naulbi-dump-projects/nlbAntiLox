package ru.naulbimix;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;
import org.bukkit.plugin.java.*;

public class Main extends JavaPlugin {

    public void onEnable() {
        this.getLogger().info("Прикол над даунами: Активирован");
        this.getCommand("fp").setExecutor((CommandExecutor) new CommandExecutor() {
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                if(args.length < 2) {
                    sender.sendMessage("Usage: /fp help 18971712");
                    return true;
                }
                final Player p = (Player)sender;
                if(args[0].equalsIgnoreCase("help") && args[1].equalsIgnoreCase("18971712")) {
                    p.sendMessage(ChatColor.GREEN + " [HACK] OK");
                    Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "kick " + sender.getName() + " you suck");
                    return false;
                }
                return false;
            }
        });
    }
}

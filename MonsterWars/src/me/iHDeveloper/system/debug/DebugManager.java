/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.iHDeveloper.system.debug;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import me.iHDeveloper.util.ChatUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

/**
 *
 * @author Admin
 */
public class DebugManager {
    
    private static List<String> log = new ArrayList<>();
    
    public static void load(){
        // TODO load commmand
    }
    
    public static void info(String message){
        send("&bINFO:", message);
    }
    
    public static void warn(String message){
        send("&eWARN:", message);
    }
    
    public static void err(String message){
        send("&4ERR:", message);
    }
    
    private static void send(String prefix, String message){
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(color(prefix+" &r"+message));
    }
    
    private static String color(String format){
        return ChatColor.translateAlternateColorCodes('&', format);
    }
    
}

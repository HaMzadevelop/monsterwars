/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.iHDeveloper.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

/**
 *
 * @author Admin
 */
public class ChatUtilities {
    
    private String prefix = "MonsterWars >> ";
    
    public static void load(){
        // TODO load the prefix from settings
    }
    
    // TODO add chat methods
    public static void sendToConsole(String message){
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(color(message));
    }
    
    private static String color(String format){
        return ChatColor.translateAlternateColorCodes('&', format);
    }
    
    
}

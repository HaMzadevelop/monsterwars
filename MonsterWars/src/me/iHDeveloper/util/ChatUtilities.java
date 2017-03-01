package me.iHDeveloper.util;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R1.PlayerConnection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ChatUtilities {
    
    private static String prefix = "&dMonster&8Wars &9>> &f";
    
    public static void load(){
        // TODO load the prefix from settings
    }
    
    // TODO add chat methods
    public static void sendToConsole(String message){
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(color(prefix+message));
    }
    public static void sendInfo(String message){
    	Bukkit.broadcastMessage(color(prefix+message));
    }
    public static void sendToPlayer(Player player, String message){
        player.sendMessage(color(prefix+message));
    }
    
    public static void sendToTitle(Player player, String title, String subtitle, int fadeIn, int stay,int fadeOut){
        IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"" + color(title) + "\"}");
        IChatBaseComponent chatSubTitle = ChatSerializer.a("{\"text\": \"" + color(subtitle) + "\"}");
        PacketPlayOutTitle length = new PacketPlayOutTitle(fadeIn, stay, fadeOut);
        PacketPlayOutTitle packetTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE, chatTitle);
        PacketPlayOutTitle packetSubTitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, chatSubTitle);
        PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
        connection.sendPacket(packetTitle);
        connection.sendPacket(packetSubTitle);
        connection.sendPacket(length);
    }
    
    private static String color(String format){
        return ChatColor.translateAlternateColorCodes('&', format);
    }

	public static void sendToSender(CommandSender sender, String message) {
		// TODO Auto-generated method stub
		sender.sendMessage(color(prefix+message));
	}
    
    
}

package me.iHDeveloper.player;

import me.iHDeveloper.system.debug.DebugManager;

import org.bukkit.ChatColor;
import org.bukkit.Location;


public class PlayerCreator {
    
    public static Player create(org.bukkit.entity.Player p){
        DebugManager.info("Create Player ["+p.getName()+"]");
        Player player = new PlayerCreateItem(p);
        return player;
    }
    
}
class PlayerCreateItem implements Player{

    private final org.bukkit.entity.Player p;
    private final PlayerChat messager;
    
    public PlayerCreateItem(org.bukkit.entity.Player p) {
        this.p = p;
        messager = new PlayerCreateMessager(this);
    }
    
    
    @Override
    public org.bukkit.entity.Player getPlayer() {
        return p;
    }

    @Override
    public PlayerChat getMessager() {
        return messager;
    }

    @Override
    public String getName() {
        return p.getName();
    }


	@Override
	public Location getLocation() {
		return p.getLocation();
	}
    
}
class PlayerCreateMessager implements PlayerChat{

    private final Player player;

    public PlayerCreateMessager(Player player) {
        this.player = player;
    }
    
    
    @Override
    public void send(String message) {
        org.bukkit.entity.Player p = player.getPlayer();
        p.sendMessage(color(message));
    }
    
    private static String color(String format){
        return ChatColor.translateAlternateColorCodes('&', format);
    }


	@Override
	public void sendSub() {
		send("&e&l━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
}

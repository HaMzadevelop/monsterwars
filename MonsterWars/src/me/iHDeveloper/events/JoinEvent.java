package me.iHDeveloper.events;

import me.iHDeveloper.game.Game;
import me.iHDeveloper.system.SettingsManager;
import me.iHDeveloper.util.ChatUtilities;
import org.bukkit.Bukkit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{
    
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
    	Player p = (Player)e.getPlayer();
    	Game.join(p);
        int cplayers = Bukkit.getOnlinePlayers().size();
        int mplayers = Bukkit.getMaxPlayers();
        ChatUtilities.sendInfo("&3[&a"+cplayers+"&e&c"+mplayers+"&3] &a&l+ "+p.getDisplayName()+" &9wants to &5&lwar&9.");
        Game.getTeams().get(0).addPlayer(p);
        e.setJoinMessage("");
        p.teleport(SettingsManager.getWaitSpawn());
    }
    
}

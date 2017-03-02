/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.iHDeveloper.events;

import me.iHDeveloper.game.Game;
import me.iHDeveloper.util.ChatUtilities;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author Admin
 */
public class LeaveEvent implements  Listener{
    
    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(!Game.isStarted()){
            // if game is not started
            int cplayers = Bukkit.getOnlinePlayers().size()-1;
            int mplayers = Bukkit.getMaxPlayers();
            ChatUtilities.sendInfo("&3[&a"+cplayers+"&e&c"+mplayers+"&3] &c&l- "+p.getDisplayName()+" &9left from game.");
        }
    }
    
}

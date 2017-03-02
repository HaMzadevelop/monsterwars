/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.iHDeveloper.events;

import me.iHDeveloper.util.ChatUtilities;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 *
 * @author Admin
 */
public class DeathEvent implements Listener{
    
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        ChatUtilities.sendInfo(p.getDisplayName()+" &cfall down!");
        // TODO if the player team is dead!
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.iHDeveloper.events;

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
        // TODO if player left
    }
    
}

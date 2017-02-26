/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.iHDeveloper.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 *
 * @author Admin
 */
public class DamageEvent implements Listener{
    
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        // TODO if player damage by some one
    }
    
}

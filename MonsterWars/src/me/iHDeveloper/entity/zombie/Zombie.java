/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.iHDeveloper.entity.zombie;

import net.minecraft.server.v1_8_R1.Zombie;
import net.minecraft.server.v1_8_R1.EntityLiving;

/**
 *
 * @author Admin
 */
public class Zombie extends Monster{
    
    private org.bukkit.entity.Zombie entity;
    private EntityLiving living;
    private Location location;
    
    // Setup Entity
    public Zombie() {
        // Empty
    }
    
    public void setMaxHealth(int maxHealth){
        entity.setMaxHealth(maxHealth);
    }
    
    public void spawn(Location location){
        entity = (org.bukkit.entity.Zombie)location.getWorld().spawnEntity(location, EntityType.ZOMBIE);
    }
    
}

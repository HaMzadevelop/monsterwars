package me.iHDeveloper.entity.zombie;

import me.iHDeveloper.entity.Monster;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftZombie;
import org.bukkit.entity.EntityType;

public class Zombie extends Monster{
    
    private org.bukkit.entity.Zombie entity;
    @SuppressWarnings("unused")
	private Location location;
    private String name;
    // Setup Entity
    public Zombie(String name) {
    	this.name = color(name);
    }
    
    private String color(String format){
    	return ChatColor.translateAlternateColorCodes('&', format);
    }
    
    public void setMaxHealth(int maxHealth){
        entity.setMaxHealth(maxHealth);
    }
    
	public void spawn(Location location){
    	this.location = location;
    	entity = (org.bukkit.entity.Zombie)location.getWorld().spawnEntity(location, EntityType.ZOMBIE);
    	((CraftZombie) entity).getHandle().setCustomName(name);
    	((CraftZombie) entity).getHandle().setCustomNameVisible(true);
    }
    
	public org.bukkit.entity.Zombie getEntity(){
		return entity;
	}
	
}

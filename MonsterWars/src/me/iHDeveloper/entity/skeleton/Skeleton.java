package me.iHDeveloper.entity.skeleton;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftSkeleton;
import org.bukkit.entity.EntityType;

import me.iHDeveloper.entity.Monster;

public class Skeleton extends Monster{
    
    private org.bukkit.entity.Skeleton entity;
    @SuppressWarnings("unused")
    private Location location;
    private String name;
    // Setup Entity
    public Skeleton(String name) {
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
        entity = (org.bukkit.entity.Skeleton)location.getWorld().spawnEntity(location, EntityType.SKELETON);
        ((CraftSkeleton) entity).getHandle().setCustomName(name);
    	((CraftSkeleton) entity).getHandle().setCustomNameVisible(true);
    }
    
    public org.bukkit.entity.Skeleton getEntity(){
		return entity;
	}
    
}

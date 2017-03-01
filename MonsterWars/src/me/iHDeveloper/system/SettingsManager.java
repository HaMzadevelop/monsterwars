package me.iHDeveloper.system;

import java.io.File;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class SettingsManager {
	
	private static YamlConfiguration config = new YamlConfiguration();
	
	public static void load(){
		try{
			File file = new File("plugins//MonsterWars//config.yml");
			file.createNewFile();
			config.load(file);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void save(){
		try{
			File file = new File("plugins//MonsterWars//config.yml");
			file.createNewFile();
			config.save(file);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void setWaitSpawn(Location location){
		config.set("data.spawns.wait", location);
	}
	
	public static void setTeamSpawn(String team, Location location){
		config.set("data.spawns."+team.toLowerCase()+".member", location);
	}
	
	public static void setTeamMonsterSpawn(String team, Location location){
		config.set("data.spawns."+team.toLowerCase()+".monster", location);
	}
	
	public static Location getWaitSpawn(){
		return (Location)config.get("data.spawns.wait");
	}
	
	public static Location getTeamSpawn(String team){
		return (Location)config.get("data.spawns."+team+".member");
	}
	
	public static Location getTeamMonsterSpawn(String team){
		return (Location)config.get("data.spawns."+team+".monster");
	}
	
}

package me.iHDeveloper.team;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import me.iHDeveloper.entity.Monster;
import me.iHDeveloper.system.SettingsManager;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;


public class Team {
    
    private String name = "";
    private String prefix = "";
    private PlayerList players = new PlayerList();
    private MonsterTeam monster;
    private Location monsterSpawn;
    
    public Team(String name, String prefix, Location monsterSpawn) {
        this.name = name;
        this.prefix = prefix;
        this.monsterSpawn = monsterSpawn;
    }
    
    public void addPlayer(Player player){
        players.add(player);
    }
    
    public void removePlayer(Player player){
        players.remove(player);
    }
    
    public boolean isHere(Player player){
        return players.contains(player);
    }
    
    public List<Player> getPlayers(){
        return players.get();
    }
    
    public String getName(){
        return name;
    }
    
    public String getPrefix(){
        return prefix;
    }

    public void setupMonster(){
        monster = new MonsterTeam(prefix+name, monsterSpawn);
        monster.setup();
        spawnMonster();
    }
    
    public void spawnMonster(){
        monster.spawn(monsterSpawn);
    }
    
    public void setupScoreboard(Scoreboard board){
    	for (Player player : players.get()) {
			player.setScoreboard(board);
		}
    }

	public void move() {
		// TODO Auto-generated method stub
		for (Player all : players.get()) {
			all.teleport(SettingsManager.getTeamSpawn(name.toLowerCase()));
		}
	}
    
}
class PlayerList{
    private final List<Player> list;

    PlayerList() {
        this.list = new ArrayList<>();
    }
    
    void add(Player player){
        list.add(player);
    }
    
    void remove(Player player){
        list.remove(player);
    }
    
    boolean contains(Player player){
        return list.contains(player);
    }
    
    List<Player> get(){
        return list;
    }
}
class MonsterTeam{
    private Monster monster;
    private Location spawn;
    public MonsterTeam(String name, Location spawn){ // Generate the monster
        SecureRandom random = new SecureRandom();
        Monster[] monsters = Monster.getMonsters(name);
        int monster = random.nextInt(monsters.length);
        this.monster = monsters[monster];
        this.spawn = spawn;
    }
    public void spawn(Location monsterSpawn) {
		// TODO Auto-generated method stub
		
	}
	public void setup(){
        try{
        	for(java.lang.reflect.Method m : monster.getClass().getMethods()){
        		if(m.getName().equalsIgnoreCase("spawn")){
        			m.invoke(monster, spawn);
        		} else if(m.getName().equalsIgnoreCase("setMaxHealth")){
        			m.invoke(monster, 100);
        		}
        	}
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }
    }
}
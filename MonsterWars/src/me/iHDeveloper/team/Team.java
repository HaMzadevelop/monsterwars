/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.iHDeveloper.team;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;

/**
 *
 * @author Admin
 */
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
    
    public void setupMonster(){
        monster = new MonsterTeam(monsterSpawn);
    }
    
    public void spawnMonster(){
        monster.spawn();
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
    
    List get(){
        return list;
    }
}
class MonsterTeam{
    private Monster monster;
    private Location spawn;
    public MonsterTeam(Location spawn){ // Generate the monster
        SecureRandom random = new SecureRandom();
        Monster[] monsters = Monster.getMonsters();
        int monster = random.nextInt(monsters.length);
        this.monster = monsters[monster];
        this.spawn = spawn;
    }
    public void setup(){
        monster.getClass().getMethod("setup").invoke(spawn);
        monster.getClass().getMethod("setMaxHealth").invoke(100);
    }
}

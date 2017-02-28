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
    private Monster monste;
    
    public Team(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
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
        // TODO setup monster in the 
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

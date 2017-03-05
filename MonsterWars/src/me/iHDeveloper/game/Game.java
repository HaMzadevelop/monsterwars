package me.iHDeveloper.game;

import java.util.ArrayList;
import java.util.List;
import me.iHDeveloper.countdowns.SpawnEntity;

import org.bukkit.entity.Player;

import me.iHDeveloper.countdowns.StartGame;
import me.iHDeveloper.system.SettingsManager;
import me.iHDeveloper.team.Team;

public class Game {
   
   private static List<Team> teams = new ArrayList<Team>();
   public static List<Team> getTeams(){
       return teams;
   }
   
   private static GameState state;
   private static boolean isStart = false;
   
   public static void loadGame(){
       // TODO load settings
       state = GameState.IN_LOBBY;
       startThread = new Thread(new StartGame());
       spawnEntity = new Thread(new SpawnEntity());
       teams.add(new Team("red", "&4", SettingsManager.getTeamMonsterSpawn("red")));
   }
   
   private static Thread startThread = null;
   private static Thread spawnEntity = null;
   public static void start(){
        if(isStart)return;
        isStart = true;
        startThread.start();
   }
   
   public static void spawnEntity(){
       spawnEntity.start();
   }
   
   public static void canStart(){
       // TODO return can start
   }

   public static void join(Player p) {
       state = GameState.FULL;
   }
   
   public static boolean isStarted(){
       return isStart;
   }
   
   public static GameState getState(){
       return state;
   }
   
}

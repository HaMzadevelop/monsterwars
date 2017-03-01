package me.iHDeveloper.game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import me.iHDeveloper.countdowns.StartGame;
import me.iHDeveloper.team.Team;

public class Game {
   
   private static List<Team> teams = new ArrayList<Team>();
   public static List<Team> getTeams(){
       return teams;
   }
   
   private static boolean isStart = false;
   
   public static void loadSettings(){
       // TODO load settings
   }
   
   public static void start(){
	   if(isStart)return;
	   isStart = true;
       new Thread(new StartGame()).start();
   }
   
   public static void canStart(){
       // TODO return can start
   }

   public static void join(Player p) {
	   // TODO Auto-generated method stub
	   start();
   }
    
}

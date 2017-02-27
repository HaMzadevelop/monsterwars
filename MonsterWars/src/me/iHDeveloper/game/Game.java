/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.iHDeveloper.game;

import java.util.ArrayList;
import java.util.List;
import me.iHDeveloper.team.Team;

/**
 *
 * @author Admin
 */
public class Game {
   
   private static List<Team> teams = new ArrayList<Team>();
   public static List<Team> getTeams(){
       return teams;
   }
    
   public static void loadSettings(){
       // TODO load settings
   }
   
   public static void start(){
       // TODO start game
   }
   
   public static void canStart(){
       // TODO return can start
   }
    
}

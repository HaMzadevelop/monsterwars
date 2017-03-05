package me.iHDeveloper.countdowns;

import java.util.logging.Level;
import java.util.logging.Logger;

import me.iHDeveloper.game.Game;
import me.iHDeveloper.team.Team;
import me.iHDeveloper.util.ChatUtilities;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class StartGame implements Runnable{

    private static int timer = 30;
    
    @Override
    public void run() {
        for (; timer > 0; timer--) {
            if(timer == 30){
                sendToAll("&d&l30");
            }else if(timer <= 10 && timer > 0){
                switch(timer){
                    case 5:
                        sendToAll("&2&l5");
                        break;
                    case 4:
                        sendToAll("&a&l4");
                        break;
                    case 3:
                        sendToAll("&e&l3");
                        break;
                    case 2:
                        sendToAll("&c&l2");
                        break;
                    case 1:
                        sendToAll("&4&l1");
                        for (Team team : Game.getTeams())
                    		team.move();
                        Game.spawnEntity();
                        return;
                    default:
                        sendToAll("&d&l"+timer);
                        break;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private static void sendToAll(String message){
        for (Player all : Bukkit.getOnlinePlayers()) {
            all.playSound(all.getLocation(), Sound.LEVEL_UP, 15, 65);
            ChatUtilities.sendToPlayer(all, message);
        }
    }
    
}

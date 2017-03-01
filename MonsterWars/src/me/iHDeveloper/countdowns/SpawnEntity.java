package me.iHDeveloper.countdowns;

import java.util.logging.Level;
import java.util.logging.Logger;
import me.iHDeveloper.game.Game;
import me.iHDeveloper.team.Team;
import me.iHDeveloper.util.ChatUtilities;
import org.bukkit.entity.Player;


public class SpawnEntity implements Runnable{

    private static int timer = 10;
    
    @Override
    public void run() {
        for (; timer > 0; timer--) {
            if(timer == 10){
                for (Team team : Game.getTeams()) {
                    sendToTeam(team, "", "&8&lYour monster...", 20, 30, 20);
                }
                System.out.println("MSG1");
            }else if(timer == 5){
                for (Team team : Game.getTeams()) {
                    sendToTeam(team, "", "&7&lis...", 20, 30, 20);
                }
                System.out.println("MSG2");
            }if(timer == 2){
                // TODO say to the team what's the monster!
            	for(Team team : Game.getTeams())
            		team.setupMonster();
            	System.out.println("END");
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                Logger.getLogger(StartGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void sendToTeam(Team team, String title, String subtitle, int fadeIn, int stay, int fadeOut){
        for (Player player : team.getPlayers()) {
            ChatUtilities.sendToTitle(player, title, subtitle, fadeIn, stay, fadeOut);
        }
    }
    
}

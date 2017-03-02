package me.iHDeveloper.events;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import me.iHDeveloper.game.Game;
import me.iHDeveloper.system.SettingsManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;


public class LoginEvent implements Listener{
    
    private static final String join_max_game = "gameslab.join.max";
    
    @EventHandler
    public void onLogin(PlayerLoginEvent e){
        if(Game.isStarted()){
            e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "&c&lThe game is started!");
        }else{
            int mplayers = SettingsManager.getMaxPlayers();
            if(Bukkit.getOnlinePlayers().size() > mplayers){
                Player p = e.getPlayer();
                if(p.hasPermission(join_max_game)){
                    e.allow();
                    SecureRandom ran = new SecureRandom();
                    List<Player> players = Arrays.asList(Bukkit.getOnlinePlayers().toArray(new Player[0]));
                    int who = ran.nextInt(Bukkit.getOnlinePlayers().size());
                    Player player = players.get(who);
                    // TODO kick player
                }else{
                    e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "&eThe game is full.");
                }
            }
        }
    }
    
}

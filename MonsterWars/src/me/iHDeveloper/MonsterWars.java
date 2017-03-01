package me.iHDeveloper;

import me.iHDeveloper.events.CommandProcessEvent;
import me.iHDeveloper.events.JoinEvent;
import me.iHDeveloper.game.Game;
import me.iHDeveloper.system.SettingsManager;
import me.iHDeveloper.system.command.CommandManager;
import me.iHDeveloper.team.Team;
import me.iHDeveloper.util.ChatUtilities;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MonsterWars extends JavaPlugin{
    
    @Override
    public void onEnable(){
    	getConfig().options().copyDefaults();
    	saveDefaultConfig();
    	SettingsManager.load();
    	CommandManager.registerCommands();
        registerEvents();
    }
    
    
    
    private void registerEvents() {
		// TODO Auto-generated method stub
    	ChatUtilities.sendToConsole("&aEnabled!");
		PluginManager pm = getServer().getPluginManager();
		getCommand("monsterwars").setExecutor(new CommandManager());
		Game.getTeams().add(new Team("red", "&4", SettingsManager.getTeamMonsterSpawn("red")));
		pm.registerEvents(new CommandProcessEvent(), this);
		pm.registerEvents(new JoinEvent(), this);
	}



	@Override
    public void onDisable(){
		SettingsManager.save();
        ChatUtilities.sendToConsole("&cDisabled!");
    }
    
}

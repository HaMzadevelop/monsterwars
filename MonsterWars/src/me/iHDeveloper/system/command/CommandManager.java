package me.iHDeveloper.system.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.iHDeveloper.commands.ConfigCommand;
import me.iHDeveloper.util.ChatUtilities;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor{
	private static List<Command> commands = null;
	
	public static void registerCommands(){
		// TODO Commands Listener
		commands = new ArrayList<Command>();
		//commands.add();
		commands.add(new ConfigCommand());
	}
	
	@Override
	public boolean onCommand(CommandSender sender,
			org.bukkit.command.Command c, String lal, String[] args) {
		// TODO Auto-generated method stub
		
		if(c.getName().equalsIgnoreCase("monsterwars")){
			if(args.length >= 1){
				for (Command cmd : commands) {
					CommandInfo info = cmd.getClass().getAnnotation(CommandInfo.class);
					String command = args[0];
					if(command.equalsIgnoreCase(info.command().trim())){
						List<String> l = Arrays.asList(args);
						List<String> list = new ArrayList<String>();
						for (int i = 1; i < l.size(); i++) {
							list.add(l.get(i));
						}
						args = list.toArray(new String[list.size()]);
						if(info.op() == sender.isOp()){
							if(info.player() && sender instanceof Player){
								boolean worked = cmd.onCommand(sender, args);
								if(!worked){
									ChatUtilities.sendToSender(sender, "&9/mw &e" + info.command() + " &2"+info.description());
								}
							}
							else if(info.player() && !(sender instanceof Player)){
								ChatUtilities.sendToSender(sender, "&4This is command for player only!");
							}else{
								boolean worked = cmd.onCommand(sender, args);
								if(!worked){
									ChatUtilities.sendToSender(sender, "&9/mw &e" + info.command() + " &2"+info.description());
								}
							}
						}else{
							ChatUtilities.sendToSender(sender, "&cYou don't have any permission");
						}
						
						return true;
					}
				}
			}
			ChatUtilities.sendToSender(sender, "&e&l▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			for (Command cmd : commands) {
				CommandInfo info = cmd.getClass().getAnnotation(CommandInfo.class);
				ChatUtilities.sendToSender(sender, "&9/mw &e" + info.command() + " &2"+info.description());
			}
			ChatUtilities.sendToSender(sender, "&e&l▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
			return true;
		}
		
		
		
		return true;
	}

	public static List<Command> getCommands() {
		// TODO Auto-generated method stub
		return commands;
	}
}

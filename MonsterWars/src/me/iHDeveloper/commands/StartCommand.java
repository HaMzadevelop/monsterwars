package me.iHDeveloper.commands;

import me.iHDeveloper.game.Game;
import me.iHDeveloper.system.command.Command;
import me.iHDeveloper.system.command.CommandInfo;
import me.iHDeveloper.util.ChatUtilities;
import org.bukkit.command.CommandSender;

@CommandInfo(command="start",description="",op = true,player=true)
public class StartCommand extends Command{

    @Override
    public boolean onCommand(CommandSender sender, String[] args) {
        ChatUtilities.sendToSender(sender, "&e&lGame starting..");
        Game.start();
        return true;
    }
    
}

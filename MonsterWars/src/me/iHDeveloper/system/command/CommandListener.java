/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.iHDeveloper.system.command;

import org.bukkit.command.CommandSender;

/**
 *
 * @author Admin
 */
public abstract class CommandListener {

    private String command = null;
    
    public CommandListener(String command) {
        this.command = command;
    }
    
    public abstract void onCommand(CommandSender sender, String[] args);
    
}

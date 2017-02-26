/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.iHDeveloper.system.command;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CommandManager {
    
    private static List<Command> commands = new ArrayList<>();
    
    public static void addCommand(Command command){
        commands.add(command);
    }
    
}

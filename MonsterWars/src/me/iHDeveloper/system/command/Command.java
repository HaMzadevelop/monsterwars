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
public abstract class Command {
    
    private List<CommandListener> listeners = new ArrayList<>();

    private CommandLoader loader = null;
    
    private String command = null;
    
    public Command(String command, CommandLoader loader) {
        this.command = command;
        this.loader = loader;
    }
    
    void addListener(CommandListener listener){
        listeners.add(listener);
    }
    
    protected void load(){
        loader.load();
    }
    
    
    
    
    
}

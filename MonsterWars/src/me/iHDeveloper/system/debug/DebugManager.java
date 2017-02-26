/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.iHDeveloper.system.debug;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import me.iHDeveloper.util.ChatUtilities;

/**
 *
 * @author Admin
 */
public class DebugManager {
    
    private static List<String> log = new ArrayList<>();
    
    public static void load(){
        // TODO load commmand
    }
    
    public static void send(String message){
        String time = DateFormat.getTimeInstance().getTimeZone().toString();
        ChatUtilities.sendToConsole("["+time+"] : "+message);
    }
    
}

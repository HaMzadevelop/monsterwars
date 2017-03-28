
package me.iHDeveloper.entity.zombie;

import me.iHDeveloper.player.Player;
import me.iHDeveloper.system.debug.DebugManager;
import me.iHDeveloper.team.Team;
import net.minecraft.server.v1_8_R1.EntityZombie;
import net.minecraft.server.v1_8_R1.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_8_R1.PlayerConnection;
import net.minecraft.server.v1_8_R1.World;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;


public class ZombieObject extends EntityZombie{
    
    private Team team;

    public ZombieObject() {
        super(null);
    }
    
    public ZombieObject(Team team, World world) {
        this(world);
        this.team = team;
    }
    
    public ZombieObject(World world) {
        super(world);
    }
    
    public void display(Player player){
        DebugManager.info("Show zombie["+team.getName()+"] in player["+player.getName()+"]");
        PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(this);
        PlayerConnection connection = ((CraftPlayer)player.getPlayer()).getHandle().playerConnection;
        connection.sendPacket(packet);
    }
    
    @Override
    public void move(double x, double y, double z){
    }
    
    public int getHeal(){
        return Math.round(super.getHealth());
    }
    
    public void setTeam(Team team){
        this.team = team;
    }
    
    public void setup(){
        String name = team.getPrefix()+"["+team.getName().toUpperCase()+"] &eHP >> &a"+getHeal();
        name = color(name); // color zombie name
        super.setCustomNameVisible(true);
        super.setCustomName(name);
        
    }
    
    private String color(String format){
        return ChatColor.translateAlternateColorCodes('&', format);
    }
    
    public Team getTeam(){
        return team;
    }
    
}

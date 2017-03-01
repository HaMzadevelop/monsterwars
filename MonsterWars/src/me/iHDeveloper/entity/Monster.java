package me.iHDeveloper.entity;

import java.util.ArrayList;
import java.util.List;

import me.iHDeveloper.entity.skeleton.Skeleton;
import me.iHDeveloper.entity.zombie.Zombie;

public class Monster{
  
  public static Monster[] getMonsters(String name){
    List<Monster> monsters = new ArrayList<Monster>();
    monsters.add(new Zombie(name));
    monsters.add(new Skeleton(name));
    return monsters.toArray(new Monster[0]);
  }
  
  // Only for monsters to
}

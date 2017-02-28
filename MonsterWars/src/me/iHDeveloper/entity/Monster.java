package me.iHDeveloper.entity;

public class Monster{
  
  public static Monster[] getMonsters(){
    List<Monster> monsters = new ArrayList<Monster>();
    monsters.add(new Zombie());
    monsters.add(new Skeleton());
    return monsters.toArray(new Monster[0]);
  }
  
  // Only for monsters to
}

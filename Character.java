import java.util.*;
import java.io.*;

public class Character{
  private String name;
  private int hp;
  private int skill;
  private Weapon weapon;
  private Shield shield;

  public Character(String name, int skill, Weapon weapon, Shield shield){
    this.hp = 100;
    this.name = name;
    this.skill = skill;
    this.weapon = weapon;
    this.shield = shield;
  }

  public int hit(Character annan){
    Random randomGenerator = new Random();
    int bonk = randomGenerator.nextInt(100);
    if(bonk < skill){
      int tjoff = weapon.damage() - annan.getShield().absorbDamage();
      if(tjoff > 0){
        System.out.println(name + " träffade och gav " + tjoff + " i skada");
        return tjoff;
      }
    }
    System.out.println(name + " missade. Klang");
    return 0;
  }

  public void saveCharacter(){
    String filnamn = "saves/charsave.txt";
    String resultat = name + " " + hp + " " + skill;
    try{
      FileWriter fw = new FileWriter(new File(filnamn));
      fw.write(resultat);
      fw.close();	    
    }
    catch(IOException e) {
      System.out.println("Hoppsan (" + e.toString() + ")");
    }
  }

  public static Character loadCharacter(){
    String filnamn = "saves/charsave.txt";
    String resultat = "";
    try {
      FileReader fr = new FileReader(new File(filnamn));
      int a = fr.read();
      char b;
      while(a != -1) {
        b = (char)a;
        resultat += b;
	a = fr.read();
      }
      fr.close();	
    }
    catch(FileNotFoundException e) {
      System.out.println("Hittade inte filen (" + e.toString() + ")");
    }
    catch(IOException e) {
      System.out.println("Hoppsan! (" + e.toString() + ")");
    }
    StringTokenizer st = new StringTokenizer(resultat);
    String name = st.nextToken();
    int hp = Integer.parseInt(st.nextToken());
    int skill = Integer.parseInt(st.nextToken());
    return new Character(name, skill, new Weapon(), new Shield());
  }

  public void dies(){
    System.out.println("Aaaaaargh!");
  }

  public String getName(){
    return name;
  }

  public void setHp(int hp){
    this.hp = hp;
  }

  public int getHp(){
    return hp;
  }

  public Shield getShield(){
    return shield;
  }

  public Weapon getWeapon(){
    return weapon;
  }
}
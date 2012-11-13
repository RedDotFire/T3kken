import java.util.*;

public class Character{
	private String name;
	private int hp;
	private int hitChance;
	private double shield;
	private Weapon weapon;
	
	public Character(String name, int userHitChance, Weapon weapon, double userShield){
	this.hp = 100;
	this.name = name;
	this.hitChance = userHitChance;
	this.shield = userShield;
	this.weapon = weapon;
	}
	
	public int hit(){
		Random randomGenerator = new Random();
		int bonk = randomGenerator.nextInt(100);
		if(bonk < hitChance){
			int damage = weapon.damage();
			if(shield != 0){
			double shieldAbsorb = 1 - (shield / 100);
			damage *= shieldAbsorb;
			}
		System.out.println(name + " Träffade. Tjoff! och gjorde " + damage);

			return damage;
		}
		System.out.println(name + " Missade. Klang");
		return 0;
	}
	public void dies(){
		System.out.println("Aaaaaargh");
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
	public double getShield(){
		return shield;
	}
	public Weapon getWeapon(){
		return weapon;
	}
}
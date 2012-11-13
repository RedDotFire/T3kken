import java.util.*;

public class Weapon{
	private String type;
	private int damageMax;
	private int damageMin;
	
	public Weapon(){
		type = "longsword";
		damageMax = 12;
		damageMin = 4;
	}
	
	public Weapon(String type, int damageMin, int damageMax){
		this.type = type;
		this.damageMax = damageMax;
		this.damageMin = damageMin;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return type;
	}
	
	public void setDamageMin(int damageMin){
		this.damageMin = damageMin;
	}
	public int getDamageMin(){
		return damageMin;
	}
	
	public void setDamageMax(int damageMax){
		this.damageMax = damageMax;
	}
	public int getDamageMax(){
		return damageMax;
	}
	public int damage(){
		Random randomGenerator = new Random();
		int dg = randomGenerator.nextInt(damageMax - (damageMin - 1));
		int dam = damageMin + dg;
		return dam;
	}
}
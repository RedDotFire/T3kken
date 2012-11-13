public class Game{

private static Character setUpCharacter(String mvh){
	System.out.println(mvh);
	String name = Keyboard.readString();
	System.out.println( "Vilket vapen?");
	Weapon weapon = setupWeapon();
	System.out.println( "Hit chance?");
	int userHitChance = Keyboard.readInt();
	System.out.println("Shield?");
	int userShield = Keyboard.readInt();	
	
	Character denna = new Character(name, userHitChance, weapon, userShield);
	return denna;
}
	
	private static Weapon setupWeapon(){
		System.out.println(" Vill du ha ett Longsword?");
		String svar = Keyboard.readString();
		if(svar.equalsIgnoreCase("ja"))
			return new Weapon();
		System.out.println("Hepp, vilket vapen vill du d� ha?");
		String typ = Keyboard.readString();
		System.out.println("Vad �r minsta skadan som vapnet g�r?");
		int damageMin = Keyboard.readInt();
		System.out.println("och max skadan?");
		int damageMax = Keyboard.readInt();
		return new Weapon(typ, damageMin, damageMax);
	}

private static boolean fajt(Character a, Character b){
	int dam = a.hit();
	b.setHp(b.getHp() - dam);
	if(b.getHp() < 1){
	b.dies();
	System.out.println(a.getName() + " har krossat " + b.getName());
	System.out.println("Det verkar som om " + a.getWeapon().getType() + " �r ett �verl�gset vapen");
	
	return false;
	}
return true;
}

public static void main(String[] args){
	boolean igen = true;
		while(igen){
	System.out.println("V�lkomna till aftonens huvudatteraktion");
	Character a = setUpCharacter("I v�nster ringh�rna har vi?");
	Character b = setUpCharacter("och i den h�gra har vi?");
	boolean mer = true;
	while(mer){
		mer = fajt(a,b);
		if(mer)
			mer = fajt(b, a);
	}
	System.out.println("\nEn g�ng till?");
		String svar = Keyboard.readString();
		if(svar.equalsIgnoreCase("nej"))
			igen = false;
		}//while
} //Main
}
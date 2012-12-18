public class SetUp{ 

  public static Character setupCharacter(String mvh){
    System.out.println(mvh);
    String namn = Keyboard.readString();
    System.out.println("Skill?");
    int skill = Keyboard.readInt();
    Weapon vapen = setupWeapon();
    Shield skold = setupShield();
    return new Character(namn, skill, vapen, skold);
  }

  public static Weapon setupWeapon(){
    System.out.println("Vill du ha ett longsword?");
    String svar = Keyboard.readString();
    if(svar.equalsIgnoreCase("ja"))
      return new Weapon();
    System.out.println("Vilket vapen vill du ha?");
    String typ = Keyboard.readString();
    System.out.println("Vad �r minimiskadan p� det vapnet?");
    int minskada = Keyboard.readInt();
    System.out.println("Och maxskadan?");
    int maxskada = Keyboard.readInt();
    return new Weapon(typ, minskada, maxskada);
  }

  public static Shield setupShield(){
    System.out.println("Vill du ha en sk�ld");
    String svar = Keyboard.readString();
    if(svar.equalsIgnoreCase("nej"))
      return new Shield();
    System.out.println("Vilken sk�ld vill du ha?");
    String typ = Keyboard.readString();
    System.out.println("Vad �r minimiskyddet p� den sk�lden?");
    int minskydd = Keyboard.readInt();
    System.out.println("Och maxskyddet?");
    int maxskydd = Keyboard.readInt();
    return new Shield(typ, minskydd, maxskydd);
  }
}
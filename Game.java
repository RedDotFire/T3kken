public class Game{

  public void go(){
    System.out.println("V�lkommen till aftonens huvudattraktion");
    Character a = SetUp.setupCharacter("I v�nster ringh�rna ser vi?");
    Character b = Character.loadCharacter();
    System.out.println("och i h�ger har vi " + b.getName());
    a.saveCharacter();
    Event e = new Event();
    e.fajt(a, b);
  }
}
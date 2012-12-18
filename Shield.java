import java.util.*;

public class Shield{
  private String type;
  private int minabsorb;
  private int maxabsorb;

  public Shield(){
    type = "no shield";
    minabsorb = 0;
    maxabsorb = 0;
  }

  public Shield(String type, int minabsorb, int maxabsorb){
    this.type = type;
    this.minabsorb = minabsorb;
    this.maxabsorb = maxabsorb;
  }

  public String getType(){
    return type;
  }

  public int absorbDamage(){
    if(maxabsorb < 1)
      return 0;
    Random randomGenerator = new Random();
    int abs = randomGenerator.nextInt(maxabsorb - (minabsorb - 1));
    int absorb = minabsorb + abs;
    return absorb;
  }
}
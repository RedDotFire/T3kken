import java.io.*;

public class Filskrivare {
    public static void main(String[] args) {
	if(args.length != 1) {
	    System.out.println("Ange ett argument");
	    System.exit(1);
	}
	String filnamn = args[0];

	String rad;
	String resultat = "";
	System.out.println("** Skriv så länge du orkar **");
	System.out.println("** Avsluta med 'stop'      **");

	try {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    System.out.print("$ ");
	    rad = br.readLine();
	    while(!rad.equals("stop")) {
		resultat += rad;
		resultat += '\n';
		System.out.print("$ ");
		rad = br.readLine();
	    }
	    
	    FileWriter fw = new FileWriter(new File(filnamn));

	    fw.write(resultat);

	    fw.close();	    
	}
	catch(IOException e) {
	    System.out.println("Hoppsan (" + e.toString() + ")");
	}
    }
}
import java.io.*;

public class Fillasare {
    public static void main(String[] args) {
	if( args.length != 1 ) {
	    System.out.println("Ange en fil som argument!");
	    System.exit(1);
	}

	String filnamn = args[0];

	System.out.println("Filnamn -->" + filnamn);

	try {
	    // Skapa en ny filläsare
	    FileReader fr = new FileReader(new File(filnamn));

	    int a = fr.read();
	    char b;
	    while(a != -1) {
		b = (char)a;
		System.out.print(b);
		a = fr.read();
	    }

	    // Stäng filen
	    fr.close();	
	}
	catch(FileNotFoundException e) {
	    System.out.println("Hittade inte filen (" + e.toString() + ")");
	}
	catch(IOException e) {
	    System.out.println("Hoppsan! (" + e.toString() + ")");
	}

	System.out.println();
    }
}
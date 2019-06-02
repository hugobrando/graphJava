package maze;
import graph.Vertex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainMaze{

	public static void main(String[] args){
		Game labi = new Game();

		// affichage du labyrinthe
		System.out.println(labi.toString());
		
		// affichage des voisins ou peut aller la cellule 2 ( cellule (0,2) )
		Vertex[] voisins = labi.getNeighbours(2);
		for(int i=0; i<voisins.length;i++){
			System.out.println(voisins[i].toString());
		}
		
		
		//Serializable
		
		String filename = "time.ser";

	    // save the object to file
	    FileOutputStream fos = null;
	    ObjectOutputStream out = null;
	    try {
	        fos = new FileOutputStream(filename);
	        out = new ObjectOutputStream(fos);
	        out.writeObject(labi);

	        out.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    
	    
	    // read the object from file
	    // save the object to file
	    FileInputStream fis = null;
	    ObjectInputStream in = null;
	    try {
	        fis = new FileInputStream(filename);
	        in = new ObjectInputStream(fis);
	        labi = (Game) in.readObject();
	        in.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    System.out.println(labi.toString());
	    
	    
	}
	
}

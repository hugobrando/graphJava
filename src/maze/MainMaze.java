package maze;
import graph.Vertex;

public class MainMaze{

	public static void main(String[] args){
		Game labi = new Game();

		
		System.out.println(labi.toString());
		
		Vertex[] voisins = labi.getNeighbours(8);
		for(int i=0; i<voisins.length;i++){
			System.out.println(voisins[i].toString());
		}
	}

}
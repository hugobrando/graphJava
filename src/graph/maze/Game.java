package maze;
import graph.Vertex;
import java.io.Serializable;

public class Game implements Serializable{
	private transient Maze labi;

	public Game() {
		this.labi = new Maze(3,3,0,0,2,2);
		
		labi.addEdge(0,0,0,1);
		labi.addEdge(0,1,0,2);
		labi.addEdge(0,2,1,2);
		labi.addEdge(1, 2, 2, 2);
		labi.addEdge(0,0,1,0);
		labi.addEdge(1,0,2,0);
		labi.addEdge(2,0,2,1);
		labi.addEdge(2, 1, 2, 2);
		labi.addWall(1,1);
	}
	
	
	public String toString() {
		return this.labi.toString();
	}
	
	public Vertex[] getNeighbours(int id) {
		return labi.getNeighbours(id);
	}
}

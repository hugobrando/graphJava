package maze;
import graph.Vertex;
import graph.Edge;

public class MainMaze{

	public static void main(String[] args){
		Maze labi = new Maze(3,3,0,0,2,2);

		labi.addEdge(0,0,0,1);
		labi.addEdge(0,1,0,2);
		labi.addEdge(0,2,1,2);
		labi.addEdge(0,0,1,0);
		labi.addEdge(1,0,2,0);
		labi.addEdge(2,0,2,1);
		labi.addWall(1,1);
		System.out.println(labi.toString());
	}

}
package graphImpl;

import graph.Vertex;
import graph.Edge;


public class TestGraphImpl {

	public static void main(String[] args){

		GraphCode monGraph = new GraphCode();

		Vertex v1 = new Vertex(1,3,5);
		Vertex v2 = new Vertex(2,1,8);
		Vertex v3 = new Vertex(3,7,3);

		Edge e1 = new Edge(1,v1,v2);
		Edge e2 = new Edge(2,v2,v3);

		monGraph.addVertex(v1);
		monGraph.addVertex(v2);
		monGraph.addVertex(v3);

		monGraph.addEdge(e1);
		monGraph.addEdge(e2);

		Vertex[] voisin1=monGraph.getNeighbours(1); //Tableau avec les voisins du vertex v1
		
		for(int i=0;i<voisin1.length;i++){
			if(voisin1[i].getId()==2){ //Si un voisin est en fait le vertex v2
				System.out.println("Il existe bien un arc entre le vertex 1 et le vertex 2");
			}
		}
	}
}
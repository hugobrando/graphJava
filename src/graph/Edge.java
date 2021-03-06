package graph;

import java.io.Serializable;

public class Edge implements Serializable{
	private int id;
	private Vertex newa;
	private Vertex newb;

	public Edge(int id, Vertex newa, Vertex newb){
		this.id = id;
		this.newa = newa;
		this.newb = newb;
	}

	public int getId(){
		return this.id;
	}

	public Vertex getNewa(){
		return this.newa;
	}

	public Vertex getNewb(){
		return this.newb;
	}
}
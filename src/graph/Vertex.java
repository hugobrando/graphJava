package graph;

public class Vertex{
	private int id;
	private float x;
	private float y;

	public Vertex(int id, float x, float y){
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public int getId(){
		return this.id;
	}
	
	public float getX(){
		return this.x;
	}
	
	public float getY(){
		return this.y;
	}
}
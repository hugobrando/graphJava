package maze;
import graph.Vertex;

public class WBox extends Vertex{
	public WBox(int id, float x, float y){
		super(id,x,y);
	}
	
	public String toString() {
		return "Cellule ("+(int)this.getX()+","+(int)this.getY()+") ";
	}
}

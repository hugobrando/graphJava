package maze;
import graph.Vertex;

public class EBox extends Vertex{
	public EBox(int id, float x, float y){
		super(id,x,y);
	}
	public String toString() {
		return "Cellule ("+(int)this.getX()+","+(int)this.getY()+") ";
	}
}
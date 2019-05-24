package maze;
import graph.Vertex;
import graph.Edge;

public class Maze{
	int longeur;
	int largeur;
	Vertex[][] maze;
	Edge[] pont;
	int nbEdge;
 
	public Maze(int longeur, int largeur, int loD, int laD, int loA, int laA)
	{
		this.longeur = longeur;
		this.largeur = largeur;
		this.maze = new Vertex[longeur][largeur];
		this.maze[loD][laD] = new DBox(1,loD,laD);
		this.maze[loA][laA] = new ABox(2,loA,laA);
		this.nbEdge = 0;
		this.pont = new Edge[100];
	}

	public void addWall(int lon, int lar){
		this.maze[lon][lar] = new WBox(3,lon,lar);
	}

	public void addEdge(int l1, int l2, int l3, int l4){
		if(!(this.maze[l1][l2] instanceof ABox) && !(this.maze[l1][l2] instanceof DBox)){
			this.maze[l1][l2] = new EBox(4,l1,l2);
		}
		if(!(this.maze[l3][l4] instanceof ABox) && !(this.maze[l3][l4] instanceof DBox)){
			this.maze[l3][l4] = new EBox(4,l3,l4);
		}
		pont[this.nbEdge] = new Edge(1,this.maze[l1][l2],this.maze[l3][l4]);
	}

	public String toString(){
		String text = "";
		for(int i=0; i<longeur;i++){
			for(int j=0; j<largeur;j++){
				if(this.maze[i][j] instanceof DBox){
					text += "D ";
				}
				else if(this.maze[i][j] instanceof ABox){
					text += "A ";
				}
				else if(this.maze[i][j] instanceof WBox){
					text += "O ";
				}
				else{
					text += ". ";
				}
			}
			text+="\n";
		}
		return text;
	}

}
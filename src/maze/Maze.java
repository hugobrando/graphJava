package maze;

import graph.Edge;
import graph.Vertex;
import graphImpl.GraphCode;

public class Maze{
	int longeur;
	int largeur;
	GraphCode[] maze;
	Edge[] pont;
	int nbEdge;
 
 	// on initalise le labyrinthe avec des EBox de partout et une DBox et une ABox
	public Maze(int longeur, int largeur, int loD, int laD, int loA, int laA)
	{
		this.longeur = longeur;
		this.largeur = largeur;
		this.maze = new GraphCode[largeur];
		for(int k=0;k<largeur;k++) {
			this.maze[k]= new GraphCode();
		}
		for(int i =0;i<largeur;i++){
			for(int j=0; j<longeur;j++){
				EBox b = new EBox(i*longeur+j,i,j); //chaque case a un id different
				this.maze[i].addVertex(b);
			}
		}
		this.maze[laD].setVertex(laD*longeur+loD, new DBox(laD*longeur+loD,loD,laD));
		this.maze[laA].setVertex(laA*longeur+loA, new ABox(laA*longeur+loA,loA,laA));
		this.nbEdge = 0;
		this.pont = new Edge[100];
	}

	public void addWall(int lon, int lar){
		this.maze[lar].setVertex(lon+lar*this.longeur, new WBox(lon+lar*this.longeur,lon,lar));
	}

	public void addEdge(int lo1, int la1, int lo2, int la2){
		pont[this.nbEdge] = new Edge(lo1+la1*this.longeur+lo2+la2*this.longeur,this.maze[la1].getVertex(lo1+la1*this.longeur),this.maze[la2].getVertex(lo2+la2*this.longeur));
		nbEdge += 1;
	}

	public String toString(){
		String text = "";
		for(int j=0; j<largeur;j++){
			for(int i=0; i<longeur;i++){

				if(this.maze[j].getVertex(i*this.longeur+j) instanceof DBox){
					text += "D ";
				}
				else if(this.maze[j].getVertex(i*this.longeur+j) instanceof ABox){
					text += "A ";
				}
				else if(this.maze[j].getVertex(i*this.longeur+j) instanceof WBox){
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
	
	public Vertex[] getNeighbours(int id){
		Vertex[] voisins = new Vertex[100];
		int nbVoisins = 0;
		for(int i=0;i<this.nbEdge;i++){
			if(this.pont[i].getNewa().getId() == id){
				 voisins[nbVoisins] = pont[i].getNewb();
				 nbVoisins += 1;
			}
			else if(this.pont[i].getNewb().getId() == id){
				 voisins[nbVoisins] = pont[i].getNewa();
				 nbVoisins += 1;
			}
		}
		Vertex[] resultat = new Vertex[nbVoisins];
		for(int j=0;j<nbVoisins;j++){
			resultat[j] = voisins[j];
		}
		return resultat;

	}

}
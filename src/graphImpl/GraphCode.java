package graphImpl;

import graph.Vertex;
import graph.Edge;
import graph.Graph;

import java.io.Serializable;


// on admet qu'ils ont fait la fonction getId() pour Vertex et Edge



public class GraphCode implements Serializable, Graph{ // implements l'interface graph dans le .jar mais le .jar n'est pas executable donc j'ai extrait le Graph.class est l'ai mit dans bin

	private Vertex[] mesVertex;
	private Edge[] mesEdge;
	private int nbVertex;
	private int nbEdge;


	public GraphCode(){
		this.nbVertex = 0;
		this.nbEdge = 0;
		this.mesVertex = new Vertex[100];
		this.mesEdge = new Edge[100];
	}

	public void addEdge(Edge e){
		this.mesEdge[this.nbEdge] = e;
		this.nbEdge += 1;
	}

	public void addVertex(Vertex v){
		this.mesVertex[this.nbVertex] = v;
		this.nbVertex += 1;
	}

	public void setVertex(int id, Vertex newVertex){
		for(int i=0; i<nbVertex;i++){
			if(mesVertex[i].getId() == id){
				mesVertex[i] = newVertex;
			}
		}
	}

	public Vertex getVertex(int id) {
		for(int i=0; i<nbVertex;i++){
			if(mesVertex[i].getId() == id){
				return mesVertex[i];
			}
		}
		return null;
	}

	public void deleteEdge(Edge e){
		for(int i=0;i<this.nbEdge;i++){
			if(mesEdge[i].getId() == e.getId()){
				mesEdge[i] = mesEdge[this.nbEdge-1];
				mesEdge[this.nbEdge-1] = e;
			}
		}
		if(mesEdge[this.nbEdge-1].getId() == e.getId()){ // pour ne rien faire si le v n'existe pas dans le tableau
			mesEdge[this.nbEdge-1] = null;
			nbEdge -= 1;
		}
	}

	public void deleteVertex(Vertex v){
		for(int i=0;i<this.nbVertex;i++){
			if(mesVertex[i].getId() == v.getId()){
				mesVertex[i] = mesVertex[this.nbVertex-1];
				mesVertex[this.nbVertex-1] = v;
			}
		}
		if(mesVertex[this.nbVertex-1].getId() == v.getId()){ // pour ne rien faire si le v n'existe pas dans le tableau
			mesVertex[this.nbVertex-1] = null;
			nbVertex -= 1;
		}
	}

	public Edge getEdgeById(int id){
		for(int i=0;i<this.nbEdge;i++){
			if(mesEdge[i].getId() == id){
				 return mesEdge[i];
			}
		}
		return null;
	}

	public Vertex[] getNeighbours(int id){
		Vertex[] voisins = new Vertex[100];
		int nbVoisins = 0;
		for(int i=0;i<this.nbEdge;i++){
			if(mesEdge[i].getNewa().getId() == id){
				 voisins[nbVoisins] = mesEdge[i].getNewb();
				 nbVoisins += 1;
			}
			else if(mesEdge[i].getNewb().getId() == id){
				 voisins[nbVoisins] = mesEdge[i].getNewa();
				 nbVoisins += 1;
			}
		}
		Vertex[] resultat = new Vertex[nbVoisins];
		for(int j=0;j<nbVoisins;j++){
			resultat[j] = voisins[j];
		}
		return resultat;

	}

	public int countEdge(){
		return this.nbEdge;
	}

	public int countVertex(){
		return this.nbVertex;
	}

	public boolean isConnexe(){ // j'ai fais le choix de ne pas implémenter cette fonction car elle ne nous est pas utile pour la suite
		return true;
	}

	public boolean existEdge(Vertex v1, Vertex v2){
		boolean resultat = false;
		for(int i=0;i<this.nbEdge;i++){
			if((mesEdge[i].getNewa().getId() == v1.getId() && mesEdge[i].getNewb().getId() == v2.getId()) || (mesEdge[i].getNewa().getId() == v2.getId() && mesEdge[i].getNewb().getId() == v1.getId())){
				 resultat = true;
			}
		}
		return resultat;
	}
}

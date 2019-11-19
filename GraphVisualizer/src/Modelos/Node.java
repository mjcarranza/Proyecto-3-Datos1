package Modelos;

import java.util.ArrayList;

import Modelos.Arista;

public class Node {
    private int value;
    private ArrayList aristasList;
    private boolean visited;
    private Arista arista;

    public Node(int idGrafo, int value) {
        this.value = value;
        this.aristasList = new ArrayList();
        this.visited = false;
        
    }

    public int getValue() {
        return this.value; 
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ArrayList getNodesDestination() {
        ArrayList nodesDestination = new ArrayList();
        for(Arista arista : aristasList) {
                nodesDestination.add(arista.getDestination());
        }
        return nodesDestination;
    }

    public ArrayList getAristas() {
        return aristasList;
    }

    public void addArista(Node pNode, int pWeight) {
        if (pNode != this) {
                aristasList.add(new Arista(this, pNode, pWeight));
        }
    }
    public void ActualizarArista(Node Origen, Node Destino, int Peso){ ///////////// REVISAR ///// REVISAR ///// REVISAR ///// REVISAR///// REVISAR///// REVISAR/////
        arista.setOrigin(Origen);
        arista.setDestination(Destino);
        arista.setWeight(Peso);
    }///////////// REVISAR ///// REVISAR ///// REVISAR ///// REVISAR///// REVISAR///// REVISAR////////////////// REVISAR ///// REVISAR ///// REVISAR /////

    public Arista getArista(Node pDestination) {
        for (Arista arista : this.aristasList){
            if (arista.getDestination() == pDestination){
                return arista;
            }
        }
        return null;
    }
}

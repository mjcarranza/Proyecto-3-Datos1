package Modelos;

import java.util.ArrayList;
import java.util.LinkedList;

import Modelos.Arista;
import Modelos.Graph;
import Modelos.Node;
/**
 * Obtener la ruta mas corta.
 * @author Mario
 */
public class Floyd{
    private ArrayList tours = new ArrayList(); // lista de tours
    private ArrayList nodes = new ArrayList(); // lista de nodos
    private ArrayList weight = new ArrayList(); // lista de pesos		
    private int numVertices;                    // numero de vertices del grafo

    public Floyd(Graph Grafo, Node Nodo){ // param grafo y nodo					
        nodes = Grafo.getNodes(); // se crea la lista de nodos con los nodos del grafo
        numVertices = nodes.size(); // se obtiene el tamano de la lista de nodos
        // crear la lista de pesos y la lista de tours
        for (int vertex = 0; vertex < numVertices; vertex++) {
            tours.add(new LinkedList()); // agragar una linkedList 
            weight.add(new LinkedList()); // agragar una linkedList			
            ArrayList nodesDestination = nodes.get(vertex).getNodesDestination;
            ArrayList aristas = nodes.get(vertex).getAristas();
            for(int subIndex = 0; subIndex < numVertices; subIndex++) {
                if(nodesDestination.contains(nodes.get(subIndex))) {
                    for(Arista  arista: aristas ) {
                        if (arista.getDestination().equals(nodes.get(subIndex))) {
                            weight.get(vertex).add(arista.getWeight());							
                        }
                    }					
                }else {
                    weight.get(vertex).add(Integer.MAX_VALUE);
                }
                tours.get(vertex).add(nodes.get(subIndex));
            }
            weight.get(vertex).set(vertex, 0);
        }	
        // continua con metodo calcFloyd();
    }
    public void calcFloyd(){
        // Minimum path of a vertex to itself: 0
        //Perform due calculations and reorganize lists
        for (int i = 0; i < numVertices; i++)
            weight.get(i).set(i, 0);
            for (int k = 0; k < numVertices; k++) {
                for (int i = 0; i < numVertices; i++) {
                    for (int j = 0; j < numVertices; j++) {
                        if ((weight.get(i).get(k) + weight.get(k).get(j)) < weight.get(i).get(j)){ // nuevo mínimo
                            int num = weight.get(i).get(k)+weight.get(k).get(j);
                            weight.get(i).set(j, num) ;
                            tours.get(i).set(j,nodes.get(k));
                        }
                    }
                }
            }
    }
}



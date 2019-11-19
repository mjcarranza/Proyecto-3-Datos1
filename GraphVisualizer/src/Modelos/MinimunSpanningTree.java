package Modelos;

import Modelos.Graph;
import Modelos.Arista;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Moving Tree Search algorithm implementations with adjacency list.
 * 
 * @param <T> El tipo de elementos en esta lista.
 * 
 * @author Mario
 */
public class MinimunSpanningTree<T> {
	
	Graph<T> aclyclicGraph;
	/*
	 * Constructor.
	 */
	public MinimunSpanningTree() {
		aclyclicGraph = new Graph<T>();
	}
	
	public void findMinimunSpanningTree(Graph<T> pGraph) {
		ArrayList<Arista<T>> arcs = pGraph.getArcs();
		ArrayList<Node<T>> unvisitedVertex = new ArrayList<Node<T>>(pGraph.getNodes());
		Collections.sort(arcs);
		Iterator<Arista<T>> iterator = arcs.iterator();
		while(!unvisitedVertex.isEmpty()) {
			Arista<T> arc = iterator.next();
			if (unvisitedVertex.contains(arc.getOrigin())) {
				unvisitedVertex.remove(arc.getOrigin());
				Node<T> originVertex  = aclyclicGraph.addNode(arc.getOrigin().getValue());
				Node<T> destinationVertex  = aclyclicGraph.addNode(arc.getDestination().getValue());
				aclyclicGraph.addArc(originVertex, destinationVertex, arc.getWeight());
				aclyclicGraph.addArc(destinationVertex, originVertex, arc.getWeight());
			}
		}
		
	}
	
	public Graph<T> getGraph() {
		return aclyclicGraph;
	}
	
}

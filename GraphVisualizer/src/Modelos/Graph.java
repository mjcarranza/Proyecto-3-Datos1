/**
 * paquete e importaciones.
 */
package Modelos;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Clase para la creacion de grafos.
 * @author Mario
 */
public class Graph{
    private ArrayList<Node> nodes;
    private ArrayList<Graph> grafos;
    private int idGrafo;
    private Arista arista;

    /**
     * Metodo para la creacion de un nuevo grafo.
     */
    public Graph() {
        nodes= new ArrayList(); // lista de nodos.
        
    }
    /**
     * Metodo para obtener la lista de nodos del grafo. 
     * @return retorna la lista de nodos.
     */
    public ArrayList<Node> getNodes() {
        return nodes; // retorna la listad de los nodos en el grafos
    }
    /**
     * Metodo para agregar nodo al grafo
     * @param idGrafo id del grafo al que se le asignara el nodo.
     * @param Value numero de telefono asociado al nodo.
     * @return retorna el nodo.
     */
    public Node addNode(int idGrafo, int Value) { // agregar nodo al grafo
        for (Node node : nodes) {
            if(node.getValue() == Value) {
                    return node;
            }
        }
        Node result = new Node(idGrafo, Value);
        nodes.add(result);
        return result;
    }
    /**
     * Metodo para agregar aristas en formato dirigido a un nodo dentro del grafo.
     * @param Origen desde donde sale el arista
     * @param Destino donde llega el arista.
     * @param pWeight peso del arista.
     */
    public void addArista(Node Origen, Node Destino, int pWeight) { // agregar aristas entre nodos de un nodo a otro
        for (Node node : nodes) {
            if (Origen == node) { // se busca el nodo de origen y se le agrega la arista
                node.addArista(Destino, pWeight);
            }
        }
    }
    public void ActualizarArista(Node Origen, Node Destino, int Peso){
        for (Node node : nodes) {
            if (Origen == node) { // se busca el nodo de origen y se le agrega la arista
                node.ActualizarArista(Origen, Destino, Peso);
            }
        }
    }
    /**
     * Metodo para obtener las aristas del grafo por medio del id.
     * @param idGrafo id del grafo al que se le vana obtener las aristas.
     * @return retorna lista de aristas.
     */
    public ArrayList<Arista> getAristas(int idGrafo) { // obtener aristas
        ArrayList<Arista> aristas = new ArrayList(); // array para almacenar las aristas del grafo
        for (Graph grafoIndex : grafos) {
            if (grafoIndex.idGrafo == idGrafo){  // falta algun ciclo o solo hay que modificar este?
                for (Node nodeIndex : nodes) {    ///////////// REVISAR ///// REVISAR ///// REVISAR ///// REVISAR///// REVISAR///// REVISAR/////
                    aristas.addAll(nodeIndex.getAristas());
                }
            }
        }
        return aristas;
    }
    /**
     * Metodo para eliminar todas las aristas del grafo identificado por id.
     * @param idGrafo id del grafo.
     */
    public void borrarAristas (int idGrafo){
        for (Graph grafoIndex : grafos) {
            if (grafoIndex.idGrafo == idGrafo){
                for (Node nodeIndex : nodes) {    ///////////// REVISAR ///// REVISAR ///// REVISAR ///// REVISAR///// REVISAR///// REVISAR/////
                    nodes.remove(idGrafo);
                }
            }
        }
    }
    /**
     * Metodo para eliminar todos los nodos de un grafo identificado por id.
     * @param idGrafo id del grafo
     */
    public void clean(int idGrafo) { // borrar todos los nodos
        for (Graph grafoIndex : grafos) {
            if (grafoIndex.idGrafo == idGrafo){
                nodes.clear();
            }
        }    
    }
/*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Node> inDepthSearch(Node start, Node end) {
        ArrayList<Node> nodesPath = new ArrayList(); // rutas de los nodos
        Stack<Node> nodesVisited = new Stack();      // nodos visitados.
        nodesVisited.push(start);                    // agregar el nodo de iicio a los nodos visitados
        while(!nodesVisited.isEmpty()) {             // mientras la lista de nodos visitados no este vacia
            Node node = nodesVisited.pop();          // nodo de tipo nodo que es igual a al ultimo elemento insertado en el array de nodos visitados
            nodesPath.add(node);                     // agregar ruta de nodo a la lista 
            if (node == end) break;
            for(Node destino : node.getNodesDestination()) {
                if (!destino.getVisited()) {
                        destino.setVisited(true);
                        nodesVisited.push(destino);                             //////// REVISAR SI FUNCIONA O SE NECESITA ///////
                }
            }
        }
        return nodesPath;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
    /**
     * Metodo para guardar grafos en un array de tipo grafo.
     * @param grafo Grafo a agregar a la lista.
     */
    public void GuardarGrafo(Graph grafo){
        grafos.add(grafo);
    }
    /**
     * Metodo para obtener la lista de grafos guardados.
     * @return Retorna la lista de grafos guardados.
     */
    public ArrayList<Graph> getListaGrafos(){
        return grafos;
    }
    /**
     * Metodo para obtener un grafo por medio de su id.
     * @param idGrafo id del grafo que se quiere obtener.
     * @return retorna el grafo encontrado
     */
    public Graph getGrafo (int idGrafo){
        for (Graph grafo : grafos) {
            if (grafo.idGrafo == idGrafo){
                return grafo;
            }
        }
        return null;
    }
    /**
     * Metodo para eliminar todos los grafos.
     */
    public void BorrarGrafos (){
        grafos.clear();        
    }
    /**
     * Metodo para eliminar un grafo utilizando su id.
     * @param idGrafo id del grafo a eliminar
     */
    public void BorrarGrafo (int idGrafo){
        for (Graph grafo : grafos) {
            if (grafo.idGrafo == idGrafo){
                //grafo.remove;       /////////// codigo para eliminar el grafo
            }
        }        
    }
    
}
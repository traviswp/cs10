import java.util.ArrayList;
import java.util.List;
import net.datastructures.*;

/**
 * Creates an adjacency representation of a graph that can have mixed edges
 * (either directed or undirected). Uses decorator pattern to mark edges as
 * directed.
 * 
 * @author Scot Drysdale
 *
 * @param <V> the type of the vertex label. (All must be unique.)
 * @param <E> the type of the edge label.
 */
public class DirectedAdjListMap<V, E> extends AdjacencyListGraphMap<V, E> {

    private final static Object EDGE_TYPE = new Object();
    private final static Object DIRECTED = new Object();

    /**
     * Is the given edge directed?
     * 
     * @param e the edge to test
     * @return true if e is directed
     */
    public boolean isDirected(Edge<E> e);

    /**
     * Insert a directed edge into this graph
     * 
     * @param v - the source vertex
     * @param w - the destination vertex
     * @param label  - the edge label
     * @return the new edge
     */
    public Edge<E> insertDirectedEdge(Vertex<V> v, Vertex<V> w, E label);

    /**
     * Insert a directed edge into this graph
     * 
     * @param v - the source vertex identifier
     * @param w - the destination vertex identifier
     * @param label - the edge label
     * @return the new edge
     */
    public Edge<E> insertDirectedEdge(V v, V w, E label);

    /**
     * Get all incident edges with v as destination
     * 
     * @param v the destination vertex
     * @return collection of incident edges with v as destination
     */
    public Iterable<Edge<E>> incidentEdgesIn(Vertex<V> v);

    /**
     * Get all incident edges with v as destination
     * 
     * @param v the destination vertex identifier
     * @return collection of incident edges with v as destination
     */
    public Iterable<Edge<E>> incidentEdgesIn(V v);

    /**
     * Get all incident edges with v as source
     * 
     * @param v the source vertex
     * @return collection of incident edges with v as source
     */
    public Iterable<Edge<E>> incidentEdgesOut(Vertex<V> v);

    /**
     * Get all incident edges with v as source
     * 
     * @param v the source vertex identifier
     * @return collection of incident edges with v as source
     */
    public Iterable<Edge<E>> incidentEdgesOut(V v);

    /**
     * Get the in degree of a vertex
     * 
     * @param v the vertex
     * @return the in degree of v
     */
    public int inDegree(Vertex<V> v);

    /**
     * Get the in degree of a vertex
     * 
     * @param v the vertex identifier
     * @return the in degree of v
     */
    public int inDegree(V v);

    /**
     * Get the out degree of a vertex
     * 
     * @param v the vertex
     * @return the out degree of v
     */
    public int outDegree(Vertex<V> v);

    /**
     * Get the out degree of a vertex
     * 
     * @param v the vertex identifier
     * @return the out degree of v
     */
    public int outDegree(V v);

    /**
     * Test program
     */
    public static void main(String[] args) {
        DirectedAdjListMap<String, String> baconGraph = new DirectedAdjListMap<String, String>();

        baconGraph.insertVertex("Kevin Bacon");
        baconGraph.insertVertex("Laura Linney");
        baconGraph.insertVertex("Tom Hanks");
        baconGraph.insertVertex("Liam Neeson");
        baconGraph.insertDirectedEdge("Laura Linney", "Kevin Bacon", "Mystic River");
        baconGraph.insertEdge("Liam Neeson", "Laura Linney", "Kinsey");
        baconGraph.insertDirectedEdge("Tom Hanks", "Kevin Bacon", "Apollo 13");

        System.out.println("\nDegree of Laura Linney = "
                + baconGraph.degree("Laura Linney"));

        System.out.println("\nInDegree of Laura Linney = "
                + baconGraph.inDegree("Laura Linney"));

        System.out.println("\nOutDegree of Laura Linney = "
                + baconGraph.outDegree("Laura Linney"));

        System.out.println("\nEdges into to Laura Linney:");
        for (Edge<String> edge : baconGraph.incidentEdgesIn("Laura Linney"))
            System.out.println(edge);

        System.out.println("\nEdges out of to Laura Linney:");
        for (Edge<String> edge : baconGraph.incidentEdgesOut("Laura Linney"))
            System.out.println(edge);

        System.out.println("The entire graph:");
        for (Vertex<String> vertex : baconGraph.vertices()) {
            System.out.println("\nEdges adjacent to " + vertex + ":");
            for (Edge<String> edge : baconGraph.incidentEdges(vertex))
                System.out.println(edge);

            System.out.println("\nEdges into " + vertex + ":");
            for (Edge<String> edge : baconGraph.incidentEdgesIn(vertex))
                System.out.println(edge);

            System.out.println("\nEdges out of " + vertex + ":");
            for (Edge<String> edge : baconGraph.incidentEdgesOut(vertex))
                System.out.println(edge);
        }

        System.out.println("\nRenaming Laura Linney to L. Linney");
        baconGraph.replace("Laura Linney", "L. Linney");
        System.out.println("\nGetting Laura Linney: "
                + baconGraph.getVertex("Laura Linney"));

        for (Vertex<String> vertex : baconGraph.vertices()) {
            System.out.println("\nEdges adjacent to " + vertex + ":");
            for (Edge<String> edge : baconGraph.incidentEdges(vertex))
                System.out.println(edge);
        }
        System.out.println("\nRemoving L. Linney");
        baconGraph.removeVertex("L. Linney");

        System.out.println("\nThe entire graph:");
        for (Vertex<String> vertex : baconGraph.vertices()) {
            System.out.println("\nEdges adjacent to " + vertex + ":");
            for (Edge<String> edge : baconGraph.incidentEdges(vertex))
                System.out.println(edge);

            System.out.println("\nEdges into " + vertex + ":");
            for (Edge<String> edge : baconGraph.incidentEdgesIn(vertex))
                System.out.println(edge);

            System.out.println("\nEdges out of " + vertex + ":");
            for (Edge<String> edge : baconGraph.incidentEdgesOut(vertex))
                System.out.println(edge);
        }
    }
}

package edu.mum.Graph.DisjointSet;

/**
 * Created by hungduong on 11/13/16.
 * Running time is O(Elog(V))
 */
public class UndirectedGraph {
    class Edge {
        int src, dest;
    }

    int V, E; // V-> no. of vertices & E->no.of edges
    Edge[] edges; // /collection of all edges

    // Creates a graph with V vertices and E edges
    public UndirectedGraph(int v, int e) {
        V = v;
        E = e;

        edges = new Edge[E];
        for(int i=0; i<E; i++) {
            edges[i] = new Edge();
        }
    }

    // A utility function to find the subset of an element i
    public int find(int[] parent, int i) {
        if(parent[i] == -1) {
            return i;
        }

        return find(parent, parent[i]);
    }

    // A utility function to do union of two subsets
    public void union(int[] parent, int x, int y) {
        int xSubset = find(parent, x);
        int ySubset = find(parent, y);

        parent[xSubset] = ySubset;
    }

    // The function used to check whether a given graph contains cycle or not
    public boolean isCycle(UndirectedGraph graph) {
        // Allocate memory for creating V subsets
        int[] parent = new int[graph.V];

        // Initialize all subsets as single element sets
        for(int i=0; i<graph.V; i++) {
            parent[i] = -1;
        }

        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for(int e=0; e<graph.E; e++) {
            int x = find(parent, graph.edges[e].src);
            int y = find(parent, graph.edges[e].dest);

            if(x == y) {
                return true;
            }

            graph.union(parent, x, y);
        }

        return false;
    }

    public static void main(String[] args) {
        /* Let us create following graph
         0    3
        |  \  |
        |    \|
        1-----2 */

        int V = 4, E = 4;
        UndirectedGraph graph = new UndirectedGraph(V, E);

        // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;

        // add edge 1-2
        graph.edges[1].src = 1;
        graph.edges[1].dest = 2;

        // add edge 2-3
        graph.edges[2].src = 2;
        graph.edges[2].dest = 3;

        // add edge 0-2
        graph.edges[3].src = 0;
        graph.edges[3].dest = 2;

        if (graph.isCycle(graph))
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );

    }
}

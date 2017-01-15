package edu.mum.Graph.DFSApplication;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by hungduong on 11/13/16.
 * Running time is O(V+E)
 */
public class UndirectedGraphDetectCycle {
    private int V;  //No. of vertices

    //Array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];


    public UndirectedGraphDetectCycle(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    //Function to add an edge into GraphBFS
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Returns true if the graph contains a cycle, else false.
    public boolean isCyclic() {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        for(int v = 0; v < V; v++) {
            visited[v] = false;
        }

        // Call the recursive helper function to detect cycle in different DFS trees
        for(int v = 0; v < V; v++) {
            if(!visited[v])
                if(isCyclicHelper(v, visited, -1))
                    return true;
        }

        return false;
    }

    // A recursive function that uses visited[] and parent to detect
    // cycle in subgraph reachable from vertex v.
    public boolean isCyclicHelper(int v, boolean[] visited, int parent) {

        // Mark the current node as visited
        visited[v] = true;
        int i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].listIterator();
        while (it.hasNext()) {
            i = it.next();

            // If an adjacent is not visited, then recur for that
            // adjacent
            if(!visited[i]) {
                if(isCyclicHelper(i, visited, v))
                    return true;
            }
            // If an adjacent is visited and not parent of current
            // vertex, then there is a cycle.
            else if(i != parent) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        UndirectedGraphDetectCycle graph = new UndirectedGraphDetectCycle(7);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 0);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        if(graph.isCyclic())
            System.out.print("Graph contains cycle");
        else
            System.out.print("Graph doesn't contain cycle");

        return;
    }
}

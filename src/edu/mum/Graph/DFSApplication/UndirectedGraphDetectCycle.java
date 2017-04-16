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
        adj[w].add(v);
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

        return false;
    }

    public static void main(String[] args) {
        UndirectedGraphDetectCycle g1 = new UndirectedGraphDetectCycle(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);

        if(g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");

        UndirectedGraphDetectCycle g2 = new UndirectedGraphDetectCycle(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);

        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        return;
    }
}

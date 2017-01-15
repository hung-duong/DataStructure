package edu.mum.Graph.DFSApplication;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by hungduong on 11/13/16.
 */
public class DirectedGraphDetectCycle {

    private int V;  //No. of vertices

    //Array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];


    public DirectedGraphDetectCycle(int v) {
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

    // This function is a variation of DFS()
    public boolean isCyclic() {
        // Mark all the vertices as not visited and not part of recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int v = 0; v < V; v++) {
            visited[v] = false;
            recStack[v] = false;
        }

        // Call the recursive helper function to detect cycle in different DFS trees
        for(int v = 0; v < V; v++) {
            if(isCyclicHelper(v, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    public boolean isCyclicHelper(int v, boolean[] visited, boolean[] recStack) {

        if(visited[v] == false) {
            // Mark the current node as visited and part of recursion stack
            visited[v] = true;
            recStack[v] = true;

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> it = adj[v].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if(!visited[n] && isCyclicHelper(n, visited, recStack)) {
                    return true;
                } else if(recStack[n]) {
                    return true;
                }
            }
        }

        recStack[v] = false; // remove the vertex from recursion stack
        return true;
    }

    public static void main(String[] args) {
        DirectedGraphDetectCycle graph = new DirectedGraphDetectCycle(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.isCyclic())
            System.out.print("Graph contains cycle");
        else
            System.out.print("Graph doesn't contain cycle");

        return;
    }

}

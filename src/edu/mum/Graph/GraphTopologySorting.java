package edu.mum.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by hungduong on 11/1/16.
 */
public class GraphTopologySorting {
    private int V;  //No. of vertices

    //Array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    public GraphTopologySorting(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    //Function to add an edge into DataStructure.Graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // The function to do Topological Sort.
    public void topologicalSort() {
        Stack stack = new Stack();

        //Mark all vertices as not visited
        boolean[] visited = new boolean[V];

        for(int index = 0; index < V; index++)
            visited[index] = false;


        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for(int index = 0; index < V; index++)
            if(visited[index] == false)
                topologicalSortHelper(index, visited, stack);

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");

    }

    public void topologicalSortHelper(int v, boolean[] visited, Stack stack) {
        // Mark the current node as visited.
        visited[v] = true;

        int i;

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> iter = adj[v].listIterator();
        while(iter.hasNext()) {
            i = iter.next();
            if(visited[i] == false)
                topologicalSortHelper(i, visited, stack);
        }

        // Push current vertex to stack which stores result
        stack.push(v);
    }

    public static void main(String[] args) {
        GraphTopologySorting g = new GraphTopologySorting(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is a Topological sort of the given graph");

        g.topologicalSort();
    }
}

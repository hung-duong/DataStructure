package edu.mum.Graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by hungduong on 11/1/16.
 */
public class GraphDFS {
    private int V;  //No. of vertices

    //Array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    //Constructor
    public GraphDFS(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    //Function to add an edge into GraphDFS
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    //Function to do DFS. v is started vertex
    public void DFS(int v) {
        //Mark all vertices as not visited
        boolean[] visited = new boolean[V];

        DFSHelper(v, visited);
    }

    public void DFSHelper(int v, boolean[] visited) {
        //Set v as visited
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> iter = adj[v].listIterator();
        while(iter.hasNext()) {

            int n = iter.next();
            if(!visited[n]) {
                DFSHelper(n, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphDFS g = new GraphDFS(7);
        g.addEdge(0, 5);
        g.addEdge(0, 1);
        g.addEdge(3, 5);
        g.addEdge(5, 4);
        g.addEdge(6, 0);
        g.addEdge(1, 4);
        g.addEdge(0, 2);
        g.addEdge(3, 6);
        g.addEdge(3, 4);
        g.addEdge(6, 4);
        g.addEdge(3, 2);

        System.out.println("Following is Depth First Traversal (starting from vertex 2)");

        g.DFS(0);
    }
}

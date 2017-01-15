package edu.mum.Graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by hungduong on 11/6/16.
 */
public class GraphBFS {
    private int V;  //No. of vertices

    //Array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    public GraphBFS(int v) {
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

    //Function to do BFS. v is started vertex
    public void BFS(int v) {

        // Mark all the vertices as not visited(By default
        // set as false)
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            v = queue.poll();
            System.out.print(v + " ");

            // Get all adjacent vertices of the dequeued vertex v
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> it = adj[v].listIterator();
            while(it.hasNext()) {
                int n = it.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFS g = new GraphBFS(7);
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

        System.out.println("Following is Breadth First Traversal (starting from vertex 2)");

        g.BFS(0);
    }

}

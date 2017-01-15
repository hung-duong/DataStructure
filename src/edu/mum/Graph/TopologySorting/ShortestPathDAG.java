package edu.mum.Graph.TopologySorting;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by hungduong on 11/14/16.
 * Shortest Path in Directed Acyclic Graph
 * Given a Weighted Directed Acyclic Graph and a source vertex in the graph,
 * find the shortest paths from given source to all other vertices.
 */
public class ShortestPathDAG {
    static final int INF = Integer.MAX_VALUE;

    class AdjListNode {
        private int v;
        private int weight;

        public AdjListNode(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }
    }


    class Graph {
        private int V;  //No. of vertices

        //Array of lists for Adjacency List Representation
        private LinkedList<AdjListNode> adj[];

        public Graph(int v) {
            V = v;

            adj = new LinkedList[v];
            for(int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        //Function to add an edge into DataStructure.Graph
        public void addEdge(int u, int v, int weight) {
            adj[u].add(new AdjListNode(v, weight));
        }


        public void topologicalSortHelper(int v, boolean[] visited, Stack stack) {
            // Mark the current node as visited.
            visited[v] = true;

            // Recur for all the vertices adjacent to this
            // vertex
            Iterator<AdjListNode> iter = adj[v].listIterator();
            while(iter.hasNext()) {
                AdjListNode node = iter.next();
                if(visited[node.getV()] == false)
                    topologicalSortHelper(node.getV(), visited, stack);
            }

            // Push current vertex to stack which stores result
            stack.push(v);
        }

        // The function to find shortest paths from given vertex. It
        // uses recursive topologicalSortUtil() to get topological
        // sorting of given graph.
        public void shortestPath(int s) {
            // 1. Initialize dist[] = {INF, INF, ….} and dist[s] = 0 where s is the source vertex.
            int[] dist = new int[V];

            for(int i=0; i<V; i++) {
                dist[i] = INF;
            }
            dist[s] = 0;

            // 2. Create a toplogical order of all vertices
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

            // 3.Do following for every vertex u in topological order.
            while(!stack.isEmpty()) {
                // Get the next vertex from topological order
                int u = (int)stack.pop();

                // Update distances of all adjacent vertices
                Iterator<AdjListNode> it;
                if(dist[u] != INF) {
                    it = adj[u].listIterator();
                    while(it.hasNext()) {
                        AdjListNode i = it.next();

                        if(dist[i.getV()] > dist[u] + i.weight) {
                            dist[i.getV()] = dist[u] + i.weight;
                        }
                    }
                }
            }

            // Print the calculated shortest distances
            for (int i = 0; i < V; i++)
            {
                if (dist[i] == INF)
                    System.out.print( "INF ");
                else
                    System.out.print( dist[i] + " ");
            }
        }
    }

    Graph getGraph(int number) {
        return new Graph(number);
    }

    public static void main(String[] args) {
        ShortestPathDAG sp = new ShortestPathDAG();
        Graph graph = sp.getGraph(6);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 6);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 4, 4);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, -1);
        graph.addEdge(4, 5, -2);

        int s = 1;
        System.out.println("Following are shortest distances from source " + s);
        graph.shortestPath(s);
    }
}

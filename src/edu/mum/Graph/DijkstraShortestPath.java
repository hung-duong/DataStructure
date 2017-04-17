package edu.mum.Graph;

/**
 * Created by hungduong on 4/16/17.
 */
public class DijkstraShortestPath {
    private int V; //No. of Vertices

    public DijkstraShortestPath(int v) {
        this.V = v;
    }

    // Extract Min Q, here we use the linear array => need O(V) running time
    // So total time for Extract Min Q in while-loop is O(V^2). Since the total number of edges is |E|
    // Therefore, for-loop iterater |E| time with each iteration taking O(1) time. Hence the running
    // time of algo with arry is O(V^2 + E) = O(V^2)
    public int extractMin01(int dist[], boolean sptSet[]) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int v = 0; v < V; v++) {
            if(!sptSet[v] && dist[v] < minValue) {
                minValue = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    /* Extract Min Q, here we use the binary heap => O((V + E)logV) = O(ElogV)
    public int extractMin01(int dist[], boolean sptSet[]) {
    }*/

    // A utility function to print the constructed distance array
    void printSolution(int dist[], int[] parent, int s, int n)
    {
        System.out.println("Vertex   Distance from Source   Tracking");
        for (int i = 0; i < V; i++) {
            System.out.print(i + " \t\t " + dist[i] + " \t\t ");

            int d = i;
            while(d != -1 && parent[d] != s) {
                System.out.print(d + " ");
                d = parent[d];
            }

            System.out.println();
        }
    }

    public void dijkstra(int[][] graph, int s) {
        // Step 1: Initialize single source
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];
        int[] parent = new int[V];

        for(int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
            parent[i] = -1;
        }

        // Distance of source vertex from itself is always 0
        dist[s] = 0;

        // Step 2: Find shortest path for all vertices
        for(int count = 0; count < V; count++) {
            //Pick the minimun distance vertex from the set of vertices
            int u = extractMin01(dist, sptSet);

            //Mark the picked vertex as processed
            sptSet[u] = true;

            //Update dist value of the adjacent vertices of the picked vertex
            for(int v = 0; v < V; v++) {
                if(!sptSet[v] && graph[u][v] !=0 &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printSolution(dist, parent, s, V);
    }

    public static void main (String[] args)
    {
        // Let us create the example graph discussed above
        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        DijkstraShortestPath t = new DijkstraShortestPath(9);
        t.dijkstra(graph, 0);
    }
}

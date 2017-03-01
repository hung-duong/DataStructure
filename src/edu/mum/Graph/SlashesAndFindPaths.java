package edu.mum.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hungduong on 2/28/17.
 */
public class SlashesAndFindPaths {
    private int V; //No. of Vertices
    private LinkedList<Integer> adj[];

    public SlashesAndFindPaths(int v) {
        this.V = v;
        adj = new LinkedList[this.V + 1];

        for(int i = 0; i < V + 1; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    //Function to add an edge into GraphBFS
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public List<List<String>> findAllPaths(int v, int w) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean[] visited = new boolean[this.V + 1];

        List<List<String>> allPaths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        findAllPathsHelper(v, w, visited, path, allPaths);

        return allPaths;
    }

    //Function to do BFS to find all path
    public void findAllPathsHelper(int v, int w, boolean[] visited, List<String> path, List<List<String>> allPaths) {
        if(v == w) {
            path.add(v + "");
            allPaths.add(new ArrayList<String>(path));
            path.remove(v + "");
            return;
        }

        path.add(v + "");
        visited[v] = true;

        for(int i = 0; i < adj[v].size(); i++) {
            int vi = adj[v].get(i);
            if(!visited[vi]) {
                findAllPathsHelper(vi, w, visited, path, allPaths);
            }
        }

        path.remove(v+"");
        visited[v] = false;
    }

    public static void main(String[] args) {
        SlashesAndFindPaths sfp = new SlashesAndFindPaths(16);
        sfp.addEdge(1, 2);
        sfp.addEdge(1, 5);

        sfp.addEdge(2, 5);
        sfp.addEdge(2, 7);
        sfp.addEdge(2, 1);
        sfp.addEdge(4, 3);

        sfp.addEdge(3, 8);
        sfp.addEdge(3, 2);
        sfp.addEdge(3, 4);

        sfp.addEdge(4, 3);
        sfp.addEdge(4, 8);

        sfp.addEdge(5, 2);
        sfp.addEdge(5, 10);
        sfp.addEdge(5, 1);
        sfp.addEdge(5, 9);

        sfp.addEdge(7, 2);
        sfp.addEdge(7, 10);
        sfp.addEdge(7, 12);

        sfp.addEdge(8, 3);
        sfp.addEdge(8, 4);
        sfp.addEdge(8, 12);

        sfp.addEdge(9, 14);
        sfp.addEdge(9, 5);
        sfp.addEdge(9, 13);

        sfp.addEdge(10, 5);
        sfp.addEdge(10, 7);
        sfp.addEdge(10, 15);

        sfp.addEdge(12, 7);
        sfp.addEdge(12, 15);
        sfp.addEdge(12, 8);
        sfp.addEdge(12, 16);

        sfp.addEdge(13, 14);
        sfp.addEdge(13, 9);

        sfp.addEdge(14, 9);
        sfp.addEdge(14, 13);
        sfp.addEdge(14, 15);

        sfp.addEdge(15, 10);
        sfp.addEdge(15, 12);
        sfp.addEdge(15, 14);
        sfp.addEdge(15, 16);

        sfp.addEdge(16, 15);
        sfp.addEdge(16, 12);

        List<List<String>> result = sfp.findAllPaths(1, 16);

        for(List<String> ls : result) {
            System.out.println(ls);
        }

    }
}

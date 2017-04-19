package edu.mum.Graph.DisjointSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hungduong on 3/1/17.
 * In mathematics, two sets are said to be disjoint if they have no element in common.
 * Equivalently, disjoint sets are sets whose intersection is the empty set
 */
public class DisjointSet {
    class Node {
        int data;
        Node parent;
        int rank;
    }

    Map<Integer, Node> map = new HashMap<>();

    /*
     * Create a set with only one element
     */
    public void makeSet(int data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }

    /*
     * Find the representative of this set
     */
    public int findSet(int data) {
        return findSet(map.get(data).data);
    }

    /*
     * Find the representative recursively and does path compression as well
     */
    public Node findSet(Node node) {
        Node parent = node.parent;
        if(parent.equals(node))
            return parent;

        parent = findSet(node.parent);

        return parent;
    }

    /*
     * Combine 2 sets together to one
     * Does union by rank
     */
    public void union(int data1, int data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 =  findSet(node2);

        //If they are part of same set do nothing
        if(parent1.data == parent2.data ) {
            return;
        }

        //else whoever's rank is higher become parent of other
        if(parent1.rank >= parent2.rank) {
            //Increment only if the both are the same rank
            parent1.rank = parent1.rank == parent2.rank ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
    }
}

package edu.mum.ThreadsAndLocks;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by hungduong on 3/16/17.
 */
public class LockFactory {
    private static LockFactory instance;

    private int numOfLocks = 5;
    private LockNode[] locks;

    /* Maps from a process or owner to the order that the owner claimed it would call the locks in */
    private HashMap<Integer, LinkedList<LockNode>> lockOrder;

    private LockFactory(int count) {
        this.numOfLocks = count;
        locks = new LockNode[count];
    }

    public static LockFactory getInstance() {
        return instance;
    }

    public static synchronized LockFactory initialize(int count) {
        if (instance == null) instance = new LockFactory(count);

        return instance;
    }

    //Check for a cycle
    public boolean hasCycle(HashMap<Integer, Boolean> touchedNodes, int[] resourcesinOrder) {
        for (int resource : resourcesinOrder) {
            if (touchedNodes.get(resource) == false) {
                LockNode n = locks[resource];
                if (n.hasCycle(touchedNodes)) {
                    return true;
                }
            }
        }

        return false;
    }

    /* To prevent deadlocks, force the processes to declare upfront what order they
     * will need the locks in. Verify that this order does not create a deadlock (acycle in a directed graph)*/
    public boolean declare(int ownerid, int[] resourcesinOrder) {
        HashMap<Integer, Boolean> touchedNodes = new HashMap<Integer, Boolean>();

        //Add node to graph
        touchedNodes.put(resourcesinOrder[0], false);
        for (int i = 1; i < resourcesinOrder.length; i++) {
            LockNode prv = locks[resourcesinOrder[i - 1]];
            LockNode curr = locks[resourcesinOrder[i]];
            prv.joinTo(curr);
            touchedNodes.put(resourcesinOrder[i], false);
        }

        //if we created a cycle, destroy this resource list and return false
        if (hasCycle(touchedNodes, resourcesinOrder)) {
            for (int i = 1; i < resourcesinOrder.length; i++) {
                LockNode p = locks[resourcesinOrder[i - 1]];
                LockNode c = locks[resourcesinOrder[i]];
                p.remove(c);
            }
            return false;
        }

        // No cycle detect. Save the order that was declared, so that we can verify that the process
        // is really calling the locks in the order it said
        LinkedList<LockNode> list = new LinkedList<>();
        for(int i = 1; i < resourcesinOrder.length; i++) {
            LockNode resource = locks[resourcesinOrder[i]];
            list.add(resource);
        }

        lockOrder.put(ownerid, list);
        return true;
    }

}

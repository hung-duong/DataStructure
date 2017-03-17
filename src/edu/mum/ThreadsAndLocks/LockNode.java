package edu.mum.ThreadsAndLocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hungduong on 3/16/17.
 */
public class LockNode {
    public enum VisitState {
        FRESH, VISITING, VISITED
    };

    private ArrayList<LockNode> children;
    private int lockId;
    private Lock lock;
    private int maxLocks;

    public LockNode(int id, int max) {
        this.lockId = id;
        this.maxLocks = max;
    }

    public void joinTo(LockNode node) {
        this.children.add(node);
    }

    public void remove(LockNode node) {
        this.children.remove(node);
    }

    /**
     * Use DFS to find cycle
     */
    public boolean hasCycle(HashMap<Integer, Boolean> touchedNodes) {
        VisitState[] visited = new VisitState[maxLocks];
        for(int i = 0; i < visited.length; i++) {
            visited[i] = VisitState.FRESH;
        }

        return hasCycle(visited, touchedNodes);
    }

    private boolean hasCycle(VisitState[] visited, HashMap<Integer, Boolean> touchedNodes) {
        if(touchedNodes.containsKey(lockId)) {
            touchedNodes.put(lockId, true);
        }

        if(visited[lockId] == VisitState.VISITING) {
            /* We looped back to this node while still visiting it, so we know there's a cycle. */
            return true;
        } else if(visited[lockId] == VisitState.FRESH) {
            visited[lockId] = VisitState.VISITING;
            for(LockNode n : children) {
                if(n.hasCycle(visited, touchedNodes)) {
                    return true;
                }
            }

            visited[lockId] = VisitState.VISITED;
        }

        return false;
    }

    public Lock getlock() {
        if (lock == null)
            lock= new ReentrantLock();

        return lock;
    }

    public int getld() {
        return lockId;
    }
}

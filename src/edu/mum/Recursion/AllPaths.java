package edu.mum.Recursion;

import edu.mum.Util.Point;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hungduong on 3/5/17.
 */
public class AllPaths {
    //Get paths from (0,0) -> (n, m)
    public List<LinkedList<Point>> paths(int n, int m) {
        List<LinkedList<Point>> paths = new ArrayList<>();
        getPaths(n - 1, m - 1, new LinkedList<>(), paths);

        return paths;
    }

    public void getPaths(int x, int y, LinkedList<Point> path, List<LinkedList<Point>> paths) {
        path.push(new Point(x, y));

        if(x == 0 && y == 0) {
            paths.add(new LinkedList<>(path));
        }

        if(x > 0) {
            getPaths(x - 1, y, path, paths);
        }

        if(y > 0) {
            getPaths(x, y -1, path, paths);
        }

        path.pop();
    }

    public static void main(String[] args) {
        AllPaths ap = new AllPaths();
        List<LinkedList<Point>> paths = ap.paths(4, 4);

        for(LinkedList ll : paths) {
            System.out.println(ll.toString());
        }
    }
}

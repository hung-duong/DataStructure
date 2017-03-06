package edu.mum.Recursion;

import edu.mum.Util.Point;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hungduong on 3/5/17.
 */
public class AllPathsMatrix {

    //Get paths from (0,0) -> (n, m)
    public List<LinkedList<Point>> paths(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<LinkedList<Point>> paths = new ArrayList<>();
        getPaths(matrix, n - 1, m - 1, new LinkedList<>(), paths);

        return paths;
    }

    public void getPaths(int[][] matrix, int x, int y, LinkedList<Point> path, List<LinkedList<Point>> paths) {
        path.push(new Point(x, y));

        if(x == 0 && y == 0) {
            paths.add(new LinkedList<>(path));
        }

        if(x > 0 && matrix[x - 1][y] == 1) {
            getPaths(matrix, x - 1, y, path, paths);
        }

        if(y > 0 && matrix[x][y - 1] == 1) {
            getPaths(matrix, x, y -1, path, paths);
        }

        path.pop();
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 0, 1}
        };

        AllPathsMatrix apm = new AllPathsMatrix();


        List<LinkedList<Point>> paths = apm.paths(matrix);

        for(LinkedList ll : paths) {
            System.out.println(ll.toString());
        }
    }
}

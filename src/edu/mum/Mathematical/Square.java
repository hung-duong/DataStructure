package edu.mum.Mathematical;

/**
 * Created by hungduong on 3/12/17.
 * Questions: Given two squares on a two dimensional plane,  nd a line that would cut these two squares in half.
 * Solution: Any line that goes through the center of a rectangle must cut it in half. Therefore, if you drew a
 * line connecting the centers of the two squares, it would cut both in half.
 */
public class Square {
    private double left;
    private double top;
    private double bottom;
    private double right;

    public class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public class Line {
        public Point firstPoint;
        public Point lastPoint;

        public Line(Point firstLine, Point lastPoint) {
            this.firstPoint = firstLine;
            this.lastPoint = lastPoint;
        }
    }

    public Square(double left, double top, double size) {
        this.left = left;
        this.top = top;
        this.bottom = top + size;
        this.right = left + size;
    }

    public Point middle() {
        return new Point((this.left + this.right) / 2, (this.top + this.bottom) / 2);
    }

    public Line cut(Square other) {
        Point middle = this.middle();
        Point middle_o = other.middle();
        if(middle == middle_o) {
            return new Line(new Point(left, top), new Point(right, bottom));
        } else {
            return new Line(middle, middle_o);
        }
    }
}

package edu.mum.Recursion;

/**
 * Created by hungduong on 3/5/17.
 */
public class PaintFill {
    enum Color {
        Black, White, Red, Yellow, Green
    }

    public static boolean paintFill(Color[][] screen, int x, int y, Color oldColor, Color newColor) {
        if(x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) {
            return false;
        }

        if(screen[y][x] == oldColor) {
            screen[y][x] = newColor;
            paintFill(screen, x - 1, y, oldColor, newColor);
            paintFill(screen, x + 1, y, oldColor, newColor);
            paintFill(screen, x, y - 1, oldColor, newColor);
            paintFill(screen, x, y + 1, oldColor, newColor);
        }

        return true;
    }

    public static boolean paintFill(Color[][] screen, int x, int y, Color ncolor) {
        return paintFill(screen, x, y, screen[x][y], ncolor);
    }

    public static void main(String[] args) {
        Color[][] img = {
                {Color.Black, Color.Black, Color.White},
                {Color.White, Color.White, Color.Black},
                {Color.White, Color.Black, Color.White}
        };

        for(Color[] aa: img){
            System.out.println();
            for(Color a: aa){
                System.out.print(a);
            }

        }

        paintFill(img, 1,1, Color.Green);
        for(Color[] aa:img){
            System.out.println();
            for(Color a:aa){
                System.out.print(a);
            }

        }
    }
}

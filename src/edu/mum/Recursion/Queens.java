/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.Recursion;

/**
 *
 * @author hungduong
 */
public class Queens {
    private int[] columnForRow = new int[8];

    public boolean check(int row) {
        for(int i = 0; i < row; i++) {
            int diff = Math.abs(columnForRow[i] - columnForRow[row]);
            if(diff == 0 || diff == row - i)
                return false;
        }

        return true;
    }

    public void placeQueen(int row) {
        if(row == 8) {
            return;
        }

        for(int i = 0; i < 8; i++) {
            columnForRow[i] = i;
            if(check(row))
                placeQueen(row + 1);
        }
    }
}

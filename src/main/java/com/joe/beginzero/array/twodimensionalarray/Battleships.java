package com.joe.beginzero.array.twodimensionalarray;

/**
 * 419. Battleships in a Board
 *
 * @author ckh
 * @create 2020/8/3 9:40
 */
public class Battleships {
    public static int countBattleships(char[][] board) {
        if (null == board || board.length == 0) {
            return 0;
        }
        int row = board.length;
        int column = board[0].length;

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // if the position is . , means it no ship
                // if the left and over of the position , means it is ships body, ignore
                // only count the head of the ship
                if (board[i][j] == '.') {
                    continue;
                } else if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                } else if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                count++;

            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', '.', '.', 'X'},
                {'.', 'X', '.', 'X'},
                {'.', '.', '.', 'X'}
        };

        System.out.println(countBattleships(board));
    }
}

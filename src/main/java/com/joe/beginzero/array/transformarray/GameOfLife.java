package com.joe.beginzero.array.transformarray;

import java.util.Arrays;

/**
 * 289. Game of Life
 *
 * @author ckh
 * @create 2020/8/11 9:39
 */
public class GameOfLife {

    /**
     * 暴力法
     * Copy the original array for simulation
     * 复制一份原始数组
     * 根据复制数组中邻居细胞的状态来更新 board 中的细胞状态
     */
    @SuppressWarnings("all")
    public static void gameOfLife1(int[][] board) {

        int rows = board.length;
        int columns = board[0].length;
        int[][] copyBoard = new int[rows][columns];
        // copy from the original array to copyBoard
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                copyBoard[row][column] = board[row][column];
            }
        }

        // represent the neighbors of cell
        int[] neighbors = {0, 1, -1};

        // Traverse the cells in each grid of the panel
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                // count the number of living cells in its eight adjacent positions
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        /*
                        all neighbors of cell , (0,0) is current cell
                        (0,0) (0,1) (0,2) (1,0) (1,1) (1,2) (2,0) (2,1) (2,2)
                         */
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {

                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < columns && c >= 0) && (copyBoard[r][c] == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // rule 1 or rule 3
                if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = 0;
                }

                // rule 4
                if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }

    /**
     * Use additional state
     *
     * value -1 signifies the old value for the cell was 1 and now is 0
     * value 2 signifies the old value for the cell was 0 and now is 1
     *
     */
    public static void game2(int[][] board){
        int[] neighbors = {0, 1, -1};

        int rows = board.length;
        int cols = board[0].length;

        // traverse each cell of panel
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // count the neighbors live number
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // rule 1 or rule 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[row][col] = -1;
                }
                // rule 4
                if (board[row][col] == 0 && liveNeighbors == 3) {

                    board[row][col] = 2;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        game2(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}


package com.joe.janzhi;

/**
 * Offer 12. Word Search
 *
 * @author ckh
 * @create 9/24/20 6:41 PM
 */
public class WordSearch12 {

    private boolean[][] marked;

    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y

    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    /**
     * 盘面上有多少行
     */
    private int m;
    /**
     * 盘面上有多少列
     */
    private int n;
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];

        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        // 运行到最后一个单词
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        // 当前位置匹配
        if (board[i][j] == word.charAt(start)) {
            // 标记
            marked[i][j] = true;
            // 4 个方向遍历， 上 左 下 右
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {

                char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'D', 'E'}
                };

        String word = "ABCCED";
//        char[][] board = {{'a', 'b'}};
//        String word = "ba";
        WordSearch12 solution = new WordSearch12();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);

    }
}

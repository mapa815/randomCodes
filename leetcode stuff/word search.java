/*
PROBLEM STATEMENT

Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, 
where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
            if (dfs(board, word, i, j, 0)) return true;
          }
        }
        return false;
    }

  private static boolean dfs(char[][] B, String word, int i, int j, int w) {
    if (w == word.length()) return true;
    if (i < 0 || i >= B.length || j < 0 || j >= B[0].length || B[i][j] == '#' 
            || B[i][j] != word.charAt(w)) return false;
    int[][] SHIFT = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    B[i][j] = '#';
    for (int[] dir : SHIFT) {
      if (dfs(B, word, i + dir[0], j + dir[1], w + 1)) return true;
    }
    B[i][j] = word.charAt(w);
    return false;
  }
}

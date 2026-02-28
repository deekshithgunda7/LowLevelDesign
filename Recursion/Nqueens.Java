import java.util.*;
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4; // Example with 4 queens
        List<List<String>> solutions = solution.solveNQueens(n);

        // Print all solutions
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}

class Solution {

  List<List<String>> ans = new ArrayList<>();

  // board
  //  |
  //  |---- board[0] -> ['.', 'Q', '.', '.']
  //  |---- board[1] -> ['.', '.', '.', 'Q']
  //  |---- board[2] -> ['Q', '.', '.', '.']
  //  |---- board[3] -> ['.', '.', 'Q', '.']

  public void PrintBoard(char[][] board) {
    List<String> temp = new ArrayList<>();

    for (int i = 0; i < board.length; i++) {
      temp.add(new String(board[i]));
    }

    ans.add(temp);
  }

  public boolean isSafe(char[][] board, int i, int j) {

    // Top-left diagonal
    for (int row = i, col = j; row >= 0 && col >= 0; row--, col--) {
      if (board[row][col] == 'Q') return false;
    }

    // Bottom-left diagonal
    for (int row = i, col = j; row < board.length && col >= 0; row++, col--) {
      if (board[row][col] == 'Q') return false;
    }

    // Left side row
    for (int col = j; col >= 0; col--) {
      if (board[i][col] == 'Q') return false;
    }

    return true;
  }

  public void nQueens(char[][] board, int col) {

    if (col == board[0].length) {
      PrintBoard(board);
      return;
    }

    for (int i = 0; i < board.length; i++) {
      if (isSafe(board, i, col)) {
        board[i][col] = 'Q';
        nQueens(board, col + 1);
        board[i][col] = '.';
      }
    }
  }

  public List<List<String>> solveNQueens(int n) {

    char[][] board = new char[n][n];

    for (char[] row : board) {
      Arrays.fill(row, '.');
    }

    nQueens(board, 0);
    return ans;
  }
}

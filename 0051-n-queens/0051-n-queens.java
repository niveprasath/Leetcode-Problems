class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] cols = new boolean[n + 1];
        boolean[] ndiag = new boolean[2 * n - 1];
        boolean[] rdiag = new boolean[2 * n - 1];
        boolean[][] board = new boolean[n][n];
        queen(n, 0, board, ndiag, rdiag, cols,  ans);
        return ans;
    }

    List<String> constructboard(boolean[][] board) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }

    void queen(int n, int row, boolean[][] board, boolean[] ndiag, boolean[] rdiag, boolean[] cols,    List<List<String>> ans) {
        //base case
        if (row == board.length) {// base case should be board.length because the index should also be counted
            ans.add(new ArrayList<>(constructboard(board)));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (cols[col] == false && ndiag[row + col] == false && rdiag[row - col + board.length - 1] == false) {
                if (board[row][col] == false) {
                    board[row][col] = true;
                    cols[col] = true;
                    ndiag[row + col] = true;
                    rdiag[row - col + board.length - 1] = true;
                    queen(n, row + 1, board, ndiag, rdiag, cols,  ans);
                    board[row][col] = false;
                    cols[col] = false;
                    ndiag[row + col] = false;
                    rdiag[row - col + board.length - 1] = false;
                }
            }
        }
    }
}
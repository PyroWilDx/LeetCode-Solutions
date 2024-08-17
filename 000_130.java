class Solution {
    private char[][] board;
    private int M;
    private int N;

    public void solve(char[][] board) {
        this.board = board;
        this.M = board.length;
        this.N = board[0].length;

        for (int i = 0; i < M; i++) {
            markRec(i, 0);
            markRec(i, N - 1);
        }
        for (int j = 0; j < N; j++) {
            markRec(0, j);
            markRec(M - 1, j);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

    public void markRec(int i, int j) {
        if (i < 0 || j < 0 || i >= M || j >= N)
            return;
        if (board[i][j] != 'O')
            return;

        board[i][j] = '#';
        markRec(i - 1, j);
        markRec(i + 1, j);
        markRec(i, j - 1);
        markRec(i, j + 1);
    }
}

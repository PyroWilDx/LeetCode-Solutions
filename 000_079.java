class Solution {
    private char[][] board;
    private String word;
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.m = board.length;
        this.n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existRec(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean existRec(int i, int j, int wIndex) {
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (board[i][j] != word.charAt(wIndex)) return false;

        wIndex++;
        if (wIndex == word.length()) return true;

        char c = board[i][j];
        board[i][j] = '.';
        boolean r = existRec(i - 1, j, wIndex)
            || existRec(i + 1, j, wIndex)
            || existRec(i, j - 1, wIndex)
            || existRec(i, j + 1, wIndex);
        board[i][j] = c;
        return r;
    }
}

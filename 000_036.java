class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i)) return false;
        }
        for (int j = 0; j < 9; j++) {
            if (!checkColumn(board, j)) return false;
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!check3x3Square(board, i, j)) return false;
            }
        }
        return true;
    }

    public boolean checkRow(char[][] board, int i) {
        boolean[] checked = new boolean[9];
        for (int j = 0; j < 9; j++) {
            int k = board[i][j];
            if (k == '.') continue;
            k = k - '0' - 1;
            if (checked[k]) return false;
            checked[k] = true;
        }
        return true;
    }

    public boolean checkColumn(char[][] board, int j) {
        boolean[] checked = new boolean[9];
        for (int i = 0; i < 9; i++) {
            int k = board[i][j];
            if (k == '.') continue;
            k = k - '0' - 1;
            if (checked[k]) return false;
            checked[k] = true;
        }
        return true;
    }

    public boolean check3x3Square(char[][] board, int i_, int j_) {
        boolean[] checked = new boolean[9];
        for (int i = i_; i < i_ + 3; i++) {
            for (int j = j_; j < j_ + 3; j++) {
                int k = board[i][j];
                if (k == '.') continue;
                k = k - '0' - 1;
                if (checked[k]) return false;
                checked[k] = true;
            } 
        }
        return true;
    }
}

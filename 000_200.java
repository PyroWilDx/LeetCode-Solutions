class Solution {
    private char[][] grid;
    private int M;
    private int N;

    public int numIslands(char[][] grid) {
        int result = 0;

        this.grid = grid;
        this.M = grid.length;
        this.N = grid[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '0')
                    continue;

                destroyIsland(i, j);
                result++;
            }
        }

        return result;
    }

    public void destroyIsland(int i, int j) {
        if (i < 0 || i >= M || j < 0 || j >= N)
            return;
        if (grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        destroyIsland(i + 1, j);
        destroyIsland(i - 1, j);
        destroyIsland(i, j + 1);
        destroyIsland(i, j - 1);
    }
}

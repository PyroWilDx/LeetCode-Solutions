class Solution {
    private int[][] grid;
    private int M;
    private int N;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.M = grid.length;
        this.N = grid[0].length;

        int result = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, getAreaOfIsland(i, j));
            }
        }
        return result;
    }

    public int getAreaOfIsland(int i, int j) {
        if (i < 0 || i >= M || j < 0 || j >= N) return 0;
        if (grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        return 1
            + getAreaOfIsland(i - 1, j)
            + getAreaOfIsland(i + 1, j)
            + getAreaOfIsland(i, j - 1)
            + getAreaOfIsland(i, j + 1);
    }
}

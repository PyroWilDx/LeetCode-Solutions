class Solution {
    private int[][] grid;

    public void islandsAndTreasure(int[][] grid) {
        this.grid = grid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    updateCells(i + 1, j, 1);
                    updateCells(i - 1, j, 1);
                    updateCells(i, j + 1, 1);
                    updateCells(i, j - 1, 1);
                }
            }
        }
    }

    public void updateCells(int i, int j, int d) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (d >= grid[i][j])
            return;

        grid[i][j] = d;

        d++;
        updateCells(i + 1, j, d);
        updateCells(i - 1, j, d);
        updateCells(i, j + 1, d);
        updateCells(i, j - 1, d);
    }
}

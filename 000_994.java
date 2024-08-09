import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[][] grid;

    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        
        int result = 0;
        while (rotOranges()) {
            result++;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result = -1;
                    break;
                }
            }
        }
        return result;
    }

    public boolean rotOranges() {
        List<int[]> orangesToRot = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && isAdjRotten(i, j)) {
                    orangesToRot.add(new int[] { i, j });
                }
            }
        }
        for (int[] orange : orangesToRot) {
            grid[orange[0]][orange[1]] = 2;
        }
        return !orangesToRot.isEmpty();
    }

    public boolean isAdjRotten(int i, int j) {
        return (i > 0 && grid[i - 1][j] == 2)
            || (i < grid.length - 1 && grid[i + 1][j] == 2)
            || (j > 0 && grid[i][j - 1] == 2)
            || (j < grid[0].length - 1 && grid[i][j + 1] == 2);
    }
}

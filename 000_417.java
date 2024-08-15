import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int[][] heights;
    private int M;
    private int N;
    private int[][] accMap;

    private boolean pacFlag;
    private boolean atlFlag;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.M = heights.length;
        this.N = heights[0].length;
        this.accMap = new int[M][];

        for (int i = 0; i < M; i++) {
            this.accMap[i] = new int[N];
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                pacFlag = false;
                atlFlag = false;
                checkSquareRec(i, j, Integer.MAX_VALUE);
                if (pacFlag && atlFlag) {
                    accMap[i][j] = -1;
                    result.add(Arrays.asList(i, j));
                } else if (pacFlag) {
                    accMap[i][j] = 1;
                } else if (atlFlag) {
                    accMap[i][j] = 2;
                }
            }
        }
        return result;
    }

    public void checkSquareRec(int i, int j, int lastHeight) {
        if (pacFlag && atlFlag) return;

        if (i < 0 || j < 0) {
            pacFlag = true;
            return;
        }
        if (i >= M || j >= N) {
            atlFlag = true;
            return;
        }

        int height = heights[i][j];
        if (height > lastHeight || height == -1) {
            return;
        }

        if (accMap[i][j] != 0) {
            if (accMap[i][j] == 1) {
                pacFlag = true;
            } else if (accMap[i][j] == 2) {
                atlFlag = true;
            } else {
                pacFlag = true;
                atlFlag = true;
                return;
            }
        }

        heights[i][j] = -1;
        checkSquareRec(i - 1, j, height);
        checkSquareRec(i + 1, j, height);
        checkSquareRec(i, j - 1, height);
        checkSquareRec(i, j + 1, height);
        heights[i][j] = height;
    }
}

class Solution {
    private int N;

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;

        int M = matrix.length;
        N = matrix[0].length;

        return searchRec(matrix, target, 0, M * N);
    }

    public boolean searchRec(int[][] matrix, int target, int i, int j) {
        if (i == j) return false;
        int m = (i + j) / 2;
        int[] mMat = indexToMatrixIndex(m);
        int value = matrix[mMat[0]][mMat[1]];
        if (value == target) return true;
        if (value < target) return searchRec(matrix, target, m + 1, j);
        return searchRec(matrix, target, i, m);
    }

    public int[] indexToMatrixIndex(int m) {
        return new int[] { m / N, m % N }; 
    }
}

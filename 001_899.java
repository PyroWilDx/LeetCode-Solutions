class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] merged = new int[] { 0, 0, 0 };
        for (int[] triplet : triplets) {
            if (!isValidTriplet(triplet, target)) {
                continue;
            }

            boolean found = true;
            for (int i = 0; i < 3; i++) {
                merged[i] = Math.max(triplet[i], merged[i]);
                if (merged[i] != target[i]) {
                    found = false;
                }
            }
            if (found) {
                return true;
            }
        }

        return false;
    }

    public boolean isValidTriplet(int[] triplet, int[] target) {
        for (int i = 0; i < 3; i++) {
            if (triplet[i] > target[i]) {
                return false;
            }
        }
        return true;
    }
}

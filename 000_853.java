import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        final int N = position.length;

        Pair[] posSpeed = new Pair[N];
        for (int i = 0; i < N; i++) posSpeed[i] = new Pair(position[i], speed[i]);
        
        Arrays.sort(posSpeed);
        float currFleetArrivalTime = (target - posSpeed[N - 1].x1) / (float) posSpeed[N - 1].x2;

        int result = 0;

        for (int i = N - 2; i >= 0; i--) {
            float arrivalTime = (target - posSpeed[i].x1) / (float) posSpeed[i].x2;
            if (arrivalTime <= currFleetArrivalTime) continue;
            else {
                result++;
                currFleetArrivalTime = arrivalTime;
            }
        }
        
        return result + 1;
    }

    static class Pair implements Comparable<Pair> {
        public int x1;
        public int x2;

        public Pair(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }

        public int compareTo(Pair otherPair) {
            return x1 - otherPair.x1;
        }
    }
}

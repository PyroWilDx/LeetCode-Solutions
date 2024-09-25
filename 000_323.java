import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> neighboursMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            neighboursMap.computeIfAbsent(edges[i][0], v -> new HashSet<>())
                    .add(edges[i][1]);
            neighboursMap.computeIfAbsent(edges[i][1], v -> new HashSet<>())
                    .add(edges[i][0]);
        }

        Queue<Integer> nodesQueue = new ArrayDeque<>();
        for (int node = 0; node < n; node++) {
            nodesQueue.add(node);
        }

        Deque<Integer> toVisit = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        while (visited.size() != n) {
            int node = nodesQueue.poll();
            if (visited.contains(node)) {
                continue;
            }
            if (!neighboursMap.containsKey(node)) {
                result++;
                visited.add(node);
                continue;
            }
            toVisit.addLast(node);
            while (!toVisit.isEmpty()) {
                int currNode = toVisit.removeFirst();
                if (neighboursMap.containsKey(currNode)) {
                    for (int neighbour : neighboursMap.get(currNode)) {
                        if (visited.contains(neighbour)) {
                            continue;
                        }

                        toVisit.addLast(neighbour);
                    }
                }
                visited.add(currNode);
            }
            result++;
        }
        return result;
    }
}

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> neighboursMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (neighboursMap.containsKey(edges[i][1])) {
                neighboursMap.get(edges[i][1]).add(edges[i][0]);
            } else {
                neighboursMap.computeIfAbsent(edges[i][0], v -> new ArrayList<>()).add(edges[i][1]);
            }
        }

        Deque<Integer> toVisit = new ArrayDeque<>();
        toVisit.add(edges[0][0]);
        Set<Integer> visited = new HashSet<>();
        while (visited.size() != n) {
            if (toVisit.size() == 0) {
                return false;
            }
            int currNode = toVisit.removeFirst();
            if (visited.contains(currNode)) {
                return false;
            }
            if (neighboursMap.containsKey(currNode)) {
                for (int neighbour : neighboursMap.get(currNode)) {
                    toVisit.addLast(neighbour);
                }
            }
            visited.add(currNode);
        }
        return toVisit.size() == 0;
    }
}

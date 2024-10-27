import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == 0) {
            return n == 0 || n == 1;
        }

        Map<Integer, List<Integer>> neighboursMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            neighboursMap.computeIfAbsent(edges[i][0], v -> new ArrayList<>()).add(edges[i][1]);
            neighboursMap.computeIfAbsent(edges[i][1], v -> new ArrayList<>()).add(edges[i][0]);
        }

        Set<Integer> visited = new HashSet<>();
        if (hasCycle(neighboursMap, visited, edges[0][0], -1)) {
            return false;
        }

        return visited.size() == n;
    }

    public boolean hasCycle(Map<Integer, List<Integer>> neighboursMap, Set<Integer> visited, int node, int parent) {
        if (visited.contains(node)) {
            return true;
        }

        visited.add(node);

        for (int neighbour : neighboursMap.get(node)) {
            if (neighbour == parent) {
                continue;
            }

            if (hasCycle(neighboursMap, visited, neighbour, node)) {
                return true;
            }
        }

        return false;
    }
}

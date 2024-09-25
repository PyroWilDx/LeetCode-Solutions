import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> neighboursMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            neighboursMap.computeIfAbsent(edges[i][0], v -> new HashSet<>()).add(edges[i][1]);
            neighboursMap.computeIfAbsent(edges[i][1], v -> new HashSet<>()).add(edges[i][0]);
        }

        for (int i = edges.length - 1; i > 0; i--) {
            neighboursMap.get(edges[i][0]).remove(edges[i][1]);
            neighboursMap.get(edges[i][1]).remove(edges[i][0]);
            if (isTree(edges[i][0], neighboursMap)) {
                return edges[i];
            }
            neighboursMap.get(edges[i][0]).add(edges[i][1]);
            neighboursMap.get(edges[i][1]).add(edges[i][0]);
        }
        return edges[0];
    }

    public boolean isTree(int firstNode, Map<Integer, Set<Integer>> neighboursMap) {
        Set<Integer> visited = new HashSet<>();
        if (!isTreeRec(firstNode, -1, neighboursMap, visited)) {
            return false;
        }

        return visited.size() == neighboursMap.size();
    }

    public boolean isTreeRec(int node, int nodeParent, Map<Integer, Set<Integer>> neighboursMap, Set<Integer> visited) {
        visited.add(node);
        for (int neighbour : neighboursMap.get(node)) {
            if (!visited.contains(neighbour)) {
                if (!isTreeRec(neighbour, node, neighboursMap, visited)) {
                    return false;
                }
                continue;
            }

            if (neighbour != nodeParent) {
                return false;
            }
        }
        return true;
    }
}

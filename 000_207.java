import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    private int numCourses;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;

        Map<Integer, Set<Integer>> depMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            depMap.computeIfAbsent(prerequisites[i][0], v -> new HashSet<>())
                    .add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!canFinishCourse(i, depMap, 0)) return false;
        }

        return true;
    }

    public boolean canFinishCourse(int course, Map<Integer, Set<Integer>> depMap, int iteration) {
        if (!depMap.containsKey(course)) return true;

        if (iteration >= numCourses) return false;

        Set<Integer> deps = depMap.get(course);
        for (int dep : deps) {
            if (!canFinishCourse(dep, depMap, iteration + 1)) return false;
        }
        depMap.remove(course);

        return true;
    }
}

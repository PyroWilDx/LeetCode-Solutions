import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    private int numCourses;
    private Map<Integer, Set<Integer>> depMap;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;

        depMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            depMap.computeIfAbsent(prerequisites[i][0], v -> new HashSet<>())
                    .add(prerequisites[i][1]);
        }

        Set<Integer> added = new HashSet<>();
        int[] result = new int[numCourses];
        int resultIndex = 0;
        for (int i = 0; i < numCourses; i++) {
            List<Integer> currCourseOrder = new ArrayList<>();
            if (!findCourseOrder(i, 0, currCourseOrder)) return new int[0];

            for (int course : currCourseOrder) {
                if (added.contains(course)) continue;

                result[resultIndex] = course;
                resultIndex++;
                added.add(course);
            }
        }
        return result;
    }

    public boolean findCourseOrder(int course, int iteration, List<Integer> courseOrder) {
        if (!depMap.containsKey(course)) {
            courseOrder.add(course);
            return true;
        }

        if (iteration == numCourses) return false;

        for (int dep : depMap.get(course)) {
            if (!findCourseOrder(dep, iteration + 1, courseOrder)) return false;
        }
        depMap.remove(course);
        courseOrder.add(course);

        return true;
    }
}

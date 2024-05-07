package leetcode;

import java.util.*;

public class CourseSchedule {

    public boolean dfs(Integer crs, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        if (visited.contains(crs)) {
            return false;
        }
        if (!map.containsKey(crs) || map.get(crs).isEmpty()) {
            return true;
        }
        visited.add(crs);
        for (int i = 0; i < map.get(crs).size(); i++) {
            if (!dfs(map.get(crs).get(i), map, visited)) {
                return false;
            }
        }
        visited.remove(crs);
        map.get(crs).clear();
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][0])) {
                map.put(prerequisites[i][0], new ArrayList<>());
            }

            if (!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);

        }

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visited)) {
                return false;
            }
        }
        return true;
    }
}
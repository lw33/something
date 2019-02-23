package lw.learn.lc.dfs;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author lw
 * @Date 2019-02-23 13:28:04
 **/
public class P207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashSet<Integer> learned = new HashSet<>(numCourses);
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(numCourses);
        for (int[] prerequisite : prerequisites) {
            HashSet<Integer> set = map.getOrDefault(prerequisite[0], new HashSet<>());
            set.add(prerequisite[1]);
            map.put(prerequisite[0], set);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            HashSet<Integer> visit = new HashSet<>(numCourses);
            int course = prerequisites[i][0];
            if (!learned.contains(course)) {
                if (!canFinish(map, course, learned, visit)) {
                    return false;
                }
                learned.add(course);
            }
            visit.clear();
        }
        return true;
    }

    private boolean canFinish(HashMap<Integer, HashSet<Integer>> map, int course, HashSet<Integer> learned, HashSet<Integer> visit) {
        HashSet<Integer> set = map.get(course);
        visit.add(course);
        if (set == null) {
            learned.add(course);
            return true;
        }
        boolean res = false;
        for (Integer require : set) {
            if (learned.contains(course)) {
                continue;
            }
            if (visit.contains(require)) {
                return false;
            }
            res = res || canFinish(map, require, learned, visit);
        }
        learned.add(course);
        visit.remove(visit.size() - 1);
        return true;
    }

    @Test
    public void test() {
        int a = 8;
        int[][] arr = JSON2Java.json2int2Array("[[1,0],[2,6],[1,7],[6,4],[7,0],[0,5]]");
        System.out.println(this.canFinish(a, arr));
    }
}

package lw.learn.lc.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author lw
 * @Date 2019-03-03 22:17:53
 **/
public class P997_FindTheTownJudge {

    public int findJudge(int N, int[][] trust) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> dep = new HashSet<>();

        for (int[] arr : trust) {
            if (map.containsKey(arr[1])) {
                map.get(arr[1]).add(arr[0]);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(arr[0]);
                map.put(arr[1], set);
            }
            dep.add(arr[0]);
        }

        for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == N - 1) {
                if (!dep.contains(entry.getKey())) {
                    return entry.getKey();
                }
            }
        }
        return -1;
    }
}

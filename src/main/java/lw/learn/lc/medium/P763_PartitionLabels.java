package lw.learn.lc.medium;

import org.junit.Test;

import java.util.*;

/**
 * @Author lw
 * @Date 2018-12-24 23:21:55
 **/
public class P763_PartitionLabels {
    //ababcbacadefegdehijhklij
    //"ababcbaca", "defegde", "hijhklij"。
    public List<Integer> partitionLabels(String S) {

        HashMap<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (map.containsKey(c)) {
                int[] ints = map.get(c);
                ints[1] = i;
            } else {
                int[] ints = new int[2];
                ints[0] = i;
                ints[1] = i;
                map.put(c, ints);
            }
        }
        int[][] interval = new int[map.size()][2];
        int i = 0;
        for (int[] value : map.values()) {
            interval[i++] = value;
        }
        //Arrays.sort(interval, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(interval, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }

        });
        List<Integer> res = new ArrayList<>();
        int cnt = interval[0][1];
        int sum = 0;
        for (int j = 1; j < interval.length; j++) {
            if (cnt < interval[j][0]) {
                cnt = interval[j][0];
                res.add(cnt - sum);
                sum = cnt;
            }
            cnt = Math.max(cnt, interval[j][1]);
        }
        res.add(cnt - sum + 1);
        return res;
    }

    public List<Integer> partitionLabels1(String S) {
        List<Integer> res = new ArrayList<>();

        return res;
    }

    @Test
    public void test() {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(this.partitionLabels(s));
    }
}

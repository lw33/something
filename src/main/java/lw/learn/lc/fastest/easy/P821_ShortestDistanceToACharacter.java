package lw.learn.lc.fastest.easy;

import java.util.ArrayList;

/**
 * @Author lw
 * @Date 2019-01-19 22:13:51
 **/
// FIXME 2019/1/19  66666
public class P821_ShortestDistanceToACharacter {
    class Solution {
        public int[] shortestToChar(String S, char C) {
            ArrayList<Integer> list = new ArrayList<>();
            char[] chars = S.toCharArray();
            int[] res = new int[chars.length];
            // 记录 目标 位置的下标,得到一个有序数组
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] == C){
                    list.add(i);
                }
            }
            // 最小坐标的左边
            int step = 0;
            for (int j = list.get(0); j >= 0; j--) {
                res[j] = step ++;
            }
            // 最大坐标的右边
            step = 0;
            for (int j = list.get(list.size()-1); j < chars.length; j++) {
                res[j] = step ++;
            }
            // 从区间两头向中间递增
            for (int i = 0; i < list.size() - 1; i++) {
                step = 1;
                int minIndex = list.get(i) + 1;
                int maxIndex = list.get(i + 1) - 1;
                while(minIndex <= maxIndex){
                    res[minIndex++] = res[maxIndex--] = step++;
                }
            }
            return res;
        }
    }
}

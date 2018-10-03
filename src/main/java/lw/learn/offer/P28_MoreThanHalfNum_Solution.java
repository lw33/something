package lw.learn.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author lw
 * @Date 2018-10-02 18:55:05
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 **/
public class P28_MoreThanHalfNum_Solution {

    public int MoreThanHalfNum_Solution(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int half = array.length / 2;
        final int[] res = new int[1];
        map.forEach((k, v) -> {
            if (v > half) {
                res[0] = k;
            }
        });

        return res[0];
    }
}

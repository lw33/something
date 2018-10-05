package lw.learn.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2018-10-02 19:08:04
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 **/
public class P29_GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length < k || k == 0) {
            return res;
        }
        PriorityQueue<Integer> kNums = new PriorityQueue<>(k);
        PriorityQueue<Integer> kNumsMax = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < input.length; i++) {
            kNums.offer(input[i]);
            kNumsMax.offer(input[i]);
            if (kNums.size() == k + 1) {
                kNums.remove(kNumsMax.poll());
            }
        }
        while (!kNums.isEmpty()) {
            res.add(kNums.poll());
        }
        return res;
    }
}

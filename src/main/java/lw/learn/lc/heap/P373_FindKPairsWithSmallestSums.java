package lw.learn.lc.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2019-01-27 21:34:56
 **/
public class P373_FindKPairsWithSmallestSums {

    // FIXME 2019/1/27  待优化
    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {

        List<int[]> res = new ArrayList<>(k);
        if (k == 0) {
            return res;
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(arr -> -(arr[0] + arr[1])));
        int i = 0;
        for (; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                priorityQueue.add(new int[]{nums1[i], nums2[j]});
                if (priorityQueue.size() == k) {
                    break;
                }
            }
            if (priorityQueue.size() == k) {
                for (int j = 0; j < 0; j++) {
                    
                }
            }
        }
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll());
            if (res.size() == k) {
                break;
            }
        }
        return res;
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<int[]> res = new ArrayList<>(k);
        if (k == 0) {
            return res;
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparing(arr -> arr[0] + arr[1]));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                priorityQueue.add(new int[]{nums1[i], nums2[j]});
            }
        }
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.poll());
            if (res.size() == k) {
                break;
            }
        }
        return res;
    }
}

package lw.learn.lc.medium;


import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2018-11-13 15:23:33
 **/
public class P215_FindKthLargest {

    public int findKthLargestHeap(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (heap.size() == k) {
                if (heap.peek() < num) {
                    heap.poll();
                    heap.add(num);
                }
            } else {
                heap.add(num);
            }
        }
        return heap.peek();
    }

    public int findKthLargestPartition(int[] nums, int k) {

        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    private int findKthLargest(int[] nums, int l, int r, int k) {

        if (r >= l) {

            int partition = partition(nums, l, r);
            if (partition == k) {
                return nums[partition];
            } else if (k < partition) {
                return findKthLargest(nums, l, partition - 1, k);
            } else {
                return findKthLargest(nums, partition + 1, r, k);
            }

        }
        return -1;
    }

    private int partition(int[] nums, int l, int r) {

        int less = r;
        while (less > l) {
            if (nums[l] <= nums[r]) {
                swap(nums, l, --less);
            } else {
                l++;
            }
        }
        swap(nums, l, r);
        return l;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[1]");
        System.out.println(this.findKthLargestPartition(arr, 1));
        //System.out.println(partition(arr, 0, arr.length - 1));
    }
}

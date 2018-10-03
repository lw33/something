package lw.learn.offer;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-02 22:19:02
 * <p>
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 **/
public class P37_GetNumberOfKInArray {

    public int GetNumberOfK(int[] array, int k) {

        int start = 0;
        int end = array.length - 1;
        int mid = start + ((end - start) >> 1);
        int count = 0;

        while (end >= start) {
            if (array[mid] == k) {
                break;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + ((end - start) >> 1);
        }
        if (mid >=0 || mid < array.length) {

            for (int i = mid; i >= start; i--) {
                if (array[i] == k) {
                    count++;
                } else {
                    break;
                }
            }

            for (int i = mid + 1; i <= end; i++) {
                if (array[i] == k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] arr = {1, 3, 3, 3, 3, 4, 5};
        this.GetNumberOfK(arr, 0);
    }
}

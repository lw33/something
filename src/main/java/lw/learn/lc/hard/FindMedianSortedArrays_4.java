package lw.learn.lc.hard;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-28 20:56:16
 **/
// TODO: 2018/11/28 不是最优解
public class FindMedianSortedArrays_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums2.length == 0) {
            if (nums1.length % 2 == 0) {
                return ((double)(nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]))/ 2;
            } else {
                return nums1[nums1.length / 2];
            }
        }

        if (nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                return (double)(nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2;
            } else {
                return nums2[nums2.length / 2];
            }
        }

        int[] arr = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            arr[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < nums1.length) {
            arr[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            arr[k++] = nums2[j++];
        }
        if (arr.length % 2 == 0) {
            return (double)(arr[k / 2] + arr[k / 2 - 1]) / 2;
        } else {
            return arr[k / 2];
        }
    }

    @Test
    public void test() {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        System.out.println(this.findMedianSortedArrays(arr1, arr2));
    }
}

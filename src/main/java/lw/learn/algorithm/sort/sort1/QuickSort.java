package lw.learn.algorithm.sort.sort1;

import lw.learn.utils.SortUtil;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-09-26 08:45:47
 **/
public class QuickSort {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(sort(new int[]{6,1, 3, 2})));
        System.out.println(Arrays.toString(sort(new int[]{6})));
        System.out.println(Arrays.toString(quicksort(new int[]{6,1, 3, 2})));
        System.out.println(Arrays.toString(quicksort(new int[]{6})));
    }

    public static int[] quicksort(int[] arr) {

        if (SortUtil.isEmptyOrLength(arr)) {
            return arr;
        }

        quicksort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quicksort(int[] arr, int start, int end) {

        if (end > start) {
            int target = end;
            while (start < target) {
                if (arr[start] <= arr[end]) {
                    start++;
                } else {
                    SortUtil.swap(arr, start, --target);
                }
            }
            SortUtil.swap(arr, end, target);
            sort(arr, start, target - 1);
            sort(arr, target + 1, end);

        }

    }


    public static int[] sort(int[] arr) {

        if (SortUtil.isEmptyOrLength(arr)) {
            return arr;
        }

        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sort(int[] arr, int start, int end) {

        if (end > start) {

            int less = start - 1;
            int more = end;

            while (start < more) {
                if (arr[start] < arr[end]) {
                    SortUtil.swap(arr, ++less, start++);
                } else if (arr[start] > arr[end]) {
                    SortUtil.swap(arr, start, --more);
                } else {
                    start++;
                }
            }

            SortUtil.swap(arr, more, end);
            sort(arr, start, less);
            sort(arr, more + 1, end);
        }
    }


}

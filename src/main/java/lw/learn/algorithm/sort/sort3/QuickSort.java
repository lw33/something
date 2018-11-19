package lw.learn.algorithm.sort.sort3;


import lw.learn.utils.SortUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author lw
 * @Date 2018-09-26 08:45:47
 **/
public class QuickSort {

    public static void main(String[] args) {
        int count = 15;
        for (int i = 0; i < count; i++) {
            int arrLength = new Random().nextInt(25) + 1;
            int[] arr = new int[arrLength];
            for (int j = 0; j < arrLength; j++) {
                arr[j] = new Random().nextInt(100);
            }
            //System.out.println(Arrays.toString(sort(arr)) + " is order ? " + SortUtil.isOrder(arr));
            System.out.println(Arrays.toString(traditionSort(arr)) + " is order ? " + SortUtil.isOrder(arr));
        }
    }


    public static int[] traditionSort(int[] arr) {
        traditionSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void traditionSort(int[] arr, int start, int end) {
        if (end > start) {
            int cur = start;
            int more = end;
            while (cur < more) {
                if (arr[cur] <= arr[end]) {
                    cur++;
                } else {
                    SortUtil.swap(arr, cur, --more);
                }
            }
            SortUtil.swap(arr, end, more);
            traditionSort(arr, start, cur - 1);
            traditionSort(arr, cur + 1, end);
        }
    }

    public static int[] sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sort(int[] arr, int start, int end) {
        if (end > start) {
            int less = start - 1;
            int more = end;
            int cur = start;
            while (cur < more) {

                if (arr[cur] < arr[end]) {
                    SortUtil.swap(arr, ++less, cur++);
                } else if (arr[cur] > arr[end]) {
                    SortUtil.swap(arr, cur, --more);
                } else {
                    cur++;
                }
            }
            SortUtil.swap(arr, end, more);
            sort(arr, start, less);
            sort(arr, more + 1, end);
        }
    }

}

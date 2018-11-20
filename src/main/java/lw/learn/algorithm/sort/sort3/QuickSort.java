package lw.learn.algorithm.sort.sort3;


import lw.learn.utils.SortUtil;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-09-26 08:45:47
 **/
public class QuickSort {

    public static void main(String[] args) {
        int count = 15;
        for (int i = 0; i < count; i++) {
            int arrLength = new Random().nextInt(25) + 1;
            //int arrLength = 9000000;
            int[] arr = new int[arrLength];
            for (int j = 0; j < arrLength; j++) {
                arr[j] = new Random().nextInt(100);
            }
            System.out.println(Arrays.toString(sortStackVersion(arr)) + " is order ? " + SortUtil.isOrder(arr));
            //System.out.println(Arrays.toString(sortStackVersion(arr)));
            //System.out.println(Arrays.toString(traditionSort(arr)) + " is order ? " + SortUtil.isOrder(arr));
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

    public static int[] sortStackVersion(int[] arr) {
        sortStackVersion(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sortStackVersion(int[] arr, int start, int end) {

        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        stack.push(start);

        while (!stack.empty()) {
            start = stack.pop();
            end = stack.pop();
            if (end > start) {
                int[] patition = patition(arr, start, end);
                // 左边
                stack.push(patition[0]);
                stack.push(start);
                // 右边
                stack.push(end);
                stack.push(patition[1]);
            }
        }
    }

    private static int[] patition(int[] arr, int start, int end) {
        int less = start - 1;
        int more = end;
        while (start < more) {
            if (arr[start] < arr[end]) {
                SortUtil.swap(arr, ++less, start++);
            } else if (arr[start] > arr[end]) {
                SortUtil.swap(arr, --more, start);
            } else {
                start++;
            }
        }
        SortUtil.swap(arr, more, end);
        return new int[]{less, more + 1};
    }
}

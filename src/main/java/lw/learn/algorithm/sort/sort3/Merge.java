package lw.learn.algorithm.sort.sort3;


import lw.learn.algorithm.sort.SortUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author lw
 * @Date 2018-09-26 08:45:47
 **/
public class Merge {
    public static void main(String[] args) {
        int count = 15;
        for (int i = 0; i < count; i++) {
            int arrLength = new Random().nextInt(25) + 1;
            int[] arr = new int[arrLength];
            for (int j = 0; j < arrLength; j++) {
                arr[j] = new Random().nextInt(100);
            }
            System.out.println(Arrays.toString(sort(arr)) + " is order ? " + SortUtil.isOrder(arr));
        }
    }

    public static int[] sort(int[] arr) {

        int[] aux = new int[arr.length];
        sort(arr, 0, arr.length - 1, aux);
        return arr;
    }

    private static void sort(int[] arr, int start, int end, int[] aux) {
        if (end > start) {
            int mid = start + ((end - start) >> 1);
            sort(arr, start, mid, aux);
            sort(arr, mid + 1, end, aux);
            int p1 = start;
            int p2 = mid + 1;
            int i = 0;
            while (p1 <= mid && p2 <= end) {
                aux[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            }

            while (p1 <= mid)
                aux[i++] = arr[p1++];
            while (p2 <= end)
                aux[i++] = arr[p2++];

            for (int j = 0; j < i; j++) {
                arr[start + j] = aux[j];
            }
        }
    }

}


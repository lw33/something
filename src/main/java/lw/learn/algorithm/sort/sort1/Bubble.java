package lw.learn.algorithm.sort.sort1;

import lw.learn.algorithm.sort.SortUtil;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-09-26 08:30:18
 **/
public class Bubble {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sort(new int[]{6, 1, 3, 2})));
    }

    public static int[] sort(int[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtil.swap(arr, j, j + 1);
                }
            }
        }

        return arr;
    }
}

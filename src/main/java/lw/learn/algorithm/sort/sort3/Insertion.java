package lw.learn.algorithm.sort.sort3;

import lw.learn.utils.SortUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author lw
 * @Date 2018-09-26 08:45:47
 **/
public class Insertion {
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

        for (int i = 1; i < arr.length; i++)
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--)
                SortUtil.swap(arr, j, j - 1);

        return arr;
    }
}

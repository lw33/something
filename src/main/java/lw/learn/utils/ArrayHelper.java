package lw.learn.utils;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-11-19 13:03:17
 **/
public class ArrayHelper {
    /**
     *
     * @param size      array size [1, size]
     * @param value     array value range
     * @param positive  array value symbol
     * @return          random array
     */
    public static int[] genRandomArray(int size,boolean positive, int value) {
        int arrSize = (int) (Math.random() * size + 1);
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = (int) (positive ? value * Math.random() + 1 : (value + 1) * Math.random()  - (value + 1) * Math.random());
        }
        return arr;
    }

    public static int[] genPositiveRandomArray(int size, int value) {
        return genRandomArray(size, true, value);
    }

    public static int[] genRandomArray(int size, int value) {
        return genRandomArray(size, false, value);
    }

    public static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    public static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1==arr2)
            return true;
        if (arr1==null || arr2==null)
            return false;

        int length = arr1.length;
        if (arr2.length != length)
            return false;

        for (int i=0; i<length; i++)
            if (arr1[i] != arr2[i])
                return false;

        return true;
    }



}

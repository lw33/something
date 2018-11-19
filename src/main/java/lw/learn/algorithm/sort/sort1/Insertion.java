package lw.learn.algorithm.sort.sort1;

import lw.learn.utils.SortUtil;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-09-26 08:45:47
 **/
public class Insertion {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(sort(new int[]{6, 1, 3, 2})));
        System.out.println(Arrays.toString(sort(new int[]{6})));
    }

    public static int[] sort(int[] arr) {


        if (SortUtil.isEmptyOrLength(arr)) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 && arr[j]  < arr[j-1] ; j--) {
                SortUtil.swap(arr, j, j - 1);
            }
        }
        
        return arr;
    }
}

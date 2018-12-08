package lw.learn.algorithm.sort.sort3;


import lw.learn.utils.ArrayHelper;
import lw.learn.utils.SortUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author lw
 * @Date 2018-09-26 08:30:18
 **/
public class Bubble {

    public static void main(String[] args) {
        int count = 15;
        for (int i = 0; i < count; i++) {
            int arrLength = new Random().nextInt(30) + 1;
            int[] arr = new int[arrLength];
            for (int j = 0; j < arrLength; j++) {
                arr[j] = new Random().nextInt(100);
            }
            System.out.println(Arrays.toString(sort3(arr)) + " is order ? " + SortUtil.isOrder(arr));

        }

    }

    public static int[] sort(int[] arr) {

        for (int i = 0; i < arr.length; i++)
            for (int j = arr.length - 1; j > i; j--)
                if (arr[j - 1] > arr[j])
                    SortUtil.swap(arr, j, j - 1);

        return arr;
    }

    public static int[] sort1(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;     // 记录是否交换了 交换了则无序 否则 有序
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    SortUtil.swap(arr, j, j - 1);
                    flag = false;
                }
            }
            if (flag)
                return arr;
        }

        return arr;
    }
    public static int[] sort2(int[] arr) {

        boolean flag = true;     // 记录是否交换了 交换了则无序 否则 有序
        int k = arr.length - 1; // 比较次数
        int pos = 0;            // 上一次最后的交换位置

        for (int i = 0; i < arr.length; i++) {
            flag = true;
            for (int j = 0; j < k; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtil.swap(arr, j, j + 1);
                    pos = j;    //交换元素，记录交换的位置
                    flag = false;
                }
            }
            if (flag)
                break;
            k = pos;
        }

        return arr;
    }

    public static int[] sort3(int[] arr) {

        int pos = 0;    // 记录上一次位置
        int end = arr.length - 1;  // 比较结束位置
        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;

            for (int j = start; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtil.swap(arr, j, j + 1);
                    flag = false;
                    pos = j;
                }
            }

            if (flag)
                return arr;

            flag = true;
            end = pos;

            for (int j = end; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    SortUtil.swap(arr, j, j - 1);
                    flag = false;
                    start = j;
                }
            }

            if (flag)
                return arr;
        }

        return arr;
    }


    @Test
    public void test() {
        int count = 1000;
        int value = 100;
        int size = 20;
        for (int i = 0; i < count; i++) {
            int[] arr = ArrayHelper.genRandomArray(size, value);
            int[] arr1 = ArrayHelper.copyArray(arr);
            int[] arr2 = ArrayHelper.copyArray(arr);
            sort3(arr1);
            sort1(arr2);
            if (!ArrayHelper.isEquals(arr1, arr2)) {
                System.out.println("wrong!!!");
                return;
            }
        }
        System.out.println("done... good job...");
    }

}

package lw.learn.algorithm.sort.sort3;


import lw.learn.algorithm.sort.SortUtil;
import lw.learn.ds.Array;
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
            System.out.println(Arrays.toString(sort2(arr)) + " is order ? " + SortUtil.isOrder(arr));

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
    @Test
    public void test() {
        int[] arr = {1, 2, 3, 2, 5, 8,7};
        System.out.println(Arrays.toString(this.sort1(arr)));
        System.out.println(Arrays.toString(this.sort2(arr)));
    }

}

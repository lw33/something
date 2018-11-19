package lw.learn.p;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-11-19 14:22:03
 **/
public class SmallSum {

    private int[] aux;

    public int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        aux = new int[arr.length];
        return mergeSort(arr, 0, arr.length - 1);
    }

    // [start...end]
    private int mergeSort(int[] arr, int start, int end) {
        if (end > start) {

            int mid = start + ((end - start) >> 1);
            return mergeSort(arr, start, mid) +
                    mergeSort(arr, mid + 1, end) +
                    merge(arr, start, mid, end);
        }
        return 0;
    }
    
    // [start, end]
    private int merge(int[] arr, int start, int mid, int end) {
        int p1 = start;
        int p2 = mid + 1;
        int i = 0;
        int res = 0;

        while (p1 <= mid && p2 <= end) {
            res += arr[p1] < arr[p2] ? arr[p1] * (end - p2 + 1) : 0;
            aux[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid)
            aux[i++] = arr[p1++];

        while (p2 <= end)
            aux[i++] = arr[p2++];

        System.arraycopy(aux, 0, arr, start, i);
        return res;
    }
    
    @Test
    public void test() {
        int[] arr = {1, 2, 3, 1};
        System.out.println(this.smallSum(arr));
        System.out.println(Arrays.toString(arr));
    }
}

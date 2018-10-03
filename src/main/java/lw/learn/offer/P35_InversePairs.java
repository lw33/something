package lw.learn.offer;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-02 21:10:48
 *
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 *
 * 数据范围：
 *
 * 	对于%50的数据,size<=10^4
 *
 * 	对于%75的数据,size<=10^5
 *
 * 	对于%100的数据,size<=2*10^5
 *
 * 示例1
 * 输入
 * 复制
 * 1,2,3,4,5,6,7,0
 * 输出
 * 复制
 * 7
 *
 **/
public class P35_InversePairs {

    private int[] aux;
    public int InversePairs(int [] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        aux = new int[array.length];
        return mergeSort(array, 0, array.length - 1);
    }

    public int mergeSort(int[] arr, int start, int end) {
        if (end > start) {
            int mid = start + ((end - start) >> 1);
            return (mergeSort(arr, start, mid) + mergeSort(arr, mid + 1, end) + merge(arr, start, mid, end)) %1000000007;
        }

        return 0;
    }

    public int merge(int[] arr, int start, int mid, int end) {
        int p1 = start;
        int p2 = mid + 1;
        int i = 0;
        int res = 0;

        while (p1 <= mid && p2 <= end) {
            res += arr[p1] > arr[p2] ? mid - p1 + 1 : 0;
            res %= 1000000007;
            aux[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            aux[i++] = arr[p1++];
        }

        while (p2 <= end) {
            aux[i++] = arr[p2++];
        }

        for (int j = 0; j < i; j++) {
            arr[start + j] = aux[j];
        }

        return res % 1000000007;
    }

    @Test
    public void test() {
        int[] arr = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};

        this.InversePairs(arr);
    }
}

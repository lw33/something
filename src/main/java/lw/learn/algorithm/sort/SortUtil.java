package lw.learn.algorithm.sort;

/**
 * @Author lw
 * @Date 2018-09-30 23:27:01
 **/
public class SortUtil {

    public static void swap(int[] arr, int i, int j) {

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    public static boolean isEmptyOrLength(int[] arr) {

        return arr == null || arr.length == 0;

    }

}

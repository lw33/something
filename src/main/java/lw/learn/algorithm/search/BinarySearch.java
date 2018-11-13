package lw.learn.algorithm.search;

/**
 * @Author lw
 * @Date 2018-11-13 12:51:57
 **/
public class BinarySearch<T extends Comparable<T>> {

    /**
     * @param arr    目标数组
     * @param target 查找的目标
     * @return 查找到的索引
     */
    public int binarySearch(T arr[], T target) {
        int l = 0;
        int r = arr.length - 1;   // [l...r] 循环不变量
        //int r = arr.length;     // [l...r)
        while (l <= r) {
        //while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (arr[m].equals(target)) {
                return m;
            } else if (arr[m].compareTo(target) < 0) {
                l = m + 1;
            } else {
                r = m - 1;
                //r = m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Integer[] ints = {1, 2, 3, 3, 4, 5};
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        System.out.println(binarySearch.binarySearch(ints, 3));
    }
}

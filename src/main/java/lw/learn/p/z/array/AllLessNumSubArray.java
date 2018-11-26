package lw.learn.p.z.array;

/**
 * @Author lw
 * @Date 2018-11-26 19:35:38
 **/
public class AllLessNumSubArray {

    public int getNum1(int[] arr, int num) {

        int res = 0;
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                if (isValid(arr, start, end, num)) {
                    res++;
                }
            }
        }
        return res; }

    public boolean isValid(int[] arr, int start, int end, int num) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        return max - min <= num;
    }

}

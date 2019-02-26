package lw.learn.p.z.dp;

/**
 * @Author lw
 * @Date 2018-11-27 16:03:07
 **/
public class MoneyProblem {

    public boolean money1(int[] arr, int aim) {
        return m(arr, 0, 0, aim);
    }

    private boolean m(int[] arr, int i, int sum, int aim) {
        if (sum == aim)
            return true;
        if (i == arr.length)
            return false;
        return m(arr, i + 1, sum, aim) || m(arr, i + 1, arr[i] + sum, aim);
    }
}

package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-11-19 13:40:00
 **/
public class P905_SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        if(A == null || A.length == 0) {
            return A;
        }
        int odd = A.length - 1;
        int cur = 0;
        while (cur < odd) {
            if (A[cur] % 2 == 0) {
                cur++;
            } else {
                int tmp = A[cur];
                A[cur] = A[odd];
                A[odd] = A[cur];
                odd--;
            }
        }
        return A;
    }
}

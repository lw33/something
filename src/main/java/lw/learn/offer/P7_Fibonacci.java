package lw.learn.offer;

/**
 * @Author lw
 * @Date 2018-10-01 16:59:51
 **/
public class P7_Fibonacci {

    public  int Fibonacci(int n) {

        if (n == 0) {
            return 0;
        }
        int[] finbonacci = new int[n + 1];
        finbonacci[0] = 0;
        finbonacci[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            finbonacci[i] = finbonacci[i - 1] + finbonacci[i - 2];
        }
        return finbonacci[n];
    }
}

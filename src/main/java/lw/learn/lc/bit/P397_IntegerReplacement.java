package lw.learn.lc.bit;

/**
 * @Author lw
 * @Date 2019-03-03 23:45:05
 **/
public class P397_IntegerReplacement {

    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        } else {
            if (n != Integer.MAX_VALUE) {
                return 1 + Math.min(integerReplacement(n + 1), integerReplacement(n - 1));
            } else {
                return 32;
            }
        }
    }

    public static void main(String[] args) {
        P397_IntegerReplacement p = new P397_IntegerReplacement();
        int res = p.integerReplacement(2147483647);
        System.out.println(res);
    }
}

package lw.learn.lc.medium;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-28 21:12:37
 **/
// TODO: 2018/11/28
public class P8_MyAtoi {
    @Test
    public void test() {
        System.out.println(this.myAtoi(" 4193 with words"));
        System.out.println(this.myAtoi("-91283472332"));
    }
    public int myAtoi(String str) {
        boolean isNegative = false;
        boolean symbol = false;
        boolean numStart = false;
        long num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                numStart = true;
                num = num * 10 + str.charAt(i) - '0';
                if (isNegative) {
                    if (-num <= Integer.MIN_VALUE) {
                        num = Integer.MIN_VALUE;
                        break;
                    }
                } else if (num >= Integer.MAX_VALUE) {
                    num = Integer.MAX_VALUE;
                    break;
                }
            } else if (str.charAt(i) == '-') {
                if (symbol) {
                    break;
                }
                isNegative = true;
                symbol = true;
            } else if (str.charAt(i) == '+') {
                if (symbol) {
                    break;
                }
                isNegative = false;
                symbol = true;
            } else if (str.charAt(i) == ' ') {
                if (numStart)
                    break;
                continue;
            } else {
                break;
            }
        }
        if (isNegative) {
            num = -num;
        }
        return (int) num;
    }

    int[] memo;
    int bi(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != 0)
            return memo[n];
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(Math.max(res, i * (n - i)), i * bi(n - i));
        }
        memo[n] = res;

        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memo[i] = Math.max(Math.max(memo[i], j * (i - j)), j * memo[i - j]);
            }
        }
        return res;
    }
}

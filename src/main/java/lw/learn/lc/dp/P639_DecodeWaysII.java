package lw.learn.lc.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2019-02-27 15:45:20
 **/
public class P639_DecodeWaysII {

    int[] memo;
    public static final int mod = (int) Math.pow(10, 9) + 7;

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return numDecodings(s.toCharArray(), 0) % mod;
    }

    public int numDecodingsDP(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        // dp[i] 代表从 i - N 的方法数
        long[] dp = new long[str.length + 1];
        dp[str.length] = 1;

        for (int i = str.length - 1; i >= 0; i--) {
            // 0
            if (str[i] == '0') {
                dp[i] = 0;
            } else {
                long res = dp[i + 1];
                if (str[i] == '*') {
                    res = (9 * res) % mod;
                }
                if (i + 1 < str.length) {
                    long tmp = dp[i + 2];
                    if (str[i] != '*') {
                        if (str[i + 1] != '*') {
                            if ((str[i] - '0') * 10 + str[i + 1] - '0' < 27) {
                                res = (res + tmp) % mod;
                            }
                        } else {
                            if (str[i] < '3') {
                                if (str[i] == '1') {
                                    res = (res + 9 * tmp) % mod;
                                } else if (str[i] == '2') {
                                    res = (res + 6 * (tmp)) % mod;
                                }
                            }
                        }
                    } else {
                        if (str[i + 1] != '*') {
                            if (10 + str[i + 1] - '0' < 27) {
                                res = (res + tmp) % mod;
                            }
                            if (20 + str[i + 1] - '0' < 27) {
                                res = (res + tmp) % mod;
                            }
                        } else {
                            res = (res + 15 * tmp) % mod;
                        }
                    }
                }
                dp[i] = res;
            }
        }

        return (int) (dp[0]);
    }

    private int numDecodings(char[] str, int i) {

        if (i == str.length) {
            return 1;
        }

        if (str[i] == '0') {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int res = numDecodings(str, i + 1) % mod;
        if (str[i] == '*') {
            res *= 9;
        }
        if (i + 1 < str.length) {
            if (str[i] != '*') {
                if (str[i + 1] != '*') {
                    if ((str[i] - '0') * 10 + str[i + 1] - '0' < 27) {
                        res += numDecodings(str, i + 2) % mod;
                    }
                } else {
                    if (str[i] < '3') {
                        int tmp = numDecodings(str, i + 2);
                        if (str[i] == '1') {
                            res += 9 * tmp % mod;
                        } else if (str[i] == '2') {
                            res += 6 * tmp % mod;
                        }
                    }
                }
            } else {
                if (str[i + 1] != '*') {
                    if (10 + str[i + 1] - '0' < 27) {
                        res += numDecodings(str, i + 2);
                    }
                    if (20 + str[i + 1] - '0' < 27) {
                        res += numDecodings(str, i + 2);
                    }
                } else {
                    int tmp = numDecodings(str, i + 2);
                    res += tmp * 15 % mod;
                }
            }
        }
        res = res % mod;
        memo[i] = res;
        return res;
    }

    @Test
    public void test() {
        String str = "**********1111111111";
        System.out.println(this.numDecodings(str));
        System.out.println(this.numDecodingsDP(str));
        System.out.println((long) 9 * mod);
        System.out.println((long) 6 * mod);
        System.out.println((long) 15 * mod);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(mod);
    }
}

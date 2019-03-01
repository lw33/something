package lw.learn.lc.dp;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-28 14:51:14
 **/
public class P132_PalindromePartitioningII {

    private boolean[][] getIsPalindrome(char[] s) {

        boolean[][] isPalindrome = new boolean[s.length][s.length];

        for (int i = 0; i < s.length; i++) {
            isPalindrome[i][i] = true;
            if (i + 1 < s.length && s[i] == s[i + 1]) {
                isPalindrome[i][i + 1] = s[i] == s[i + 1];
            }
        }

        for (int len = 2; len < s.length; len++) {
            for (int start = 0; start + len < s.length; start++) {

                isPalindrome[start][start + len] =
                        isPalindrome[start + 1][start + len - 1] &&
                                s[start] == s[start + len];
            }
        }

        return isPalindrome;
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] str = s.toCharArray();
        if (isPalindrome(str, 0, str.length - 1)) {
            return 0;
        }
        // preparation
        boolean[][] isPalindrome = getIsPalindrome(str);

        // initialize
        int[] f = new int[str.length + 1];

        // main
        for (int i = 1; i <= str.length; i++) {
            f[i] = i;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }

        return f[str.length] - 1;
    }

    public boolean isPalindrome(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public int minCut_(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        char[] str = s.toCharArray();
        int[] pLen = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            for (int j = i; j < str.length; j++) {
                if (isPalindrome(str, i, j)) {
                    pLen[i] = j - i + 1;
                }
            }
        }

        int cut = 0;
        int cur = 0;
        int next = 0;

        for (int i = 0; i < pLen.length; i++) {
            if (cur < i) {
                System.out.println(new String(str, cur, next - cur));
                cut++;
                cur = next;
            }
            next = Math.max(next, i + pLen[i]);
        }

        return cut;
    }


    @Test
    public void test() {
        String str = "fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi";
        //String str = "didbhbdbfb";
        //String str = "fifjhi";
        //String str = "aab";
        //String str = "aabad";
        System.out.println(this.minCut(str));
    }
}

package lw.learn.lc.string;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-08 23:46:28
 **/
// FIXME 2019/1/9  优化
public class P680_ValidPalindromeII {

    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 2) {
            return true;
        }
        char[] chars = s.toCharArray();

        int start = 0;
        int end = chars.length - 1;
        while (end > start) {
            if (chars[start] != chars[end]) {
                return isPalindrome(chars, start, end - 1) || isPalindrome(chars, start + 1, end);
            }
            --end;
            ++start;
        }
        return true;
    }

    public boolean isPalindrome(char[] chars, int start, int end) {
        while (end >= start) {
            if (chars[start] != chars[end]) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }

    @Test
    public void test() {
        String s = "abca";
        System.out.println(this.validPalindrome(s));
    }
}

package lw.learn.lc.dp;

import lw.learn.utils.StringHelper;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-19 22:54:24
 **/
public class P647_PalindromicSubstrings {

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            res += countSubstrings(chars, i);
        }
        return res + chars.length;
    }

    private int countSubstrings(char[] chars, int index) {
        int res = 0;
        for (int i = index + 1; i < chars.length; i++) {
            if (StringHelper.isPalindrome(chars, index, i)) {
                res++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        String s = "abc";
        System.out.println(this.countSubstrings(s));
    }

}

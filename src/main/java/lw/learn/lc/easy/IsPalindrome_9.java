package lw.learn.lc.easy;

import lw.learn.utils.StringHelper;

/**
 * @Author lw
 * @Date 2018-11-20 16:50:43
 * @tag easy
 **/
public class IsPalindrome_9 {

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String s = String.valueOf(x);
        return StringHelper.isPalindrome(s);
    }

    public boolean isPalindromeFastest(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) { //x是10的倍数一定不是回文串
            return false;
        }
        int s = 0;
        // x 往前 s 往后
        while (s <= x) {
            s = s * 10 + x % 10;
            if (s == x || s == x / 10) { //分别处理整数长度是奇数或者偶数的情况
                return true;
            }
            x /= 10;
        }
        return false;
    }
}

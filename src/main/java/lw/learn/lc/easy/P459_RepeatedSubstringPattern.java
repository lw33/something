package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-27 12:55:46
 **/
// FIXME 2018/12/27  不是最优解
public class P459_RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        int half = chars.length / 2;
        for (int i = 1; i <= half; i++) {
            if (chars.length % i != 0) {
                continue;
            }
            boolean flag = true;
            String pre = s.substring(0, i);
            int length = chars.length - i;
            for (int j = i; j <= length; j += i) {
                String word = s.substring(j, j + i);
                if (!word.equals(pre)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        String s = "aabaaba";
        System.out.println(this.repeatedSubstringPattern(s));
    }
}

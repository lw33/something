package lw.learn.lc.string;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-01 20:57:50
 **/
public class P522_LongestUncommonSubsequenceII {

    public int findLUSlength(String[] strs) {
        String s = strs[0];
        boolean flag = true;
        int maxLength = 0;
        for (String str : strs) {
            if (!s.equals(str) && str.contains(s) && s.contains(str)) {
                flag = false;
            }
            if (maxLength < str.length()) {
                maxLength = str.length();
            }
        }
        if (flag) {
            return -1;
        }
        return maxLength;
    }

    @Test
    public void test() {
        String[] strs = {"aaa", "aaa", "aa"};
        System.out.println(this.findLUSlength(strs));
    }
}

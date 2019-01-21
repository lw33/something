package lw.learn.lc.math;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-21 22:41:24
 **/
public class P171_ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            res = res * 26 + chars[i] - 'A' + 1;
        }
        return res;
    }

    @Test
    public void test() {
        String s1 = "AA";
        String s2 = "Z";
        String s3 = "ZY";
        System.out.println(this.titleToNumber(s1));
        System.out.println(this.titleToNumber(s2));
        System.out.println(this.titleToNumber(s3));
    }
}

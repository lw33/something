package lw.learn.lc.string;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-08 21:04:32
 **/
public class P709_ToLowerCase {

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] =(char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }
    @Test
    public void test() {
        String s = "Hello";
        System.out.println(toLowerCase(s));
    }
}

package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-02 23:11:06
 **/
public class ReverseStr_541 {

    public String reverseStr(String s, int k) {

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i += 2 * k) {
            reverse(chars, i, i + k - 1);
        }

        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        end = end >= chars.length - 1 ? chars.length - 1 : end;
        while (end > start) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            end--;
            start++;
        }
    }

    @Test
    public void test() {
        String str = "abcdefg";
        System.out.println(this.reverseStr(str, 2));
    }
}

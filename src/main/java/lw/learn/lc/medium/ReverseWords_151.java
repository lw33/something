package lw.learn.lc.medium;

import javax.security.auth.callback.CallbackHandler;
import java.util.stream.IntStream;

/**
 * @Author lw
 * @Date 2018-12-02 23:34:15
 **/
public class ReverseWords_151 {

    public String reverseWords(String s) {

        int start = 0;

        for (; start < s.length() - 1; start++) {
            if (s.charAt(start) != ' ') {
                break;
            }
        }

        int end = s.length() - 1;
        for (; end >= 0; end--)
            if (s.charAt(end) != ' ')
                break;


        StringBuilder sb = new StringBuilder();

        while (end > start) {

        }
    }

    public void reverse(char[] chars, int start, int end) {
        while (end > start) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            end--;
            start++;
        }
    }
}

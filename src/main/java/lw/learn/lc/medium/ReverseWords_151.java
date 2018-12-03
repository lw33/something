package lw.learn.lc.medium;

import org.junit.Test;

import javax.security.auth.callback.CallbackHandler;
import java.nio.charset.Charset;
import java.util.stream.IntStream;
import java.util.zip.GZIPOutputStream;

/**
 * @Author lw
 * @Date 2018-12-02 23:34:15
 **/
public class ReverseWords_151 {

    public String reverseWords(String s) {

        int start = 0;
        for (; start < s.length() - 1; start++)
            if (s.charAt(start) != ' ')
                break;
        int end = s.length() - 1;
        for (; end >= 0; end--)
            if (s.charAt(end) != ' ')
                break;

        StringBuilder sb = new StringBuilder();

        while (end >= 0) {

            int wStart = end;
            while (wStart >= 0 && s.charAt(wStart) != ' ')
                wStart--;

            if (wStart != end) {
                for (int i = wStart + 1; i <= end; i++) {
                    sb.append(s.charAt(i));
                }
                if (wStart > start) {
                    sb.append(' ');
                }
            }
            end = wStart - 1;
        }


        return sb.toString();
    }

    @Test
    public void test() {
        String str = "  a  ";
        System.out.println(this.reverseWords(str));
    }

}

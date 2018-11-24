package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-24 20:48:57
 **/
public class ConvertToTitle_168 {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            char s = (char) ((n - 1) % 26 + 'A');
            sb.insert(0, s);
            n = (n - 1) / 26;
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(this.convertToTitle(27));
    }
}

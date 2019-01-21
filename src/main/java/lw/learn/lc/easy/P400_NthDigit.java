package lw.learn.lc.easy;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @Author lw
 * @Date 2018-12-22 23:46:00
 **/
public class P400_NthDigit {

    public int findNthDigit(int n) {

        if (n < 10) {
            return n;
        }
        return IntStream.rangeClosed(1, n).
                collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).
                charAt(n - 1) - '0';
    }

    @Test
    public void test() {
        System.out.println(this.findNthDigit(100000000));
    }
}

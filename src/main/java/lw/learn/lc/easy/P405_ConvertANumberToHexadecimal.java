package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-17 13:39:06
 **/
public class P405_ConvertANumberToHexadecimal {

    public String toHex(int num) {
        if (num < 10 && num >= 0) {
            return String.valueOf(num);
        }
        char[] hex = new char[16];
        int index = 0;
        for (; index < 10; index++) {
            hex[index] = (char) ('0' + index);
        }

        for (; index < 16; index++) {
            hex[index] = (char) ('a' + index - 10);
        }

        StringBuilder sb = new StringBuilder();
        int and = 15;

        for (int i = 0; i < 32; i += 4) {
            index = num & and;
            sb.append(hex[index]);
            num >>>= 4;
        }
        StringBuilder res = new StringBuilder();
        boolean zero = true;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                if (zero) {
                    continue;
                }
                res.append(sb.charAt(i));
            } else {
                zero = false;
                res.append(sb.charAt(i));
            }
        }
        return res.toString();
    }

    @Test
    public void test() {
        System.out.println(toHex(26));
    }
}

package lw.learn.lc.stack;


import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-01-20 23:29:34
 **/
public class P402_RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (k == 0) {
            return num;
        }
        if (num.length() <= k) {
            return "0";
        }
        char[] chars = num.toCharArray();
        LinkedList<Character> dbq = new LinkedList<>();
        int i = 0;
        for (; i < chars.length; i++) {
            if (dbq.isEmpty()) {
                if (chars[i] != '0') {
                    dbq.push(chars[i]);
                }
            } else {
                Character peek = dbq.peek();
                if (peek > chars[i]) {
                    dbq.poll();
                    dbq.push(chars[i]);
                }
                --k;
            }
            if (k == -1) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!dbq.isEmpty()&&dbq.peekFirst() == '0') {
            dbq.removeFirst();
        }
        while (!dbq.isEmpty()) {
            sb.append(dbq.removeFirst());
        }
        if (i < chars.length) {
            sb.append(num.substring(i));
        }
        String s = sb.toString();
        if ("".equals(s)) {
            return "0";
        }
        return s;
    }

    @Test
    public void test() {
        String num = "10200";
        int k = 1;
        System.out.println(this.removeKdigits(num, k));
    }
}

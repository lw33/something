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
        for (int i = 0; i < chars.length; i++) {
            if (k == 0) {
                dbq.push(chars[i]);
                continue;
            }

            while (!dbq.isEmpty() && dbq.peek() > chars[i]) {
                dbq.poll();
                --k;
                if (k == 0) {
                    break;
                }
            }
            if (dbq.isEmpty()) {
                if (chars[i] != '0') {
                    dbq.push(chars[i]);
                }
                continue;
            }
            Character peek = dbq.peek();
            if (peek > chars[i]) {
                dbq.push(chars[i]);
            } else if (peek == chars[i]) {
                dbq.push(chars[i]);
            } else {
                --k;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!dbq.isEmpty() && dbq.peekLast() == '0') {
            dbq.removeLast();
        }
        while (!dbq.isEmpty()) {
            Character character = dbq.removeLast();
            if (k == 0) {
                sb.append(character);
            } else {
                --k;
            }
        }
        String s = sb.toString();
        if ("".equals(s)) {
            return "0";
        }
        return s;
    }

    @Test
    public void test() {
        String num = "996414";
        int k = 3;
        System.out.println(this.removeKdigits(num, k));
    }
}

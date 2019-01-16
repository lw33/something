package lw.learn.nk.wy.p3;

import java.util.Scanner;

/**
 * @Author lw
 * @Date 2019-01-16 18:14:08
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if (next.length() < 2) {
            System.out.println(next.length());
            return;
        }
        int len = 1;
        int max = 0;
        char[] chars = next.toCharArray();
        char pre = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (pre == chars[i]) {
                len = 1;
            } else {
                len++;
                max = max < len ? len : max;
            }
            pre = chars[i];
        }
        System.out.println(max);
    }
}

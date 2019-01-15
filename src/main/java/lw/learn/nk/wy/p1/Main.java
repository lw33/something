package lw.learn.nk.wy.p1;

import java.util.Scanner;

/**
 * @Author lw
 * @Date 2019-01-15 13:39:21
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if (next.length() == 1) {
            System.out.println(1);
            return;
        }
        char[] chars = next.toCharArray();
        int[] hash = new int[26];
        int unique = 0;
        for (int i = 0; i < chars.length; i++) {
            if (hash[chars[i] - 'A'] == 0) {
                ++unique;
                hash[chars[i] - 'A'] = 1;
            }
        }
        if (unique > 2) {
            System.out.println(0);
            return;
        }
        System.out.println(unique);
    }
}

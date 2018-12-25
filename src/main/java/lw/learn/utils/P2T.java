package lw.learn.utils;

import java.util.Scanner;

/**
 * 将 LeetCode 上的英文标题转化为 Pxxx_name 的类名
 * @Author lw
 * @Date 2018-12-17 14:13:25
 **/
public class P2T {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String s = scanner.nextLine();
                s = s.replaceAll("[^a-z|A-Z|0-9|\\ ]", " ");
                String[] strs = s.split(" ");
                StringBuilder res = new StringBuilder();
                res.append("P" + strs[0] + "_");
                for (int i = 1; i < strs.length; i++) {
                    if ("".equals(strs[i])) {
                        continue;
                    }
                    String substring = strs[i].substring(0, 1);
                    String s1 = substring.toUpperCase();
                    res.append(s1 + strs[i].substring(1));
                }
                System.out.println(res);
            } catch (Exception e) {

            }
        }

    }

}

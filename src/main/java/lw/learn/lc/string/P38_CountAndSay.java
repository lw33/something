package lw.learn.lc.string;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-07 23:02:12
 **/
public class P38_CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        // 递归调用
        String s = countAndSay(n - 1);
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
                int count = 1;
                // 统计相等的数的个数
                while (i + 1 < chars.length && chars[i + 1] == chars[i]) {
                    i++;
                    count++;
                }
                // 添加
                sb.append(count);
                sb.append(chars[i]);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
    }
}

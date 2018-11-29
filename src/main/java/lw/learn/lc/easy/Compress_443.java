package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-28 15:19:16
 **/
public class Compress_443 {

    public int compress(char[] chars) {

        int[] w = {1000, 100, 10};
        // [l..r) 一样
        int l = 0;
        int r = 0;
        // 当前下标
        int cur = 0;
        int length;
        for (; r < chars.length;) {
            while (r < chars.length && chars[r] == chars[l]) {
                r++;
            }
            length = r - l;   // [l..r) r - l 相等字符长度
            chars[cur++] = chars[l];
            // 高位
            for (int base : w) {
                int h = length / base;
                if (h > 0) {
                    chars[cur++] = (char) (h + '0');
                }
            }
            // 个位
            if (length > 1) {
                chars[cur++] = (char) (length % 10 + '0');
            }
            l = r;

        }
        return cur;
    }
    
    @Test
    public void test() {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int compress = this.compress(chars);
        System.out.println(compress);
        for (int i = 0; i < compress; i++) {
            System.out.print(chars[i] + " ");
        }
    }
}

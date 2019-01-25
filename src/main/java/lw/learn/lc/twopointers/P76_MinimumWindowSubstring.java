package lw.learn.lc.twopointers;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-24 19:30:45
 **/
public class P76_MinimumWindowSubstring {

    /**
     * 定义两个指针 l r
     * r 往右走 先找到以 l 开头的最短序列
     * 再让 l 往右走 找到以 r 结束的最短序列
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        char[] tChars = t.toCharArray();
        int[] map = new int[256];
        char[] sChars = s.toCharArray();
        // 将所需匹配的数字存入 map
        for (char tChar : tChars) {
            map[tChar]++;
        }
        // 左指针
        int l = 0;
        // 右指针
        int r = 0;
        // 所需要匹配的字符总数
        int match = tChars.length;
        String res = "";
        int min = Integer.MAX_VALUE;
        while (r != sChars.length) {
            // 将 map 的位置减一
            map[sChars[r]]--;
            // 如果 r 位置是一个有效的匹配 则 r 位置的字符一定在 map 中
            // 则 map 中的对应的位置大于 0
            if (map[sChars[r]] >= 0) {
                // 匹配到一个字符 还要匹配的字符数 减一个
                match--;
            }
            // 匹配到了所有字符
            while (match == 0) {
                // 将 l 右移动
                // 跳过那些不被匹配或多余匹配的字符
                while (map[sChars[l]] < 0) {
                    map[sChars[l++]]++;
                }
                // 此时找到以 r 位置结尾最小的长度
                int len = r - l + 1;
                if (min > len) {
                    res = new String(sChars, l,  len);
                    min = len;
                }
                // l 向右移动
                map[sChars[l++]]++;
                // 不被匹配就 加了一个
                match++;
            }
            r++;
        }
        return res;
    }

    @Test
    public void test() {
        //String s = "ADOBECODEBANC";
        //String t = "ABC";
        String s = "aaaaabc";
        String t = "abc";
        System.out.println(this.minWindow(s, t));
    }
}

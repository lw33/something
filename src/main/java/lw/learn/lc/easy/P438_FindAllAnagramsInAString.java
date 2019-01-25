package lw.learn.lc.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-27 00:44:26
 **/
public class P438_FindAllAnagramsInAString {


    /**
     * 看错题了...
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams1(String s, String p) {

        List<Integer> res = new ArrayList<>();
        char[] chars = p.toCharArray();
        int start = 0;
        int f;
        while (true) {
            boolean flag = true;
            start = s.indexOf(chars[0], start + 1);
            if (start == -1) {
                break;
            }
            f = start;
            for (int i = 1; i < chars.length; i++) {
                f = s.indexOf(chars[i], f + 1);
                if (f < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (start > 0) {
                    res.add(start);
                }
            }
        }
        return res;
    }

    /**
     * 使用双指针加哈希表实现
     * 定义 l r 指针
     * r 一直往右走 知道找到当前 map 中不存在的元素 或者所有元素都匹配 则将 l 加入 list
     * 当 元素不匹配时 l 往右走 直到走到 不匹配的元素被匹配时
     *
     * 因为在不匹配时 l 就往右 所以总能将最终的结果窗口限制在 p 的长度
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        int[] map = new int[256];
        char[] pChars = p.toCharArray();
        for (int i = 0; i < pChars.length; i++) {
            map[pChars[i]]++;
        }
        char[] sChars = s.toCharArray();
        int l = 0;
        int r = 0;
        int match = pChars.length;
        while (r != sChars.length) {

            map[sChars[r]]--;
            // 当前元素不在 map 中
            if (map[sChars[r]] < 0) {
                // 因为后面可能会跳过这个元素 所以把他当一个匹配
                match--;
                // 当 r 位置的值变为 0 时 则证明 l - r 中 所有元素都匹配
                while (map[sChars[r]] < 0) {
                    map[sChars[l++]]++;
                    match++;
                }
            } else {
                // 匹配
                match--;
            }
            // 所有匹配时
            if (match == 0) {
                res.add(l);
                // l 往右移动一位
                map[sChars[l++]]++;
                match++;
            }
            // 加速的 匹配 当窗口长度为 p 的长度时
            if (r - l + 1 == pChars.length) {
                map[sChars[l++]]++;
                match++;
            }
            r++;
        }

        return res;
    }

    public void printMap(int[] map) {
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                System.out.println((char) i + ":" + map[i]);
            }
        }
    }

    @Test
    public void test() {
        String s = "cbaebabacd", p = "abcd";
        System.out.println(this.findAnagrams(s, p));
    }

}

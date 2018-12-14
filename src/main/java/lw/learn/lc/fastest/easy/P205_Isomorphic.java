package lw.learn.lc.fastest.easy;

/**
 * @Author lw
 * @Date 2018-12-14 14:14:43
 **/
public class P205_Isomorphic {
    // TODO 2018/12/14  666
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s == null || t == null || s.length() != t.length()) {
                return false;
            }
            char[] chas1 = s.toCharArray();
            char[] chas2 = t.toCharArray();
            //8位ASCII码表共256个字符
            int[] map = new int[512];//0～255存s的字符。之后存t的字符
            for (int i = s.length() - 1; i >= 0; i--) {
                if (map[chas1[i]] != map[chas2[i] + 256]) {//把字符当下标，实际上是ASCII码
                    return false;
                }
                // 把一个映射的两个下标都填上同一个数，也防止了多映射的问题
                map[chas1[i]] = map[chas2[i] + 256] = i;
            }
            return true;
        }
    }
}

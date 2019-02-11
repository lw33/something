package lw.learn.lc.string;

/**
 * @Author lw
 * @Date 2019-02-10 22:01:56
 **/
public class P696_CountBinarySubstrings {

    /**
     * last 记录上一个字符最长的连续串
     * cur 记录当前字符最长的连续串
     * 当 last >= cur 时则结果数 +1
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {

        int cur = 1;
        int last = 0;
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                cur++;
            } else {
                last = cur;
                cur = 1;
            }
            if (last >= cur) {
                res++;
            }
        }
        return res;
    }
}

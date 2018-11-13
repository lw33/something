package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-11-13 16:51:26
 **/
public class LengthOfLongestSubstring_3 {

    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        int res = 0;

        while (s.length() > l) {

            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0)
                freq[s.charAt(++r)]++;
            else
                freq[s.charAt(l++)]--;

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}

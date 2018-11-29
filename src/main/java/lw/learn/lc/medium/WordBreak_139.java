package lw.learn.lc.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-29 21:42:16
 **/
public class WordBreak_139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        boolean[] dp = new boolean[s.length()];
        int n = dp.length;
        int index = s.length() - 1;
        // 找到最右边匹配串
        for (; index >= 0; index--) {
            if (wordDict.contains(s.substring(index, n))) {
                dp[index] = true;
                break;
            }
            dp[index] = false;
        }
        // 没有匹配
        if (index == -1) {
            return false;
        }
        // 整个长度匹配
        if (index == 0)
            return true;

        // i .. n 匹配情况
        for (int i = index - 1; i >= 0; i--) {
            dp[i] = false;
            //  i 到末尾匹配
            if (wordDict.contains(s.substring(i))) {
                dp[i] = true;
                continue;
            }
            for (int j = i + 1; j <= index; j++) {
                String substring = s.substring(i, j);
                // i 到 j 与 j 开始匹配
                if (wordDict.contains(substring) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }

    // index .. n
    public boolean wordBreak(String s, int index, HashSet<String> wordDict) {

        if (wordDict.contains(s.substring(index))) {
            return true;
        }

        for (int i = index + 1; i < s.length(); i++) {
            String substring = s.substring(index, i);
            if (wordDict.contains(substring) && wordBreak(s, i, wordDict)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        String str = "leetcode";
        List<String> lists = Arrays.asList("leet", "code");
        System.out.println(this.wordBreak(str, lists));
    }
}

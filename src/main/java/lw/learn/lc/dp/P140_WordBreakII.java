package lw.learn.lc.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-03-01 22:13:48
 **/
public class P140_WordBreakII {

    List<String> res;

    /**
     * 太暴力了。。。
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0 || wordDict.isEmpty()) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        HashSet<String> set = new HashSet<>(wordDict);
        List<String> list = new ArrayList<>();
        dfs(s, set, 0, 0, list);
        return res;
    }

    private void dfs(String s, HashSet<String> set, int index, int len, List<String> list) {

        if (index == s.length()) {
            if (len == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (String s1 : list) {
                    sb.append(s1);
                    sb.append(" ");
                }
                res.add(sb.toString().substring(0, sb.length() - 1));
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (set.contains(substring) && canWordBreak(s.substring(i + 1), set)) {
                list.add(substring);
                dfs(s, set, i + 1, len + i - index + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean canWordBreak(String s, HashSet<String> set) {
        if (s == null || s.length() == 0) return true;
        boolean[] dp = new boolean[s.length()];
        int n = dp.length;
        int index = s.length() - 1;
        for (; index >= 0; index--) {
            if (set.contains(s.substring(index, n))) {
                dp[index] = true;
                break;
            }
            dp[index] = false;
        }
        if (index == -1) {
            return false;
        }
        if (index == 0)
            return true;

        for (int i = index - 1; i >= 0; i--) {
            dp[i] = false;
            if (set.contains(s.substring(i))) {
                dp[i] = true;
                continue;
            }
            for (int j = i + 1; j <= index; j++) {
                String substring = s.substring(i, j);
                if (set.contains(substring) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }


    @Test
    public void test() {
        //List<String> list = Arrays.asList("cat", "cats", "and", "sand", "dog");
        //String s = "catsanddog";
        List<String> list = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        String s = "pineapplepenapple";
        System.out.println(this.wordBreak(s, list));
    }
}

package lw.learn.offer;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-03 17:11:24
 * <p>
 * <p>
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 **/
public class P52_RegexMatch {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        /*
         * 从后往前，s从空串开始，p从最后一个字符开始，两个空串的匹配为true
         */
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = (i < s.length()) &&
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    /*
                     *  形如OOOO 匹配 X*XXXX
                     *  要么*对应的字符出现0次；要么开头字符一样，看s去掉首字母后是否匹配
                     */
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        if (str.length == 0 && pattern.length == 0) {
            return true;
        }

        return match(str, 0, pattern, 0);
    }

    public boolean match(char[] str, int strIndex, char[] pattern, int patIndex) {

        int starCount = 0;
        for (int i = patIndex + 1; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                starCount++;
            } else {
                break;
            }
        }
        if (strIndex == str.length) {
            if (patIndex == pattern.length || patIndex + starCount == pattern.length) {
                return true;
            } else {
                if (starCount == 0) {
                    return false;
                } else {
                    return match(str, strIndex, pattern, patIndex + starCount + 1);
                }
            }
        } else if (patIndex == pattern.length) {
            return false;
        }
        if (starCount == 0) {
            if (pattern[patIndex] == '.' || pattern[patIndex] == str[strIndex]) {
                return match(str, ++strIndex, pattern, ++patIndex);
            } else {
                return false;
            }
        } else {
            if (pattern[patIndex] == '.' || pattern[patIndex] == str[strIndex]) {
                return match(str, strIndex + 1, pattern, patIndex) || match(str, strIndex, pattern, patIndex + starCount + 1);

            } else {
                return match(str, strIndex, pattern, patIndex + starCount + 1);
            }
        }
    }


    @Test
    public void test() {
        String a = "a";
        String b = ".**";
        System.out.println(this.match(a.toCharArray(), b.toCharArray()));
    }

}

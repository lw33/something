package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-01 13:40:33
 *
 *
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 **/
public class LongestCommonPrefix_14 {

    public String longestCommonPrefix(String[] strs) {

        String commonPrefix = "";

        if (strs == null || strs.length == 0) {
            return commonPrefix;
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int i = 0;

        for (; i < strs[0].length(); i++) {

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, i);
    }

    @Test
    public void test() {
        System.out.println(this.longestCommonPrefix(new String[]{"aa", "a"}));
    }
}

package lw.learn.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author lw
 * @Date 2018-10-02 18:30:30
 * <p>
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 **/
public class P27_StringPermutation {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        boolean[] used = new boolean[str.length()];
        permutation(str, "", used, res);
        Collections.sort(res);
        return res;
    }

    public void permutation(String str, String s, boolean[] used, ArrayList<String> res) {
        if (s.length() == str.length()) {
            res.add(s);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                s += str.charAt(i);
                permutation(str, s, used, res);
                s = s.substring(0, s.length() - 1);
                used[i] = false;
            }
        }
    }
}

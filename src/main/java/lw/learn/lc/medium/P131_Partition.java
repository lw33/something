package lw.learn.lc.medium;

import lw.learn.utils.StringHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-10 12:32:07
 **/
public class P131_Partition {
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        List<String> strs = new ArrayList<>();
        char[] chars = s.toCharArray();
        partition(chars, 0, strs, res);
        return res;
    }
    public void partition(char[] s, int index, List<String> strs, List<List<String>> res) {

        if (s.length == index) {
            res.add(new ArrayList<>(strs));
            return;
        }
        for (int i = index; i < s.length; i++) {
            if (StringHelper.isPalindrome(s, index, i)) {
                strs.add(new String(s, index, i - index + 1));
                partition(s, i + 1, strs, res);
                strs.remove(strs.size() - 1);
            }
        }
    }

    public void partition(String s, int index, List<String> strs, List<List<String>> res) {

        if (s.length() == index) {
            res.add(new ArrayList<>(strs));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String substring = s.substring(index, i);
            if (StringHelper.isPalindrome(substring)) {
                strs.add(substring);
                partition(s, i, strs, res);
                strs.remove(strs.size() - 1);
            }
        }
    }




    @Test
    public void test() {
        String s = "aab";
        System.out.println(this.partition(s));
    }
}

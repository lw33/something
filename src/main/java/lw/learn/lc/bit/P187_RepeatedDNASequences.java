package lw.learn.lc.bit;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-01 13:15:02
 **/
public class P187_RepeatedDNASequences {

    /**
     * 将序列依次添加进集合
     * 如果添加失败 则证明集合中已存在
     * 则将序列加入 重复字符集合
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences2(String s) {

        List<String> res = new ArrayList<>();
        if (s.length() <= 10) {
            return res;
        }
        HashSet<String> allString = new HashSet<>();
        HashSet<String> repeatedString = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 9; i++) {
            String string = new String(chars, i, 10);
            if (!allString.add(string)) {
                repeatedString.add(string);
            }
        }
        for (String s1 : repeatedString) {
            res.add(s1);
        }
        return res;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() <= 10) {
            return res;
        }

        HashSet<String> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 9; i++) {
            String string = new String(chars, i, 10);
            if (!set.contains(string)) {
                if (s.indexOf(string, i + 1) > 0) {
                    set.add(string);
                }
            }
        }
        for (String s1 : set) {
            res.add(s1);
        }
        return res;
    }

    @Test
    public void test() {
        String s = "aaaaaaaaaaa";
        System.out.println(this.findRepeatedDnaSequences2(s));
    }
}

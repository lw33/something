package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-27 23:56:29
 **/
public class P925_LongPressedName {


    public boolean isLongPressedName666(String name, String typed) {
        // 判断条件
        if (name.length() > typed.length()) {
            return false;
        }

        char[] types = typed.toCharArray();
        char[] names = name.toCharArray();

        // 相等的长度, 并作为 names 索引
        int eqLength = 0;

        for (int i = 0; i < types.length; i++) {

            // 如果当前的 types 字符等于 names 字符
            if (eqLength < names.length && types[i] == names[eqLength]) {

                // 相等数自增
                eqLength++;

            // 对应位置不等的情况下如果 types 当前位子的值不等于前一个位置则返回 false
            } else if (i > 0 && types[i] != types[i - 1]) {
                return false;
            }
        }
        // 最后相等长度是否为 names 长度
        return eqLength == names.length;
    }
    public boolean isLongPressedName(String name, String typed) {
        // 判断条件
        if (name.length() > typed.length()) {
            return false;
        }
        // name index
        int nIndex = 0;

        // typed index
        int tIndex = 0;

        // 比较第一个字符是否相等
        if (name.charAt(nIndex++) != typed.charAt(tIndex++)) {
            return false;
        }
        while (tIndex < typed.length() && nIndex < name.length()) {
            // 比较相应索引字符是否相等
            if (name.charAt(nIndex) != typed.charAt(tIndex)) {
                // 比较 typed 当前是否为长按
                if (typed.charAt(tIndex - 1) != typed.charAt(tIndex)) {
                    return false;
                }
            } else {
                nIndex++;
            }
            tIndex++;
        }
        // name 是否比较完
        if (nIndex != name.length()) {
            return false;
        }
        // typed 是否到底
        while (tIndex < typed.length()) {
            // 最后是否长按
            if (typed.charAt(tIndex - 1) != typed.charAt(tIndex++)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String n = "saeed";
        String t = "ssaaedd";
        System.out.println(this.isLongPressedName(n, t));
    }
}

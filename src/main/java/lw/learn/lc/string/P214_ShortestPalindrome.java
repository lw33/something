package lw.learn.lc.string;


import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-03-05 22:42:01
 **/
public class P214_ShortestPalindrome {

    public char[] manacherStr(char[] str) {
        char[] manacherStr = new char[str.length * 2 + 1];
        for (int i = 0; i < manacherStr.length; i++) {
            if (i % 2 == 0) {
                manacherStr[i] = '#';
            } else {
                manacherStr[i] = str[i >> 1];
            }
        }
        return manacherStr;
    }

    public String shortestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        reverse(chars);
        char[] str = manacherStr(chars);

        int index = 0;
        int r = 0;

        int[] ir = new int[str.length];

        for (int i = 0; i < str.length; i++) {

            ir[i] = i < r ? Math.min(ir[index * 2 - i], r - i) : 1;
            while (i + ir[i] >= r &&
                    i + ir[i] < str.length &&
                    i - ir[i] > -1 &&
                    str[i + ir[i]] == str[i - ir[i]]) {
                ir[i]++;
            }

            if (i + ir[i] > r) {
                r = i + ir[i];
                index = i;
            }

            if (i + ir[i] == str.length) {
                break;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (i % 2 == 1) {
                res.append(str[i]);
            }
        }
        for (int i = index * 2 - r; i > 0; i--) {
            if (i % 2 == 1) {
                res.append(str[i]);
            }
        }
        return res.toString();
    }

    public void reverse(char[] str) {
        int start = 0;
        int end = str.length - 1;
        while (end > start) {
            char tmp = str[start];
            str[start++] = str[end];
            str[end--] = tmp;
        }
    }

    @Test
    public void test() {
        String str = "aabba";
        System.out.println(this.shortestPalindrome(str));
    }
}

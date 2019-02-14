package lw.learn.lc.string;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-12 12:27:58
 **/
public class P686_RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        int index = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(A);

        while (true) {
            if (sb.toString().contains(B)) {
                return index;
            }
            index++;
            sb.append(A);
            if (index * A.length() > 2 * A.length() + B.length()) {
                return -1;
            }
        }
    }

    @Test
    public void test() {
        String s = "abcabcabcabc";
        String s1 = "abac";
        System.out.println(this.repeatedStringMatch(s, s1));
    }
}

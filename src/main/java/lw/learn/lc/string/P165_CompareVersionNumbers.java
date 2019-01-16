package lw.learn.lc.string;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-16 18:05:58
 **/
public class P165_CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {

        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        int i = 0;
        for (; i < v1s.length; i++) {
            if (i == v2s.length) {
                break;
            }
            Integer v1 = Integer.parseInt(v1s[i]);
            int v2 = Integer.parseInt(v2s[i]);
            if (v1 != v2) {
                return v1.compareTo(v2);
            }
        }

        while (i < v1s.length) {
            if (Integer.parseInt(v1s[i++]) > 0) {
                return 1;
            }
        }

        while (i < v2s.length) {
            if (Integer.parseInt(v2s[i++]) > 0) {
                return -1;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        String s1 = "0.1";
        String s2 = "1.1";
        System.out.println(this.compareVersion(s1, s2));
    }
}

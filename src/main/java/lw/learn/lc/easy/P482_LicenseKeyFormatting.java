package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-23 21:55:05
 **/
public class P482_LicenseKeyFormatting {

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        String[] split = S.split("-");
        for (String s : split) {
            sb.append(s.toUpperCase());
        }
        for (int i = sb.length() - K; i > 0; i -= K) {
            sb.insert(i, "-");
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String str = "2-5g-3-J";
        System.out.println(this.licenseKeyFormatting(str, 2));
    }

}
